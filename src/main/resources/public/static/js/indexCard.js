// why it doesn't work on firefox?
var card = $(".card");
var card2 = $(".second");
var card3 = $(".third");

$(document).on("mousemove",function(e) {  
  var ax = -($(window).innerWidth()/2- e.pageX)/20;
  var ay = ($(window).innerHeight()/2- e.pageY)/10;
  card.attr("style", "transform: rotateY("+ax+"deg) rotateX("+ay+"deg);-webkit-transform: rotateY("+ax+"deg) rotateX("+ay+"deg);-moz-transform: rotateY("+ax+"deg) rotateX("+ay+"deg)");

  var ax2 = -($(window).innerWidth()/2- e.pageX)/20;
  var ay2 = ($(window).innerHeight()/2- e.pageY)/10;
  card2.attr("style", "transform: rotateY("+ax2+"deg) rotateX("+ay2+"deg);-webkit-transform: rotateY("+ax2+"deg) rotateX("+ay2+"deg);-moz-transform: rotateY("+ax2+"deg) rotateX("+ay2+"deg)");


});