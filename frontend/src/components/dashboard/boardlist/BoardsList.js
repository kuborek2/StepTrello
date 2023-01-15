import _ from 'lodash';
import Tags from '../../../enums/Tags';
import BoardElement from './BoardElement';
import { useDispatch, useSelector } from "react-redux";
import { setBoardName } from '../../../store/boardSlice'
import { useEffect, useState } from 'react';

const BoardsList = () => {

    const dispatch = useDispatch()
    const board = useSelector(state => state.board.boardsList)
    const [boardList, setBoardList] = useState(board)

    useEffect(() => {
        dispatch(setBoardName(["",-1]))
    })

    const List = ({list}) => {
        if( list && _.isEmpty(list) ){
            return (<></>);
        } else {
            let result = list.map((elem) => {
                if ( _.isObject(elem) ){
                    let keys = Object.keys(elem);
                    if( keys.includes("name") && keys.includes("description") && keys.includes("tagName") && keys.includes("board_id") ){
                        return (
                            <BoardElement element={elem} key={elem.board_id}/>
                        );
                    }
                }
                return '';
            })
            return result;
        }
        
    }

    return (
        <>
            <List list={board}/>
        </>
    );
}

export default BoardsList;