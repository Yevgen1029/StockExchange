package com.gmail.yevgen.dao;

import com.gmail.yevgen.dao.interfaces.GenericDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AbstractDao<T> implements GenericDao<T> {

    @Autowired
    SessionFactory sessionFactory;


    public T create(T t) {
        System.out.println(1);
        Session session = sessionFactory.getCurrentSession();
        System.out.println(2);
        session.save(t);
        System.out.println(3);
        session.flush();
        System.out.println(4);
        return t;
    }


    public T read(Class<T> tClass, Long id) {
        Session session = sessionFactory.getCurrentSession();
        T t = (T) session.get(tClass, id);
        session.flush();
        return t;
    }


    public T update(T t) {
        Session session = sessionFactory.getCurrentSession();
        session.update(t);
        session.flush();
        return t;
    }


    public T delete(T t) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(t);
        session.flush();
        return t;
    }


    public List<T> readAll(Class<T> tClass) {
        return (List<T>) sessionFactory.getCurrentSession().createCriteria(tClass).list();
    }
}