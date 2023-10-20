import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import {Button, Container, Navbar} from "react-bootstrap";
import {Link, Outlet} from "react-router-dom";
import LoginAndRegister from "./components/LoginAndRegister";
import Profile from "./components/Profile"

export default function Layout() {
    return (
        <div>
            <Navbar className="bg-body-tertiary" data-bs-theme="dark">
                <Container>
                    <Navbar.Brand href="/">Sport Buddy Finder
                        <span className="material-symbols-outlined">hiking</span>
                    </Navbar.Brand>
                    <Navbar.Toggle/>
                    <Navbar.Collapse className="justify-content-end">
                        <Profile />
                        <LoginAndRegister/>
                        <Link to={"/activities/create"}>
                            <Button style={{margin: "0.5rem"}}>Create new post</Button>
                        </Link>
                        <Navbar.Text>
                            By: Team team = new Team();
                        </Navbar.Text>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
            <Outlet/>
        </div>
    )
}
