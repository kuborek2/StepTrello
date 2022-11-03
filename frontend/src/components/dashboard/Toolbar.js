import './Toolbar.css'
import { useState } from 'react';
import BoardPath from './BoardPath';

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
                Add board
            </button>
        </div>
    );
}

export default Toolbar;