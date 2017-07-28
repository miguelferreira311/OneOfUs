package org.academiadecodigo.bootcamp.model.dao;

import org.academiadecodigo.bootcamp.model.Role;

public interface RoleDao extends Dao<Role>{

    Role findByName(String name);

}
