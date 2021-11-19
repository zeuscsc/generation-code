import { useState } from "react";
import "./TicTacForm.css"

export default function TicTacForm(){
    const [username,setUsername]=useState("");
    const [password,setPassword]=useState("");
    function inputUsername(event){
        const name=event.target.value;
        setUsername(name)
    }
    function inputPassword(event){
        const pw=event.target.value;
        setPassword(pw)
    }
    async function onTicTacFormSubmit(event){
        event.preventDefault();
        const name=event.target[0].value
        const pw=event.target[1].value
        // console.log(name,pw)
        // console.log(username,password)
        let res= await fetch("http://localhost:8081/authenticate",{
            "method":"POST",
            "headers":{
                "Content-Type":"application/json"
            },
            "body":JSON.stringify({"username":username,"password":password})
        })
        let token=await res.json();
        localStorage.setItem("token",token.token)
        console.log(token)
    }
    return (
        <form onSubmit={onTicTacFormSubmit}>
            <div>
                <label>Username:</label>
                <input id="username" name="username" type="text" value={username} onInput={inputUsername}></input>
            </div>
            <div>
                <label>Password:</label>
                <input id="password" name="password" type="password" value={password} onInput={inputPassword}></input>
            </div>
            <div>
                <input type="submit" value="Submit"></input>
            </div>
        </form>
    );

}