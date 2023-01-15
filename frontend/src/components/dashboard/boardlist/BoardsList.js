import _ from 'lodash';
import Tags from '../../../enums/Tags';
import BoardElement from './BoardElement';
import { useDispatch } from "react-redux";
import { setBoardName } from '../../../store/boardSlice'
import { useEffect } from 'react';

const BoardsList = () => {

    const dispatch = useDispatch()

    useEffect(() => {
        dispatch(setBoardName(["",-1]))
    })

    let initialList = [
        {
            board_id: 1,
            name: 'board1',
            description: "A description of board1",
            tags: [Tags.GREEN, Tags.YELLOW]
        },
        {
            board_id: 2,
            name: 'board2',
            description: "A description of board2, A description of board2, A description of board2, A description of board2, end of board2 description",
            tags: [Tags.RED]
        },
        {
            board_id: 3,
            name: 'board3',
            description: "A description of board3",
            tags: [Tags.GREEN]
        }
    ]

    const List = ({list}) => {
        if( list && _.isEmpty(list) ){
            return (<></>);
        } else {
            let result = list.map((elem) => {
                if ( _.isObject(elem) ){
                    let keys = Object.keys(elem);
                    if( keys.includes("name") && keys.includes("description") && keys.includes("tags") && keys.includes("board_id") ){
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
            <List list={initialList}/>
        </>
    );
}

export default BoardsList;