package com.bari.springmvc.dao;

import com.bari.springmvc.model.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public List<User> listUser() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    @Override
    public User getUserById(Integer Id) {
        Session session = sessionFactory.getCurrentSession();
        List<User> list = session.createQuery("from User u where u.id=:id").setParameter("id", Id).list();
        return list.size() > 0 ? (User) list.get(0) : null;
    }

    @Override
    public void removeUser(Integer Id) {
        User user = (User) sessionFactory.getCurrentSession().load(User.class, Id);
        if (user != null) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }

    @Override
    public User loginUser(String email, String pass) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM User u WHERE u.email =:email and u.pass=:pass");

        query.setString("email", email);
        query.setString("pass", pass);

        List<User> cList = query.list();
        cList.toString();
        System.out.println(cList.size());
        System.out.println("Dao");
        return cList.size() > 0 ? cList.get(0) : null;
    }

}
