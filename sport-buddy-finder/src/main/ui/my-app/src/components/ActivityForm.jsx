import {useState} from "react";
import {Button, Form} from "react-bootstrap";
import {useOutletContext} from "react-router-dom";

export const ActivityForm = ({handleSave, onCancel, sportCategories}) => {


    const [title, setTitle] = useState("");
    const [location, setLocation] = useState("");
    const [description, setDescription] = useState("");
    const [sport, setSport] = useState("");
    const [minPeople, setMinPeople] = useState(0);
    const [maxPeople, setMaxPeople] = useState(0);
    const [user, setUser] = useOutletContext();
    const onSubmit = (e) => {
        e.preventDefault();
        console.log(user)

        return handleSave({
            title,
            location,
            description,
            sport,
            user,
            minPeopleToFind: minPeople,
            maxPeopleToFind: maxPeople,
        })
    }


    return (
        <Form className='m-5' onSubmit={onSubmit}>
            <Form.Group className='mb-3'>
                <Form.Label htmlFor="title">Title:</Form.Label>
                <Form.Control
                    onChange={(e) => setTitle(e.target.value)}
                    type="text"
                    id="title"
                    required={true}

                />

                <Form.Label htmlFor="sport">Sport:</Form.Label>
                <Form.Select onChange={(e) => setSport(e.target.value)} id="type" required={true}>
                    <option value="" disabled selected>Select your option</option>
                    {sportCategories.map((category) => <option value={category} key={category}>{category}</option>)}
                </Form.Select>

                <Form.Label htmlFor="location">Location:</Form.Label>
                <Form.Control
                    onChange={(e) => setLocation(e.target.value)}
                    type="text"
                    id="location"
                    required={true}
                    as="textarea" rows="3"
                />
                <Form.Label htmlFor="description">Description:</Form.Label>
                <Form.Control
                    onChange={(e) => setDescription(e.target.value)}
                    type="text"
                    id="description"
                    required={true}
                    as="textarea" rows="3"
                />

                <Form.Label htmlFor="minPeople">Minimum people:</Form.Label>
                <Form.Control
                    onChange={(e) => setMinPeople(e.target.value)}
                    type="number"
                    id="minPeople"
                    required={true}
                />

                <Form.Label htmlFor="maxPeople">Maximum people:</Form.Label>
                <Form.Control
                    onChange={(e) => setMaxPeople(e.target.value)}
                    type="number"
                    id="maxPeople"
                    required={true}
                />

            </Form.Group>
            <Button type="submit" style={{margin: "0.2rem"}}>Save</Button>
            <Button type="button" onClick={onCancel} style={{margin: "0.2rem"}}>Cancel</Button>
        </Form>
    )
}