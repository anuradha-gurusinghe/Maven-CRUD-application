package com.usermanagement.dao.impl;

import java.util.List;

import com.usermanagement.dao.UserDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.usermanagement.model.User;

@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAllUser() {

        Session session = this.getSession();
        List<User> userList = session.createQuery("from User").list();
        return userList;
    }

    @Override
    public void updateUser(User user) {

        Session session = this.getSession();
        session.update(user);
    }

    @Override
    public void saveUser(User user) {

        Session session = this.getSession();
        session.persist(user);
    }

    @Override
    public void deleteUser(int id) {

        Session session = this.getSession();
        User user = (User) session.load(User.class, id);
        if (null != user) {
            session.delete(user);
        }
    }

    @Override
    public User getUser(int id) {

        Session session = this.getSession();
        User user = (User) session.load(User.class, id);
        return user;
    }
}


//    @SuppressWarnings("unchecked")
//    @Override
//    public List<User>  getAllUser() {
//        Session session = this.sessionFactory.getCurrentSession();
//        List<User> userList = session.createQuery("from User").list();
//        return userList;
//    }

//    @Override
//    public void saveUser(User user) {
//        Session session = this.sessionFactory.getCurrentSession();
//        session.persist(user);
//    }

//    @Override
//    public void updateUser(User user) {
//        Session session = this.sessionFactory.getCurrentSession();
//        session.update(user);
//
//    }

//    @Override
//    public User getUser(int id) {
//        Session session = this.sessionFactory.getCurrentSession();
//        User user = (User) session.load(User.class, new Integer(id));
//        return user;
//    }

//    @Override
//    public void deleteUser(int id) {
//        Session session = this.sessionFactory.getCurrentSession();
//        User user = (User) session.load(User.class, new Integer(id));
//        if(null != user){
//            session.delete(user);
//        }
//
//    }







