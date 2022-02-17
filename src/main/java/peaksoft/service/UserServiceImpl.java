package peaksoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import peaksoft.dao.UserDao;
import peaksoft.model.User;

import java.util.List;

/**
 * created by Beksultan Mamatkadyr uulu
 * project : SpringMVC-CRUD
 * 1/11/21
 * Monday 22:13
 */
@Service
public class UserServiceImpl implements UserService{

    //define dependency
    private UserDao userDao;

    //inject dependency
    public UserServiceImpl(@Qualifier("userDaoImplSF") UserDao userDao) {
        this.userDao = userDao;
    }

    //CRUD METHODS
    @Override
    public void saveOrUpdate(User user) {
        userDao.saveOrUpdate(user);
    }

    @Override
    public void deleteById(int id) {
        userDao.deleteById(id);
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Override
    public void deleteAll() {
        userDao.deleteAll();
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
