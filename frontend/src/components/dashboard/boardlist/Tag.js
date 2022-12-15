import './Tag.css'

const styleGreen = {
    backgroundColor: "green",
}

const styleYellow = {
    backgroundColor: "yellow",
}

const styleRed = {
    backgroundColor: "red",
}

const Tag = () => {
    return (
        <div className="tag" style={styleGreen}>
            <div></div>
        </div>
    );
}

export default Tag;