package com.warehouse;

import com.warehouse.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.SecurityContextProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAuthorizeMode;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ContextIdApplicationContextInitializer;
import org.springframework.boot.context.embedded.jetty.ServletContextInitializerConfiguration;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;
import java.security.Security;
import java.util.Arrays;
import java.util.Locale;

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
@EnableJpaRepositories
@SpringBootApplication
public class WarehouseApplication /*extends SpringBootServletInitializer*/ {

    /*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WarehouseApplication.class);
    }*/

    public static void main(String[] args) {
//        SpringApplication.run(WarehouseApplication.class, args);
        ApplicationContext ctx = SpringApplication.run(WarehouseApplication.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot:");
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
//
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB_initializer_server");
//		EntityManager em = emf.createEntityManager();
//
//		em.getTransaction().begin();
//
//        OrderIncDel orderIncDel = new OrderIncDel();
//        em.persist(orderIncDel);
//
//        UserRole userRole = new UserRole();
//        em.persist(userRole);
//
//		User user = new User();
//		user.setUserName("m");
//		user.setPassword("admin");
//        user.setEnabled(true);
////        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
////		user.setPassword(passwordEncoder.encode("makena"));
//        user.addRole("ROLE_ADMIN");
//		user.setEmail("email@email.com");
////
//		em.persist(user);
//
//        IncDel incDel = new IncDel();
//        em.persist(incDel);
//
//
//
//        Logger logger = new Logger();
//        em.persist(logger);
//
//        Language language = new Language();
//        em.persist(language);
//
//
//		em.getTransaction().commit();


        System.out.println(" ================================= Initialize Spring Boot complite");
    }


}

//
//    Box box= new Box();
//box.setNumber("1");
//        box.setNumBoxInсDel(1);
//        box.setCost(200);
//        box.setDamageStatus("false");
//        box.setDescription("desc");
//        box.setHeight(100);
//        box.setIncDelJOIN(incDel);
//        box.setLenght(100);
//        box.setStatus("new");
//        box.setVolWeight(300);
//        box.setWight(2);
//        box.setWeight(2);
//        em.persist(box);