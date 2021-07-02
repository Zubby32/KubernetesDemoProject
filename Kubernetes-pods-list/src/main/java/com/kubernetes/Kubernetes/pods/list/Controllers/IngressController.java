package com.kubernetes.Kubernetes.pods.list.Controllers;

import com.kubernetes.Kubernetes.pods.list.Services.ingressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class IngressController {
    @Autowired
    ingressService service;
    @RequestMapping("/createIngress")
    public  void createIngress(){
        service.ingress();
    }

    @GetMapping("/listIngress")
    public Map<String, String> listIngress() {
        return service.listIngress();
    }
    @DeleteMapping("/deleteIngress")
    public  void deleteIngress(){
        service.deleteIngress();
    }
}
