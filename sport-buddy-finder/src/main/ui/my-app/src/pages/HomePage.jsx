import "bootstrap/dist/css/bootstrap.min.css";
import {useEffect, useState} from "react";
import ActivityCards from "../components/ActivityCards";
import {useOutletContext} from "react-router-dom";
import Loading from "../components/Loading";

const fetchActivities = () => {
    return fetch("http://localhost:8080/activities/").then((res) => res.json());
}

export default function HomePage() {
    const [activities, setActivities] = useState([]);
    const [loading, setLoading] = useState(true);
    const [user, setUser] = useOutletContext();
    const [name, setName] = useState(null);

    useEffect(() => {
        fetchActivities()
            .then((activities) => {
                setLoading(false);
                setActivities(activities);
            })
    }, [])
    useEffect(() => {
        if (user !== null) {
            const {name, id, email, password, birthDate, profilePicURL, interests, postedActivities} = user;
            setName(name);
        }
    }, [user])
    if(loading){
        return <Loading/>;
    }

    return (
        <div>
            <ActivityCards activities={activities}/>
        </div>
    )
}