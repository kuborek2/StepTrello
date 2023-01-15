import './DashboardPage.css'
import Toolbar from './toolbar/Toolbar';
import { Outlet } from 'react-router-dom';
import CircularProgress from '@mui/material/CircularProgress';
import { useDispatch, useSelector } from 'react-redux';
import { useEffect, useState } from 'react';
import { requestBoards, setBoardsList } from '../../store/boardSlice';
import BoardUtils from '../../utils/BoardUtils';
import SimpleAlert from '../reusable/SimpleAlert';

const DashboardPage = () => {

    //Alert control
    const [open, setOpen] = useState(false);
    const [alertInfo, setAlertInfo] = useState({
        title: "",
        content: ""
    })

    const handleClickOpen = () => {
      setOpen(true);
    };
  
    const handleClose = () => {
      setOpen(false);
    };

    const login = useSelector(state => state.login)
    const board = useSelector(state => state.board)
    const note = useSelector(state => state.note)
    const dispatch = useDispatch()

    const requestBoardsSettled = (response) => {
        dispatch(setBoardsList(response.data));
    }

    const requestBoardsRejected = () => {
        setAlertInfo({
            title: "Pobranie danych o boardach nie powidoło się",
            content: ""
        })
        handleClickOpen();
    }

    useEffect(() => {
        if( login.userName !== ""){
            setIsBLockerOut(blockerDisplayOption.visable)
            setIsLoading(blockerDisplayOption.visable)
            BoardUtils.requestBoards(login.userName, requestBoardsSettled, requestBoardsRejected)
            setIsBLockerOut(blockerDisplayOption.hidden)
            setIsLoading(blockerDisplayOption.hidden)
        }
    }, [login])

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
    const [isLoading, setIsLoading] = useState(blockerDisplayOption.hidden)

    return (
        <div className='container'>
            <Toolbar />
            <div className='dashboardBox'>
                <Outlet />
            </div>
            <div className='loadingBlocker' style={isBlockerOut}>
                <CircularProgress sx={isLoading}/>
            </div>
            <SimpleAlert
                open={open}
                onClose={handleClose}
                info={alertInfo}
            />
        </div>
    );
}

export default DashboardPage;