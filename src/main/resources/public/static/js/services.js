  /*$("#services_").hide();
  $("#services1").hide();
  $("#services2").hide();
  $("#services3").hide();

  $("#welcome_").addClass("animated zoomIn");
  $("#welcome_2").addClass("animated zoomIn");
  */
  $( document ).ready(function() {

    $("#bt_tell_more").addClass("animated fadeInLeftBig");




$( "#logoHREF" ).click(function() {
  $("#img_truck-active").addClass("img_truck-active");
});




  //  $(".lighter").hide();
  $("#bt_tell_more").click(function() {

    $(this).addClass("animated flipOutX");
  // $(".lighter").show();
  });

  $(".message_send").hide();

  $("#btnSendMesage").click(function() {
    $(this).addClass("animated fadeOut");
    $("#contactForm").addClass("animated fadeOut");
    
    
    $(".message_send").show();
    $(".message_send").addClass("animated bounceIn");
  
  // $(".lighter").show();
  });

$("#phone").mask("(999) 999  99  99",{placeholder:"(___) ___/ __/ __"});


    

  /*

  Vents
  */
  var widthD = $( window ).width();
  if(widthD > 1200 && !$("#vent_left").is(".vent_left") && !$("#vent_right").is(".vent_right")){
    $("#vent_left").addClass("vent_left");
    $("#vent_left").append("<img src='img/vent_left_smol.png' class='vent' alt=''>");
    $("#vent_right").addClass("vent_right");
    $("#vent_right").append("<img src='img/vent_left_smol.png' class='vent' alt=''>");
  } else {
    $("#vent_left").removeClass("vent_left");
    $("#vent_right").removeClass("vent_right");
    $(".vent").remove();
  }

 
$('a#go').click( function(event){ // лoвим клик пo ссылки с id="go"
    event.preventDefault(); // выключaем стaндaртную рoль элементa
    $('#overlay').fadeIn(400, // снaчaлa плaвнo пoкaзывaем темную пoдлoжку
      function(){ // пoсле выпoлнения предъидущей aнимaции
        $('#modal_form') 
          .css('display', 'block') // убирaем у мoдaльнoгo oкнa display: none;
          .animate({opacity: 1, top: '50%'}, 200); // плaвнo прибaвляем прoзрaчнoсть oднoвременнo сo съезжaнием вниз
    });
  });
  /* Зaкрытие мoдaльнoгo oкнa, тут делaем тo же сaмoе нo в oбрaтнoм пoрядке */
  $('#modal_close, #overlay').click( function(){ // лoвим клик пo крестику или пoдлoжке
    $('#modal_form')
      .animate({opacity: 0, top: '45%'}, 200,  // плaвнo меняем прoзрaчнoсть нa 0 и oднoвременнo двигaем oкнo вверх
        function(){ // пoсле aнимaции
          $(this).css('display', 'none'); // делaем ему display: none;
          $('#overlay').fadeOut(400); // скрывaем пoдлoжку
        }
      );
  });


    $('a#goPost').click( function(event){ // лoвим клик пo ссылки с id="go"
      event.preventDefault(); // выключaем стaндaртную рoль элементa
      $('#overlay').fadeIn(400, // снaчaлa плaвнo пoкaзывaем темную пoдлoжку
          function(){ // пoсле выпoлнения предъидущей aнимaции
            $('#modal_form')
                .css('display', 'block') // убирaем у мoдaльнoгo oкнa display: none;
                .animate({opacity: 1, top: '50%'}, 400); // плaвнo прибaвляем прoзрaчнoсть oднoвременнo сo съезжaнием вниз
          });
    });
    /* Зaкрытие мoдaльнoгo oкнa, тут делaем тo же сaмoе нo в oбрaтнoм пoрядке */
    $('#modal_close, #overlay').click( function(){ // лoвим клик пo крестику или пoдлoжке
      $('#modal_form')
          .animate({opacity: 0, top: '45%'}, 200,  // плaвнo меняем прoзрaчнoсть нa 0 и oднoвременнo двигaем oкнo вверх
              function(){ // пoсле aнимaции
                $(this).css('display', 'none'); // делaем ему display: none;
                $('#overlay').fadeOut(400); // скрывaем пoдлoжку
              }
          );
    });


//$("#phone").mask("",{placeholder:"mm/dd/yyyy"});






  });



  /*

  Vents
  */

  $( window ).resize(function() {
    var width = $( window ).width();
    if(width >= 1200 && !$("#vent_left").is(".vent_left") && !$("#vent_right").is(".vent_right")){
      $("#vent_left").addClass("vent_left");
      $("#vent_left").append("<img src='img/vent_left_smol.png' class='vent' alt=''>");
      $("#vent_right").addClass("vent_right");
      $("#vent_right").append("<img src='img/vent_left_smol.png' class='vent' alt=''>");
    }else if(width<1200){
      $("#vent_left").removeClass("vent_left");
      $("#vent_right").removeClass("vent_right");
      $(".vent").remove();
    }


    $("#infoWidth").text(width);
  });



  /*Scroll*/ $(window).scroll(function() {

    var s = $(window).scrollTop();




    if($(window).scrollTop() > 1) {

      $("#infoScroll").text(s);
    }

    if(s>0){

  /*var p = $( "#bt_tell_more" );
  var position = p.position();
  $("#infoScroll").text(position.top);
  */
  


  $(".lighter").show();
  }



  if(s>240){
    $(".logoTop").removeClass("hidden");
    $(".logoTop").addClass("animated zoomIn");
  } else {
    $(".logoTop").addClass("hidden");
    $(".logoTop").removeClass("animated zoomIn");

  }

  if(s>420){
    $("#services3").addClass("animated slideInUp");
    $("#services2").addClass("animated slideInUp");
    $("#services1").addClass("animated slideInUp");
  }





  $(".aboutText_1").hide();

  if(s > 2222){
    $(".aboutText_1").show();
    $(".aboutText_1").textillate({
      in: {
        effect: 'fadeInRightBig',
        delayScale: 1.5,
        delay: 5,
        sequence: true,
        sync: false,
        shuffle: false,
        reverse: false,
        callback: function () {}
      }
    });


  }

  $(".aboutText_2").hide();
  if(s > 2415){  
    $(".aboutText_2").show();
    $(".aboutText_2").textillate({
      in: {
        effect: 'fadeInLeftBig',
        delayScale: 1.5,
        delay: 5,
        sequence: true,
        sync: false,
        shuffle: false,
        reverse: false,
        callback: function () {}
      }
    });
  }


  $(".aboutText_3").hide();
  if(s > 2800){  
    $(".aboutText_3").show();
    $(".aboutText_3").textillate({
      in: {
        effect: 'fadeInRightBig',
        delayScale: 1.5,
        delay: 5,
        sequence: true,
        sync: false,
        shuffle: false,
        reverse: false,
        callback: function () {}
      }
    });
  }

  $(".aboutText_4").hide();

  if(s > 3055){
    $(".aboutText_4").show();
    $(".aboutText_4").textillate({
      in: {
        effect: 'fadeInLeftBig',
        delayScale: 1.5,
        delay: 5,
        sequence: true,
        sync: false,
        shuffle: false,
        reverse: false,
        callback: function () {}
      }
    });


  }

  $(".aboutText_5").hide();
  if(s > 3315){  
    $(".aboutText_5").show();
    $(".aboutText_5").textillate({
      in: {
        effect: 'fadeInRightBig',
        delayScale: 1.5,
        delay: 5,
        sequence: true,
        sync: false,
        shuffle: false,
        reverse: false,
        callback: function () {}
      }
    });
  }

  if(s>4300) {
    $(".ourTeamFoto").removeClass("animated flip");
    $(".ourTeamFoto").addClass("animated flip");
  }





  });/* Scroll-----  */






  /*   $('.services_class').hover(
  function(){
  $(this).addClass("hovered");
  $(this).addClass("animated zoomIn");
  },
  function(){
  $(this).removeClass("hovered");
  $(this).removeClass("animated zoomIn");
  }
  );


  $('#services_')
  .mouseover(function(){
  $(this).stop().animate( {backgroundColor:'blue'}, {duration:500});
  })
  .mouseout(function(){
  $(this).stop().animate( {backgroundColor:'red'}, {duration:500});
  });

  */
