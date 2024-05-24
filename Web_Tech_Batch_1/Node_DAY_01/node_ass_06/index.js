const http = require('http');

var server = http.createServer(function(req,resp){
    resp.writeHead(200, {'Content-Type': 'text/html'});
    resp.end("<h1>Welcome to nodejs</h1>")
})

server.listen(5000,function(){
    console.log("Server is running on port 5000");
})