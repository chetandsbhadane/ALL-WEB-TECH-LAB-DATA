import Header from "./components/Header";
import Footer from "./components/Footer";
import TextList from "./components/TextList";
import { useEffect, useState } from "react";
import UpdateData from "./components/UpdateData";

function App() {
  // var namearr = ["chetan","abc","xyz","hello"];
  const [namearr,setnamearr] = useState(["chetan","abc","xyz","hello"])
  const [searcharr,setsearcharr] = useState(["chetan","abc","xyz","hello"])
  const [search,setsearch] = useState("")
  // console.log(namearr);
  // console.log(search)

  useEffect(() => {
    if(search!=""){
      var newarr = namearr.filter(ob=>ob.includes(search));
      setsearcharr(newarr);
    }
    else{
      setsearcharr(namearr);
    }
  }, [search])
  
  const changesearch=(event)=>{
    setsearch(event.target.value);
  }
  const addnamearr=(name)=>{
    // console.log("in App addnamearr",name);
    setnamearr([...namearr,name])
    setsearcharr([...namearr,name])
  }

  const deletedata=(name)=>{
    var newarr = namearr.filter(ob=>ob!==name);
    setnamearr([...newarr]);
    setsearcharr([...newarr])
  }
  

  const updatedata = (name1, name2) => {
    // Create a copy of the namearr to avoid mutation
    const updatedArr = [...namearr];

    // Find the index of the element to replace
    const index = updatedArr.findIndex((item) => item === name1);

    // If the element is found (index is not -1), replace it
    if (index !== -1) {
      updatedArr[index] = name2;
      setsearcharr(updatedArr); // Update the state with the modified array
    } 
  };



  return (
    <div>
      <Header></Header>
      Search: <input type="text" name="search" id="search"
       value={search}
       onChange={changesearch}
       ></input>
      <TextList narr={searcharr} insertdata={addnamearr} deletedata={deletedata}></TextList>
      <UpdateData updatename={updatedata}></UpdateData>
      <Footer></Footer>
    </div>
  );
}

export default App;
