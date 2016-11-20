package com.warehouse.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Locale;

/**
 * Created by user on 02.11.2016.
 */
public class MAIN {

//    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB_property_connection");
//        EntityManager em = emf.createEntityManager();
//
//        em.getTransaction().begin();
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



//    public static void main(String[] args) {
//
//        Locale currentLocale = Locale.getDefault();
//        System.out.println(currentLocale);
//        System.out.println(currentLocale.getISO3Country());
//        System.out.println(currentLocale.getISO3Language());
//        System.out.println(currentLocale.getCountry());
//        System.out.println(currentLocale.getDisplayCountry());
//        System.out.println("//===================================");
//        System.out.println(currentLocale.getDisplayLanguage());
//        System.out.println(currentLocale.getDisplayScript());
//        System.out.println("//===================================");
//        System.out.println(currentLocale.getDisplayVariant());
//
//        System.out.println(currentLocale.toLanguageTag());
////        System.out.println(currentLocale.);
//
//
//
//
//
//        System.out.println("//===================================");
//
//
//        Locale currentLocale2 = new Locale("aze", "UA", "UNIX");
//
//
//
//        System.out.println(currentLocale2.getISO3Country());
//        System.out.println(currentLocale2.getCountry());
//        System.out.println(currentLocale2.getDisplayCountry());
//        System.out.println(currentLocale2.getDisplayLanguage());
//    }
}
