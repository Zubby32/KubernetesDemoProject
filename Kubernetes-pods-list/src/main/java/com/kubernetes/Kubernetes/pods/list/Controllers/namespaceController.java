package com.kubernetes.Kubernetes.pods.list.Controllers;

import com.kubernetes.Kubernetes.pods.list.Services.namespaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.Map;
@RestController
public class namespaceController {
    @Autowired
    namespaceService service;
    @RequestMapping("/createNamespace")
    public void createNamespace() throws FileNotFoundException {
        service.createNamespace();
    }
    @GetMapping("/listNamespace")
    public Map<String, String> listNamespace() {
        return service.listNamespace();
    }
    @DeleteMapping("/deleteNamespace")
    public  void deleteNamespace(){
        service.deleteNamespace();
    }
}
