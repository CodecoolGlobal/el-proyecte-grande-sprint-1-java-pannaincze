import {useEffect, useState} from "react";
import {Button, Form} from "react-bootstrap";


export default function () {
    const [email, setEmail] = useState(null);
    const [password, setPassword] = useState(null);
    const [user, setUser] = useState(null);

    function handleLogin() {
        fetch(`http://localhost:8080/users/login/${email}/${password}`, {
            method: "GET",
        })
            .then((response) => response.json())
            .then((user) => {
                setUser(user);
                console.log(user);
            })
            .catch((error) => console.log(error));
    }
    return (

        <div>
            <Form className="container text-center" onSubmit={event => {
                event.preventDefault();
                handleLogin()
            }}>
                <br/>

                <Form.Group className="mb-3">
                    <Form.Label htmlFor="email" className="form-label">Email address: </Form.Label><br/>
                    <Form.Control onChange={event => setEmail(event.target.value)} id="email" type="email"
                                  placeholder="example@gmail.com" required={true}></Form.Control>
                </Form.Group>
                <Form.Group className="mb-3 ">
                <Form.Label htmlFor="password" className="form-label">Password: </Form.Label><br/>
                <Form.Control onChange={event => setPassword(event.target.value)} id="password" placeholder="******"
                              type="password" required={true}></Form.Control>
            </Form.Group>
                <Button type={"submit"}>Login</Button>
            </Form>
        </div>
        )

}
