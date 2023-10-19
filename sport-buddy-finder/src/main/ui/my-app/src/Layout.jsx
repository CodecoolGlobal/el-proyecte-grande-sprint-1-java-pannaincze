import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import {Container, Navbar} from "react-bootstrap";
import {Outlet} from "react-router-dom";
import LoginAndRegister from "./components/LoginAndRegister";

export default function Layout() {
    return (
        <div>
            <Navbar className="bg-body-tertiary" data-bs-theme="dark">
                <Container>
                    <Navbar.Brand href="/">Sport Buddy Finder</Navbar.Brand>
                    <Navbar.Toggle />
                    <Navbar.Collapse className="justify-content-end">
                        <LoginAndRegister />
                        <Navbar.Text>
                            By: Team team = new Team();
                        </Navbar.Text>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
            <Outlet />
        </div>
    )
}
