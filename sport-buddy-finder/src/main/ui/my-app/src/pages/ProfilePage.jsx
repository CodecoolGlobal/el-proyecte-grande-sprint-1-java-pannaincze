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
        <div className={"profilePageContainer"} style={{
            backgroundColor: "#282c34",
            width: "100vw",
            height: "100vh"
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

                        }} />
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
            <div className={"userInfo"} style={{
                color: "#e6e7f0",
                fontFamily: "inherit",
                borderRadius: "15px",
                width: "25vw",
                height: "20vh",
                padding: "50px",
                justifyContent: "center",

            }}>
                <h2 style={{ fontSize: "1.5em"} }>{"User Name: " + user.name}</h2>
                <h2 style={{ fontSize: "1.5em"} }>{"Email: " + user.email}</h2>
                {user.interests ? <ul>
                    {user.interests.map(interest => {
                        return <li>{interest}</li>
                    })}
                </ul> : <></>}
            </div>
            <div className={"profileActivities"}>
                {user.postedActivities ? <div>
                    <ActivityCards activities={user.postedActivities}/>
                </div> : <></>}
            </div>
        </div>
    )
}