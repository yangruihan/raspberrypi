var xiaoming = {
    name: '小明',
    age: 14,
    gender: true,
    height: 1.65,
    grade: null,
    'middle-school': '"W3C" Middle School',
    skills: ['JavaScript', 'Java', 'Python', 'Lisp']
};

alert(JSON.stringify(xiaoming, null, '    '));