var Student = {
    name: 'Robot',
    height: 1.2,
    run: function () {
         alert(this.name + ' is running');
    }
};

var xiaoming = {
    name: '小明'
};

xiaoming.__proto__ = Student;

alert(xiaoming.name);
xiaoming.run();

function createStudent (name) {
     var s = Object.create(Student);
     s.name = name;
     return s;
}

var xiaohong = createStudent('小红');
xiaohong.run();