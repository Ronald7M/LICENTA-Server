package com.example.ServerL.Tables.SHARED_RESOURCE;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/sharedResource")
public class SharedResourceController {

    private final SharedResourceService service;

    public SharedResourceController(SharedResourceService sharedResourceService) {
        this.service = sharedResourceService;
    }

    @GetMapping
    public List<SharedResource> getSharedResources(){
        return service.getSharedResources();
    }
    @PostMapping
    public void insertSharedResource(@RequestBody SharedResource sharedResource){
        service.insertSharedResource(sharedResource);

    }
    @PutMapping(path="{id}")
    public void updateUser(@PathVariable int id,@RequestBody SharedResource sharedResource){
        service.updateSharedResource(id,sharedResource);

    }



}
