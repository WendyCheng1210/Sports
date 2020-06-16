package com.ascending.training.repository;

import com.ascending.training.model.Game;
import com.ascending.training.model.Team;
import com.ascending.training.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class GameDaoImpl implements GameDao{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Game save(Game game) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session s = sessionFactory.openSession();
//        s.save(game);

        try{
            transaction = session.beginTransaction();
            session.save(game);
            transaction.commit();
            session.close();
            return game;

        }catch (Exception e){
            if(transaction != null) transaction.rollback();
            logger.error("fail to insert record",e);
            session.close();
            return null;
        }
    }

    @Override
    public List<Game> getGames() {
        String hql = "FROM Game";
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session s = sessionFactory.openSession();
        List<Game> result = new ArrayList<>();

        try {
            Query query = s.createQuery(hql);
            result = query.list();
            s.close();
        }catch (HibernateException e){
            logger.error("session close exception try again...",e);
            s.close();
        }
        return result;
    }

    @Override
    public Game getBy(long id) {
        return null;
    }

    @Override
    public boolean delete(Game game) {
        String hql = "DELETE Game as g where g.id = :Id";
        int deletedCount = 0;
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            Query<Team> query = session.createQuery(hql);
            query.setParameter("Id",game.getId());
            deletedCount = query.executeUpdate();
            transaction.commit();
            session.close();
            return deletedCount >= 1 ? true : false;
        }catch (HibernateException e){
            if (transaction != null) transaction.rollback();
            session.close();
            logger.error("unable to delete record",e);
        }
        return false;
    }
}
