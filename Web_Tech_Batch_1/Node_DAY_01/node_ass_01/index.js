var calci = require('./calc');

// Calling Addition function stored in addAns
var addAns = calci.addition(10,20);
console.log("Addition is " + addAns);
//Method 2 print result...
// console.log("addition is " + calci.addition(20,60));

// Calling substraction function
var subAns = calci.sub(30,10);
console.log("substraction is " + subAns);


// Calling Multiplication function
var mulAns = calci.mul(30,10);
console.log("Multiplication is " + mulAns);


// Calling Division function
var mulDiv = calci.div(30,10);
console.log("Division is " + mulDiv);

// Calling factorial.. function
var fact = calci.fact(5);
console.log("Fact is " + fact);

//calling max function to find maximum no.
var arr= [33,66,88,99,11,88]
var max = calci.max(arr);
console.log("Maximum no " + max);

//calling Min function to find Minimum no.
var min = calci.min(arr);
console.log("Minimum no " + min);