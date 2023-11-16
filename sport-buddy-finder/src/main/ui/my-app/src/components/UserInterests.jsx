import {Button, Form} from "react-bootstrap";
import {useState} from "react";

export default function UserInterests ({userInterests, user, addInterest}){
    const [sports, setSports] = useState([]);
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
                    })} <Button onClick={()=>{fetchAllSports()}}>+</Button>
                    {sports.length > 0 ?
                        <Form.Select style={{width: "20vw", marginTop: "0.3rem"}} onChange={(e) => {
                            addInterest({name: e.target.value})
                            console.log(e.target.value)
                        }} id="type"
                                     required={true}>
                            <option value={sports} selected disabled>Select your option</option>
                            {sports.map((category) => <option value={category.name}
                                                              key={category.id}>{category.name}</option>)}
                        </Form.Select> : <></>}
                </div> : <><Button onClick={()=>{fetchAllSports()}}>+</Button></>}
        </div>
    )
}