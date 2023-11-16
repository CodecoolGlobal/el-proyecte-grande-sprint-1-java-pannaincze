import {Card, Button} from "react-bootstrap";
import {Link, useNavigate, useOutletContext} from "react-router-dom";
import {SignUpButton} from "./SignUpButton";
import {useContext, useEffect} from "react";
import {UserContext} from "../context/UserContext";

export default function DisplayActivity({activity, onBack, onDelete, onSignUp, onWithdraw}) {
    const navigate = useNavigate();
    const [user, setUser, checkedUser, setCheckedUser] = useOutletContext();
    //const [checkedUser, setCheckedUser] = useContext(UserContext);



    async function checkProfile(userID) {
        fetch(`/api/users/${userID}`)
            .then((response) => response.json())
            .then((data) => {
                console.log(data)
                setCheckedUser(data);
            }).then(navigate('/checked-profile'))
            .catch((error) => console.log(error));

    }

    return (
        <div className="activityConatiner" style={{margin: "3rem"}}>
            <Card className="activity">
                <Card.Body>
                    <Card.Title>{activity.title}</Card.Title>
                    <Card.Text>
                        Description: {activity.description}
                    </Card.Text>
                    <Card.Text>
                        Sport type: {activity.sport.toLowerCase()}
                    </Card.Text>
                    <Card.Text>
                        Status: {activity.postStatus}
                    </Card.Text>
                    <Card.Text>
                        Location: {activity.location}
                    </Card.Text>
                    <Card.Text id={activity.user.id} onClick={()=>{checkProfile(activity.user.id)}}>
                        Created: {activity.user.name}
                    </Card.Text>
                    <Card.Text>
                        {`${activity.appliedUsers.length}/${activity.maxPeopleToFind}`}
                    </Card.Text>
                    {activity.appliedUsers.length !== 0 ?

                        <Card.Text>
                            Applied users:
                            {activity.appliedUsers.map((user) => (
                                    <Card.Text key={activity.id} id={user.id} onClick={()=>{checkProfile(user.id)}}>{user.name} </Card.Text>
                               ))}
                        </Card.Text> :
                        ""
                    }
                </Card.Body>
                {(user && user.id == activity.user?.id) && <Link to={`/activities/update/${activity.id}`}>
                    <Button className="button" type="button"
                            style={{margin: "1rem", padding: "0.3rem", width: "5rem"}}>Edit</Button>
                </Link>}


                {(user && user.id == activity.user?.id) ? <Button className="button" type="button" onClick={() => {
                        onDelete(activity.id)
                    }} style={{margin: "1rem", padding: "0.3rem", width: "5rem"}}>Delete</Button>
                    :
                    <></>}
                <Button className="button" type="button" onClick={() => {
                    navigate(-1)
                }} style={{margin: "1rem", padding: "0.3rem", width: "5rem"}}>Back</Button>
                {user?.id !== activity.user.id && <><SignUpButton
                    onSignUp={onSignUp}
                    onWithdraw={onWithdraw}
                    activity={activity}
                    user={user}
                />
                    {user === null && <p> Sign in to apply!</p>}</>}
            </Card>
        </div>
    )
}