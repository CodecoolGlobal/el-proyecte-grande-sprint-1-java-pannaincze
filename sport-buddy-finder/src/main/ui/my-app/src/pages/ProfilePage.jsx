import {useState, useEffect} from "react";
import Container from 'react-bootstrap/Container';
import Image from 'react-bootstrap/Image';
import Col from 'react-bootstrap/Col';
import {useOutletContext} from "react-router-dom";
import ActivityCards from "../components/ActivityCards";
import UserInterests from "../components/UserInterests";

export default function ProfilePage() {
    const [user, setUser] = useOutletContext();
    const [userActivities, setUserActivities] = useState([]);
    const [userInterests, setUserInterests] = useState([])
    const fetchActivities = () => {
        return fetch(`/api/activities/user-id/${user.id}`).then((res) => res.json());
    }
    const addInterest = (interest) => {
        userInterests.push(interest)
        console.log(userInterests)
    }
    async function fetchUser(userID) {
        fetch(`/api/users/${userID}`, {
            method: "GET",
        })
            .then((response) => response.json())
            .then((data) => {
                setUser(data)
                setUserInterests(data.interests)
                console.log(data.interests)
            })
            .catch((error) => console.log(error));
    }

    useEffect(() => {
        fetchUser(user.id)
        fetchActivities()
            .then((activities) => {
                setUserActivities(activities);})
    }, [])

    return (
        <div className={"profilePageContainer"} style={{
            backgroundColor: "#282c34",

        }}>
            <Container style={{
                paddingTop: "4vh",
                paddingLeft: "3.5vw",
                width: "30vw",
                float: "left"
            }}>
                <Col xs={6} md={4}>
                    <Image src={user.profilePicURL} roundedCircle style={{
                        width: "40vh",
                        marginBottom: "1.3vh"
                    }}/>
                </Col>
            </Container>
                <div className={"banner"} style={{
                    width: "100vw",
                    height: "35vh",
                    backgroundImage: `url("https://images.pexels.com/photos/209977/pexels-photo-209977.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")`,
                    backgroundRepeat: "no-repeat",
                    backgroundSize: "cover",
                    backgroundPosition: "10%"
                }}>
                </div>
                <UserInterests userInterests={userInterests} user={user} addInterest={addInterest}/>
                {userActivities ?
                    <ActivityCards activities={userActivities}/>
                 : <></>}

        </div>
    )
}