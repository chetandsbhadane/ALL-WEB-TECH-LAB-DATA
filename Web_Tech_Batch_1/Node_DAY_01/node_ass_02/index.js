exports.fact = function(num){
    var fact=1;
    for(var i=1;i<=num;i++){
        fact = fact*i;
    }
    return fact;
}

exports.primeNo = function(num){
    for(var i=2;i<=num/2;i++){
        if(num%i === 0){
            return "Not Prime Number";
        }
    }
    return "Prime Number";
}

