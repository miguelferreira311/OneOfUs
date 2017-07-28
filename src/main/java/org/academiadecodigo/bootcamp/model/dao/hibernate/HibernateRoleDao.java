package org.academiadecodigo.bootcamp.model.dao.hibernate;

import org.academiadecodigo.bootcamp.model.Role;
import org.academiadecodigo.bootcamp.model.dao.RoleDao;

/**
 * Created by codecadet on 28/07/17.
 */
public class HibernateRoleDao extends HibernateDao<Role> implements RoleDao{
    public HibernateRoleDao() {
        super(Role.class);
    }

    @Override
    public Role findByName(String name) {
        return null;
    }
}
