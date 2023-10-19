import {useState} from "react";

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




    return (
        <></>
    )
}