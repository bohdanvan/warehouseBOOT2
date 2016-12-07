package com.warehouse.controller;


import com.warehouse.model.IncDel;
import com.warehouse.model.UserRepository;
import com.warehouse.print.PrintLableService;
import com.warehouse.service.LangRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.TemplateEngine;

import javax.print.*;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;
import java.util.Locale;

/**
 * Created by user on 30.10.2016.
 */
@Controller
public class UploadController {
    @Autowired
    LangRepository langRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    HttpSession httpSession;
    @Autowired
    HttpServletRequest httpServletRequest;

    String localess[] = Locale.getISOCountries();
    String localeLang = Locale.getDefault().getISO3Language();
    //    String getLocaleLang = userRepository.findByLogin("login").getLanguage();
    final static Logger log4j = LoggerFactory.getLogger(UploadController.class);

    @RequestMapping("/upload")
    public ModelAndView home(ModelAndView model,
                             HttpServletRequest request,
                             HttpServletResponse response,
                             ServletContext servletContext,
                             TemplateEngine templateEngine)
            throws IOException, PrintException {
        log4j.info("Start ========================================== upload");

        try {
            Path p1 = Paths.get("D:/p1.txt");
            Path p2 = Paths.get("D://p2.txt");
            Path p3 = Paths.get("D:\\p3.txt");
            Path p4 = Paths.get("p4.txt");
            Path p5 = Paths.get("/p5.txt");
            Path p6 = Paths.get("/temp/p6.txt");

//            Uri uri = new Uri("p.txt");
//            Path p7 = Paths.get(String.valueOf(uri));


            log4j.info("upload ========================================== initialize");

//            try {
//                Files.createFile(p7);
//                log4j.info("p7");
//
//            } catch (IOException e) {
//                log4j.error("File p7 already exists");
//            }

            try {
                Files.createFile(p6);
                log4j.info("p6");

            } catch (IOException e) {
                log4j.error("File p6 already exists");
            }

            try {
                Files.createFile(p5);
                log4j.info("p5");

            } catch (IOException e) {
                log4j.error("File p5 already exists");
            }

            try {

                Files.createFile(p4);
                log4j.info("p4");

            } catch (IOException e) {
                log4j.error("File p4 already exists");
            }
            try {

                Files.createFile(p3);
                log4j.info("p3");

            } catch (IOException e) {
                log4j.error("File p3 already exists");
            }

            try {

                Files.createFile(p2);
                log4j.info("p2");

            } catch (IOException e) {
                log4j.error("File p2 already exists");
            }

            try {
                Files.createFile(p1);
                log4j.info("p1");

            } catch (IOException e) {
                log4j.error("File p1 already exists");
            }


            Path p8 = Paths.get("D:/b.txt");
            try {
                Files.move(p1, p2, StandardCopyOption.REPLACE_EXISTING);
                log4j.info("p1 move p2");
            } catch (IOException e) {
                log4j.error(e.toString());
            }
            try {
                log4j.info("deleting......:" + p2.getFileName());
                Files.deleteIfExists(p2);
                log4j.info("delete :" + p2.getFileName());

            } catch (IOException e) {
                log4j.error(e.toString());
            }

            log4j.info("========================================================== wright to file p4");

            try (FileChannel fch = (FileChannel) Files.newByteChannel(p4,
                    StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.READ)) {
                MappedByteBuffer mbf = fch.map(FileChannel.MapMode.READ_WRITE, 0, 15);
                mbf.put("Hello word".getBytes());
            } catch (IOException e) {
                log4j.error(e.toString());
            }


            log4j.info("========================================================== read from  file p4");
            log4j.info(p4.getFileName().toString());
            log4j.info(String.valueOf(p4.getFileSystem().isOpen()));

            try (SeekableByteChannel sbc = Files.newByteChannel(p4, StandardOpenOption.READ)) {
                ByteBuffer bb = ByteBuffer.allocate(1024);
                int bufferread = 0;
                for (; (bufferread = sbc.read(bb)) > 0; ) {
                    bb.rewind();
                    for (int i = 0; i < bufferread; i++) {
                        log4j.info("==============" + (char) bb.get());
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            }

            log4j.info("===================================================== AsynchronousFileChannel");
            try (AsynchronousFileChannel afc = AsynchronousFileChannel.open(p4)) {
                ByteBuffer bb = ByteBuffer.allocate(10_000);
                afc.read(bb, 0, bb, new CompletionHandler<Integer, ByteBuffer>() {

                    @Override
                    public void completed(Integer result, ByteBuffer attachment) {
                        log4j.info("AsynchronousFileChannel - Read OK");
                        log4j.info(new String(bb.array(), 0, result));
                    }

                    @Override
                    public void failed(Throwable exc, ByteBuffer attachment) {
                        log4j.error("AsynchronousFileChannel - Read BAD ");
                    }
                });
                log4j.info("=====================================" + new String(bb.array()));
            } catch (IOException e) {
                log4j.error(e.toString());
            }


        } catch (Exception ex) {
            log4j.error(" error path :" + ex.toString());
        }


        IncDel incDel = new IncDel();
        incDel.setNumber("12345");
        incDel.setCustomsType("POST");
        incDel.setShippingType("AIR");
        incDel.setUserID("Client - Makena Co");
        incDel.setDestFROM("USA - New York");
        incDel.setDestFROM("UZB - Baky ");
        incDel.setCurrierTrackNumber("130 250 6753 track");
        incDel.setSupplierInvoice("132-D/234");
        incDel.setDate("09.10.2016 20:32");


//        PrintLableService printServiceDoc = new PrintLableService();

        log4j.info("=================================================================== " +
                "====================================================================" +
                "==================================================================Start print block");


//1
        try {
            PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
            for (int i = 0; i < services.length; i++) {
                log4j.info(services[i].getName());
            }
        } catch (Exception e) {
            log4j.error("1 :" + e.toString());
        }


//        2
        try {
            DocFlavor flavor = DocFlavor.URL.GIF;
            PrintService[] services2 = PrintServiceLookup.lookupPrintServices(flavor, null);
            for (int i = 0; i < services2.length; i++) {
                log4j.info(services2[i].getName());
            }
        } catch (Exception e) {
            log4j.error("2 :" + e.toString());
        }

//3
        try {
            PrintService service = PrintServiceLookup.lookupDefaultPrintService();
            DocFlavor flavor2 = DocFlavor.URL.GIF;

            if (!service.isDocFlavorSupported(flavor2)) {
                log4j.error("The printer does not support the appropriate DocFlavor");
            } else {
                log4j.info("The printer support the appropriate DocFlavor");
            }
        } catch (Exception e) {
            log4j.error("3 :" + e.toString());
        }


//5
//        try {
//            PrintService service5 = PrintServiceLookup.lookupDefaultPrintService();
//            DocPrintJob job = service5.createPrintJob();
//            URL url = new URL(
//                    "http://www.azemex.com/print.gif");
//            log4j.info(url.toString());
//            log4j.info(url.getFile());
//
//            DocFlavor flavor5 = DocFlavor.URL.GIF;
//            Doc doc = new SimpleDoc(url, flavor5, null);
//            PrintRequestAttributeSet attrs = new HashPrintRequestAttributeSet();
//            attrs.add(new Copies(2));
//            job.print(doc, attrs);
//        } catch (Exception e) {
//            log4j.error("5 :" + e.toString());
//        }


        try {
            PrintLableService.printLableVertical(incDel);

        } catch (Exception e) {
            log4j.error("Start print CN23 :" + e.toString());
        }

        log4j.info("======================================finish");
        model.setViewName("admin");
        return model;
    }

}