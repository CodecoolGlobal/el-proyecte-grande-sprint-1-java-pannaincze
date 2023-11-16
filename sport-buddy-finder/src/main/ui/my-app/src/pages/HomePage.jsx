import "bootstrap/dist/css/bootstrap.min.css";
import {useEffect, useState} from "react";
import ActivityCards from "../components/ActivityCards";
import {useOutletContext} from "react-router-dom";

const fetchActivities = () => {
    return fetch("/main")
        .then((res) => res.json());
}

export default function HomePage() {
    const [activities, setActivities] = useState([]);
    const [loading, setLoading] = useState(true);
    const [user, setUser,checkedUser, setCheckedUser] = useOutletContext();
    const [name, setName] = useState(null);

    useEffect(() => {
        const storedUser = JSON.parse(localStorage.getItem('user'))
        const storedToken = localStorage.getItem('token')


        if (storedUser && storedToken) {
            setUser({...storedUser, token: storedToken});
            setName(storedUser.name);
        }

        console.log(storedUser)

        fetchActivities()
            .then((activities) => {
                setLoading(false);
                setActivities(activities);
                setCheckedUser(null);
            })
    }, [])
    useEffect(() => {
        if (user !== null) {
            setName(name);
        }
    }, [user])

    return (
        <div>
            <ActivityCards activities={activities}/>
        </div>
    )
}