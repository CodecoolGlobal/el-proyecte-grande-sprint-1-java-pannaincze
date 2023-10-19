import {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";

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
                    }, "2200");
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
        fetch("http://localhost:8080/activities/categories", {
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
                <form className="container text-center" onSubmit={event => {
                    event.preventDefault();
                    handleRegistration()
                }}>
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
                    <div className="mb-3">
                        <label htmlFor="birthdate" className="form-label">Birth Date: </label><br/>
                        <input onChange={event => setDate(event.target.value)} id="birthdate" type="date"
                               required={true}></input>
                    </div>
                    <div className="mb-3 container">
                        <label>Choose your sport interests:</label><br/><br/>
                        {sportCategories.length > 0 &&
                            <div className="container row">{sportCategories.map((category, index) => (
                                <div key={index} className="col-4 ">
                                    <label className="form-check-label" htmlFor={category}>{category}</label><br/>
                                    <input onClick={event => checkboxHandling(event.target)} type="checkbox"
                                           className="form-check-input" id={category} value={category}></input>
                                </div>
                            ))}</div>}
                    </div>
                    <button type="submit"> Save</button>

                </form>
            </>}

        </div>

    )
}