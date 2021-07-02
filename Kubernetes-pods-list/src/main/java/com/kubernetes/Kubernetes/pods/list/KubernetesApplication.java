package com.kubernetes.Kubernetes.pods.list;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;

@SpringBootApplication
public class KubernetesApplication {

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(KubernetesApplication.class, args);

	}

}
