
import './Toolbar.css'
import { useDispatch, useSelector } from 'react-redux';
import BoardPath from './BoardPath';
import { Link } from 'react-router-dom';
import { Button } from '@mui/material';
import EditBoardDialog from '../../reusable/EditBoardDialog';
import { useState } from 'react';
import BoardUtils from '../../../utils/BoardUtils';
import { setBoardsList } from '../../../store/boardSlice';


const Toolbar = () => {

    const dispatch = useDispatch()

    const login = useSelector(state => state.login)
    const board = useSelector(state => state.board)
    const note = useSelector(state => state.note.name)

    //Alert control
    const [open, setOpen] = useState(false);

    const handleClickOpen = () => {
      setOpen(true);
    };
  
    const handleClose = () => {
      setOpen(false);
    };

    const requestSettled = () => {

    }

    const requestBoardsSettled = (response) => {
        dispatch(setBoardsList(response.data));
    }

    const requestBoardsRejected = () => {

    }

    const requestBoardChange = async (boardInfo) => {
        handleClose();
        const saved = localStorage.getItem("access_token");
        const initial = JSON.parse(saved);
        await BoardUtils.requestBoardChange(
            boardInfo.board_id,
            initial,
            {
                name: boardInfo.title,
                ownerLogin: login.userName,
                notesArrayList: null,
                collaboratorsArrayList: null,
                tagName: boardInfo.tag,
                description: boardInfo.description
            },
            requestSettled,
            requestBoardsRejected
        )
        await BoardUtils.requestBoards(login.userName, initial,requestBoardsSettled, requestBoardsRejected)
    }

    const deleteBoardFunction = async (id) => {
        handleClose();
        const saved = localStorage.getItem("access_token");
        const initial = JSON.parse(saved);
        await BoardUtils.requestBoardDeletion(id, initial);
        await BoardUtils.requestBoards(login.userName, initial, requestBoardsSettled, requestBoardsRejected)
    }

    const editBoard = () => {
        handleClickOpen();
    }

    return (
        <div className='toolbar'>
            <h3 className='subpage_title'>
                { note !== "" ? note : board.boardName !== "" ? board.boardName : "Dashboard"}
            </h3>
            <span>
                <span>
                    <label name="search" id="search">Search: </label>
                    <input type="text" name='search' id="search" placeholder='input filter'></input>
                </span>

                <BoardPath />
            </span>

            <Button 
                variant="contained" 
                color="primary" 
                type="submit" 
                sx={{backgroundColor: "white", color: "black", width: "2vw", height: "3vh", margin: "1vw"}} 
                onClick={() => editBoard()}>
                Edit Board
                </Button>

            <button>
                { board.boardName !== "" &&
                    <Link to={"/access/dashboard/add-board"}>
                        Add Note
                    </Link>  }
                { board.boardName === "" &&
                <Link to={"/access/dashboard/add-board"}>
                    Add board
                </Link> }
            </button>
            <EditBoardDialog
                open={open}
                onClose={handleClose}
                SendDataFunction={requestBoardChange}
                deleteFunction={deleteBoardFunction}
            />
        </div>
    );
}

export default Toolbar;