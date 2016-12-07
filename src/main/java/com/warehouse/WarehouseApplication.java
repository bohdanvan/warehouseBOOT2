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
import java.util.Random;


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
//            User userFullInfo = new User();
//            userFullInfo.setUserName("admin");
//            userFullInfo.setPassword("adminka");
//            userFullInfo.setEnabled(true);
//            userFullInfo.addRole("ROLE_ADMIN");
//            userFullInfo.setEmail("email@email.com");
//            userRepository.save(userFullInfo);

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
//		userFullInfo.setPassword(passwordEncoder.encode("makena"));
        user.addRole("ROLE_ADMIN");
		user.setEmail("email@email.com");
		em.persist(user);

        UserFullInfo userFullInfo = new UserFullInfo();
        userFullInfo.setUserJOIN(user);
        em.persist(userFullInfo);

        Warehouse warehouse = new Warehouse();
        warehouse.setNumber("U1");
        warehouse.setCountry("USA");
        em.persist(warehouse);

        Warehouse warehouse2 = new Warehouse();
        warehouse2.setNumber("AZ1");
        warehouse2.setCountry("Azerbaijan");
        em.persist(warehouse2);

        Warehouse warehouse3 = new Warehouse();
        warehouse3.setNumber("UAE1");
        warehouse3.setCountry("UAE");
        em.persist(warehouse3);

        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            IncDel incDel = new IncDel();
            incDel.setNumber("US-1000" + i + "-AZ");
            incDel.setSupplier("Amazon");
            incDel.setBoxQty(random.nextInt(50));
            incDel.setAmount(random.nextInt(1000));
            incDel.setWeight(random.nextInt(30));
            incDel.setVolWeight(random.nextInt(200));
            incDel.setCurrierCompany("DHL");
            incDel.setCurrierTrackNumber(random.nextInt(1000) + "-" + random.nextInt(1000));
            incDel.setEmployeeID("Employee");
            incDel.setDestFROM("U1");
            incDel.setDestTO("AZ1");
            incDel.setWarehouseID("USA Warehouse 1");
            incDel.setStatus("new");
            incDel.setShippingType("air");
            incDel.setCustomsType("post");
            em.persist(incDel);


            IncDel incDel2 = new IncDel();
            incDel2.setNumber("US-2000" + i + "-AZ");
            incDel2.setSupplier("Amazon");
            incDel2.setBoxQty(random.nextInt(50));
            incDel2.setAmount(random.nextInt(1000));
            incDel2.setWeight(random.nextInt(30));
            incDel2.setVolWeight(random.nextInt(200));
            incDel2.setCurrierCompany("DHL");
            incDel2.setCurrierTrackNumber(random.nextInt(1000) + "-" + random.nextInt(1000));
            incDel2.setEmployeeID("Employee");
            incDel2.setDestFROM("U1");
            incDel2.setDestTO("AZ1");
            incDel2.setWarehouseID("USA Warehouse 1");
            incDel2.setShippingType("air");
            incDel2.setCustomsType("post");
            incDel2.setStatus("in processing");
            em.persist(incDel2);

            IncDel incDel3 = new IncDel();
            incDel3.setNumber("US-3000" + i + "-AZ");
            incDel3.setSupplier("Amazon");
            incDel3.setBoxQty(random.nextInt(50));
            incDel3.setAmount(random.nextInt(1000));
            incDel3.setWeight(random.nextInt(30));
            incDel3.setVolWeight(random.nextInt(200));
            incDel3.setCurrierCompany("DHL");
            incDel3.setCurrierTrackNumber(random.nextInt(1000) + "-" + random.nextInt(1000));
            incDel3.setEmployeeID("Employee");
            incDel3.setDestFROM("U1");
            incDel3.setDestTO("AZ1");
            incDel3.setWarehouseID("USA Warehouse 1");
            incDel3.setStatus("repacking");
            incDel3.setShippingType("air");
            incDel3.setCustomsType("post");
            em.persist(incDel3);

            IncDel incDel4 = new IncDel();
            incDel4.setNumber("US-4000" + i + "-AZ");
            incDel4.setSupplier("Amazon");
            incDel4.setBoxQty(random.nextInt(50));
            incDel4.setAmount(random.nextInt(1000));
            incDel4.setWeight(random.nextInt(30));
            incDel4.setVolWeight(random.nextInt(200));
            incDel4.setCurrierCompany("DHL");
            incDel4.setCurrierTrackNumber(random.nextInt(1000) + "-" + random.nextInt(1000));
            incDel4.setEmployeeID("Employee");
            incDel4.setDestFROM("U1");
            incDel4.setDestTO("AZ1");
            incDel4.setWarehouseID("USA Warehouse 1");
            incDel4.setStatus("on the way");
            incDel4.setShippingType("air");
            incDel4.setCustomsType("post");
            em.persist(incDel4);
        }




//        IncDel incDel = new IncDel();
//        incDel.setNumber("init");
//        em.persist(incDel);
//
//            OrderIncDel orderIncDel = new OrderIncDel();
//            orderIncDel.setProductName("product name");// FIXME: 24.11.2016 Change to productName
//            orderIncDel.setIncDelJOIN(incDel);
//            em.persist(orderIncDel);
//
//        OrderIncDel orderIncDel2 = new OrderIncDel();
//        orderIncDel2.setProductName("product name 2");// FIXME: 24.11.2016 Change to productName
//        orderIncDel2.setIncDelJOIN(incDel);
//        em.persist(orderIncDel2);
//
//        Logger logger = new Logger();
//        em.persist(logger);
//
//        Language language = new Language();
//        em.persist(language);

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