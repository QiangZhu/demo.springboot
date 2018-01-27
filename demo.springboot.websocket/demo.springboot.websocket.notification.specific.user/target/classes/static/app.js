
var stompClient1 = null;
var stompClient2 = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation1").show();
        $("#conversation2").show();
    }
    else {
        $("#conversation1").hide();
        $("#conversation2").hide();
    }
    $("#tomgreetings").html("");
    $("#jerrygreetings").html("");
}

function connect() {
    var socket1 = new SockJS('/gs-guide-websocket');
    stompClient1 = Stomp.over(socket1);
    stompClient1.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient1.subscribe('/user/tom/greetings', function (greeting) {
            console.log(greeting);
            showTomGreeting(JSON.parse(greeting.body).content);
        });
    });

    var socket2 = new SockJS('/gs-guide-websocket');
    stompClient2 = Stomp.over(socket2);
    stompClient2.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient2.subscribe('/user/jerry/greetings', function (greeting) {
            console.log(greeting);
            showJerryGreeting(JSON.parse(greeting.body).content);
        });
    });
}

function disconnect() {
    if (stompClient1 !== null) {
        stompClient1.disconnect();
    }
    if (stompClient2 !== null) {
        stompClient2.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient1.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
}

function showTomGreeting(message) {
    $("#tomgreetings").append("<tr><td>" + message + "</td></tr>");
}

function showJerryGreeting(message) {
    $("#jerrygreetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $("#connect").click(function () {
        connect();
    });
    $("#disconnect").click(function () {
        disconnect();
    });
    $("#send").click(function () {
        sendName();
    });
});