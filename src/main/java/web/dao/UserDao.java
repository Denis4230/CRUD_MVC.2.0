package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();
    public User getUserById(int id);
    public void add(User user);
    public void update(int id, User newUser);
    public void delete(int id);
}
