package digital_clock;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;

public class MyWindow extends JFrame{

    private JLabel heading;
    private JLabel clockLabel;
    private Font font = new Font("",Font.BOLD,35);
    MyWindow(){
        super.setTitle("My Clock");//since jFrame is the parent class
        super.setSize(400,400);//this can be used without super as it will automatially call it
        super.setLocation(300,50);
        this.createGUI();
        this.startClock();
        super.setVisible(true);
    }
    public void createGUI(){
        //gui
        heading = new JLabel("My Clock");
        clockLabel = new JLabel("clock");
        heading.setFont(font);
        clockLabel.setFont(font);

        this.setLayout(new GridLayout(2,1));
        this.add(heading);
        this.add(clockLabel);

    }

    public void startClock(){
//        Timer timer = new Timer(1000, new ActionListener() {//this ActionListener() is anonymous class
//            @Override
//            public void actionPerformed(ActionEvent e) {
//               // String dateTime = new Date().toString();
//                // above give global timing in ist
//                //or
//                //  String dateTime = new Date().toLocaleString();
//                // above give date with am or pm
//                //or
//
//                //below give the time of format edited by user
//                Date d = new Date();//Date obj present in  java.util pkg
//                SimpleDateFormat sdf = new SimpleDateFormat("hh : mm : ss a");//here a will give am or pm
//                //another class simple date foramt present in util pkg
//                String dateTime = sdf.format(d);//input date output string of above pattern
//
//
//                clockLabel.setText(dateTime);
//
//            }
//        });
//        timer.start();



        //using thread
        Thread t  = new Thread(){
         public void run(){
             try{
                 while(true){
                     Date d = new Date();//Date obj present in  java.util pkg
                     SimpleDateFormat sdf = new SimpleDateFormat("hh : mm : ss a");//here a will give am or pm
                     //another class simple date foramt present in util pkg
                     String dateTime = sdf.format(d);//input date output string of above pattern


                     clockLabel.setText(dateTime);
                     Thread.sleep(1000);

                 }
             }
             catch (InterruptedException e){
                 e.printStackTrace();
             }
         }
        };
        t.start();
    }
}
