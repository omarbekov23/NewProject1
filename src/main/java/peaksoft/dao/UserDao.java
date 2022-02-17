package peaksoft.dao;

import peaksoft.model.User;

import java.util.List;

/**
 * created by Beksultan Mamatkadyr uulu
 * project : SpringMVC-CRUD
 * 1/11/21
 * Monday 16:02
 */
public interface UserDao {

    //saveOrUpdate
    void saveOrUpdate(User user);

    //delete by id
    void deleteById(int id);

    //get by id
    User getById(int id);

    //delete all
    void deleteAll();

    //get all users
    List<User> getAllUsers();
}
