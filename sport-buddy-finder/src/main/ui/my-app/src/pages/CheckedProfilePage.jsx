import {useState, useEffect, useContext} from "react";
import Container from 'react-bootstrap/Container';
import Image from 'react-bootstrap/Image';
import Col from 'react-bootstrap/Col';
import {useLocation, useOutletContext, useParams} from "react-router-dom";
import ActivityCards from "../components/ActivityCards";
import {UserContext} from "../context/UserContext";
import Loading from "../components/Loading";


export default function CheckedProfilePage() {
    const [user, setUser, checkedUser, setCheckedUser] = useOutletContext();
    const [activies, setActivities] = useState([]);
    //const [checkedUser, setCheckedUser] = useContext(UserContext);
    const [chUser, setChUser] = useState(null);
    const [loading, setLoading] = useState(true);


    useEffect(() => {
        // const fetchActivities = () => {
        //     return fetch(`/api/activities/user-id/${checkedUser.id}`).then((res) => res.json());
        // }
        if (checkedUser !== null) {
            console.log(checkedUser)
            fetch(`/api/activities/user-id/${checkedUser.id}`).then((res) => res.json()).then((activities) => {
                setActivities(activities);
            })}

    }, [checkedUser])

    return (<>
            {(!checkedUser && loading) ? <Loading/> : <div>
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
                            <Image src={checkedUser.profilePicURL} roundedCircle style={{
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
                        <h2 style={{fontSize: "1.5em"}}>{"User Name: " + checkedUser.name}</h2>
                        <h2 style={{fontSize: "1.5em"}}>{"Email: " + checkedUser.email}</h2>
                        {checkedUser.interests?.length > 0 ? <div><h2 style={{fontSize: "1.5em"}}>{"Interests:"}</h2>
                            <ul>

                                {checkedUser.interests.map(interest => {
                                    return <li>{interest.name}</li>
                                })}
                            </ul>
                        </div> : <></>}
                    </div>
                    <div className={"profileActivities"}>
                        {activies ? <div>
                            <ActivityCards activities={activies}/>
                        </div> : <></>}
                    </div>
                </div>
            </div>
            }
        </>
    )
}