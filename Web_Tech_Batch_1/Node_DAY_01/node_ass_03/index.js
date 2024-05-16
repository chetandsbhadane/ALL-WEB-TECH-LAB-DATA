const http = require("http");
const fs = require("fs");
const url = require("url");
var circle = require("./circleModule");
var rect = require("./rectModule");

var server = http.createServer(function (req, res) {
  var q = url.parse(req.url, true);
  res.writeHeader(200, { "content-type": "text/html" });
  console.log(q.pathname);
  switch (q.pathname) {
    case "/circle":
      rs = fs.createReadStream("./circle.html");
      rs.pipe(res);
      break;
    case "/circle-area":
      const radius = parseInt(q.query.radius);
      var areaCircle = circle.calcArea(radius);
      var Circum = circle.calcCircumfenece(radius);
      var diameter = circle.calcDiameter(radius);
      res.write("<h2>Area Of Circle is : " + areaCircle);
      res.write("<h2>Circumfernece Of Circle is : " + Circum);
      res.end("<h2>Diameter Of Circle is : " + diameter);
      break;

    case "/rect":
      rs = fs.createReadStream("./rect.html");
      rs.pipe(res);
      break;

    case "/rect-func":
      const length = parseInt(q.query.length);
      const breadth = parseInt(q.query.breadth);
      var areaRect = rect.calcArea(length, breadth);
      var rectPeri = rect.calcPerimeter(length, breadth);
      res.write("<h2>Area Of Rect is : " + areaRect);
      res.end("<h2>Perimeter Of Rect is : " + rectPeri);
      break;
  }
});

server.listen(3001, function () {
  console.log("Server is running on 3001");
});
