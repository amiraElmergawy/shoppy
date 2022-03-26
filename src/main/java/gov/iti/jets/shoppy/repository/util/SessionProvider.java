package gov.iti.jets.shoppy.repository.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionProvider {
    private static final SessionProvider sessionProvider = new SessionProvider();
    private final SessionFactory sessionFactory;

    private SessionProvider() {
       this.sessionFactory = buildSessionFactory();
    }
    public static SessionProvider getInstance() {
        return sessionProvider;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void endSession() {
        sessionFactory.close();
    }

    private SessionFactory buildSessionFactory(){
        Configuration configuration = new Configuration().configure(this.getClass().getResource("/hibernate.cfg.xml"));
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties());
        return configuration.buildSessionFactory(builder.build());
    }

}
