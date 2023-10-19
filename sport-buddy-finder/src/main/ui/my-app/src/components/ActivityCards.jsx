import "bootstrap/dist/css/bootstrap.min.css";
import {Button, Card} from "react-bootstrap";

export default function ActivityCards({activities}) {
    return (
        <div className="ActivityCards" style={{ display: "flex", flexWrap: "wrap"}}>
        {activities.map((activity) => (
            <Card style={{ width: '18rem', margin: "0.5rem" }}>
                <Card.Header as="h5">{activity.sport}</Card.Header>
                <Card.Body>
                    <Card.Title>{activity.title}</Card.Title>
                    <Card.Subtitle className="mb-2 text-muted">{activity.location}</Card.Subtitle>
                    <Card.Text>
                        {`${activity.appliedUsers.length}/${activity.maxPeopleToFind}`}
                    </Card.Text>
                    <Button variant="primary">See more</Button>
                </Card.Body>
            </Card>
            ))}
        </div>
    )
}
