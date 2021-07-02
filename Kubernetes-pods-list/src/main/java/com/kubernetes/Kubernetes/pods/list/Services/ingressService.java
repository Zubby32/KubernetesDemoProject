package com.kubernetes.Kubernetes.pods.list.Services;

import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.networking.v1beta1.Ingress;
import io.fabric8.kubernetes.api.model.networking.v1beta1.IngressBuilder;
import io.fabric8.kubernetes.api.model.networking.v1beta1.IngressList;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ingressService {
    public KubernetesClient client = null;
    public ingressService() {
        this.client = new DefaultKubernetesClient();
    }
    public String ingress(){
        Ingress ingress = new IngressBuilder()
                .withNewMetadata().withName("test-ingress").addToAnnotations("nginx.ingress.kubernetes.io/rewrite-target", "/").endMetadata()
                .withNewSpec()
                .addNewRule()
                .withNewHttp()
                .addNewPath()
                .withPath("/testPath").withNewBackend().withServiceName("test").withServicePort(new IntOrString(80)).endBackend()
                .endPath()
                .endHttp()
                .endRule()
                .endSpec()
                .build();
        client.network().ingress().inNamespace("default").create(ingress);
        return("ingress created in default namespace");

    }
    public Map<String, String> listIngress() {
        Map<String, String> result = new HashMap<>();
        IngressList ingressList = client.network().ingress().inAnyNamespace().list();
        result.put("message", "There are " + ingressList.getItems().size() + " ingress  in default  namespaces.");
        return result;
    }
    public  void deleteIngress(){
        Boolean isDeleted = client.network().ingress().inNamespace("default").withName("test-ingress").delete();

    }
}
