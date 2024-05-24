const http = require("http");
const url = require("url");
const path = require("path");
const fs = require("fs");
const m1 = require("./Circle");

const server = http.createServer(function (req, res) {
  var p = url.parse(req.url, true);
  res.writeHeader(200, { "Content-Type": "text/html" });
  switch (p.pathname) {
    case "/form":
      var rs = fs.createReadStream("form.html");
      rs.pipe(res);
      break;
    case "/submit":
      var radius = p.query.num;
      var area = m1.calArea(radius);
      var peri = m1.calPeri(radius);

      res.write("Area is:" + `${area}` + "<br>");
      res.write("Perimeter is:" + `${peri}`);
      break;
      res.end();
    default:
      console.log("server ended...");
      res.end();
      break;
  }
});

server.listen(3002, function (req, res) {
  console.log("server started");
});
