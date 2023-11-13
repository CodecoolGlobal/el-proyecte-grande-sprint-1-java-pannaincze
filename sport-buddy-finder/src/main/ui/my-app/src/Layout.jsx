import React, {useEffect, useState} from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import {Button, Container, Navbar} from "react-bootstrap";
import {Link, Outlet, useLocation, useNavigate} from "react-router-dom";
import LoginAndRegister from "./components/LoginAndRegister";
import {render} from "@testing-library/react";
import Profile from "./components/Profile"

export default function Layout() {

    let {state} = useLocation();
    const [id, setId] = useState(null)
    const [userName, setUserName] = useState(null)
    const [user, setUser] = useState(null);
    const navigate = useNavigate();
    useEffect(() => {
        if (state !== null) {
            const {name, id, email, password, birthDate, profilePicURL, interests, postedActivities} = state;
            setUser({name, id, email, password, birthDate, profilePicURL, interests, postedActivities});
            setId(id);
            setUserName(name)
        }
    }, [state]);
    return (
        <div>
            <Navbar className="bg-body-tertiary" data-bs-theme="dark">
                <Container>
                    <Navbar.Brand> <Link to={"/"} className="text-white text-decoration-none">Sport Buddy Finder</Link>
                        <span className="material-symbols-outlined">hiking</span>
                    </Navbar.Brand>
                    <Navbar.Toggle/>
                    <Navbar.Collapse className="justify-content-end">
                        {user !== null ? <div ><Button onClick={()=>{navigate("/profile")}}>{userName}</Button>&nbsp;&nbsp;<Button onClick={() => {
                            navigate('/');
                            state = null;
                            setUser(null);
                            setUserName(null);
                            setId(null);
                            // setTimeout(()=>{
                            // navigate('/');
                            // },200)
                        }}>Logout</Button></div> : <LoginAndRegister />}
                        {user && <Link to={"/activities/create"}>
                            <Button style={{margin: "0.5rem"}}>Create new post</Button>
                        </Link>}
                        <Navbar.Text>
                            By: Team team = new Team();
                        </Navbar.Text>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
            <Outlet context={[user, setUser]}  />
        </div>
    )
}
