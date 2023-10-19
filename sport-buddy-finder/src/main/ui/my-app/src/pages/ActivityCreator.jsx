import {useState} from "react";
import {useNavigate} from "react-router-dom";
import {ActivityForm} from "../components/ActivityForm";

const createActivity = (newActivityDTO) => {
    return fetch("http://localhost:8080/activities/create", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(newActivityDTO),
    }).then(res => res.json());
}

export const ActivityCreator = () => {

    const [loading, setLoading] = useState(true);
    const navigate = useNavigate();

    const handleCreate = (activityDTO) => {
        setLoading(true);

        createActivity(activityDTO)
            .then(() => {
                setLoading(false);
                navigate("/")
            })
    }


    return (
        <ActivityForm
            handleSave={handleCreate}
            onCancel={() => navigate("/")}
        />
    )
}