import {Button} from "react-bootstrap";

export const SignUpButton = ({onSignUp, onWithdraw, activity, user}) => {
    return (
        <>
            {activity.appliedUsers.filter(u => u.id === user?.id).length === 0 ?

                activity.appliedUsers.length >= activity.maxPeopleToFind ?
                    <Button disabled={true}
                            style={{margin: "1rem", padding: "0.3rem", width: "5rem"}}>Full</Button>
                    :
                    <Button className="button" type="button" onClick={() => {
                        onSignUp(activity.id, user)
                    }} style={{margin: "1rem", padding: "0.3rem", width: "5rem"}} disabled={!user}>Sign Up</Button>


                :
                <Button className="button" type="button" onClick={() => {
                    onWithdraw(activity.id, user)
                }} style={{margin: "1rem", padding: "0.3rem", width: "5rem"}} disabled={!user}>Withdraw</Button>
            }
        </>
    )
}