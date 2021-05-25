/*!
* MStore - shop-template version-1.0.0 (https://github.com/maithanhduyan/m-store)
* Copyright © 2021. Mai Thành Duy An
* Licensed under MIT (https://github.com/maithanhduyan/m-store/blob/master/LICENSE)
*/

!(function($) {
    "use strict";

    //Navbar Toggle Button Click
    $('.navbar-toggler').on('click', function() {
        // Change icon
        // $(this).children('.fa-bars, .fa-times').toggleClass("fa fa-bars fa fa-times");
         console.log('Toggle');
    });

    // Toggle .header-scrolled class to #header when page is scrolled
    $(window).scroll(function() {
        if ($(this).scrollTop() > 100) {
            $('#header').addClass('header-scrolled');
            $('#header').addClass('stickyHeader');
            $('#header').attr("data-aos","fade-down");
            $('#header')
                .css('opacity', 0)
                .slideDown('slow')
                .animate(
                    { opacity: 1 },
                    { queue: false, duration: 'slow' }
                );
        } else {
            $('#header').removeClass('header-scrolled');
            $('#header').removeClass('stickyHeader');
            $('#header').removeAttr("data-aos","css");
        }
    });

    if ($(window).scrollTop() > 100) {
        $('#header').addClass('header-scrolled');
        // $('#header').addClass('stickyHeader');
    }


    // Back to top button
    $(window).scroll(function() {
        if ($(this).scrollTop() > 100) {
            $('.back-to-top').fadeIn('slow');
        } else {
            $('.back-to-top').fadeOut('slow');
        }
    });
    $('.back-to-top').click(function() {
        $('html, body').animate({
            scrollTop: 0
        }, 1500, 'easeInOutExpo');
        return false;
    });

    // Initi AOS
    AOS.init({
        duration: 800,
        easing: "ease-in-out"
    });

})(jQuery);