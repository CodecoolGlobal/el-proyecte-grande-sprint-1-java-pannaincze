import {useState, useEffect} from "react";

export default function ProfilePage(){

    const [user, setUser] = useState({name:"",email:"",password:"",birthDate:""})
    async function fetchUser(userID){
        fetch(`http://localhost:8080/${userID}`,{
            method: "GET",
        })
            .then((response) => response.json())
            .then((data) => setUser(data))
            .catch((error) => console.log(error));
    }
    useEffect(()=> {
        fetchUser(userId)
    },[])
}