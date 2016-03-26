// console.log(global.console);
// console.log('\n');
// console.log(global.process);

process.nextTick(function () {
	console.log('nextTick callback!');
});
console.log('nextTick was set!');

process.on('exit', function (code) {
    console.log('about to exit with code:' + code);
});

if (typeof(window) === 'undefined') {
    console.log('node.js');
} else {
    console.log('browser');
}