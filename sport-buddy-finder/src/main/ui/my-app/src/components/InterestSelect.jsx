import {Button, Form} from "react-bootstrap";

export default function InterestSelect({sports, addInterest, changeShowSelect}){
    return (
        <div style={{ display: "flex"}}>
        <Form.Select style={{width: "20vw", marginTop: "0.3rem"}} onChange={(e) => {
            addInterest({name: e.target.value})
            console.log(e.target.value)
        }} id="type"
                     required={true}>
            <option value={sports} selected disabled>Select your option</option>
            {sports.map((category) => <option value={category.name}
                                              key={category.id}>{category.name}</option>)}
        </Form.Select>
        <Button onClick={() => {changeShowSelect(false)}}>Close</Button>
        </div>
    )
}