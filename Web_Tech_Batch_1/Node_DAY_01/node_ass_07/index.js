const http = require('http');
var fs = require('fs');
var wordcounter = require('word-count');

var server = http.createServer(function(req,resp){
    resp.writeHead(200, {'Content-Type': 'text/html'});
    fs.appendFile('mynewfile1.txt', 'Hello content!', function (err) {
        if (err) throw err;
        console.log('Saved!');
    });

    fs.readFile("mynewfile1.txt","utf8", (err, data) =>{
        console.log(data);
        if (err) {
            console.error(err);
            return;
        }
        var words = wordcounter(data);
       
        console.log(`mynewfile.txt has ${words} words`);
    })

})

server.listen(3001,function(){
    console.log("server 3001");
})