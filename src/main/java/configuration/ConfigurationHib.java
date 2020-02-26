package configuration;

import importxml.xmltohib;
import literals.LiteralHIB;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.util.ArrayList;


public class ConfigurationHib extends Configuration{
    private SessionFactory new_session;
    private Session _session;

    public ConfigurationHib() {

    }
    public void createSession() {
        new_session = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }
    public void openSession() {
        _session = new_session.openSession();
    }
    public void closeSession() {
        _session.close();
    }
    public void startTransaction() {
        _session.beginTransaction();
    }

    public SessionFactory getNew_session() {
        return new_session;
    }
    public void setNew_session(SessionFactory new_session) {
        this.new_session = new_session;
    }
    public Session get_session() {
        return _session;
    }
    public void set_session(Session _session) {
        this._session = _session;
    }
    public void createfromxml() {
        startTransaction();
        xmltohib x = new xmltohib();
        ArrayList<LiteralHIB> list = x.start();
        for(LiteralHIB lit : list) {
            get_session().save(lit);
        }
        get_session().flush();
        get_session().clear();
        get_session().getTransaction().commit();

    }
}
