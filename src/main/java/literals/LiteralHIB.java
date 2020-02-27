package literals;

import java.util.List;

import configuration.ConfigurationHib;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import mapping.literal;

/**
 * Class that retrieves strings from Hibernate
 *
 * @author Dani Garrido Morillas
 *
 */
public class LiteralHIB{
    private SessionFactory new_session;
    private Session _session;
    public LiteralHIB() {

    }

    /**
     * constructor
     * @param hib
     */
    public LiteralHIB(ConfigurationHib hib) {
        this.new_session=hib.getNew_session();
        this._session=hib.get_session();
    }

    /**
     * selects one string by input
     * @param keyword
     * @return
     */
    public literal select_one(String keyword){
        List<literal> result = (List<literal>)_session.createNativeQuery("FROM literal where str_name ").list();
        if(result.size()==0) {
            return null;
        }
        return result.get(0);
    }

    /**
     * selects all the data from table
     * @return returns all the table
     */
    public List select_all() {
        List<literal> result = (List<literal>)_session.createNativeQuery("FROM treballador").list();
        return result;
    }

    /**
     * Deletes entire table
     */
    public void delete() {
        _session.beginTransaction();
        Query<literal> query = _session.createNativeQuery("DELETE FROM treballador");
        query.executeUpdate();
        _session.getTransaction().commit();
    }

    /**
     * inserts new one literal
     * @param new_treb
     */
    public void insert(literal new_treb) {
        _session.beginTransaction();
        _session.save(new_treb);
        _session.flush();
        _session.clear();
        _session.getTransaction().commit();
    }
    public void update(literal obj, String replace) {
        //obj.setStr_name(replace);
        _session.beginTransaction();
        _session.update(obj);
        _session.flush();
        _session.clear();
        _session.getTransaction().commit();
    }
    public List select_all_ordered() {
        List<literal> result = (List<literal>)_session.createNativeQuery("FROM treballador order by treb_Naixement asc").list();
        return result;
    }
    public void delete_one(String id) {
        _session.beginTransaction();
        Query<literal> query = _session.createNativeQuery("DELETE FROM treballador WHERE treb_id = "+id);
        query.executeUpdate();
        _session.getTransaction().commit();
    }

}