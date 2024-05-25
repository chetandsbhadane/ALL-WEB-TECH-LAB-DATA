import React, { useState } from 'react'

export default function NameForm(props) {
    var ob = {backgroundColor:"Black",
        color:"White",
        border: "1px solid white",
        borderRadius:"10px"
    }

    var [name,setname] = useState("");

    var changeName=(event)=>{
        setname(event.target.value)
    }
    var addName=()=>{
        props.insertname(name);
        //clear the text box
        setname("");
    }

    var removeName=()=>{
      props.deletename(name)
       //clear the text box
       setname("");
    }
  return (
    <div>
      <form>
        <label htmlFor="nm">Name: </label>
        <input style={ob} type="text" name="name" id="nm"
        value={name}
        onChange={changeName}></input><br></br>
        <button type="button" name='btn' id='add' value='add' onClick={addName}>Add</button>
        <button type="button" name='btn' id='remove' value='remove' onClick={removeName}>Remove</button>
      </form>
    </div>
  )
}
