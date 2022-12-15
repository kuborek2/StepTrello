import { useSelector, useDispatch } from "react-redux";
import './BoardPath.css'
import { setBoardName } from '../../../store/boardSlice'
import { Link } from "react-router-dom";

const BoardPath = () => {

    const board = useSelector(state => state.board.boardName)
    const note = useSelector(state => state.note.name)

    const ResetPath = () => {
        const dispatch = useDispatch()
        dispatch(setBoardName(""))
    }

    console.log(board.constructor.name)
    console.log(board)

    return (
        <div id="path">
            Path: &nbsp;
            <Link to={"/access/dashboard"} onClick={() => ResetPath()}>
                { "dashboard" }
            </Link> &nbsp; 
            / &nbsp;
            { board !== "" && 
                <Link to={"/access/dashboard/board?name="+board}>
                    { board }
                </Link> } &nbsp;
            { note !== "" && 
                <Link to={"/access/dashboard/board?name="+board+"/note?name="+note}>
                    { note }
                </Link> } &nbsp;
        </div>
    );
}

export default BoardPath;