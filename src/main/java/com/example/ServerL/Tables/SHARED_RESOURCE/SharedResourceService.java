package com.example.ServerL.Tables.SHARED_RESOURCE;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SharedResourceService {

    private final SharedResourceRepository repository;

    public SharedResourceService(SharedResourceRepository sharedResourceRepository) {
        this.repository = sharedResourceRepository;
    }

    public List<SharedResource> getSharedResources(){
        return repository.findAll();
    }
    public void insertSharedResource(SharedResource sharedResource){
        repository.save(sharedResource);
    }
    public void updateSharedResource(int id, SharedResource sharedResource){
        SharedResource find=repository.findById(id).orElseThrow(()->new IllegalStateException(String.format("Resource with id= %s doesn't exist", id)));

        find.setName(sharedResource.getName());
        find.setIdUser(sharedResource.getIdUser());
        find.setDescription(sharedResource.getDescription());
        find.setIdCategory(sharedResource.getIdCategory());
        find.setScheduleS(sharedResource.getScheduleS());
        repository.save(find);

    }
}
