package com.warehouse;


import com.warehouse.model.*;
import com.warehouse.service.IncDelRepository;
import com.warehouse.service.OrderIncDelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;


@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
@EnableJpaRepositories
public class WarehouseApplication /*extends SpringBootServletInitializer*/ {

    /*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WarehouseApplication.class);
    }*/

    @Bean
    CommandLineRunner init(UserRepository userRepository, IncDelRepository incDelRepository, OrderIncDelRepository orderIncDelRepository
                           ) {
        return (evt) -> {
//            User user = new User();
//            user.setUserName("admin");
//            user.setPassword("adminka");
//            user.setEnabled(true);
//            user.addRole("ROLE_ADMIN");
//            user.setEmail("email@email.com");
//            userRepository.save(user);

//            IncDel incDel = new IncDel();
//            incDel.setNumber("number init");
//            incDelRepository.save(incDel);
//
//            OrderIncDel orderIncDel = new OrderIncDel();
//            orderIncDel.setProductName("product to order init");
//            orderIncDel.setIncDelJOIN(incDel);
//            orderIncDelRepository.save(orderIncDel);



        };
    }

    public static void main(String[] args) {
//        SpringApplication.run(WarehouseApplication.class, args);
        ApplicationContext ctx = SpringApplication.run(WarehouseApplication.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot:");
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB_initializer_server");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();



        UserRole userRole = new UserRole();
        em.persist(userRole);

		User user = new User();
		user.setUserName("admin");
		user.setPassword("admin");
        user.setEnabled(true);
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		user.setPassword(passwordEncoder.encode("makena"));
        user.addRole("ROLE_ADMIN");
		user.setEmail("email@email.com");

		em.persist(user);

        IncDel incDel = new IncDel();
        incDel.setNumber("init");
        em.persist(incDel);

            OrderIncDel orderIncDel = new OrderIncDel();
            orderIncDel.setProductName("product name");// FIXME: 24.11.2016 Change to productName
            orderIncDel.setIncDelJOIN(incDel);
            em.persist(orderIncDel);

        OrderIncDel orderIncDel2 = new OrderIncDel();
        orderIncDel2.setProductName("product name 2");// FIXME: 24.11.2016 Change to productName
        orderIncDel2.setIncDelJOIN(incDel);
        em.persist(orderIncDel2);

        Logger logger = new Logger();
        em.persist(logger);

        Language language = new Language();
        em.persist(language);

		em.getTransaction().commit();

        System.out.println(" ====================================== Initialize models complite==================================================");
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