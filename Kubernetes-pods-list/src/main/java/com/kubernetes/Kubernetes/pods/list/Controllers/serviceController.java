package com.kubernetes.Kubernetes.pods.list.Controllers;

import com.kubernetes.Kubernetes.pods.list.Services.serviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.Map;

@RestController
public class serviceController {
    @Autowired
    serviceService service;

    @RequestMapping("/service")
    public void service() throws FileNotFoundException {

        service.deployservice();
    }
    @GetMapping("/listServices")
    public Map<String, String> listService() {

        return service.listService();
    }
}
