package com.usermanagement.repository.impl;

import com.usermanagement.model.User;
import com.usermanagement.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public void deleteById(int id) {
        User user = em.find(User.class, id);
        em.remove(user);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(int id) {
        return Optional.empty();
    }
}


//    @SuppressWarnings("unchecked")
//    @Override
//    public List<User> getAllUser() {
//
//        Criteria criteria = getSession().createCriteria(User.class);
//        return (List) criteria.list();
//    }
//
//    @Override
//    public void updateUser(User user) {
//        getSession().update(user);
//    }
//
//    @Override
//    public void saveUser(User user) {
//
//        getSession().persist(user);
//    }
//
//    @Override
//    public void deleteUser(int id) {
//        User user = (User) getSession().load(User.class, id);
//        if (null != user) {
//            getSession().delete(user);
//        }
//    }
//
//    @Override
//    public User getUser(int id) {
//
//        User user = (User) getSession().load(User.class, id);
//        return user;
//    }

