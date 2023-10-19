import {useState, useEffect} from "react";
import Container from 'react-bootstrap/Container';
import Image from 'react-bootstrap/Image';
import Col from 'react-bootstrap/Col';
export default function ProfilePage({userID}){

    const [user, setUser] = useState({
        name:"",
        email:"",
        password:"",
        birthDate:"",
        userID:"",
        profilePicURL:"",
        interests: [],
        postedActivities: []})
    async function fetchUser(userID){
        fetch(`http://localhost:8080/users/${userID}`,{
            method: "GET",
        })
            .then((response) => response.json())
            .then((data) => setUser(data))
            .catch((error) => console.log(error));
    }
    useEffect(()=> {
        console.log(userID)
        fetchUser(userID)
    },[])
    return (
        <div>
            <Container>
                    <Col xs={6} md={4}>
                        <Image src={user.profilePicURL} rounded />
                    </Col>
            </Container>
            <h1>{user.name}</h1>
            <h2>{user.email}</h2>
            <ul>
                {user.interests.map((interest) => {
                    return <li>{interest}</li>
                })}
            </ul>
            <ul>
                {user.postedActivities.map((activity) => {
                    return <li>{activity}</li>
                })}
            </ul>
        </div>
    )
}