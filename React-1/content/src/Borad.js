import Square from "./Square";
import "./Board.css"
import { useState } from "react";

export default function Board() {
    const [squares, setSquares] = useState(Array(9).fill(""));
    const [isOTurn, setIsOTurn] = useState(true);
    function renderSquare(id) {
        function onSquareClick() {
            handleSqureClick(id)
        }
        return (<Square value={squares[id]} onSquareClick={onSquareClick}></Square>)
    }
    function handleSqureClick(id) {
        const newSquares = [...squares]
        // const newSquares=Array(9).fill("")
        // for(let i=0;i<squares.length;i++){
        //     newSquares[i]=squares[i];
        // }
        if (newSquares[id] === "") {
            if (isOTurn) {
                newSquares[id] = "O"
                setIsOTurn(false)
            } else {
                newSquares[id] = "X"
                setIsOTurn(true)
            }
            setSquares(newSquares)
        }
    }
    function isWon() {
        const winningCondictions = [
            [0, 1, 2],
            [3, 4, 5],
            [6, 7, 8],
            [0, 3, 6],
            [1, 4, 7],
            [2, 5, 8],
            [0, 4, 8],
            [2, 4, 6],
        ]
        //0|1|2  O|X|X
        //3|4|5  O|O|O
        //6|7|8  X| | 
        for (let c of winningCondictions) {
            if (squares[c[0]] === squares[c[1]]&&squares[c[1]] ===squares[c[2]]&&
                (squares[c[0]]!=="")) {
                return true;
            }
        }
        return false;
    }
    let status = isWon()?`${isOTurn?"X":"O"} Won`:`${isOTurn?"O":"X"} Turn`;
    // if(isWon()){
    //     status="Won";
    // }else{
    //     if(isOTurn){
    //         status="O Turn"
    //     }else{
    //         status="X Turn"
    //     }
    // }
    return (
        <div>
            <div className="tic-tac-toe">
                <div>
                    <div>Tic Tac Toe</div>
                    <div className="status">{status}</div>
                    <div className="board-row">
                        {renderSquare(0)}
                        {renderSquare(1)}
                        {renderSquare(2)}
                    </div>
                    <div className="board-row">
                        {renderSquare(3)}
                        {renderSquare(4)}
                        {renderSquare(5)}
                    </div>
                    <div className="board-row">
                        {renderSquare(6)}
                        {renderSquare(7)}
                        {renderSquare(8)}
                    </div>
                </div>
            </div>
        </div>
    );
}