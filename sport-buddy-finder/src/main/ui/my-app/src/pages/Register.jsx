import {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";
import {Button, Form} from "react-bootstrap";

export default function () {
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [interests, setInterests] = useState([]);
    const [sportCategories, setSportCategories] = useState([]);
    const [date, setDate] = useState(null);
    const navigate = useNavigate();
    const [isRegisterSuccessful, setRegisterSuccessAs] = useState(null);

    function handleRegistration() {
        console.log(JSON.stringify({name: name, email: email, password: password, interests: interests, date: date}))
        if (name.length > 0 && email.length > 4 && email.includes("@") && email.includes(".") && password.length > 0 && date !== null) {
            const requestOptions = {
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify({name: name, email: email, password: password, interests: interests, date: date})
            };
            fetch('http://localhost:8080/users', requestOptions)
                .then(response => response.json()).then((bool) => {
                setRegisterSuccessAs(bool);
                if(bool){
                    setTimeout(() => {
                        setRegisterSuccessAs(null);
                        navigate("/");

                    }, "450");
                }
            });
        }
    }

    function checkboxHandling(target) {
        if (target.checked) {
            setInterests([...interests, target.value])
        } else if (!target.checked) {
            setInterests(interests.filter(interest => interest !== target.value));
        }
    }

    useEffect(() => {
        fetchSports();
    }, [])

    async function fetchSports() {
        fetch("http://localhost:8080/sports", {
            method: "GET",
        })
            .then((response) => response.json())
            .then((data) => {
                setSportCategories(data);

            })
            .catch((error) => console.log(error));
    }

    return (
        <div>
            {isRegisterSuccessful && <div className="container text-center mb-2 bg-success text-white">Registration Successful</div>}
            {isRegisterSuccessful === false && <div className="container text-center bg-danger text-white">This email already exists in our system!</div>}
            {!isRegisterSuccessful && <>
                <Form className="container text-center" onSubmit={event => {
                    event.preventDefault();
                    handleRegistration()
                }}>
                    <br/>
                    <Form.Group className="mb-3 ">
                        <Form.Label htmlFor="name" className="form-label">Name: </Form.Label><br/>
                        <Form.Control onChange={event => setName(event.target.value)} id="name" placeholder="John Doe"
                               required={true}></Form.Control>
                    </Form.Group>
                    <Form.Group className="mb-3">
                        <Form.Label htmlFor="email" className="form-label">Email address: </Form.Label><br/>
                        <Form.Control onChange={event => setEmail(event.target.value)} id="email" type="email"
                               placeholder="example@gmail.com" required={true}></Form.Control>
                    </Form.Group>
                    <Form.Group className="mb-3">
                        <Form.Label htmlFor="password" className="form-label">Password: </Form.Label><br/>
                        <Form.Control onChange={event => setPassword(event.target.value)} id="password" type={"password"}
                               placeholder="********" required={true}></Form.Control>
                    </Form.Group>
                    <Form.Group className="mb-3">
                        <Form.Label htmlFor="birthdate" className="form-label">Birth Date: </Form.Label><br/>
                        <Form.Control onChange={event => setDate(event.target.value)} id="birthdate" type="date"
                               required={true}></Form.Control>
                    </Form.Group>
                    <Form.Group className="mb-3 container">
                        <Form.Label>Choose your sport interests:</Form.Label><br/><br/>
                        {sportCategories.length > 0 &&
                            <Form.Group className="container row">{sportCategories.map((category, index) => (
                                <div key={index} className="col-4 ">
                                    <Form.Check onClick={event => checkboxHandling(event.target)} type="checkbox" id={category.id} value={category.id} label={category.name}></Form.Check>
                                </div>
                            ))}</Form.Group>}
                    </Form.Group>
                    <Button type="submit"> Save</Button>

                </Form>
            </>}

        </div>

    )
}