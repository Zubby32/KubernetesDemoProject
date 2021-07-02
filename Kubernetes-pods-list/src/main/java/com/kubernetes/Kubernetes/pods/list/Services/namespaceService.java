package com.kubernetes.Kubernetes.pods.list.Services;

import io.fabric8.kubernetes.api.model.NamespaceList;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

@Service
public class namespaceService {
    public KubernetesClient client = null;
    public namespaceService() {
        this.client = new DefaultKubernetesClient();
    }
    public void createNamespace() throws FileNotFoundException {
        KubernetesClient client = new DefaultKubernetesClient();
        io.fabric8.kubernetes.api.model.Namespace namespace = client.namespaces().load(new FileInputStream("namespace.yaml")).get();
        client.namespaces().createOrReplace(namespace);

    }
    public Map<String, String> listNamespace() {
        Map<String, String> result = new HashMap<>();
        NamespaceList namespaceList = client.namespaces().list();
        result.put("message", "There are " + namespaceList.getItems().size() + " namespaces.");
        return result;
    }
    public  void deleteNamespace(){
        Boolean isDeleted = client.namespaces().withName("development").delete();
    }
}
