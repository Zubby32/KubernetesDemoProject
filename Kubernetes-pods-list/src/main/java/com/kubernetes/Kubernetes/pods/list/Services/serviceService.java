package com.kubernetes.Kubernetes.pods.list.Services;

import io.fabric8.kubernetes.api.model.ServiceList;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

@Service
public class serviceService {
    public KubernetesClient client = null;
    public serviceService() {
        this.client = new DefaultKubernetesClient();
    }
    public void deployservice() throws FileNotFoundException {
        KubernetesClient client = new DefaultKubernetesClient();
        io.fabric8.kubernetes.api.model.Service aService = client.services().load(new FileInputStream("service.yml")).get();
        client.services().inNamespace("default").createOrReplace(aService);
    }
    public Map<String, String> listService() {
        Map<String, String> result = new HashMap<>();
        ServiceList svcList = client.services().inNamespace("default").list();
        result.put("message", "There are " + svcList.getItems().size() + " services in default namespace.");
        return  result;
    }
}
