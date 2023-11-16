import {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router-dom";
import {ActivityForm} from "../components/ActivityForm";
import Loading from "../components/Loading";

const fetchActivity = (id) => {
    return fetch(`/api/activities/${id}`).then((res) => res.json());
}

const fetchSports = () => {
    return fetch(`/api/activities/categories`).then((res) => res.json());
}

async function fetchImage(sport) {
    const apiKey = '1NvDE7fcKjluIPqLQJarPaOsQHjv9jjl2eRfrb9caySj64lgithsh7yD';
    const res = await fetch(`https://api.pexels.com/v1/search?query=${sport}&per_page=1`, {
        headers: {
            Authorization: apiKey,
        },
    });
    const data = await res.json();
    return data.photos[0].src.original;
}

export const ActivityUpdater = () => {
    const { id } = useParams();
    const navigate = useNavigate();

    const storedToken = localStorage.getItem('token')
    const [token, setToken] = useState(storedToken);

    const [activityLoading, setActivityLoading] = useState(true);
    const [sportsLoading, setSportsLoading] = useState(true);
    const [updateLoading, setUpdateLoading] = useState(true);

    const [activity, setActivity] = useState(null)
    const [sportCategories, setSportCategories] = useState([]);

    const updateActivity = (activity) => {
        return fetch(`/api/activities/update/${activity.id}`, {
            method: "PUT",
            headers: {
                Authorization: `Bearer ${token}`,
                "Content-Type": "application/json",
            },
            body: JSON.stringify(activity),
        }).then((res) => res.json());
    }

    const handleUpdate = (activity) => {
        setUpdateLoading(true);
        updateActivity(activity)
            .then(() => {
                setUpdateLoading(false);
                setTimeout(()=>{navigate("/");},200)
            })
    }

    useEffect(() => {
        setActivityLoading(true);
        fetchActivity(id)
            .then((activity) => {
                setActivity(activity);
                setActivityLoading(false);
            })
    }, [id])

    useEffect(() => {
        setSportsLoading(true);
        fetchSports()
            .then((sportCategories) => {
                setSportCategories(sportCategories);
                setSportsLoading(false);
            });
    }, [])

    if (activityLoading || sportsLoading) {
        return <Loading />;
    }

    return (
        <ActivityForm
            activity={activity}
            handleSave={handleUpdate}
            onCancel={() => navigate("/")}
            sportCategories={sportCategories}
            fetchImage={fetchImage}
        />
    )
}