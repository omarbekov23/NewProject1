package peaksoft.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.model.User;

import javax.transaction.Transactional;
import java.util.List;

/**
 * project : SpringMVC-CRUD
 */
@Repository
public class UserDaoImplSF implements UserDao{

    //define dependency
    private SessionFactory sessionFactory;

    //inject dependency
    @Autowired
    public UserDaoImplSF(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //CRUD METHODS
    @Override
    @Transactional
    public void saveOrUpdate(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        sessionFactory.getCurrentSession().delete(getById(id));
    }

    @Override
    @Transactional
    public User getById(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        sessionFactory.getCurrentSession().createSQLQuery("delete * from users;").executeUpdate();
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User").getResultList();
    }
}
