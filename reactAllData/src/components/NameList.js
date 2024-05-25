import React from 'react'
import NameForm from './NameForm'

export default function NameList(props) {
    console.log(props)
    console.log("in NameList component----3")
    const adddata=(name)=>{
        console.log("in adddata of namelist",name);
        //pass to parent
        props.insertdata(name); 
    }
    const deletdata=(name)=>{
        console.log("in namelist delete")
        props.removedata(name);
    }
  return (
    <div>
    <ul>
    {
        props.narr.map((ob,index)=><li key={index}>{ob}</li>)
    }
    </ul>
    <NameForm insertname={adddata} removename={deletdata}></NameForm>
    </div>
  )
}
