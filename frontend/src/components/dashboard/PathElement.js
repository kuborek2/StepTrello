import './PathElement.css'
import { Link } from "react-router-dom";

const PathElement = ({props, element, linkPath}) => {
    return (
        <>
            <Link to={linkPath}>
                { element }
            </Link>
        </>
    );
}

export default PathElement;