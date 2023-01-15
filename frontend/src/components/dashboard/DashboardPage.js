import './DashboardPage.css'
import Toolbar from './toolbar/Toolbar';
import { Outlet } from 'react-router-dom';
import CircularProgress from '@mui/material/CircularProgress';
import { useSelector } from 'react-redux';
import { useEffect, useState } from 'react';

const DashboardPage = () => {

    const login = useSelector(state => state.login)

    // Visiability of loading screen control
    const blockerDisplayOption = {
        visable: {
            display: "flex"
        },
        hidden:  {
            display: "none"
        }
    }

    const assesVsiability = () => {
        return login.userName === "" ? blockerDisplayOption.visable : blockerDisplayOption.hidden
    }

    const [isBlockerOut, setIsBLockerOut] = useState(assesVsiability)

    return (
        <div className='container'>
            <Toolbar />
            <div className='dashboardBox'>
                <Outlet />
            </div>
            <div className='loadingBlocker' style={isBlockerOut}/>
        </div>
    );
}

export default DashboardPage;