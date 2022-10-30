import { Link } from "react-router-dom";
import './TopNavigation.css'

const TopNavigation = () => {
    return (
        <div className="layout">
            <Link to="/">
                <h2 className="header">
                    StepTrello
                </h2>
            </Link>
        </div>
    );
}

export default TopNavigation;