import java.util.HashMap;
import java.util.Map;

public class UserDAO {
    private Map<String, User> users;

    public UserDAO() {
        this.users = new HashMap<>();
        // Initialize with some dummy data
        users.put("user1", new User("user1", "password1", false));
        users.put("admin", new User("admin", "admin123", true));
    }

    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public User getUser(String username) {
        return users.get(username);
    }

    // Other user management methods
}
