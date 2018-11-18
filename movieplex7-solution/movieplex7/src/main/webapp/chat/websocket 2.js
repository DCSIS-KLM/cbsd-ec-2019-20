var websocketUri = 'ws://' + document.location.host
        + document.location.pathname.substr(0,
                document.location.pathname.indexOf("/faces")) + '/websocket';
console.log(websocketUri);
var websocket = new WebSocket(websocketUri);

var textField = document.getElementById("textField");
var users = document.getElementById("users");
var chatlog = document.getElementById("chatlog");

var username;

websocket.onopen = function (event) {
    onOpen(event);
};
websocket.onmessage = function (event) {
    onMessage(event);
};
websocket.onerror = function (event) {
    onError(event);
};
websocket.onclose = function (event) {
    onClose(event);
};

var output = document.getElementById("output");

function join() {
    username = textField.value;
    websocket.send(username + " joined");
}

function send_message() {
    websocket.send(username + ": " + textField.value);
}

function onOpen() {
    writeToScreen("CONNECTED");
}

function onClose() {
    writeToScreen("DISCONNECTED");
}

function onMessage(event) {
    writeToScreen("RECEIVED: " + event.data);

    if (event.data.indexOf("joined") !== -1) {
        users.innerHTML += event.data.substring(0,
                event.data.indexOf("joined")) + "\n";
    } else {
        chatlog.innerHTML += event.data + "\n";
    }
}

function onError(event) {
    writeToScreen('<span style="color: red;">ERROR:</span> '
            + event.data);
}

function disconnect() {
    websocket.close();
}

function writeToScreen(message) {
    var pre = document.createElement("p");
    pre.style.wordWrap = "break-word";
    pre.innerHTML = message;
    output.appendChild(pre);
}