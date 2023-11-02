import {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router-dom";
import {ActivityForm} from "../components/ActivityForm";
import Loading from "../components/Loading";

const fetchActivity = (id) => {
    return fetch(`/activities/${id}`).then((res) => res.json());
}

const fetchSports = () => {
    return fetch(`/activities/categories`).then((res) => res.json());
}

const updateActivity = (activity) => {
    return fetch(`/activities/update/${activity.id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(activity),
    }).then((res) => res.json());
}

export const ActivityUpdater = () => {
    const { id } = useParams();
    const navigate = useNavigate();

    const [activityLoading, setActivityLoading] = useState(true);
    const [sportsLoading, setSportsLoading] = useState(true);
    const [updateLoading, setUpdateLoading] = useState(true);

    const [activity, setActivity] = useState(null)
    const [sportCategories, setSportCategories] = useState([]);

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
        />
    )
}