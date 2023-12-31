import React, {useContext, useEffect, useState} from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import {Button, Container, Navbar} from "react-bootstrap";
import {Link, Outlet, useLocation, useNavigate} from "react-router-dom";
import LoginAndRegister from "./components/LoginAndRegister";
import {render} from "@testing-library/react";
import Profile from "./components/Profile"
import {UserContext} from "./context/UserContext";
import CheckedProfilePage from "./pages/CheckedProfilePage";

export default function Layout() {

    let {state} = useLocation();
    const [id, setId] = useState(null);
    const [userName, setUserName] = useState(null);
    const [user, setUser] = useState(null);
    const [token, setToken] = useState(null);
    const [checkedUser, setCheckedUser] = useState(null);
    const navigate = useNavigate();

    useEffect(() => {
        const storedUser = JSON.parse(localStorage.getItem('user'));
        const storedToken = localStorage.getItem('token');

        if (storedUser && storedToken) {
            setUser(storedUser);
            setToken(storedToken);
            setUserName(storedUser.name)
            setId(storedUser.id)

        }
    }, [state]);

    return (
        <div>
            <UserContext.Provider value={[checkedUser, setCheckedUser]}>
                <Navbar className="bg-body-tertiary" data-bs-theme="dark">
                    <Container>
                        <Navbar.Brand> <Link to={"/"} className="text-white text-decoration-none">Sport Buddy
                            Finder</Link>
                            <span className="material-symbols-outlined">hiking</span>
                        </Navbar.Brand>
                        <Navbar.Toggle/>
                        <Navbar.Collapse className="justify-content-end">
                            {user !== null ? <div><Button onClick={() => {
                                navigate("/profile")
                            }}>{userName}</Button>&nbsp;&nbsp;<Button onClick={() => {
                                localStorage.clear()
                                navigate('/');
                                state = null;
                                setUser(null);
                                setUserName(null);
                                setId(null);
                            }}>Logout</Button></div> : <LoginAndRegister/>}
                            {user && <Link to={"/activities/create"}>
                                <Button style={{margin: "0.5rem"}}>Create new post</Button>
                            </Link>}
                            <Navbar.Text>
                                By: Team team = new Team();
                            </Navbar.Text>
                        </Navbar.Collapse>
                    </Container>
                </Navbar>
                <Outlet context={[user, setUser, checkedUser, setCheckedUser]}/>
            </UserContext.Provider>
        </div>
    )
}
