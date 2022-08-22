package com.usermanagement.dao.impl;

import java.util.List;

import com.usermanagement.dao.UserDao;
import org.hibernate.Criteria;
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

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAllUser() {

        Criteria criteria = getSession().createCriteria(User.class);
        return (List) criteria.list();
    }

    @Override
    public void updateUser(User user) {
        getSession().update(user);
    }

    @Override
    public void saveUser(User user) {

        getSession().persist(user);
    }

    @Override
    public void deleteUser(int id) {
        User user = (User) getSession().load(User.class, id);
        if (null != user) {
            getSession().delete(user);
        }
    }

    @Override
    public User getUser(int id) {

        User user = (User) getSession().load(User.class, id);
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







