/**
 * Dependency Injection (DI) is a design pattern commonly used in software
 * development, especially in frameworks like Spring Boot. It facilitates loose
 * coupling between classes by delegating the responsibility of providing
 * dependent objects to an external entity, typically a framework or container.
 * This allows for easier maintenance, testing, and flexibility in managing
 * object dependencies.
 * 
 * @author wasif
 * @version 1.0
 * @since 02/05/2024
 */

// UserRepositoty interface
interface UserRepositoty {
    void save(String user);
}

// concrete implementation of UserRepository
class JpaUserRepository implements UserRepositoty {

    @Override
    public void save(String user) {
        // simulated save opertaion
        System.out.println("Saving user: " + user);
    }

}

// UserService class with dependency on UserRepository
class UserService {
    private final UserRepositoty userRepositoty;

    // constructor based dependency injection
    public UserService(UserRepositoty userRepositoty) {
        this.userRepositoty = userRepositoty;
    }

    // method to create a new user
    public void createUser(String user) {
        userRepositoty.save(user);
    }
}

// main class
public class DependencyInjection {
    public static void main(String[] args) {
        // instantiate UserRepository
        UserRepositoty userRepositoty = creatUserRepositoty();

        // instantiate UserService with UserRepositry dependecy injected
        UserService userService = new UserService(userRepositoty);

        // call createUser method
        userService.createUser("wasif");

    }

    // factory method to create UserRepository instance
    private static UserRepositoty creatUserRepositoty() {
        return new JpaUserRepository();
    }
}