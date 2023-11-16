import {Button, Form} from "react-bootstrap";
import {useState} from "react";
import InterestSelect from "./InterestSelect";

export default function UserInterests ({userInterests, user, addInterest}){
    const [sports, setSports] = useState([]);
    const [showSelect, setShowSelect] = useState(false)
    const changeShowSelect = (boolean) => {
        setShowSelect(boolean)
    }
    const fetchAllSports = () => {
        fetch("/api/sports").then((res) => res.json()).then((sports) => {
            setSports(sports);
        });
    }
    return (
        <div style={{
            paddingLeft: "30px",
            paddingTop: "10px"
        }}>
            {user.interests?.length > 0 ?
                <div><h2 style={{fontSize: "1.5em"}}>{"Interests:"}</h2>
                    {userInterests.map((interest, i) => {
                        return <Button key={i} style={{
                            display: "inline",
                            margin: "0.3rem",
                        }}>{interest.name + " "}
                        </Button>
                    })}
                    <Button onClick={()=> {
                        {
                            fetchAllSports()
                            setShowSelect(true)
                        }
                    }}>+</Button>
                </div> : <Button onClick={()=> {
                    {
                        fetchAllSports()
                        setShowSelect(true)
                    }
                }}>+</Button>}
            {showSelect? <InterestSelect sports={sports} addInterest={addInterest} changeShowSelect={changeShowSelect}/>: <></>}
        </div>
    )
}