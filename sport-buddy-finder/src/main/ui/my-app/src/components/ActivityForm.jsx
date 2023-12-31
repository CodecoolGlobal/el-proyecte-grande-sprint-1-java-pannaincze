import {useEffect, useState} from "react";
import {Button, Form} from "react-bootstrap";
import {useOutletContext} from "react-router-dom";

export const ActivityForm = ({handleSave, onCancel, sportCategories, activity, fetchImage, userId}) => {


    const [title, setTitle] = useState(activity?.title ?? "");
    const [location, setLocation] = useState(activity?.location ?? "");
    const [description, setDescription] = useState(activity?.description ?? "");
    const [sport, setSport] = useState(activity?.sport ?? "");
    const [minPeople, setMinPeople] = useState(activity?.minPeopleToFind ?? 0);
    const [maxPeople, setMaxPeople] = useState(activity?.maxPeopleToFind ?? 0);
    const [image, setImage] = useState(activity?.image);

    const storedUser = JSON.parse(localStorage.getItem('user'));
    const [user, setUser] = useState(storedUser);

    useEffect(() => {
        if (sport) {
            fetchImage(sport)
                .then(fetchedImage => {
                    setImage(fetchedImage);
                    console.log(image)
                })
        }
    }, [sport])

    const onSubmit = (e) => {
        e.preventDefault();

        if (activity) {
            return handleSave({
                ...activity,
                title,
                location,
                description,
                sport,
                image,
                minPeopleToFind: minPeople,
                maxPeopleToFind: maxPeople,
                userId
            })
        }

        return handleSave({
            title,
            location,
            description,
            sport,
            image,
            minPeopleToFind: minPeople,
            maxPeopleToFind: maxPeople,
            userId
        })
    }


    return (
        <Form className='m-5' onSubmit={onSubmit}>
            <Form.Group className='mb-3'>
                <Form.Label htmlFor="title">Title:</Form.Label>
                <Form.Control
                    value={title}
                    onChange={(e) => setTitle(e.target.value)}
                    type="text"
                    id="title"
                    required={true}

                />

                <Form.Label htmlFor="sport">Sport:</Form.Label>
                <Form.Select onChange={(e) => setSport(e.target.value)} id="type" required={true}>
                    <option value={sport} selected disabled >Select your option</option>
                    {sportCategories.map((category) => <option value={category} key={category}>{category}</option>)}
                </Form.Select>

                <Form.Label htmlFor="location">Location:</Form.Label>
                <Form.Control
                    value={location}
                    onChange={(e) => setLocation(e.target.value)}
                    type="text"
                    id="location"
                    required={true}
                />

                <Form.Label htmlFor="description">Description:</Form.Label>
                <Form.Control
                    value={description}
                    onChange={(e) => setDescription(e.target.value)}
                    type="text"
                    id="description"
                    required={true}
                    as="textarea" rows="3"
                />

                <Form.Label htmlFor="minPeople">Minimum people:</Form.Label>
                <Form.Control
                    value={minPeople}
                    onChange={(e) => setMinPeople(e.target.value)}
                    type="number"
                    id="minPeople"
                    required={true}
                />

                <Form.Label htmlFor="maxPeople">Maximum people:</Form.Label>
                <Form.Control
                    value={maxPeople}
                    onChange={(e) => setMaxPeople(e.target.value)}
                    type="number"
                    id="maxPeople"
                    required={true}
                />

            </Form.Group>
            <Button type="submit" style={{margin: "0.3rem"}}>Save</Button>
            <Button type="button" onClick={onCancel} style={{margin: "0.3rem"}}>Cancel</Button>
        </Form>
    )
}