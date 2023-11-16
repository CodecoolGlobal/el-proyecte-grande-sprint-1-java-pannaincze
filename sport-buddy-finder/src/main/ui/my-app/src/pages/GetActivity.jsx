import {useNavigate, useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import Loading from "../components/Loading";
import DisplayActivity from "../components/DisplayActivity";

const fetchActivity = (id) => {
    return fetch(`/main/${id}`)
        .then((res) => res.json());
};

const deleteActivity = (id) => {
    return fetch(`/api/activities/${id}`, {
        method: "DELETE",
        headers: {
            Authorization: `Bearer ${localStorage.getItem('token')}`,
        }
    })
        .then((res) => res.json());
}
const addUserToParticipants = (id, userId) => {
    return fetch(`/api/activities/update/${id}/${userId}`, {
        method: "PUT",
        headers: {
            Authorization: `Bearer ${localStorage.getItem('token')}`,
        }
    })
        .then(res => res.json());
}
const removeUserToParticipants = (id, userId) => {
    return fetch(`/api/activities/update/${id}/${userId}`, {
        method: "DELETE",
        headers: {
            Authorization: `Bearer ${localStorage.getItem('token')}`,
        }
    })
        .then(res => res.json());
}

export default function GetActivity() {
    const {id} = useParams();
    const [activity, setActivity] = useState(null);
    const [activityLoading, setActivityLoading] = useState(true);

    const navigate = useNavigate();

    useEffect(() => {
        getActivity();
    }, [id]);

    const getActivity = () => {
        setActivityLoading(true);
        return fetchActivity(id)
            .then((activity) => {
                setActivity(activity);
                console.log(activity);
                setActivityLoading(false);
            })
    }
    const handleDelete = (id) => {
        deleteActivity(id);
        setTimeout(() => {
            navigate("/");
        }, 200)
    }
    const handleSignUp = (id, user) => {
        console.log(user)
        addUserToParticipants(id, user.id)
            .then(() => getActivity())
    }
    const handleWithdraw = (id, user) => {
        console.log(user)
        removeUserToParticipants(id, user.id)
            .then(() => getActivity())
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
                onSignUp={handleSignUp}
                onWithdraw={handleWithdraw}

            />
        </div>
    )
}