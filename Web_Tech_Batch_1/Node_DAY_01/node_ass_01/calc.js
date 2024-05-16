exports.addition = function(x,y){
    return x+y;
}

exports.sub = function(x,y){
    return x-y;
}

exports.mul = function(x,y){
    return x*y;
}

exports.div = function(x,y){
    return x/y;
}

exports.fact = function(x){
    var fact=1;
    for(var i=1;i<=x;i++){
        fact = fact*i;
    }
    return fact;
}

exports.max = function(x){
    var max = x[0];
    for(var i=0;i<x.length;i++){
        if(max < x[i]){
            max = x[i];
        }
    }
    return max;
}

exports.min = function(x){
    var min = x[0];
    for(var i=0;i<x.length;i++){
        if(min > x[i]){
            min = x[i];
        }
    }
    return min;
}