
/**
 * The API Gateway pattern is a design pattern used in microservices architecture to provide a single
 * entry point for clients to access various services. It acts as a reverse proxy that sits between clients
 * and backend services, routing requests, performing protocol translation, and providing additional
 * functionalities like authentication, rate limiting, caching, and monitoring.
 * 
 * @author wasif
 * @version 1.0
 * @since 02/05/2024
 */

import java.util.HashMap;
import java.util.Map;

// BackendService interface representing backend services
interface BackendService {
    String processRequest(String request);
}

// UserService class implementing BackendService interface
class UserService implements BackendService {
    @Override
    public String processRequest(String request) {
        // Process request for UserService
        return "Response from UserService: " + request;
    }
}

// ProductService class implementing BackendService interface
class ProductService implements BackendService {
    @Override
    public String processRequest(String request) {
        // Process request for ProductService
        return "Response from ProductService: " + request;
    }
}

// ApiGateway class acting as the API Gateway
class ApiGateway {
    private Map<String, BackendService> serviceMap;

    public ApiGateway() {
        serviceMap = new HashMap<>();
        serviceMap.put("user", new UserService());
        serviceMap.put("product", new ProductService());
    }

    public String handleRequest(String service, String request) {
        // Route request to the appropriate backend service based on service name
        BackendService backendService = serviceMap.get(service);
        if (backendService != null) {
            return backendService.processRequest(request);
        } else {
            return "Service not found: " + service;
        }
    }
}

// Main class to demonstrate the API Gateway pattern
public class ApiGatewayPattern {
    public static void main(String[] args) {
        // Create an instance of the API Gateway
        ApiGateway apiGateway = new ApiGateway();

        // Simulate handling requests through the API Gateway
        String userResponse = apiGateway.handleRequest("user", "User request");
        System.out.println(userResponse);

        String productResponse = apiGateway.handleRequest("product", "Product request");
        System.out.println(productResponse);

        String unknownResponse = apiGateway.handleRequest("unknown", "Unknown request");
        System.out.println(unknownResponse);
    }
}