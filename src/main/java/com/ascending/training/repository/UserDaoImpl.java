package com.ascending.training.repository;

import com.ascending.training.model.Team;
import com.ascending.training.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User save(User user) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage(), e);
        }
        if (user != null) logger.debug(String.format("The user %s was insert failed"));
            return user;
    }

    @Override
    public User findByID(Long Id) {
        String hql = "From User as u where u.id =: Id";
        try(Session session = sessionFactory.openSession()){
            Query<User> query = session.createQuery(hql);
            query.setParameter("Id",Id);
            return query.uniqueResult();
        }
    }

    @Override
    public User getUserByEmail(String email) {
        String hql = "FROM User as u where lower(u.email) = :email";
        try(Session session = sessionFactory.openSession()){
            Query<User> query = session.createQuery(hql);
            query.setParameter("email",email.toLowerCase());
            return query.uniqueResult();
        }
    }

    @Override
    public User getUserByCredentials(String email, String password) {
        String hql = "From User as u where (lower(u.email) = :email or lower(u.name) = :email) and u.password = :password";
        logger.debug(String.format("User email: %s, password: %s", email, password));

        try(Session session = sessionFactory.openSession()){
            Query<User> query = session.createQuery(hql);
            query.setParameter("email",email.toLowerCase().trim());
            query.setParameter("password", password);
            return query.uniqueResult();
        }
    }


    @Override
    public void delete(User user) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        }
    }

    @Override
    public List<User> findAllUsers() {
        String hql = "FROM User";
        try(Session session = sessionFactory.openSession()){
            Query<User> query = session.createQuery(hql);
            return query.list();
        }
    }
}
