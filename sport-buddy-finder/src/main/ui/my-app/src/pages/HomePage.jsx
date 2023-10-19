import LoginAndRegister from "../components/LoginAndRegister";
import Loading from "../components/Loading";
import "bootstrap/dist/css/bootstrap.min.css";
import {useEffect, useState} from "react";
import ActivityCards from "../components/ActivityCards";

const fetchActivities = () => {
    return fetch("/activities/").then((res) => res.json());
}

export default function HomePage() {
    const [activities, setActivities] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        fetchActivities()
            .then((activities) => {
                setLoading(false);
                setActivities(activities);
                console.log(activities);
            })
    }, [])

    return (
        <div>
            <ActivityCards activities={activities}/>
        </div>
    )
}