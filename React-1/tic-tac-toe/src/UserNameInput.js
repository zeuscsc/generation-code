export default function UserNameInput(props){
    function onInput(e){
        let username=`${e.target.value} Chiu`
        props.onUserNameInput(username);
    }
    return (<input onInput={onInput}></input>);
}