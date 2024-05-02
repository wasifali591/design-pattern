/**
 * The Service Registry pattern is a design pattern used in distributed systems to provide a centralized
 * repository for storing and discovering services. In a microservices architecture, where multiple
 * services need to communicate with each other, a service registry acts as a directory that maintains
 * information about available services, their locations (IP addresses and ports), and other metadata.
 * 
 * @author wasif
 * @version 1.0
 * @since 02/05/2024
 */

 
import java.util.HashMap;
import java.util.Map;

// ServiceRegistration class representing the service registration process
class ServiceRegistration {
    private String serviceName;
    private String serviceUrl;
    private ServiceRegistry registry;

    // Constructor to initialize ServiceRegistration with serviceName, serviceUrl, and registry
    public ServiceRegistration(String serviceName, String serviceUrl, ServiceRegistry registry) {
        this.serviceName = serviceName;
        this.serviceUrl = serviceUrl;
        this.registry = registry;
        registerService(); // Register the service upon instantiation
    }

    // Method to register the service with the registry
    private void registerService() {
        registry.registerService(serviceName, serviceUrl);
    }
}

// ServiceRegistry class representing the centralized service registry
class ServiceRegistry {
    private Map<String, String> registryMap; // Map to store service information (service name -> service URL)

    // Constructor to initialize the registryMap
    public ServiceRegistry() {
        registryMap = new HashMap<>();
    }

    // Method to register a service with the registry
    public void registerService(String serviceName, String serviceUrl) {
        // Add the service to the registryMap
        registryMap.put(serviceName, serviceUrl);
        System.out.println("Registered service: " + serviceName + " at " + serviceUrl);
    }

    // Method to discover the URL of a service by its name
    public String discoverService(String serviceName) {
        // Retrieve the service URL from the registryMap
        String serviceUrl = registryMap.get(serviceName);
        if (serviceUrl != null) {
            System.out.println("Discovered service: " + serviceName + " at URL: " + serviceUrl);
            return serviceUrl;
        } else {
            System.out.println("Service not found: " + serviceName);
            return null;
        }
    }
}

public class ServiceRegistryPattern {
    public static void main(String[] args) {
        // Create a service registry
        ServiceRegistry registry = new ServiceRegistry();

        // Service registration
        ServiceRegistration registration = new ServiceRegistration("UserService", "http://localhost:8081", registry);

        // Service discovery
        registry.discoverService("UserService");
    }
}
