package com.warehouse.main;//package com.warehouse.model;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.print.*;
//import javax.print.attribute.HashPrintRequestAttributeSet;
//import javax.print.attribute.PrintRequestAttributeSet;
//import javax.print.attribute.standard.JobName;
//import javax.print.attribute.standard.OrientationRequested;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import java.awt.print.PageFormat;
//import java.awt.print.Printable;
//import java.awt.print.PrinterException;
//import java.awt.print.PrinterJob;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.Locale;
//
//import static java.awt.print.Printable.NO_SUCH_PAGE;
//import static java.awt.print.Printable.PAGE_EXISTS;
//
///**
// * Created by user on 02.11.2016.
// */
//public class MAIN {
//
//    public static void main(String args[]) throws IOException {
//
//
//    }
//}
//
//
//
//
////        PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
////        for (int i = 0; i < services.length; i++) {
////            System.out.println(services[i].getName());
////        }
////
////
////        DocFlavor flavor = DocFlavor.URL.GIF;
////        PrintService[] services2 = PrintServiceLookup.lookupPrintServices(flavor, null);
////        System.out.println("====================================");
////        for (int i = 0; i < services2.length; i++) {
////            System.out.println(services2[i].getName());
////        }
////        System.out.println("====================================");
////        PrintService service = PrintServiceLookup.lookupDefaultPrintService();
////        DocFlavor flavor2 = DocFlavor.URL.GIF;
////
////        if (!service.isDocFlavorSupported(flavor2)) {
////            System.err.println("The printer does not support the appropriate DocFlavor");
////        }else {
////            System.out.println("The printer support the appropriate DocFlavor");
////        }
//
//
//
////        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB_property_connection");
////        EntityManager em = emf.createEntityManager();
////
////        em.getTransaction().begin();
////
////        IncDel incDel = new IncDel();
////        incDel.setCurrierTrackNumber("222w");
////        em.persist(incDel);
//////        Box box= new Box();
//////        box.setNumBoxInсDel(2);
//////        em.persist(box);
//////        Logger logger = new Logger();
//////        logger.setDescription("sda");
//////        em.persist(logger);
////
////        em.getTransaction().commit();
////
////    }
//
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
////}
