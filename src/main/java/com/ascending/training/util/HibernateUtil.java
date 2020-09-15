package com.ascending.training.util;
import com.github.fluent.hibernate.cfg.scanner.EntityScanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

public class HibernateUtil {
    private SessionFactory sessionFactory; // -> Singleton
    private Logger logger = LoggerFactory.getLogger(HibernateUtil.class);


    public SessionFactory getSessionFactory(){
        if (sessionFactory == null) {
            try {
                String[] modelPackages = {"com.ascending.training.model"};
                String dbDriver = "org.postgresql.Driver";
                String dbDialect = "org.hibernate.dialect.PostgreSQL9Dialect";
                String dbUrl = "jdbc:postgresql://localhost:521/sport";
                String dbUser = "wendy";
                String dbPassword = "password";

                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, dbDriver);
                settings.put(Environment.DIALECT, dbDialect);
                settings.put(Environment.URL, dbUrl);
                settings.put(Environment.USER, dbUser);
                settings.put(Environment.PASS, dbPassword);
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.HBM2DDL_AUTO, "validate");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                configuration.setProperties(settings);

                EntityScanner.scanPackages(modelPackages).addTo(configuration);
                StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
                ServiceRegistry serviceRegistry = registryBuilder.applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            }
            catch (Exception e){
                logger.error("fail to generate hibernate session factory ",e);
            }
        }
        return sessionFactory;
    }

//    public void main(String[] args){
//    SessionFactory sf = HibernateUtil.getSessionFactory();
//    SessionFactory sf2 = HibernateUtil.getSessionFactory();
//    logger.info("success generate sf" + sf.hashCode());
//    Session s = sf.openSession();
//    s.close();
//    Session s1 = sf2.openSession();
//    s1.close();
//    }
}
