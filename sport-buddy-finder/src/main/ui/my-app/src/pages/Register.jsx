export default function (){
    function handleRegistration(){

    }



    return(
        <div>
            <form>
                <div className="mb-3">
                    <label for="name" class="form-label">Name: </label>
                    <input id="name" placeholder="John Doe"></input>
                </div>
                <div className="mb-3">
                    <label htmlFor="email" className="form-label">Email address: </label>
                    <input id="email" type="email" placeholder="example@gmail.com"></input>
                </div>
                <div className="mb-3">
                    <label for="password" class="form-label">Password: </label>
                    <input id="password" type={"password"} placeholder="********"></input>
                </div>

                <div className="mb-3 form-check">
                    <label>Sport interests:</label><br/>
                    <input type="checkbox" className="form-check-input" id="exampleCheck1"></input>
                    <label className="form-check-label" htmlFor="exampleCheck1">Check1</label>
                    <input type="checkbox" className="form-check-input" id="exampleCheck2"></input>
                    <label className="form-check-label" htmlFor="exampleCheck2">Check2</label>
                    <input type="checkbox" className="form-check-input" id="exampleCheck3"></input>
                    <label className="form-check-label" htmlFor="exampleCheck3">Check3</label>
                </div>
                <button> Save </button>
            </form>
        </div>

    )
}