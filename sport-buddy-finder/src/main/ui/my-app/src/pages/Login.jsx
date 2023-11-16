import {useEffect, useState} from "react";
import {Button, Form} from "react-bootstrap";
import {useNavigate} from "react-router-dom";


export default function () {
    const [user, setUser] = useState([]);
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();
    const [loginFail, setLoginFail] = useState(null);

    function handleLogin() {
        fetch(`/users/login`, {
            method: "POST",
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify({email: email, password: password})
        })
            .then((response) => response.json())
            .then(({token, user}) => {
                setUser(user);
                console.log(user);
                if (user !== null) {
                    localStorage.setItem('user', JSON.stringify(user))
                    localStorage.setItem('token', token)
                    setTimeout(() => {
                        navigate('/', {state: {user, token}})
                    }, 300)
                } else {
                    setLoginFail(true);
                }
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
                {loginFail &&
                    <div className="container text-center bg-danger text-white">This email-password combination does not
                        exists!</div>}

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
