$(document).ready(function(){

  // comparison table aside
  $(".comparison-table-aside .expand-collapse-state").click(function () {
    if ($(this).closest("aside").hasClass('collapsed-comparison')) {
      $(this).closest("aside").removeClass('collapsed-comparison');
    } else {
      $(this).closest("aside").addClass('collapsed-comparison');
    }
  });

  // structure-aside
  $(".structure-level-expand .expand-collapse-state").click(function () {
    if ($(this).closest("aside").hasClass('collapsed-structure')) {
      $(this).closest("aside").removeClass('collapsed-structure');
      $(".expanded-logo").removeClass('collapsed-structure');
      $("body").removeClass('left-aside-collapsed');
      $(".steps-wizard-box").removeClass('collapsed-structure');
    } else {
      $(this).closest("aside").addClass('collapsed-structure');
      $(".expanded-logo").addClass('collapsed-structure');
      $("body").addClass('left-aside-collapsed');
      $(".steps-wizard-box").addClass('collapsed-structure');
    }
  });

  //Open struture aside
  $('.menu-icon').click(function(e){
    $(".collapsed-structure").removeClass("collapsed-structure");
    $("body").removeClass('is-comparison-active');
    if($("body").hasClass('is-nav-active')){
      $("body").removeClass('is-nav-active');
    } else {
      $("body").addClass('is-nav-active');
    }
    e.stopPropagation();
  });

  // open comparison-table-aside
  $(".notify-icon").click(function (e) {
    $(".collapsed-comparison").removeClass("collapsed-comparison");
    if($(".comparison-table-aside").hasClass('is-comparison-active')){
      $(".comparison-table-aside").removeClass('is-comparison-active');
      $("body").removeClass("comparison-aside-extend");
    } else {
      $(".comparison-table-aside").addClass('is-comparison-active');
      $("body").addClass("comparison-aside-extend");
    }
    e.stopPropagation();
  });

  // mobile header flyout
  $(".mobile-header-nav").click(function (e) {
    e.stopPropagation();
  });
  $(".navbar-toggle").click(function (e) {
    $(".mobile-header-nav").slideToggle(200);
    e.stopPropagation();
  });

  // booked comparison button hover
  $(".comparison-box-main").hover(function () {
    $(this).addClass('booked-comparison');
  }, function () {
    $(this).removeClass('booked-comparison');
  });

  //Outside click
  $(document).click(function(e){
    $('.is-nav-active').removeClass('is-nav-active');
    $(".is-comparison-active").removeClass('is-comparison-active');
    $(".mobile-header-nav").slideUp(200);
    $(".comparison-aside-extend").removeClass("comparison-aside-extend");
  });

  $('.structure-aside, .comparison-table-aside, .mobile-header-nav').click(function(e){
    e.stopPropagation();
  });

});
