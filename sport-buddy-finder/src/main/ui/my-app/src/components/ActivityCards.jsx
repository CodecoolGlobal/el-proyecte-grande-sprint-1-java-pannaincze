import "bootstrap/dist/css/bootstrap.min.css";
import {Button, Card} from "react-bootstrap";
import {Link} from "react-router-dom";

export default function ActivityCards({activities}) {
    return (
        <div className="ActivityCards" style={{ display: "flex", flexWrap: "wrap"}}>
        {activities.map((activity) => (
            <Card style={{ width: '18rem', margin: "0.5rem" }} key={activity.id}>
                <Card.Header as="h5">{activity.sport}</Card.Header>
                <Card.Body>
                    <Card.Title>{activity.title}</Card.Title>
                    <Card.Subtitle className="mb-2 text-muted">{activity.location}</Card.Subtitle>
                    <Card.Text>
                        {`${activity.appliedUsers?.length}/${activity.maxPeopleToFind}`}
                    </Card.Text>
                    <Link to={`/activities/${activity.id}`}>
                        <Button variant="primary">See more</Button>
                    </Link>
                </Card.Body>
            </Card>
            ))}
        </div>
    )
}
