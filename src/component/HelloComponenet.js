import React from "react";

export default function HelloComponenet(props) {
  console.log(props);

  return (
    <div >
      <h2>Hello this is {props.data2.username}</h2>
    </div>
  );
}
