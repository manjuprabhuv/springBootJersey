package com.manju.springboot.jersey.config;

import java.lang.annotation.Annotation;

import javax.annotation.PostConstruct;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import com.manju.springboot.jersey.annotation.SpringBootJerseyController;
import com.manju.springboot.jersey.annotation.SpringBootJerseyProvider;
import com.manju.springboot.jersey.providers.AppExceptionMapper;

@Configuration
public class ApplicationResourceBundle extends ResourceConfig {

	@Value("${boot.jersey.endpoints.package.scan}")
	private String endPoints ;

	@Value("${boot.jersey.providers.package.scan}")
	private String providers ;

	public ApplicationResourceBundle() {

	}

	@PostConstruct
	public void setup() {
		System.out.println("Resource Bundle class");
		registerEndpoints();
		registerProviders();
		register(AppExceptionMapper.class);
	}

	private void registerEndpoints() {
		findAndRegister(endPoints, SpringBootJerseyController.class);

	}

	private void registerProviders() {
		findAndRegister(providers, SpringBootJerseyProvider.class);
	}

	private void findAndRegister(String scanPackage, Class<? extends Annotation> clz) {
		ClassPathScanningCandidateComponentProvider provider = createComponentScanner(clz);
		for (BeanDefinition beanDef : provider.findCandidateComponents(scanPackage)) {
			Class<?> cl = null;
			try {
				cl = Class.forName(beanDef.getBeanClassName());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(cl.getCanonicalName());
			register(cl);
		}
	}

	private ClassPathScanningCandidateComponentProvider createComponentScanner(Class<? extends Annotation> clz) {
		// Don't pull default filters (@Component, etc.):
		ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
		provider.addIncludeFilter(new AnnotationTypeFilter(clz));
		return provider;
	}

}
