var a = ['A', 'B', 'C'];
var s = new Set(['A', 'B', 'C']);
var m = new Map([[1, 'x'], [2, 'y'], [3, 'z']]);
for (var x of a) { // 遍历Array
    alert(x);
}
for (var x of s) { // 遍历Set
    alert(x);
}
for (var x of m) { // 遍历Map
    alert(x[0] + '=' + x[1]);
}

a.forEach(function (element, index, array) {
    alert(element);
});

s.forEach(function (element, sameElement, set) {
    alert(element);
});

m.forEach(function (value, key, map) {
    alert(value);
});