//package com.warehouse.model;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import java.util.Locale;
//import java.util.Random;
//
///**
// * Created by user on 02.11.2016.
// */
//public class MAIN {
//
//    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB_property_connection");
//        EntityManager em = emf.createEntityManager();
//
//        em.getTransaction().begin();
//        Random random = new Random();
//
//        for (int i = 0; i < 20; i++) {
//            IncDel incDel = new IncDel();
//            incDel.setNumber("US-1000" + i + "-AZ");
//            incDel.setSupplier("Amazon");
//            incDel.setBoxQty(random.nextInt(50));
//            incDel.setAmount(random.nextInt(1000));
//            incDel.setWeight(random.nextInt(30));
//            incDel.setVolWeight(random.nextInt(200));
//            incDel.setCurrierCompany("DHL");
//            incDel.setCurrierTrackNumber(random.nextInt(1000) + "-" + random.nextInt(1000));
//            incDel.setEmployeeID("Employee");
//            incDel.setDestinationFROM("New York , Empire str 201" + i);
//            incDel.setWarehouseID("USA Warehouse 1");
//            incDel.setStatus("new");
//            incDel.setShippingType("air");
//            incDel.setCustomsType("post");
//            em.persist(incDel);
//
//
//            IncDel incDel2 = new IncDel();
//            incDel2.setNumber("US-2000" + i + "-AZ");
//            incDel2.setSupplier("Amazon");
//            incDel2.setBoxQty(random.nextInt(50));
//            incDel2.setAmount(random.nextInt(1000));
//            incDel2.setWeight(random.nextInt(30));
//            incDel2.setVolWeight(random.nextInt(200));
//            incDel2.setCurrierCompany("DHL");
//            incDel2.setCurrierTrackNumber(random.nextInt(1000) + "-" + random.nextInt(1000));
//            incDel2.setEmployeeID("Employee");
//            incDel2.setDestinationFROM("New York , Empire str 201" + i);
//            incDel2.setWarehouseID("USA Warehouse 1");
//            incDel2.setShippingType("air");
//            incDel2.setCustomsType("post");
//            incDel2.setStatus("in processing");
//            em.persist(incDel2);
//
//            IncDel incDel3 = new IncDel();
//            incDel3.setNumber("US-3000" + i + "-AZ");
//            incDel3.setSupplier("Amazon");
//            incDel3.setBoxQty(random.nextInt(50));
//            incDel3.setAmount(random.nextInt(1000));
//            incDel3.setWeight(random.nextInt(30));
//            incDel3.setVolWeight(random.nextInt(200));
//            incDel3.setCurrierCompany("DHL");
//            incDel3.setCurrierTrackNumber(random.nextInt(1000) + "-" + random.nextInt(1000));
//            incDel3.setEmployeeID("Employee");
//            incDel3.setDestinationFROM("New York , Empire str 201" + i);
//            incDel3.setWarehouseID("USA Warehouse 1");
//            incDel3.setStatus("repacking");
//            incDel3.setShippingType("air");
//            incDel3.setCustomsType("post");
//            em.persist(incDel3);
//
//            IncDel incDel4 = new IncDel();
//            incDel4.setNumber("US-4000" + i + "-AZ");
//            incDel4.setSupplier("Amazon");
//            incDel4.setBoxQty(random.nextInt(50));
//            incDel4.setAmount(random.nextInt(1000));
//            incDel4.setWeight(random.nextInt(30));
//            incDel4.setVolWeight(random.nextInt(200));
//            incDel4.setCurrierCompany("DHL");
//            incDel4.setCurrierTrackNumber(random.nextInt(1000) + "-" + random.nextInt(1000));
//            incDel4.setEmployeeID("Employee");
//            incDel4.setDestinationFROM("New York , Empire str 201" + i);
//            incDel4.setWarehouseID("USA Warehouse 1");
//            incDel4.setStatus("on the way");
//            incDel4.setShippingType("air");
//            incDel4.setCustomsType("post");
//            em.persist(incDel4);
//
//
//        }
//
//        IncDel incDel = new IncDel();
//        incDel.setCurrierTrackNumber("222w");
//        em.persist(incDel);
////        Box box= new Box();
////        box.setNumBoxInсDel(2);
////        em.persist(box);
////        Logger logger = new Logger();
////        logger.setDescription("sda");
////        em.persist(logger);
//
//        em.getTransaction().commit();
//
//    }
//
//
////    public static void main(String[] args) {
////
////        Locale currentLocale = Locale.getDefault();
////        System.out.println(currentLocale);
////        System.out.println(currentLocale.getISO3Country());
////        System.out.println(currentLocale.getISO3Language());
////        System.out.println(currentLocale.getCountry());
////        System.out.println(currentLocale.getDisplayCountry());
////        System.out.println("//===================================");
////        System.out.println(currentLocale.getDisplayLanguage());
////        System.out.println(currentLocale.getDisplayScript());
////        System.out.println("//===================================");
////        System.out.println(currentLocale.getDisplayVariant());
////
////        System.out.println(currentLocale.toLanguageTag());
//////        System.out.println(currentLocale.);
////
////
////
////
////
////        System.out.println("//===================================");
////
////
////        Locale currentLocale2 = new Locale("aze", "UA", "UNIX");
////
////
////
////        System.out.println(currentLocale2.getISO3Country());
////        System.out.println(currentLocale2.getCountry());
////        System.out.println(currentLocale2.getDisplayCountry());
////        System.out.println(currentLocale2.getDisplayLanguage());
////    }
//}
