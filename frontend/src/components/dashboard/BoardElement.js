import './BoardElement.css'
import Tag from './Tag';
import { Link } from 'react-router-dom';

const BoardElement = ({element}) => {
    return (
        <Link to={{
            pathname: "/access/dashboard/board",
            search: '?name=' + element.name,
          }}>
            <div className='boardBox'>
                <div class="tagsBox">
                    <Tag/>
                </div>
                <h3>
                    {element.name}
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