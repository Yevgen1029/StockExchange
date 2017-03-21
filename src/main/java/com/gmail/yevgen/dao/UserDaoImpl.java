package com.gmail.yevgen.dao;

import com.gmail.yevgen.dao.interfaces.UserDao;
import com.gmail.yevgen.model.User;
import com.gmail.yevgen.model.UserRoles;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    public User read(Class<User> tClass, String username) {
        Session session = sessionFactory.getCurrentSession();
//        Object object = session.get(tClass, username);
//        User user = (User) object;

//        System.out.println(1);
//        Criteria criteria = session.createCriteria(User.class);
//        System.out.println(criteria.toString());
//        User user = (User) criteria.add(Restrictions.eq("username", username)).uniqueResult();
        System.out.println(username);
        Query query = session.createQuery("from User where email = ?").setString(0, username);
        User user = (User) query.uniqueResult();

        session.flush();
        return user;
    }

    public UserRoles createStandardRole(User user) {
        UserRoles userRoles = new UserRoles();
        userRoles.setUser(user);
        userRoles.setRole("ROLE_USER");
        Session session = sessionFactory.getCurrentSession();
        session.save(userRoles);
        session.flush();
        return userRoles;
    }

    public UserRoles createAdminRole(User user) {
        UserRoles adminRole = new UserRoles();
        adminRole.setUser(user);
        adminRole.setRole("ROLE_ADMIN");
        Session session = sessionFactory.getCurrentSession();
        session.save(adminRole);
        session.flush();
        return adminRole;
    }
}
