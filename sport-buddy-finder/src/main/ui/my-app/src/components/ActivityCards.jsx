import "bootstrap/dist/css/bootstrap.min.css";
import {Card} from "react-bootstrap";

export default function ActivityCards({activities}) {
    return (
        <div className="ActivityCards">
        {activities.map((activity) => (
            <Card style={{ width: '18rem' }}>
                <Card.Body>
                    <Card.Title>{activity.title}</Card.Title>
                    <Card.Subtitle className="mb-2 text-muted">{activity.sport}</Card.Subtitle>
                    <Card.Subtitle className="mb-2 text-muted">{activity.location}</Card.Subtitle>
                    <Card.Text>
                        {`${activity.appliedUsers.length}/${activity.maxPeopleToFind}`}
                    </Card.Text>
                </Card.Body>
            </Card>
            ))}
        </div>
    )
}
