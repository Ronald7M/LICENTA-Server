package com.example.ServerL.Tables.SERVICE;

import com.example.ServerL.Tables.USER.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {
    public final ServiceRepository repository;

    public ServiceService(ServiceRepository repository) {
        this.repository = repository;
    }

    public List<com.example.ServerL.Tables.SERVICE.Service> getServices(){
        return repository.findAll();
    }

    public void insertService(com.example.ServerL.Tables.SERVICE.Service service){
        repository.save(service);
    }
    public void updateService(int id , com.example.ServerL.Tables.SERVICE.Service service){
        com.example.ServerL.Tables.SERVICE.Service find=repository.findById(id).orElseThrow(()->new IllegalStateException(String.format("Service with id= %s doesn't exist", id)));
        find.setDuration(service.getDuration());
        find.setIdResource(service.getIdResource());
        find.setDelete(service.getDelete());
        find.setNameService(service.getNameService());
        repository.save(find);

    }

    public void deleteService(com.example.ServerL.Tables.SERVICE.Service service){
        com.example.ServerL.Tables.SERVICE.Service find=repository.findById(service.getIdService()).orElseThrow(()->new IllegalStateException(String.format("Service with id= %s doesn't exist", service.getIdService())));
        find.setDelete(true);
        repository.save(find);
    }

}
