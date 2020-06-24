package com.ascending.training.repository;

import com.ascending.training.model.Player;

import com.ascending.training.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlayerDaoImpl implements PlayerDao{
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Player save(Player player) {
        Transaction transaction = null;
        //Session session = HibernateUtil.getSessionFactory().openSession();
        Session session = sessionFactory.openSession();
        try{
            transaction = session.beginTransaction();
            session.save(player);
            transaction.commit();
            session.close();
            return player;

        }catch (Exception e){
            if(transaction != null) transaction.rollback();
            logger.error("fail to insert record",e);
            session.close();
            return null;
        }
    }

    @Override
    public List<Player> getPlayers() {
        String hql = "FROM Player";
        //SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session s = sessionFactory.openSession();
        //Session s = sessionFactory.openSession();
        List<Player> result = new ArrayList<>();
        try{
            Query query = s.createQuery(hql);
            result = query.list();
            s.close();
        }catch (HibernateException e){
            logger.error("session close exception try again...", e);
            s.close();
        }
        return result;
    }

    @Override
    public Player getBy(long id) {
        String hql = "From Player p where p.id = :Id";
        //Session session = HibernateUtil.getSessionFactory().openSession();
        Session session = sessionFactory.openSession();
        try{
            Query<Player> query = session.createQuery(hql);
            query.setParameter("Id",id);
            Player result = query.uniqueResult();
            session.close();
            return result;
        }catch (HibernateException e){
            logger.error("failure to get data record",e);
            session.close();
            return null;
        }
    }

    @Override
    public Player getPlayerEagerBy(long id) {
        return null;
    }

    @Override
    public Player update(Player player) {
        Transaction transaction = null;
        //try(Session session = HibernateUtil.getSessionFactory().openSession()){
          try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(player);
            transaction.commit();
            return player;
        }catch (Exception e){
            if (transaction != null) transaction.rollback();
            logger.error("failure to update record", e.getMessage());
        }
        return null;
    }

    @Override
    public boolean delete(Player player) {
        String hql = "DELETE Player as p where p.id = :Id";
        int deletedCount = 0;
        Transaction transaction = null;
        //Session session = HibernateUtil.getSessionFactory().openSession();
        Session session = sessionFactory.openSession();
        try{
            transaction = session.beginTransaction();
            Query<Player> query = session.createQuery(hql);
            query.setParameter("Id",player.getId());
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
