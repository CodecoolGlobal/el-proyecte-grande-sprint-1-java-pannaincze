import {useState, useEffect} from "react";
import Container from 'react-bootstrap/Container';
import Image from 'react-bootstrap/Image';
import Col from 'react-bootstrap/Col';
import {useOutletContext} from "react-router-dom";
import ActivityCards from "../components/ActivityCards";
import {Button, Form} from "react-bootstrap";


export default function ProfilePage() {
    const [user, setUser] = useOutletContext();
    const [userActivities, setUserActivities] = useState([]);
    const [sports, setSports] = useState([]);
    const [userInterests, setUserInterests] = useState([])
    const fetchActivities = () => {
        return fetch(`/api/activities/user-id/${user.id}`).then((res) => res.json());
    }
    const fetchAllSports = () => {
        fetch("/api/sports").then((res) => res.json()).then((sports) => {
            setSports(sports);
        });
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
                <div className={"userInfo"} style={{
                    color: "#e6e7f0",
                    fontFamily: "inherit",
                    borderRadius: "15px",
                    width: "fit-content",
                    height: "fit-content",
                    paddingLeft: "30px",
                    paddingTop: "10px",
                    justifyContent: "center",

                }}>
                    <h2 style={{fontSize: "1.5em"}}>{"User Name: " + user.name}</h2>
                    <h2 style={{fontSize: "1.5em"}}>{"Email: " + user.email}</h2>
                    {user.interests?.length > 0 ?
                            <div><h2 style={{fontSize: "1.5em"}}>{"Interests:"}</h2>
                                {userInterests.map((interest, i) => {
                                    return <Button key={i} style={{
                                                display: "inline",
                                                margin: "0.3rem",
                                                }}>{interest.name + " "}
                                    </Button>
                                })} <Button onClick={()=>{fetchAllSports()}}>+</Button>
                                {sports.length > 0 ?
                                    <Form.Select onChange={(e) => {
                                        //TODO userInterests are objects with ID, this only adds name
                                        user.interests.push(e.target.value)
                                        console.log(e.target.value)
                                        console.log(userInterests)
                                    }} id="type"
                                                 required={true}>
                                        <option value={sports} selected disabled>Select your option</option>
                                        {sports.map((category) => <option value={category.name}
                                                                                 key={category.id}>{category.name}</option>)}
                                    </Form.Select> : <></>}
                                </div> : <><Button onClick={()=>{fetchAllSports()}}>+</Button></>}
                </div>

                {userActivities ?
                    <ActivityCards activities={userActivities}/>
                 : <></>}

        </div>
    )
}