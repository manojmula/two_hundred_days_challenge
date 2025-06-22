// Bellerina is a modern open source programming language designed specifically for cloud native applications. It is great for integration, micro services, REST API, and
// event driven systems

// What is Ballerina
//Built for network services and data integration
// First class support for HTTP, gRPC, Kafka and GraphQL
// Easy to write APIs, connect to DBs, handle JSON/XML etc
import ballerina/http;

// Create a service at base path "/"
service / on new http:Listener(8080) {

    // GET / hello
    resource function get hello() returns string {
        return "Hello world!";
    }
}

// POST / greet
resource function post greet(@http:Payload json name) returns json {
    return { message: "Hello, " + name.name.toString() + "!" };
}
}