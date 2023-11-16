import {Button} from "react-bootstrap";
import {useState} from "react";
import InterestSelect from "./InterestSelect";

export default function UserInterests ({userInterests, user, addInterest, isCheckedUser}){
    const storedToken = localStorage.getItem('token')
    const [token, setToken] = useState(storedToken)
    const [sports, setSports] = useState([]);
    const [showSelect, setShowSelect] = useState(false)
    const changeShowSelect = (boolean) => {
        setShowSelect(boolean)
    }
    const fetchAllSports = () => {
        fetch("/sports", {
            headers: {
                Authentication: `Bearer ${token}`
            }
        }).then((res) => res.json()).then((sports) => {
            setSports(sports);
        });
    }
    return (
        <div style={{
            paddingLeft: "30px",
            paddingTop: "10px",
            color: "#e6e7f0"
        }}>
            {user.interests?.length > 0 &&
                <div><h2 style={{fontSize: "1.5em"}}>{"Interests:"}</h2>
                    {userInterests.map((interest, i) => {
                        return <Button  key={i} style={{
                            display: "inline",
                            margin: "0.3rem",
                        }}>{interest.name + " "}
                        </Button>
                    })}
                    {!isCheckedUser &&<Button style={{display: "inline"}}  onClick={() => {
                        fetchAllSports()
                        setShowSelect(true)
                    }}>+
                    </Button>}
                </div> }

            {showSelect? <InterestSelect sports={sports} addInterest={addInterest} changeShowSelect={changeShowSelect}/>: <></>}
        </div>
    )
}