import { useSelector } from "react-redux";
import { Link } from "react-router-dom";
import './TopNavigation.css'

const TopNavigation = () => {

    const login = useSelector(state => state.login)
    const user = "user";
    const UserControlButtons = (...props) => {
        return (
            <div className="userControlButtons">
                <button disabled id="userName">
                    { user }
                </button>
                <button id="logOutBtn">
                    Log out
                </button>
            </div>
        );
    }

    return (
        <div className="layout">
            <Link to="/">
                <h2 className="header">
                    StepTrello
                </h2>
            </Link>
            { login.isUserLoggedIn ? <UserControlButtons/> : "" }
        </div>
    );
}

export default TopNavigation;