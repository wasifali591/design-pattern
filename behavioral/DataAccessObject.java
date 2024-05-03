
/**
 * The Data Access Object (DAO) pattern is a structural design pattern that separates the business logic
 * of an application from the data access logic. It abstracts and encapsulates all access to the data
 * source, such as a database or an external service, providing a clean interface for data manipulation.
 * This pattern promotes separation of concerns and improves maintainability by isolating database-related
 * code from the rest of the application.
 * 
 * @author wasif
 * @version 1.0
 * @since 02/05/2024
 */

import java.util.HashMap;
import java.util.Map;

// Entity class representing a user
class User {
    private long id;
    private String username;
    private String email;

    // Constructor
    public User() {
    }

    // Constructor with parameters
    public User(long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    // Getter and setter methods for id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // Getter and setter methods for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and setter methods for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

// DAO interface defining CRUD operations for User entities
interface UserDAO {
    // Method to add a new user
    void addUser(User user);

    // Method to retrieve a user by ID
    User getUserById(long id);

    // Method to update an existing user
    void updateUser(User user);

    // Method to delete a user by ID
    void deleteUser(long id);
}

// Concrete implementation of UserDAO using in-memory storage (for
// demonstration)
class InMemoryUserDAO implements UserDAO {
    // In-memory storage for user data
    private Map<Long, User> users = new HashMap<>();

    @Override
    public void addUser(User user) {
        // Add user to the in-memory storage
        users.put(user.getId(), user);
    }

    @Override
    public User getUserById(long id) {
        // Retrieve user from the in-memory storage by ID
        return users.get(id);
    }

    @Override
    public void updateUser(User user) {
        // Update user in the in-memory storage
        users.put(user.getId(), user);
    }

    @Override
    public void deleteUser(long id) {
        // Delete user from the in-memory storage by ID
        users.remove(id);
    }
}

public class DataAccessObject {
    public static void main(String[] args) {
        // Create an instance of the DAO implementation
        UserDAO userDao = new InMemoryUserDAO();

        // Create a user
        User newUser = new User(1, "wasif", "wasif@mail.com");

        // Add the user
        userDao.addUser(newUser);

        // Retrieve the user by id
        User retrievedUser = userDao.getUserById(1);
        System.out.println("Retrieved User: " + retrievedUser.getId() + " " + retrievedUser.getUsername()
                + " " + retrievedUser.getEmail());

        // Update the user's email
        retrievedUser.setEmail("wasi.ali@mail.com");
        userDao.updateUser(retrievedUser);
        System.out.println("Updated User: " + retrievedUser.getId() + " " + retrievedUser.getUsername()
                + " " + retrievedUser.getEmail());

        // Delete the user
        userDao.deleteUser(1);

        // Verify if the user is deleted
        User deletedUser = userDao.getUserById(1);
        if (deletedUser == null) {
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("User deletion failed.");
        }
    }
}