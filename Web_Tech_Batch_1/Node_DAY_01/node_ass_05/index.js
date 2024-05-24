const fs = require("fs");

function readFileAndCountWords(...filename) {
  //read 1st file
  var words;
  for(var i=0;i<filename.length;i++){
    fs.readFile(filename[i], "utf8", (err, data) => {
      if (err) {
        console.error(err);
        return;
      }
      words = data.trim().split(/\s+/).length;
    
      // console.log(`${filename[1]} has ${words} words`);
    });
    console.log(`${filename[0]} has ${words} words ${filename[1]} has ${words} words`);
  }
  // fs.readFile(filename[0], "utf8", (err, data) => {
  //   if (err) {
  //     console.error(err);
  //     return;
  //   }
  //   const words = data.trim().split(/\s+/).length;
  //   console.log(`${filename} has ${words} words`);
  // });
  // //reading 2nd file
  // fs.readFile(filename[1], "utf8", (err, data) => {
  //   if (err) {
  //     console.error(err);
  //     return;
  //   }
  //   const words = data.trim().split(/\s+/).length;
  //   console.log(`${filename} has ${words} words`);
  // });
}

// function f1() {
//   console.log("in f1");
// }
// var v;
// function f2() {
//   console.log("in f2");
//   v = setInterval(f1, 1000);
// }
// function f3() {
//   clearInterval(v);
// }

function main() {
  readFileAndCountWords("myfile.data", "mydata.txt");
  console.log("hello in main");

  // console.log("before call f1")
  // f1();

  // setTimeout(()=>{console.log("hello1")},500);
  // f2();

  // setTimeout(f3,5000);
  // setTimeout(()=>{console.log("hello2")},0);
  // console.log("after settimeout f3")

  //readFileAndCountWords();
  console.log("after in main");
}

main();
