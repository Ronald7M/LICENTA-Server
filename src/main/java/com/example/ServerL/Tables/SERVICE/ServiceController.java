package com.example.ServerL.Tables.SERVICE;

import com.example.ServerL.Tables.USER.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/service")
public class ServiceController {

    public final ServiceService SERVICE;

    public ServiceController(ServiceService service) {
        this.SERVICE = service;
    }


    @GetMapping
    public List<Service> getServices() {
        return SERVICE.getServices();
    }

    @PostMapping
    public void insertService(@RequestBody Service service){
        SERVICE.insertService(service);
    }
    @PutMapping(path="{id}")
    public void updateService(@PathVariable int id,@RequestBody Service service){
        SERVICE.updateService(id,service);
    }
    @PostMapping("/delete")
    public void deleteService(@RequestBody Service service){
        System.out.println("ajuns");
        SERVICE.deleteService(service);
    }

}


