import './Toolbar.css'
import BoardPath from './BoardPath';
import { Link } from 'react-router-dom';

const Toolbar = () => {

    return (
        <div className='toolbar'>
            <span>
                <span>
                    <label name="search" id="search">Search: </label>
                    <input type="text" name='search' id="search" placeholder='input filter'></input>
                </span>

                <BoardPath />
            </span>
            <button>
                <Link to={"/access/dashboard/add-board"}>
                    Add board
                </Link>
            </button>
        </div>
    );
}

export default Toolbar;