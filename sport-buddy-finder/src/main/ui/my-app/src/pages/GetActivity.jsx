import {useNavigate, useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import Loading from "../components/Loading";
import DisplayActivity from "../components/DisplayActivity";

const fetchActivity = (id) => {
    return fetch(`/activities/${id}`)
        .then((res) => res.json());
};

const deleteActivity = (id) => {
    return fetch(`/activities/${id}`,
        {method: "DELETE"})
        .then((res) => res.json());
}
const addUserToParticipants = (id, userId) => {
    return fetch(`/activities/update/${id}/${userId}`,
        {method: "PUT"})
        .then(res => res.json());
}

export default function GetActivity() {
    const {id} = useParams();
    const [activity, setActivity] = useState(null);
    const [activityLoading, setActivityLoading] = useState(true);

    const navigate = useNavigate();

    useEffect(() => {
        setActivityLoading(true);
        fetchActivity(id)
            .then((activity) => {
                setActivity(activity);
                console.log(activity);
                setActivityLoading(false);
            })
    }, [id]);

    const handleDelete = (id) => {
        deleteActivity(id);
        setTimeout(()=>{navigate("/");},200)
    }
    const handleApplication = (id, user) => {
        console.log(user)
      addUserToParticipants(id, user.id)
          .then(() => navigate("/"))
    }

    if (activityLoading) {
        return <Loading/>;
    }

    return (
        <div>
            <DisplayActivity
                activity={activity}
                onDelete={handleDelete}
                onBack={() => navigate("/")}
                onApply={handleApplication}
            />
        </div>
    )
}