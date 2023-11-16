import "bootstrap/dist/css/bootstrap.min.css";
import {useEffect, useState} from "react";
import ActivityCards from "../components/ActivityCards";
import {useOutletContext} from "react-router-dom";

const fetchActivities = () => {
    return fetch("/api/activities/").then((res) => res.json());
}

export default function HomePage() {
    const [activities, setActivities] = useState([]);
    const [loading, setLoading] = useState(true);
    const [user, setUser,checkedUser, setCheckedUser] = useOutletContext();
    const [name, setName] = useState(null);

    useEffect(() => {
        fetchActivities()
            .then((activities) => {
                setLoading(false);
                setActivities(activities);
                setCheckedUser(null);
            })
    }, [])
    useEffect(() => {
        if (user !== null) {
            const {name, id, email, password, birthDate, profilePicURL, interests, postedActivities} = user;
            setName(name);
        }
    }, [user])

    return (
        <div>
            <ActivityCards activities={activities}/>
        </div>
    )
}