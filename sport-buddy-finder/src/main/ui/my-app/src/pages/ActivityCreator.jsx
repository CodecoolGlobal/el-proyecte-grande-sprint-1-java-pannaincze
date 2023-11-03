import React, {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";
import {ActivityForm} from "../components/ActivityForm";
import Loading from "../components/Loading";

const createActivity = (newActivity) => {
    return fetch("http://localhost:8080/activities/create", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(newActivity),
    }).then(res => res.json());
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

export const ActivityCreator = () => {

    const [loading, setLoading] = useState(true);

    const [sportCategories, setSportCategories] = useState([]);
    const navigate = useNavigate();

    async function fetchSports() {
        fetch("http://localhost:8080/activities/categories", {
            method: "GET",
        })
            .then((response) => response.json())
            .then((data) => {
                setSportCategories(data);

            })
            .catch((error) => console.log(error));
    }
    const handleCreate = (activityDTO) => {
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

    if(loading){
        return <Loading/>;
    }
    return (
        <ActivityForm
            handleSave={handleCreate}
            onCancel={() => navigate("/")}
            sportCategories={sportCategories}
            fetchImage={fetchImage}
        />
    )
}