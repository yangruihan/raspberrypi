'use strict'

var fs = require('fs');

fs.readFile('sample.txt', 'utf-8', function(err, data){
    if (err) {
        console.log(err);
    } else {
        console.log(data); 
    }
});

var data = 'Hello, Node.js';
fs.writeFile('output.txt', data, function (err) {
    if (err) {
        console.log(err);
    } else {
        console.log('ok.');
    }
});

fs.stat('sample.txt', function (err, stats) {
    if (err) {
        console.log(err);
    } else {
        console.log('isFile: ' + stats.isFile());
        console.log('isDirectory: ' + stats.isDirectory());
        if (stats.isFile()) {
            console.log('size: ' + stats.size);
            console.log('birth time: ' + stats.birthtime);
            console.log('modified time: ' + stats.mtime);
        }
    }
});