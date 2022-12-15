import './BoardPage.css'
import { useEffect } from 'react';
import { useSearchParams } from 'react-router-dom';
import { useSelector, useDispatch  } from 'react-redux';
import { setBoardName } from '../../../store/boardSlice'

const BoardPage = () => {

    const board = useSelector(state => state.board.boardName)
    const dispatch = useDispatch()
    const [searchParams] = useSearchParams();
    useEffect(() => {
        if(!board){
            dispatch(setBoardName(searchParams.get("name")))
        }
    })
    
    return (
        <>
            <h2>{ board }</h2>
        </>
    );
}

export default BoardPage;