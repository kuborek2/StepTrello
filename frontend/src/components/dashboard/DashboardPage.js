import './DashboardPage.css'
import Toolbar from './toolbar/Toolbar';
import { Outlet } from 'react-router-dom';

const DashboardPage = () => {

    return (
        <div className='container'>
            <Toolbar />
            <div className='dashboardBox'>
                <Outlet />
            </div>

        </div>
    );
}

export default DashboardPage;