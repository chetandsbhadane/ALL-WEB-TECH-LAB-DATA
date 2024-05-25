import React from 'react'
import NameForm from './NameForm'

export default function TextList(props) {
    var ob={color:"White"}

    var adddata=(name)=>{
        props.insertdata(name)
    }

    var removename=(name)=>{
      props.deletedata(name);
      
    }
  return (
    <div style={ob}>
      <ul>
        {
          props.narr.map((ob,index)=><li key={index}>{ob}</li>)
        }
      </ul>
      <NameForm insertname={adddata} deletename={removename}></NameForm>
    </div>
  )
}

