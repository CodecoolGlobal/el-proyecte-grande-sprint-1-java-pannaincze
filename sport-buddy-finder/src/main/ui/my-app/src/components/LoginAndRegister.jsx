import {Link} from "react-router-dom";

export default function (){
    return(
        <div>
        <button>Login</button>
            <Link to={"/register"}><button>Register</button></Link>
    </div>
    )
}