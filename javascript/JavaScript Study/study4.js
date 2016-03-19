'use strict';

var arr = [1, 3, 5, 7, 9];

var result = arr.reduce(function (x, y) {
     return x * y; 
});

alert(result);

var s = "12345"
arr = s.split("");
alert(arr);
