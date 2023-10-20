import {Link} from "react-router-dom";
import {Button} from "react-bootstrap";

export default function (){
    return(
        <div>
            <Link to={"/login"} style={{margin : "0.5rem"}}><Button>Login</Button></Link>
            <Link to={"/register"} style={{margin : "0.5rem"}}><Button>Register</Button></Link>
    </div>
    )
}