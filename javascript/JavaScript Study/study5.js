function* foo(x) {
    yield x + 1; 
    yield x + 2;
    return x + 3;
}

var f = foo(5);
alert(f.next().value);
alert(f.next().value);
alert(f.next().value);
