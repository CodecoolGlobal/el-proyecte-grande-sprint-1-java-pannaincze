import {Link} from "react-router-dom";

export default function (){
    return (
        <div>
            <Link to={"/profile"}><button>Profile</button></Link>
        </div>
    )
}