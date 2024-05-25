import React,{useState} from 'react'

export default function NameForm(props) {
    const [name,setname]=useState("");
    const changename=(event)=>{
         setname(event.target.value)
    }
    const addname=()=>{
        //pass the name to parent
        props.insertname(name);
        //clear the text box
        setname("");
    }
    const deletename=()=>{
        console.log("in nameform delete")
        //step 1 
        props.removename(name);
        //clear the text box
        setname("");
    }
  return (
    <div>
        <form>
            <label htmlFor="nm">Name : </label>
            <input type="text" name="name" id="nm"
            value={name}
            onChange={changename}></input><br></br>
            <button type="button" name='btn' id='add' value='add' onClick={addname}>Add name</button>

            <button type="button" name='btn' id='del' value='del' onClick={deletename}>Delete name</button>
        </form>
    </div>
  )
}
