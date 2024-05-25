import logo from './logo.svg';
import {useState,useEffect} from 'react';
import './App.css';
import Header from './components/Header';
import Footer from './components/Footer';
import NameList from './components/NameList';
function App() {
  //array of names
  //var namearr=["Kanchan","Pramod","Manjiri","Girish"]
  //var search="";
  const [namearr,setnamearr]=useState(["Kanchan","Pramod","Manjiri","Girish"])
  const [searcharr,setsearcharr]=useState(["Kanchan","Pramod","Manjiri","Girish"])
  const [search,setsearch]=useState("");
  //this useEffect function will get called every tome you cnage the value
  //of search state.
  useEffect(()=>{
    console.log("use Effect search---2 "+search);
    if(search!=""){
        var newarr=namearr.filter(ob=>ob.includes(search));
        setsearcharr(newarr);
    }else{
        setsearcharr(namearr);
    }
  },[search])
  const changesearch=(event)=>{
    console.log("onchange--1");
    //changes the value of search when change event occurs
    setsearch(event.target.value)
  }
  //add name in namearr and searcharr
  const addnamearr=(name)=>{
    console.log("in App addnamearr",name);
    setnamearr([...namearr,name])
    setsearcharr([...namearr,name]) 
  }
  //remove name from namearr and searcharr
  const removenamearr=(name)=>{
    console.log("in App delete")
    var newarr=namearr.filter(ob=>ob!==name)
    setnamearr([...newarr]);
    setsearcharr([...newarr]);
  }
  return (
    <div>
       <Header></Header>
       Search: <input type="text" name="search" id="search"
       value={search}
       onChange={changesearch}
       ></input>
       {/* passing array to NameList Component via props */}
       <NameList narr={searcharr} p1="10" insertdata={addnamearr} removedata={removenamearr}></NameList>
       <Footer></Footer>
    </div>
  );
}

export default App;
