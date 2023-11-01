import {useState, useEffect} from "react";
import Container from 'react-bootstrap/Container';
import Image from 'react-bootstrap/Image';
import Col from 'react-bootstrap/Col';
import {useLocation, useOutletContext, useParams} from "react-router-dom";
import ActivityCards from "../components/ActivityCards";


export default function ProfilePage(){
    const [user, setUser] = useOutletContext();
    //
    //const location = useLocation()
    // const { id } = location.state
    // const [user, setUser] = useState({
    //     name:"",
    //     email:"",
    //     password:"",
    //     birthDate:"",
    //     userID:"",
    //     profilePicURL:"",
    //     interests: [],
    //     postedActivities: []})
    async function fetchUser(userID){
        fetch(`http://localhost:8080/users/${userID}`,{
            method: "GET",
        })
            .then((response) => response.json())
            .then((data) => {console.log(data)
                setUser(data)})
            .catch((error) => console.log(error));
    }
    useEffect(()=> {
        console.log(user.id)
        fetchUser(user.id)
    },[])
    return (
        <div>
            <Container>
                    <Col xs={6} md={4}>
                        <Image src={user.profilePicURL} roundedCircle />
                    </Col>
            </Container>
            <div className={"userDataContainer"}>
                <h1>{"USER NAME: " + user.name}</h1>
                <h2>{"EMAIL: " + user.email}</h2>
                {user.postedActivities ? <div>
                    <ActivityCards activities={user.postedActivities}/>
                </div> : <></>}
                {user.interests ? <ul>
                    {user.interests.map(interest => {
                        return <li>{interest}</li>
                    })}
                </ul> : <></>}
            </div>
        </div>
    )
}