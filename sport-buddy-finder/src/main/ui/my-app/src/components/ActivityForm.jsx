import {useState} from "react";
import {Button, Form} from "react-bootstrap";

export const ActivityForm = ({handleSave, onCancel, sportCategories}) => {


    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");
    const [sport, setSport] = useState("");
    const [minPeople, setMinPeople] = useState(0);
    const [maxPeople, setMaxPeople] = useState(0);

    const onSubmit = (e) => {
        e.preventDefault();

        return handleSave({
            title,
            description,
            sport,
            minPeopleToFind: minPeople,
            maxPeopleToFind: maxPeople,
        })
    }


    return (
        <Form className='mx-5' onSubmit={onSubmit}>
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
                    {sportCategories.map((category, index) => <option value={category}>{category}</option>
                    )}
                </Form.Select>

                <Form.Label htmlFor="description">Description:</Form.Label>
                <Form.Control
                    onChange={(e) => setDescription(e.target.value)}
                    type="text"
                    id="description"
                    required={true}
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
            <Button type="submit">Save</Button>
            <Button type="button" onClick={onCancel}>Cancel</Button>
        </Form>
    )
}