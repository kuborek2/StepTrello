import { Link } from "react-router-dom";
import './FrontPage.css'
import Footer from './Footer'
import { useSelector } from "react-redux";

const FrontPage = () => {

    const login = useSelector(state => state.login)

    const LoggedOutUserButtons = () => {
        return (
            <div className='buttonSpace'>
                <Link to="access/signin">
                <button className="navButton">
                    Sign in
                </button>
                </Link>
                <Link to="access/register">
                    <button className="navButton">
                        Register
                    </button>
                </Link>
            </div>
        );
    }

    const LoggedInUserButton = () => {
        return (
            <div className='buttonSpace'>
                <Link to="access/dashboard">
                    <button className="navButton">
                        Go to Dashboard
                    </button>
                </Link>
            </div>
        );
    }

    return (
        <div className="pageLayout">
            <div className="topElement">
                <img src={"../resources/frontpage_logo_background.jpeg"} alt=""/>
                <article>
                    <h1>StepTrello</h1>
                    <p>
                        Personal organizer for your needs.
                        It allows you to create boards for many acitvies.
                        Each board can be organazied how ever u like.
                        You find yourself forgetting things.
                        Not anymore.
                        Register today to see how smoothly your day can go.
                    </p>
                    { login.isUserLoggedIn ? <LoggedInUserButton/> : <LoggedOutUserButtons/> }
                </article>
            </div>
            <Footer/>
        </div>
    );
  }
  
  export default FrontPage;