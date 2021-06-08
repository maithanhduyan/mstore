!(function ($) {
  "use strict";

  //Navbar Toggle Button Click
  let open_menu = false;
  $(".navbar-toggler").on("click", function () {
    $(".nav-toggle-icon i").removeClass();
    if (!open_menu) {
      $(".nav-toggle-icon i").addClass("fa fa-times");
      open_menu = true;
      console.log("Open");
    } else {
      $(".nav-toggle-icon i").addClass("fa fa-bars");
      open_menu = false;
      console.log("Close");
    }
  });

  // Search Button
  $("#btn_search").on("click", function () {
    $("#searchPopup").removeClass();
    $("#searchPopup").addClass("active");
    console.log("clicked");
  });

  $(".closeSearch").on("click", function () {
    $("#searchPopup").removeClass();
  });

  $("#searchProduct").on("click", function () {
    console.log("Searching...");
  });

  // Toggle .header-scrolled class to #header when page is scrolled
  $(window).scroll(function () {
    if ($(this).scrollTop() > 50) {
      $("#header").addClass("header-scrolled");
      $("#header").addClass("stickyHeader");
      $("#header")
        .css("opacity", 0)
        .slideDown("slow")
        .animate({ opacity: 1 }, { queue: false, duration: "slow" });
    } else {
      $("#header").removeClass("header-scrolled");
      $("#header").removeClass("stickyHeader");
    }
  });

  if ($(window).scrollTop() > 80) {
    $("#header").addClass("header-scrolled");
    // $('#header').addClass('stickyHeader');
  }

  // Back to top button
  $(window).scroll(function () {
    if ($(this).scrollTop() > 100) {
      $(".back-to-top").fadeIn("slow");
    } else {
      $(".back-to-top").fadeOut("slow");
    }
  });

  $(".back-to-top").on("click", function () {
    $("html, body").animate(
      {
        scrollTop: 0,
      },
      800,
      "easeInOutSine"
    );
    return false;
  });

  // Initi AOS
  AOS.init({
    duration: 800,
    easing: "ease-in-out",
  });
})(jQuery);
