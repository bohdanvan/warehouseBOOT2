//package com.warehouse.util;
//
//import com.warehouse.model.IncDel;
//import com.warehouse.model.OrderIncDel;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
///**
// * Created by user on 19.11.2016.
// */
//public class Initializator {
//    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB_property_connection");
//		EntityManager em = emf.createEntityManager();
////
//		em.getTransaction().begin();
////
//IncDel incDel = new IncDel();
//        em.persist(incDel);
//
//
//
//        OrderIncDel orderIncDel = new OrderIncDel();
////
//        orderIncDel.setProductName("product");
//        orderIncDel.setUrl("url");
//        orderIncDel.setQty(1);
//        orderIncDel.setPrice(1);
//
//
//        em.persist(orderIncDel);
//
//
//        em.getTransaction().commit();
//
//
//    }
//}
