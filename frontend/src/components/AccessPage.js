import { Outlet } from "react-router-dom";
import Footer from './Footer';
import TopNavigation from './TopNavigation';

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