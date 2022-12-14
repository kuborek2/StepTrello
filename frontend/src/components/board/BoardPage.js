import './BoardPage.css'
import { useSelector } from "react-redux";

const BoardPage = () => {

    const board = useSelector(state => state.board.boardName)
    
    return (
        <>
            <h2>{ board }</h2>
        </>
    );
}

export default BoardPage;