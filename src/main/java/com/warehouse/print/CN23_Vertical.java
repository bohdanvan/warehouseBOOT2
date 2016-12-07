package com.warehouse.print;


import com.warehouse.controller.UploadController;
import com.warehouse.model.IncDel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.swing.*;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;


public class CN23_Vertical implements Printable {
    private String info;
    private IncDel incDel;

    final static Logger log4j = LoggerFactory.getLogger(CN23_Vertical.class);

    public CN23_Vertical(IncDel incDel) {
        this.incDel = incDel;
    }

    public void info(String str) {
        this.info = str;

    }

    public int print(Graphics g, PageFormat pf, int pageNumber) throws PrinterException {

        String user = "user";
        String destinationFROM = "from";
        String destinationTO = "to";
        String invoice = "invoice";


        int count = 0;    // устанавливаем количество страниц
        if (pageNumber > count) {
            return (Printable.NO_SUCH_PAGE);
        } else {

            int wight = (int) pf.getImageableWidth() - 15;
            int height= (int) pf.getImageableHeight();

           //  g.setFont(new Font("Courier", Font.HANGING_BASELINE, 10));

            int indentHor = (int) (wight * 0.10);
            int vert1hor = (int) (indentHor - (indentHor*0.1)); //смещение 1vert line по горизонтали
            int vert2hor = (int) (wight * 0.59); //смещение 2vert по горизонтали

            int hor1Scope = (int) (height*0.04);  // height for 1hor line
            int hor2Scope = (int) (height*0.14);  // height for 2hor line
            int hor3Scope = (int) (height*0.24);  // height for 3hor line
            int hor4Scope = (int) (height*0.27);  // height for 4hor line
            int hor8Scope = (int) (height*0.38);  // height for 8hor line


            g.setFont(new Font("Courier", Font.BOLD, 9));
            g.drawLine(vert1hor, hor1Scope, vert1hor, height/2); // 1vert - вертикальная
            g.drawLine(vert2hor, hor1Scope, vert2hor, hor3Scope); //  2vert

            int vert3hor = (int) (wight * 0.42);
            int v = (wight -vert3hor)/5;
            g.drawLine(vert3hor, hor3Scope, vert3hor, hor8Scope);              //  3vert
            g.drawLine(vert3hor+(v*1), hor3Scope, vert3hor+(v*1), hor8Scope);  //  4vert
            g.drawLine(vert3hor+(v*2), hor3Scope, vert3hor+(v*2), height/2);   //  5vert
            g.drawLine(vert3hor+(v*3), hor3Scope, vert3hor+(v*3), hor8Scope);  //  6vert
            g.drawLine(vert3hor+(v*4),hor3Scope+25,vert3hor+(v*4), (int) (height*0.35)); //  7vert  for commercial
            g.drawLine(wight, hor3Scope-50, wight, height/2);                 // LastVertLine

            int horControler = 30;
            g.drawLine(horControler, hor1Scope, vert2hor, hor1Scope); //1hor

            int scope = (hor2Scope - hor1Scope)/5;
            g.drawString("FROM", (int) (wight*0.02), 80);
            g.drawString("Name      : " + user, indentHor, hor1Scope + (scope*1));
            g.drawString("Bussines : " + "bussines", indentHor, hor1Scope + (scope*2));
            g.drawString("Street   : ", indentHor, hor1Scope + (scope*3));
            g.drawString("City", indentHor, hor1Scope + (scope*4));
            g.drawString("Country  : " + destinationFROM, indentHor, hor1Scope + (scope*5));

            g.drawLine(horControler, hor2Scope, vert2hor, hor2Scope); //2hor

            int scope2 =(hor3Scope-hor2Scope)/5;
            g.drawString("TO", indentHor - 40, 150);
            g.drawString("Name :", indentHor, hor2Scope + (scope2*1));
            g.drawString("Bussines : ", indentHor, hor2Scope + (scope2*2));
            g.drawString("Street : ", indentHor, hor2Scope + (scope2*3));
            g.drawString("City : ", indentHor, hor2Scope + (scope2*4));
            g.drawString("Country : " + destinationTO, indentHor, hor2Scope + (scope2*5));


            g.drawLine(horControler, hor3Scope, wight, hor3Scope); // 3hor

            int heighForChars = (int) (height*0.26);
            g.drawString("Detailed description of contents / goods",vert1hor +2,heighForChars);
            g.drawString("1. Private items",indentHor + 40,hor4Scope + 30);

            g.drawString("Quantity",vert3hor+10,heighForChars);
            g.drawString("5",vert3hor+20 ,hor4Scope + 30);                //q-ty
            g.drawString("5",vert3hor+20,hor8Scope-5);                    //q-ty total block

            g.drawString("Net Weight",vert3hor+(v*1)+3,heighForChars);
            g.drawString("6 kg",vert3hor+(v*1)+20,hor4Scope + 30); //weight
            g.drawString("weight total",vert3hor+(v*1)+20,hor8Scope-5); //weight total block


            g.drawString("Value / $",vert3hor+(v*2)+10,heighForChars);
            g.drawString("$ 120",vert3hor+(v*2)+20,hor4Scope + 30); //value
            g.drawString("$ 980",vert3hor+(v*2)+20,hor8Scope-5); //value

            g.drawString("$139",vert3hor+(v*3)+20,hor8Scope-5); //feeds

            g.drawString("For commercial items only",vert3hor+(v*3)+3,heighForChars-7);





            g.drawString("T O T A L ",vert3hor-60,hor8Scope-5);



            g.drawString("invoice",vert1hor+10,(height/2)-7);  // invoice
            g.drawString("For Personal Use",vert1hor+200,(height/2)-7);
            g.drawString("Service offered by a post office whereby mail is kept ",vert1hor+10,(height/2)-70);
            g.drawString("for an agreed period until collected by the addressee",vert1hor+10,(height/2)-50);



            int v1 = (hor8Scope-hor4Scope)/4;
            g.drawLine(vert1hor, hor4Scope, wight, hor4Scope);                    // 4hor
//            g.drawLine(vert1hor, hor4Scope+(v1*1), wight, hor4Scope+(v1*1));    // 5hor
//            g.drawLine(vert1hor, hor4Scope+(v1*2), wight, hor4Scope+(v1*2));    // 6hor
            g.drawLine(vert1hor, hor4Scope+(v1*3), wight, hor4Scope+(v1*3));      // 7hor
            g.drawLine(vert1hor, hor8Scope, wight, hor8Scope);                    // 8hor
            g.drawLine(vert2hor, hor3Scope-50, wight, hor3Scope-50);              // 9hor
            g.drawLine(v, hor3Scope+25, wight, hor3Scope+25);                            // 10hor
            g.drawLine(vert1hor, (height/2)-30, vert3hor+(v*2), (height/2)-30);   //12hor
            g.drawLine(vert1hor, height/2, wight, height/2);                      // lastHorLine

           //barCode
            int barcodePositionHor = (int) (vert2hor+(vert2hor*0.05));
            int barcodePositionVert = (int) ((height/2)*0.1);

         log4j.info("start read barcode to CN23 ");
         try {
             ImageIcon printImage = new ImageIcon(incDel.getNumber() + ".png");
             log4j.info("read CN23 complite");
             g.drawImage(printImage.getImage(), barcodePositionHor, barcodePositionVert, null);
         }catch (Exception ex){
             log4j.error("read barcode to CN23 :"+ex.toString());
         }




            Graphics2D g3D = (Graphics2D) g;
            g3D.setFont(new Font("Courier", Font.BOLD, 15));
            g3D.drawString("AZEMEX Ltd", vert1hor+50,hor1Scope-5);


            Graphics2D g2D = (Graphics2D) g;
            g2D.setFont(new Font("Courier", Font.BOLD, 10));
            g2D.drawString("CUSTOMS DECLARATION CN23", (int) (vert2hor +(vert2hor*0.05)), (int) ((height/2)*0.05));

            Graphics2D g2 = (Graphics2D) g;
            g2.setFont(new Font("Courier", Font.PLAIN, 6));
            g2.drawString("Importer reference", vert2hor + 20, hor3Scope-40);

            g2.drawString("HS tariff number",vert3hor+(v*3)+2,heighForChars+5);
            g2.drawString("Country of origin",vert3hor+(v*4)+2,heighForChars+5);
            g2.drawString("Postal charges/Fees",wight-130,hor8Scope - 17);
            g2.drawString("Office of origin/",vert1hor,hor1Scope-5);

            g2.setFont(new Font("Courier", Font.LAYOUT_LEFT_TO_RIGHT, 6));
            g2.drawString("No. of invoice",vert1hor+10,(height/2)-20);

            g2.drawString("Licence ",vert1hor+70,(height/2)-20);
            g2.drawString("Certificate ",vert1hor+130,(height/2)-20);
            g2.drawString("Category of item ",vert1hor+200,(height/2)-20);

            g2.drawString("Comments (e.g.: goods subject to quarantine, sanitary/phytosanitary inspection or other restrictions",vert1hor+5,hor8Scope+10);

            int left = wight-200;
            g2.setFont(new Font("Courier", Font.LAYOUT_LEFT_TO_RIGHT, 7));
            g2.drawString("I certify that the particulars given in this customs decla-",left,hor8Scope+8);
            g2.drawString("ration are correct and that this item does not contain any",left,hor8Scope+16);
            g2.drawString("dangerous article or articles prohibited by legislation or",left,hor8Scope+24);
            g2.drawString("by postal or customs regulations",left,hor8Scope+32);

            g2.drawString("DATE",left+10,(height/2)-40);
            g2.drawString("Date and sender’s signature",left,(height/2)-7);


//set Box number
            Graphics2D number = (Graphics2D) g;
            number.setFont(new Font("Courier", Font.BOLD, 30));
            number.drawString("number", (int) (vert2hor+(vert2hor*0.15)),hor3Scope-70);


            return (Printable.PAGE_EXISTS);
        }
    }


}

/*
       if(pageNumber>1){

            return(Printable.NO_SUCH_PAGE);
        }else{

            g.drawString("Page "+(pageNumber+1),150,150);
            g.drawString("Test STRING", 200 , 160);
            int x = 100;
            int y = 100;
            int widht = 1000;
            int height = 100;
            boolean raised = false;

            g.draw3DRect(x,y,widht,height,raised);
            g.drawLine(1,3,300,300);

        }
        return(Printable.PAGE_EXISTS);
    }
*/




