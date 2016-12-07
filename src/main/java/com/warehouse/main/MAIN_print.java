package com.warehouse.main;//package com.warehouse.model;
//
//import javax.print.PrintService;
//import javax.swing.*;
//import java.awt.print.PrinterJob;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.MalformedURLException;
//import java.net.URL;
//
///**
// * Created by user on 03.12.2016.
// */
//public class MAIN_print {
//    public static void main(String[] args) {
//
//        try {
//            PrinterJob printJob=PrinterJob.getPrinterJob();
//            printJob.printDialog();
//            System.exit(0);
//        } catch( Exception e) {
//            e.printStackTrace();
//        }
//
//        PrintService[] service = java.awt.print.PrinterJob.lookupPrintServices();
//
//        for (int i=0;i<service.length;i++)
//        {
//            JOptionPane.showMessageDialog(null,service[i].getName());
//        }
//        URL oracle = null;
//        try {
//            oracle = new URL("http://www.azemex.com/order");
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//
//        BufferedReader in = null;
//        try {
//            in = new BufferedReader(
//                    new InputStreamReader(oracle.openStream()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        String inputLine;
//        try {
//            while ((inputLine = in.readLine()) != null)
//                System.out.println(inputLine);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            in.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
