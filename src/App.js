import { useState } from "react";
import HelloComponenet from "./component/HelloComponenet";

function App() {

  let data = [ {"username":"chetan","password":1234 } ]
  let [increament,setIncrement] = useState(0);

  let btnIncreament =()=>{
    if(increament>=0)
      setIncrement(increament+1);
  }

  let btnDecreament =()=>{
    if(increament>0)
      setIncrement(increament-1);
  }

  const [changeColor, setChangeColor] = useState({});
  let prevColor = changeColor.color
  console.log("prev color " + prevColor);
  const btnChange = () => {
    setChangeColor({color:"Black"});
    if(prevColor == "White"){
     
      document.body.style.backgroundColor = 'White';
      setChangeColor({color:"Black"});
    }
    if(prevColor == "Black"){
      document.body.style.backgroundColor = 'Black';
      setChangeColor({color:"White"});
    }
    
  };

  console.log("hello " + btnDecreament);
  return (
    <div className="App" style={changeColor}>
      <h2>Hello first program!</h2>
      <HelloComponenet data2={data[0]}></HelloComponenet>
      <button onClick={btnIncreament}>Increament</button>
      <h2>{increament}</h2>
      <button onClick={btnDecreament}>Decreament</button>
      <button onClick={btnChange}>Change</button>
    </div>
  );
}

export default App;
