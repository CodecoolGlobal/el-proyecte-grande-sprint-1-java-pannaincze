import {useEffect, useState} from "react";
import {Link} from "react-router-dom";

export default function (){
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [interests, setInterests] = useState([]);
    function handleRegistration(){
        console.log(name);
    }
    function checkboxHandling(target){
        console.log(target.checked);
        console.log(target.value);
    }
    useEffect(()=>{
        fetchSports();
    },[])
    async function fetchSports(){
        const response = fetch("http://localhost:8080/activities/categories", {
            method: "GET",
        })
            .then((response) => response.json())
            .then((data) => {
                //setJoke(data[0].joke);
                console.log(data);
            })
            .catch((error) => console.log(error));
    }
    return(
        <div>
            <form className="container">
                <div className="mb-3 ">
                    <label htmlFor="name" className="form-label">Name: </label>
                    <input onChange={event => setName(event.target.value) } id="name" placeholder="John Doe"></input>
                </div>
                <div className="mb-3">
                    <label htmlFor="email" className="form-label">Email address: </label>
                    <input onChange={event => setEmail(event.target.value) } id="email" type="email" placeholder="example@gmail.com"></input>
                </div>
                <div className="mb-3">
                    <label htmlFor="password" className="form-label">Password: </label>
                    <input onChange={event => setPassword(event.target.value) } id="password" type={"password"} placeholder="********"></input>
                </div>
                <div className="mb-3 container ">
                    <label>Sport interests:</label><br/>
                    <input onClick={event =>  checkboxHandling(event.target)} type="checkbox" className="form-check-input" id="exampleCheck1" value={"Sport1"}></input>
                    <label className="form-check-label" htmlFor="exampleCheck1">Check1</label>
                    <input type="checkbox" className="form-check-input" id="exampleCheck2"></input>
                    <label className="form-check-label" htmlFor="exampleCheck2">Check2</label>
                    <input type="checkbox" className="form-check-input" id="exampleCheck3"></input>
                    <label className="form-check-label" htmlFor="exampleCheck3">Check3</label>
                </div>
                <button type={"button"} onClick={handleRegistration}> Save </button>
            </form>
        </div>

    )
}