import React,{useState} from 'react'

export default function UpdateData(props) {
  var ob = {backgroundColor:"Black",
  color:"White",
  border: "1px solid white",
  borderRadius:"10px"
}

var [updatedname1,setupdatedname1] = useState("");
var [updatedname2,setupdatedname2] = useState("");
const updateName1=(event)=>{
    setupdatedname1(event.target.value);
}
const updateName2=(event)=>{
    setupdatedname2(event.target.value);
}
var updatedName=()=>{
  props.updatename(updatedname1,updatedname2);
  //clear the text box
  // setupdatedname("");
}
  return (

    <div>
        <form>
        <label htmlFor="nm">Name: </label>
        <input style={ob} type="text" name="name" id="nm" value={updatedname1}
        onChange={updateName1}
        ></input><br></br>
        <label htmlFor="nm2">NameToUpdate: </label>
        <input style={ob} type="text" name="name2" id="nm2" value={updatedname2}
        onChange={updateName2}
       ></input><br></br>
        <button type="button" name='btn' id='add' value='add' onClick={updatedName}>Update</button>
      </form>
    </div>
  )
}
