const http = require('http');

var server = http.createServer(function(req,res){
    res.writeHead(200,{'Content-Type':'text/html'});
    for(var i=1;i<=100;i++){
        res.write("<h2>"+i);
        if((i%3==0) && (i%5==0)){
            res.write(" fizzbuzz");
        }
        else if(i%5==0){
            res.write(" buzz");
        }
        else if(i%3==0){
            res.write(" fizz");
        }
    }
    res.end("</h2>");
})

server.listen(3001,function(){
    console.log("server running on port 3001");
})