const http = require('http');
const url = require('url');
const fs = require('fs');
var myOpe = require('./index');

var server = http.createServer(function(req,res){
    var q = url.parse(req.url,true);
    console.log("q: " ,q);
    res.writeHeader(200,{'content-type':'text/html'})
    switch(q.pathname){
        case '/form':
            var rs = fs.createReadStream("./index.html");
            rs.pipe(res);
            break;
        case '/submit-data':
            var number = parseInt(q.query.num);
            if(number > 0 && number <= 5){
                var factAns = myOpe.fact(parseInt(q.query.num));
                res.write("<h2>Factorial is : "+ factAns + "</h2>");
            }else if(number > 5 && number <=10){
                var result=1;
                res.write("<h2> Table </h2>");
                for(var i=1;i<=10;i++){
                    res.write("<h2>" + number + " * " + i + " = " + number*i + "</h2>");
                }
            }
            else{
                var isPrime = myOpe.primeNo(number);
                res.write("<h2>Number is : "+ isPrime + "</h2>");
            }
            
            break;
    }
})

server.listen(3001,function(){
    console.log("server is running on port 3001");
})