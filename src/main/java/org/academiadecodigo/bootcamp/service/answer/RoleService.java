package org.academiadecodigo.bootcamp.service.answer;

import org.academiadecodigo.bootcamp.model.Role;
import org.academiadecodigo.bootcamp.model.dao.RoleDao;
import org.academiadecodigo.bootcamp.persistence.TransactionException;
import org.academiadecodigo.bootcamp.persistence.TransactionManager;
import org.academiadecodigo.bootcamp.service.Service;

public class RoleService implements Service{

    private RoleDao roleDao;
    private TransactionManager manager;

    public RoleService(RoleDao roleDao, TransactionManager manager) {
        this.roleDao = roleDao;
        this.manager = manager;
    }

    @Override
    public String getServiceName() {
        return RoleService.class.getSimpleName();
    }

    public Role findById(int id){
        try {

            manager.beginTransaction();

            Role role = roleDao.findById(id);

            manager.commitTransaction();

            return role;

        } catch (TransactionException ex) {

            System.out.println(ex.getMessage());
            manager.rollbackTransaction();
        }
        return null;
    }

    public Role findByName(String name){

        try {

            manager.beginTransaction();

            Role role = roleDao.findByName(name);

            manager.commitTransaction();

            return role;

        } catch (TransactionException ex) {

            System.out.println(ex.getMessage());
            manager.rollbackTransaction();
        }
        return null;
    }

    public void addRole(Role role){
        try {

            manager.beginTransaction();

            roleDao.save(role);

            manager.commitTransaction();

        } catch (TransactionException ex) {

            System.out.println(ex.getMessage());
            manager.rollbackTransaction();
        }

    }

    public void removeRole(Role role){
        try {

            manager.beginTransaction();

            roleDao.remove(role);

            manager.commitTransaction();

        } catch (TransactionException ex) {

            System.out.println(ex.getMessage());
            manager.rollbackTransaction();
        }
    }

}
