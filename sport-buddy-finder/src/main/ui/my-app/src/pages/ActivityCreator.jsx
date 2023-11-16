import {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";
import {ActivityForm} from "../components/ActivityForm";


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

export const ActivityCreator = () => {
    const storedToken = localStorage.getItem('token')
    const storedUser = JSON.parse(localStorage.getItem('user'))
    const [user, setUser] = useState(storedUser);
    const [userId, setUserId] = useState(user.id);

    const [token, setToken] = useState(storedToken);
    const [loading, setLoading] = useState(true);

    const [sportCategories, setSportCategories] = useState([]);
    const navigate = useNavigate();

    const createActivity = (newActivity) => {
        return fetch("/api/activities/create", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                Authorization: `Bearer ${token}`,
            },
            body: JSON.stringify(newActivity),
        }).then(res => res.json());
    }


    async function fetchSports() {
        fetch("/api/activities/categories", {
            method: "GET",
            headers: {
                Authorization: `Bearer ${token}`
            }
        })
            .then((response) => response.json())
            .then((data) => {
                setSportCategories(data);

            })
            .catch((error) => console.log(error));
    }
    const handleCreate = (activityDTO) => {
        console.log(activityDTO)
        setLoading(true);

        createActivity(activityDTO)
            .then(() => {
                setLoading(false);
                navigate("/")
            })
    }

    useEffect(() => {
        fetchSports().then(res => res);
    }, [])

    return (
        <ActivityForm
            handleSave={handleCreate}
            onCancel={() => navigate("/")}
            sportCategories={sportCategories}
            fetchImage={fetchImage}
            userId={userId}
        />
    )
}