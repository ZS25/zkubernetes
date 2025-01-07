package com.sooruth.zkubernetes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZkubernetesApplication {

	private final static Logger LOG = LoggerFactory.getLogger(ZkubernetesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ZkubernetesApplication.class, args);
		LOG.info("Welcome to Zkubernetes Application!");
	}
}
