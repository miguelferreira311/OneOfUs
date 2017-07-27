package org.academiadecodigo.bootcamp.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by codecadet on 27/07/2017.
 */
public class ServiceRegistry {

    private static ServiceRegistry instance = null;
    private Map<String, Service> services = new HashMap<>();

    public static synchronized ServiceRegistry getInstance() {

        if(instance == null) {
            instance = new ServiceRegistry();
        }

        return instance;
    }

    public void addService(Service service){
        services.put(service.getServiceName(),service);
    }

    public void unregisterService(String service){
        services.remove(service);
    }

    public Service getService(String service){
        return services.get(service);
    }
}
