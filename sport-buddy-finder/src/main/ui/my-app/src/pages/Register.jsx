import {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";

export default function () {
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [interests, setInterests] = useState([]);
    const [sportCategories, setSportCategories] = useState([]);

    const navigate = useNavigate();

    function handleRegistration() {
        if (name.length > 0 && email.length > 2 && password.length > 0) {
            const requestOptions = {
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify({name: name, email: email, password: password, interests: interests})
            };
            fetch('http://localhost:8080/users', requestOptions)
                .then(response => response.json());
            navigate("/");
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
        fetch("http://localhost:8080/activities/categories", {
            method: "GET",
        })
            .then((response) => response.json())
            .then((data) => {
                //setJoke(data[0].joke);
                setSportCategories(data);
            })
            .catch((error) => console.log(error));
    }

    return (
        <div>
            <form className="container text-center">
                <br/>
                <div className="mb-3 ">
                    <label htmlFor="name" className="form-label">Name: </label><br/>
                    <input onChange={event => setName(event.target.value)} id="name" placeholder="John Doe"
                           required={true}></input>
                </div>
                <div className="mb-3">
                    <label htmlFor="email" className="form-label">Email address: </label><br/>
                    <input onChange={event => setEmail(event.target.value)} id="email" type="email"
                           placeholder="example@gmail.com" required={true}></input>
                </div>
                <div className="mb-3">
                    <label htmlFor="password" className="form-label">Password: </label><br/>
                    <input onChange={event => setPassword(event.target.value)} id="password" type={"password"}
                           placeholder="********" required={true}></input>
                </div>
                <div className="mb-3 container ">
                    <label>Choose you sport interests:</label><br/><br/>
                    {sportCategories.length > 0 &&
                        <div className="container row">{sportCategories.map((category, index) => (
                            <div key={index} className="col-4 ">
                                <label className="form-check-label" htmlFor={category}>{category}</label><br/>
                                <input onClick={event => checkboxHandling(event.target)} type="checkbox"
                                       className="form-check-input" id={category} value={category}></input>
                            </div>
                        ))}</div>}
                </div>
                <button type={"button"} onClick={handleRegistration}> Save</button>

            </form>
        </div>

    )
}