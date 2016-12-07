package com.warehouse.print;



import com.warehouse.controller.UploadController;
import com.warehouse.model.IncDel;
import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;


/**
 * Created by user on 08.09.2016.
 */
public class PrintLableService {

    private static int lastPrintCN23;
    private static String taraNumber;
    // private static BoxI box = new BoxI();
    final static Logger log4j = LoggerFactory.getLogger(PrintLableService.class);

    //====================================================================================================================
    public static void printLable(IncDel box) throws IOException {
//____________________________________________________________________________________________________________________
        long s = System.currentTimeMillis();

        createBarCode(box);

        System.out.println("Create image barcode take : " + (System.currentTimeMillis() - s));

        PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
        System.out.println("Available Print Service  : " + printService.getName());

    PrinterJob printerJob = PrinterJob.getPrinterJob();
        PageFormat pageFormat = printerJob.defaultPage();
        double height = pageFormat.getHeight();
        double wight = pageFormat.getWidth();

        pageFormat.setOrientation(2); // 1 - vertival  2 - horizontal

    Paper paper = pageFormat.getPaper();
        paper.setImageableArea(5,5,wight-5,height-5);
        pageFormat.setPaper(paper);
    //    pageFormat = printerJob.pageDialog(pageFormat);        //  to set Page Format
        printerJob.setPrintable(new CN23_Vertical(box),pageFormat);

        try {
            printerJob.print();
        //    Thread.sleep(5000);

        } catch (Exception e) {
            System.err.println("EXePtioN print Service :" + e.getMessage());
            e.printStackTrace();
        }
    }

    //==============================================================================================================
    public static void printLable(List<IncDel> listsIncDel) throws IOException {
//_______________________________________________________________________________________________________________
        for (IncDel incDel : listsIncDel
                ) {
            printLable(incDel);
            lastPrintCN23='1';  // FIXME: 02.12.2016
        }

    }

//=================================================================================================================
    public static void printLableVertical(IncDel box) throws IOException {
//____________________________________________________________________________________________________________________
        long s = System.currentTimeMillis();

        createBarCodeVertical(box);
        log4j.info("Create image barcode take : " + (System.currentTimeMillis() - s));

      /* try {
           PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
           log4j.info("Available Print Service  : " + printService.getName());
       }catch (NullPointerException ex){
           log4j.error("no available Print Service :"+ex.toString());
       }*/


        PrinterJob printerJob = PrinterJob.getPrinterJob();
        PageFormat pageFormat = printerJob.defaultPage();
        double height = pageFormat.getHeight();
        double wight = pageFormat.getWidth();

        pageFormat.setOrientation(1); // 1 - vertival  2 - horizontal

        Paper paper = pageFormat.getPaper();
        paper.setImageableArea(5,5,wight-5,height-5);
        pageFormat.setPaper(paper);
        //    pageFormat = printerJob.pageDialog(pageFormat);        //  to set Page Format
        printerJob.setPrintable(new CN23_Vertical(box),pageFormat);

        if (printerJob.printDialog()) {
            try {
                log4j.info("try print dialog CN23");
                printerJob.print();
                log4j.info("print finish CN23");
            }
            catch (PrinterException exc) {
                log4j.error("print Service CN23 exeption :" + exc.getMessage());

            }
        }



    }

    public static void printLableVertical(List<IncDel> incDelsList) throws IOException {
        for (IncDel incDel: incDelsList
                ) {
            printLableVertical(incDel);
//            lastPrintCN23="1"; // FIXME: 02.12.2016
        }

    }



    //===============================================CREATE B A R C O D E=====//http://barcode4j.sourceforge.net/2.1/embedding-bean.html
    private static void createBarCode(IncDel box) throws IOException {
//__________________________________________________________________________________________________________________________________
        //Create the barcode bean
        Code39Bean bean = new Code39Bean();

        final int dpi = 135;

//Configure the barcode generator
        bean.setModuleWidth(UnitConv.in2mm(1.0f / dpi)); //makes the narrow bar
        //width exactly one pixel
        bean.setWideFactor(6.5);
        bean.doQuietZone(false);
        bean.setDisplayStartStop(true);
        bean.setDisplayChecksum(true);
        //  bean.setModuleWidth(300);
        bean.setBarHeight(10);


        File outputFile = new File("q.png");



        OutputStream out = new FileOutputStream(outputFile);
        try {
            //Set up the canvas provider for monochrome PNG output
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(
                    out, "image/x-png", dpi, BufferedImage.TYPE_BYTE_BINARY, false, 0);
            //Generate the barcode
            bean.generateBarcode(canvas, "12345");
            //Signal end of generation
            canvas.finish();
            log4j.info("canvas save barcode");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }


    private static void createBarCodeVertical(IncDel box) throws IOException {
//__________________________________________________________________________________________________________________________________
        //Create the barcode bean
        Code39Bean bean = new Code39Bean();

        final int dpi = 100;

//Configure the barcode generator
        bean.setModuleWidth(UnitConv.in2mm(1.0f / dpi)); //makes the narrow bar
        //width exactly one pixel
        bean.setWideFactor(3.5);
        bean.doQuietZone(false);
        bean.setDisplayStartStop(true);
        bean.setDisplayChecksum(true);
        //  bean.setModuleWidth(300);
        bean.setBarHeight(10);

        File outputFile = new File(box.getNumber() + ".png");

        log4j.info("create file :"+outputFile.getName());

        OutputStream out = new FileOutputStream(outputFile);
        try {
            //Set up the canvas provider for monochrome PNG output
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(
                    out, "image/x-png", dpi, BufferedImage.TYPE_BYTE_BINARY, false, 0);
            //Generate the barcode
            bean.generateBarcode(canvas, box.getNumber());
            //Signal end of generation
            canvas.finish();
            log4j.info("canvas save barcode");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }



}//===================================================
