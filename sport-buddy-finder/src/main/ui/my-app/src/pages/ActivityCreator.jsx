import {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";
import {ActivityForm} from "../components/ActivityForm";

const createActivity = (newActivity) => {
    return fetch("http://localhost:8080/activities/create", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(newActivity),
    }).then(res => res.json());
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

    return (
        <ActivityForm
            handleSave={handleCreate}
            onCancel={() => navigate("/")}
            sportCategories={sportCategories}
        />
    )
}