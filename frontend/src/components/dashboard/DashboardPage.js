import { useState } from 'react';
import BoardPath from './BoardPath';
import './DashboardPage.css'

const DashboardPage = () => {

    const [isBoard, setIsBoard] = useState(true);

    return (
        <div className='container'>
            <div className='toolbar'>
                <span>
                    <span>
                        <label name="search" id="search">Search: </label>
                        <input type="text" name='search' id="search" placeholder='input filter'></input>
                    </span>

                    { isBoard ? <BoardPath /> : "" }
                </span>
                <button>
                    Add board
                </button>
            </div>
            <div className='dashboardBox'>
                Boards
            </div>

        </div>
    );
}

export default DashboardPage;