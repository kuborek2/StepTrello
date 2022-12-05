import { useSelector } from "react-redux";
import './BoardPath.css'
import PathElement from './PathElement';

const BoardPath = ({props}) => {

    const board = useSelector(state => state.board.name)
    const note = useSelector(state => state.note.name)
    

    return (
        <>
        <button id="path">
            <h4>
                Path: &nbsp;
                <PathElement element={"dashboard"} linkPath={"/access/dashboard"}/> &nbsp; 
                / &nbsp;
                { board !== "" ? <PathElement element={board} linkPath={"/access/dashboard/"+board}/> + '\t/' : "" } &nbsp;
                { note !== "" ? <PathElement element={note} linkPath={"/access/dashboard/"+note}/> + '\t/' : "" } &nbsp;
            </h4>
        </button>
        </>
    );
}

export default BoardPath;