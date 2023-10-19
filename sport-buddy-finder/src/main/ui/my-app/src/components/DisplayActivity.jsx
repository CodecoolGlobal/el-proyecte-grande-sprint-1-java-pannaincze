import {Card, Button} from "react-bootstrap";

export default function DisplayActivity({activity, onBack}) {
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
                     <Card.Text>
                        User: {activity.user.name}
                    </Card.Text>
                    <Card.Text>
                        {`${activity.appliedUsers.length}/${activity.maxPeopleToFind}`}
                    </Card.Text>
                    {activity.appliedUsers.length !== 0 ?
                        <Card.Text>
                        Applied users:
                        {activity.appliedUsers.map((user) => (
                            <Card.Text key={activity.uuid}>{user.name}</Card.Text>
                        ))}
                    </Card.Text> :
                        ""
                    }
                </Card.Body>
                <Button className="button" type="button" onClick={onBack} style={{margin: "1rem", padding: "0.3rem", width: "5rem"}}>Back</Button>
            </Card>
        </div>
    )
}