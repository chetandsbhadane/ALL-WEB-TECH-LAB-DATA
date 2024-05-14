function pow(x,y){

    var pow=1;
    for(i=0;i<y;i++){
        pow = pow*x; 
    }
   return pow;
}

var x = prompt('enter base');
var y = prompt('enter expo');
let res = pow(x,y)
console.log(res);