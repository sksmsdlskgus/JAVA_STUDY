
var message;

message = function() {
    return "Hello World!";
};

console.log(message());

message = () => {
    return "Arrow Function!";
};

console.log(message());

message = () => "Arrow Function2!";
console.log(message());