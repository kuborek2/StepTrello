import './BoardPage.css'
import { useEffect } from 'react';
import { Outlet, useSearchParams } from 'react-router-dom';
import { useSelector, useDispatch  } from 'react-redux';
import { setBoardName } from '../../../store/boardSlice'

const BoardPage = () => {

    const board = useSelector(state => state.board.boardName)
    const dispatch = useDispatch()
    const [searchParams] = useSearchParams();
    useEffect(() => {
        if(!board){
            dispatch(setBoardName([searchParams.get("name"), -1])) // TODO - update pagination to request data from backend if user enters thorugh link and update id
        }
    })
    
    return (
        <>
            <Outlet/>
        </>
    );
}

export default BoardPage;