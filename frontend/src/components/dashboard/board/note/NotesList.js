import _ from 'lodash';
import { useDispatch, useSelector } from "react-redux";
import { setNoteName } from '../../../../store/noteSlice'
import { useEffect } from 'react';
import NoteElement from './NoteElement';

const NotesList = () => {

    const dispatch = useDispatch()
    const board = useSelector(state => state.board)

    useEffect(() => {
        dispatch(setNoteName(""))
    })

    let initialList = [
        {
          note_id: 1,
          title: "kurde",
          description: "witam, witam o zdrowie pytam",
          board_id: 1
        },
        {
          note_id: 2,
          title: "sok",
          description: "nie pytam o zdrowie",
          board_id: 3
        },
        {
          note_id: 3,
          title: "pieprz",
          description: "zdrowie ah tak",
          board_id: 1
        }
    ]

    const List = ({list}) => {
        if( list && _.isEmpty(list) ){
            return (<></>);
        } else {
            let result = list.filter((elem) => {
                if ( _.isObject(elem) ){
                    let keys = Object.keys(elem);
                    if( keys.includes("note_id") && keys.includes("title") && keys.includes("description") && keys.includes("board_id") && elem.board_id === board.boardId ){ // && elem.board_id === board.boardId
                      return true;
                    }
                }
                return false;
            }).map((elem) => {
              return <NoteElement element={elem} key={elem.note_id}/>
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

export default NotesList;