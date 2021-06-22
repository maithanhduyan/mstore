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

  // Websocket
  var stompClient = null;
  var username = null;
  var sessionId = "JSESSIONID=23E11257ED1E3B8CAEBAC402FDBD0250";
  function connect() {
    username = "shopping-cart";
    var socket = new SockJS("/ws");
    stompClient = Stomp.over(socket);
    stompClient.connect({}, onConnected, onError);
    console.log("connected.");
  }
  // Connect to WebSocket Server.
  connect();
  function onError(error) {
    console.log(
      "Could not connect to WebSocket server. Please refresh this page to try again!"
    );
  }

  function onConnected() {
    // Subscribe to the Public Topic
    stompClient.subscribe("/topic/publicChatRoom", onMessageReceived);

    // Tell your username to the server
    stompClient.send(
      "/app/chat.addUser",
      {},
      JSON.stringify({ sender: username, type: "JOIN" })
    );

    //connectingElement.classList.add("hidden");
  }

  function sendMessage(event) {
    var messageContent = "1";
    if (messageContent && stompClient) {
      var chatMessage = {
        sender: username,
        content: messageInput.value,
        type: "CHAT",
      };
      stompClient.send(
        "/app/cart.sendMessage",
        {},
        JSON.stringify(chatMessage)
      );
      messageInput.value = "";
    }
    event.preventDefault();
  }

  function onMessageReceived(payload) {
    var message = JSON.parse(payload.body);
    console.log(message);
  }

  function sendCartMessage(event) {
    var cartMessage = {
      type: "COUNTER",
    };
    console.log("send cart message");
    stompClient.send("/app/cartMessage", {}, JSON.stringify(cartMessage));
    event.preventDefault();
  }
  //var messageCart = document.querySelector(".add-to-card");
  //messageCart.addEventListener("click", sendCartMessage, true);

  // -------------------------------------------------------------------------------
  // Add To Cart
  var cartCounter = fetchCartCounter();
  $(".add-to-card").on("click", function () {
    // console.log("Add to cart");
    var cart = $(".fa-shopping-bag");
    var imgtodrag = $(this)
      .closest('div[class^="card h-100"]')
      .find("img")
      .eq(0);
    var productId = $(this)
      .closest('div[class^="card h-100"]')
      .find("input")
      .eq(0)
      .val();
    //console.log(productId);
    if (imgtodrag) {
      var imgclone = imgtodrag
        .clone()
        .offset({
          top: imgtodrag.offset().top + 200,
          left: imgtodrag.offset().left,
        })
        .css({
          opacity: "0.9",
          position: "absolute",
          height: "350px",
          width: "350px",
          "z-index": "200",
        })
        .appendTo($("body"))
        .animate(
          {
            top: cart.offset().top + 10,
            left: cart.offset().left + 10,
            width: 75,
            height: 75,
          },
          1000,
          "easeInOutCubic"
        );

      setTimeout(function () {
        // cart.effect("shake", {
        //     times: 2,
        //     direction: 'up'
        // }, 200);
        fetchCartCounter();
      }, 1500);

      imgclone.animate(
        {
          width: 0,
          height: 0,
        },
        function () {
          $(this).detach();
        }
      );
    }
    //console.log(imgtodrag);

    $.ajax({
      type: "POST",
      url: "/cart/add",
      data: {
        productId: productId,
      },
      success: function (data, textStatus, xhr) {
        if (xhr.status == 200 && textStatus == "success") {
          console.log(data);
        }
      },
      complete: function (xhr, textStatus) {
        //console.log(xhr.status);
        //console.log(textStatus);
      },
      dataType: "json",
    });
  });

  function fetchCartCounter() {
    $.ajax({
      type: "post",
      url: "/cart/counter",
      data: {
        command: "getCartCounter",
      },
      success: function (data, textStatus, xhr) {
        if (xhr.status == 200 && textStatus == "success") {
          //console.log(data);
          cartCounter = data;
          $("#CartCount").text(cartCounter);
        }
      },
      complete: function (xhr, textStatus) {},
      dataType: "json",
    });
    return cartCounter;
  }

  function fetchTotalAmount() {
    $.ajax({
      type: "POST",
      url: "/cart/getTotalAmount",
      data: { command: "getTotalAmount" },
      success: function (data, textStatus, xhr) {
        if (xhr.status == 200 && textStatus == "success") {
          var totalAmount = new Intl.NumberFormat("vi-VN", {
            style: "currency",
            currency: "VND",
          }).format(data.totalAmount);
          console.log(totalAmount);
          $(".temporary-amount").text(totalAmount);
          $(".total-amount").text(totalAmount);
        }
      },
      complete: function (xhr, textStatus) {},
    });
  }

  setInterval(function () {
    $("#CartCount").text(cartCounter);
  }, 3000);

  // -------------------------------------------------------------------------------
  $(".remove-cart").on("click", function () {
    var productId = $(this)
      .parent()
      .closest('div[class^="col-md-7"]')
      .find("input")
      .val();
    //console.log(productId.parent().closest('div[class^="col-md-7"]'));
    var productTag = $(this)
      .parent()
      .closest('div[class^="row mb-4 border-top"]');
    console.log(productId);
    console.log(productTag);
    $.ajax({
      type: "post",
      url: "/cart/remove",
      data: {
        command: "removeProduct",
        productId: productId,
      },
      success: function (data, textStatus, xhr) {
        if (xhr.status == 200 && textStatus == "success") {
          console.log(data);
          //cartCounter = data;
          //$("#CartCount").text(cartCounter);
          fetchCartCounter();
          fetchTotalAmount();
          productTag.remove();
          console.log("");
        }
      },
      complete: function (xhr, textStatus) {},
      dataType: "json",
    });
  });
})(jQuery);
