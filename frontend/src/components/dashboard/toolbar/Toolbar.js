
import './Toolbar.css'
import { useSelector } from 'react-redux';
import BoardPath from './BoardPath';
import { Link } from 'react-router-dom';

const Toolbar = () => {

    const board = useSelector(state => state.board.boardName)
    const note = useSelector(state => state.note.name)

    return (
        <div className='toolbar'>
            <h3 className='subpage_title'>
                { note !== "" ? note : board !== "" ? board : "Dashboard"}
            </h3>
            <span>
                <span>
                    <label name="search" id="search">Search: </label>
                    <input type="text" name='search' id="search" placeholder='input filter'></input>
                </span>

                <BoardPath />
            </span>
            <button>
                { board !== "" && 
                <Link to={"/access/dashboard/add-board"}>
                    Add Note
                </Link> }
                { board === "" &&
                <Link to={"/access/dashboard/add-board"}>
                    Add board
                </Link> }
            </button>
        </div>
    );
}

export default Toolbar;