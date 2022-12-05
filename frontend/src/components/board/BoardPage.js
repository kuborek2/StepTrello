import './BoardPage.css'
import { useSearchParams } from 'react-router-dom';
import { useSelector, useDispatch } from "react-redux";
import { setBoardName } from '../../store/boardSlice'

const BoardPage = () => {

    const [searchParams, setSearchParams] = useSearchParams();
    const name = searchParams.get("name")

    const dispatch = useDispatch()
    dispatch( setBoardName(name))

    return (
        <>
            <h2>{ name }</h2>
        </>
    );
}

export default BoardPage;