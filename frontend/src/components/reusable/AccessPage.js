import { Outlet } from "react-router-dom";
import Footer from './Footer';
import TopNavigation from './TopNavigation';

// const divStyle = {
//     width: '100%',
//     overflow: 'hidden'
// };

const AccessPage = () => {
    return (
        <div>
            <TopNavigation/>
            <Outlet />
            <Footer/>
        </div>
    );
}

export default AccessPage;