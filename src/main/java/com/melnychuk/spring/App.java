package com.melnychuk.spring;

import com.melnychuk.spring.services.NameProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import java.util.Set;

public class App implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerBean(NameProvider.class);
        context.refresh();
        servletContext.setAttribute(AppContext.SPRING_APP_CONTEXT.name(), context);
    }
}
