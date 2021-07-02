package com.kubernetes.Kubernetes.pods.list.Services;

import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
@Service
public class deploymentService {
    public KubernetesClient client = null;
    public deploymentService() {
        this.client = new DefaultKubernetesClient();
    }

    public void deployment() throws FileNotFoundException {
        KubernetesClient client = new DefaultKubernetesClient();
        Deployment deployment = client.apps().deployments().load(new FileInputStream("deployment.yaml")).get();
        client.apps().deployments().inNamespace("default").createOrReplace(deployment);

    }

    public Map<String, String> getPods() {
        Map<String, String> result = new HashMap<>();
        try {
            PodList podList = client.pods().inNamespace("default").list();
            result.put("message", "There are " + podList.getItems().size() + " pods in default namespace.");
        } catch (KubernetesClientException exception) {
            exception.printStackTrace();
            result.put("error", exception.getMessage());
        } finally {
            return result;
        }
    }



    public void deleteDeployment()
    {
        Boolean isDeleted = client.apps().deployments()
                .inNamespace("default")
                .withName("nginx-testdeployment")
                .delete();
    }

}
