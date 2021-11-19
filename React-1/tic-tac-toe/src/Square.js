import "./Square.css"
export default function Square(props){
    return (
        <button className="square" onClick={props.onSquareClick}>{props.value}</button>
    );
}