package com.kubernetes.Kubernetes.pods.list.Controllers;

import com.kubernetes.Kubernetes.pods.list.Services.deploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.Map;

@RestController
public class deploymentController {
    @Autowired
    deploymentService service;

    @RequestMapping("/getPods")
    public Map<String, String> getPods() {
               return service.getPods();
    }

    @RequestMapping("/deployment")
    public void deployment(){
        try {
            service.deployment();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/deleteDeployment")
    public void deleteDeployment() throws FileNotFoundException {
        service.deleteDeployment();
    }
}
