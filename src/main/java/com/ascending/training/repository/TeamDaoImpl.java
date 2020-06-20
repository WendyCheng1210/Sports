package com.ascending.training.repository;

import com.ascending.training.model.Team;

import com.ascending.training.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TeamDaoImpl implements TeamDao{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Team save(Team team) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try{
            transaction = session.beginTransaction();
            session.save(team);
            transaction.commit();
            session.close();
            return team;

        }catch (Exception e){
            if(transaction != null) transaction.rollback();
            logger.error("fail to insert record",e);
            session.close();
            return null;
        }
    }

    @Override
    public List<Team> getTeams() {
        String hql = "From Team";
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session s = sessionFactory.openSession();
        List<Team> result = new ArrayList<>();

        try{
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
    public Team getBy(long id) {
        String hql = "From Team t where t.id =: Id";
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            Query<Team> query = session.createQuery(hql);
            query.setParameter("Id",id);
            Team result = query.uniqueResult();
            session.close();
            return result;
        }catch (HibernateException e){
            logger.error("failure to get data record",e);
            session.close();
            return null;}
    }


    @Override
    public Team getTeamEagerBy(long id) {
        String hql = "FROM Team t LEFT JOIN FETCH t.players where t.id=:Id";
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Team> query = session.createQuery(hql);
            query.setParameter("Id",id);
            Team result = query.uniqueResult();
            session.close();
            return result;
        }catch (HibernateException e){
            logger.error("failure to retrieve data record",e);
            session.close();
            return null;
        }
    }

    @Override
    public Team update(Team team) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(team);
            transaction.commit();
            return team;
        }catch (Exception e){
            if (transaction != null) transaction.rollback();
            logger.error("failure to update record", e.getMessage());
        }
        return null;
    }

    @Override
    public boolean delete(Team team) {
        String hql = "DELETE Team as t where t.id = :Id";
        int deletedCount = 0;
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            Query<Team> query = session.createQuery(hql);
            query.setParameter("Id",team.getId());
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
