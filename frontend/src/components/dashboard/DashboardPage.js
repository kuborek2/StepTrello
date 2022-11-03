import './DashboardPage.css'
import Toolbar from './Toolbar';
import _ from 'lodash';
import Tags from '../../enums/Tags';
import BoardElement from './BoardElement';

const DashboardPage = () => {

    let initialList = [
        {
            name: 'board1',
            description: "A description of board1",
            tags: [Tags.GREEN, Tags.YELLOW]
        },
        {
            name: 'board2',
            description: "A description of board2, A description of board2, A description of board2, A description of board2, end of board2 description",
            tags: [Tags.RED]
        },
        {
            name: 'board3',
            description: "A description of board3",
            tags: [Tags.GREEN]
        }
    ]

    const BoardsList = ({list}) => {
        if( list && _.isEmpty(list) ){
            return (<></>);
        } else {
            let result = list.map((elem) => {
                if ( _.isObject(elem) ){
                    let keys = Object.keys(elem);
                    if( keys.includes("name") && keys.includes("description") && keys.includes("tags") ){
                        return (
                            <BoardElement elem={elem}/>
                        );
                    }
                }
            })
        }
    }

    return (
        <div className='container'>
            <Toolbar />
            <div className='dashboardBox'>
                Boards
            </div>

        </div>
    );
}

export default DashboardPage;