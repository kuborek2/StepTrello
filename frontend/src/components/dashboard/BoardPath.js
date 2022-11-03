import { useState } from 'react';
import { useSelector } from "react-redux";
import './BoardPath.css'
import PathElement from './PathElement';

const BoardPath = ({props}) => {

    const board = useSelector(state => state.board)

    return (
        <>
        <button id="path">
            <h4>
                Path: <PathElement element={"dashboard"} linkPath={"/access/dashboard"}/> / <PathElement element={board.name} linkPath={"/access/dashboard/"+board.name}/>
            </h4>
        </button>
        </>
    );
}

export default BoardPath;