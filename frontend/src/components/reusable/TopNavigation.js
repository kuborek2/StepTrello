import { useDispatch, useSelector } from "react-redux";
import { Link, useNavigate } from "react-router-dom";
import { toggleLogin } from "../../store/loginSlice";
import './TopNavigation.css'

const TopNavigation = () => {

    const navigate = useNavigate();

    const dispatch = useDispatch()

    const LogOut = () => {
        dispatch(toggleLogin(""))
        navigate("/");
    }

    const login = useSelector(state => state.login)
    const UserControlButtons = (...props) => {
        return (
            <div className="userControlButtons">
                <button disabled id="userName">
                    { login.userName }
                </button>
                <button id="logOutBtn" onClick={() => LogOut()}>
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