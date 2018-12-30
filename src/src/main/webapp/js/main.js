$(window).scroll(onScroll);

function onScroll() {
    var x=30 - ($(window).scrollTop()/$(document).height()*100);
    //$('.home .jumbotron').css({'background-position': '50% ' + ($(window).scrollTop() - $('.home .jumbotron ').offset().top) * .4 + 'px'});
    $('.home .jumbotron').css({'background-position': '50% ' + x+"%"});
};
onScroll();