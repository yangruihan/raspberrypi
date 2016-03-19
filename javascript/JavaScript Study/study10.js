$(function () {
    alert("1");

    $.fn.highLight1 = function () {
        this.css('backgroundColor', '#fffceb').css('color', '#f00');
        return this;
    }   

    $('.test').highLight1();
});