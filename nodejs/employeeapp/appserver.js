var http = require('http');
var employeeService = require('./lib/employees');
var responder = require('./lib/responseGenerator');
var staticFile = responder.staticFile('/public');

http.createServer(function (req, res) {
    var _url;

    req.method = req.method.toUpperCase();
    console.log(req.method + ' ' + req.url);

    if (req.method !== 'GET') {
        res.writeHead(501, {'Content-Type': 'text/plain'});
        return res.end(req.method + ' is not implemented by this server.');
    }

    if (_url = /^\/employees(\/?)$/i.exec(req.url)) {
        // return a list of employees
        employeeService.getEmployees(function (error, data) {
            if (error) {
                // send a 500 error
                return responder.send500(error, res);
            }
            // send the data with a 200 status code
            return responder.sendJson(data, res);
        });
    } else if (_url = /^\/employees\/(\d+)$/i.exec(req.url)) {
        // find the employee by the id in the route
        employeeService.getEmployee(_url[1], function (error, data) {
            if (error) {
                // send a 500 error
                return responder.send500(error, res);
            }

            if (!data) {
                // send a 404 error
                return responder.send404(res);
            }

            // send the data with a 200 status code
            return responder.sendJson(data, res);
        });
    } else {
        // try to send the static file
        //res.writeHead(200);
        staticFile(req.url, res);
    }

}).listen(1337, 'localhost');

console.log('Server running at http://localhost:1337/');
