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


{/* <Link to={{
            pathname: "/access/dashboard/board",
            search: '?name=' + element.name,
          }}></Link> */}