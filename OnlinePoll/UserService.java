public class UserService {
    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean authenticate(String username, String password) {
        User user = userDAO.getUser(username);
        return user != null && user.getPassword().equals(password);
    }

    public void registerUser(String username, String password) {
        User newUser = new User(username, password, false);
        userDAO.addUser(newUser);
    }

    // Other user operations
}
