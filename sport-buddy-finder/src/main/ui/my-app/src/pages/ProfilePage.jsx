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
        fetch(`http://localhost:8080/${userID}`,{
            method: "GET",
        })
            .then((response) => response.json())
            .then((data) => setUser(data))
            .catch((error) => console.log(error));
    }
    useEffect(()=> {
        fetchUser(userID)
    },[])
    return (
        <div>
            <Container>
                    <Col xs={6} md={4}>
                        <Image src={user.profilePicURL} rounded />
                    </Col>
            </Container>
        </div>
    )
}