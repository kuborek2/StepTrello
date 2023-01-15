import './BoardElement.css'
import Tag from './Tag';
import { Link } from 'react-router-dom';
import { useDispatch } from "react-redux";
import { setBoardName } from '../../../store/boardSlice'
import { Button } from '@mui/material';

const BoardElement = ({element, editFunction}) => {
  
    const dispatch = useDispatch()

    const changeBoardSliceState = () => {
        dispatch(setBoardName([element.name, element.board_id]))
    }

    return (
        <Link to={{
            pathname: "/access/dashboard/board",
            search: '?name=' + element.name,
            }} 
            onClick={() => changeBoardSliceState()}>
            <div className='boardBox'>
                <div className='tagsBox'>
                    <Tag tag_color={element.tagName}/>
                </div>
                <h3>
                    {element.board_id}. {element.name}
                </h3>
                <article>
                    {element.description}
                </article>
            </div>
        </Link>
    );
}

export default BoardElement;

// search: "?sort=name",