import './BoardElement.css'
import Tag from './Tag';

const BoardElement = ({element}) => {
    return (
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
    );
}

export default BoardElement;