package DAO;

import entity.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class DepartmentDAO implements DAO<Department,Integer> {

    private Session session;
    public DepartmentDAO(Session session) {
        this.session = session;
    }


    @Override
    public Department save(Department entity) {
        session.saveOrUpdate(entity);
        return entity;
    }

    @Override
    public void deleteById(Integer integer) {
       session.delete(session.load(Department.class,integer));
    }

    @Override
    public Department findById(Integer integer) {
        return session.load(Department.class,integer);
    }

    @Override
    public List<Department> findAll() {
        return  session.createQuery("from Department ").list();
    }
}
