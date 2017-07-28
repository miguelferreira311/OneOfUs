package org.academiadecodigo.bootcamp.model.dao.hibernate;

import org.academiadecodigo.bootcamp.model.KeyWord;
import org.academiadecodigo.bootcamp.model.Role;
import org.academiadecodigo.bootcamp.model.dao.RoleDao;
import org.academiadecodigo.bootcamp.persistence.TransactionException;
import org.academiadecodigo.bootcamp.persistence.hibernate.HibernateSessionManager;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by codecadet on 28/07/17.
 */
public class HibernateRoleDao extends HibernateDao<Role> implements RoleDao{
    public HibernateRoleDao() {
        super(Role.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Role findByName(String name) {
        try {
            Session session = HibernateSessionManager.getSession();

            List<Role> list = session.createCriteria(Role.class)
                    .add(Restrictions.like("name", name)).list();

            return list.size() != 0 ? list.get(0) : null;

        } catch (HibernateException ex) {
            throw new TransactionException(ex);
        }
    }
}
