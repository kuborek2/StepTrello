import Tags from '../../../enums/Tags'
import './Tag.css'

const styleGreen = {
    backgroundColor: "green",
}

const styleYellow = {
    backgroundColor: "#A2A22D",
}

const styleRed = {
    backgroundColor: "red",
}

const assesColor = (value) => {
    if( value === Tags.GREEN ){
        return styleGreen
    }
    if( value === Tags.YELLOW ){
        return styleYellow
    }
    if( value === Tags.RED ){
        return styleRed
    }
}

const Tag = ({tag_color}) => {
    return (
        <div className="tag" style={assesColor(tag_color)}>
            <div></div>
        </div>
    );
}

export default Tag;