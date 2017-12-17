package practice;

import javafx.scene.input.DataFormat;

import java.text.DateFormat;
import java.text.Format;
import java.util.Date;
import java.util.Locale;

public class PractisingThread implements Runnable {

    String nameoftheThread;

    DateFormat dateFormat;

    DateFormat timeFormat;

    Locale locale;


    PractisingThread(String nameoftheThread, Locale locale) {
        this.nameoftheThread = nameoftheThread;

        this.locale = locale;

    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            Date date = new Date();

            dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);

            timeFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT, locale);

            System.out.println(nameoftheThread);

            System.out.println(dateFormat.format(date));

            System.out.println(timeFormat.format(date));

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

    public static void main(String[] args) {

        Runnable thread1 = new PractisingThread("TimeIN", new Locale("in"));

        Runnable thread2 = new PractisingThread("TimeEn", new Locale("en"));

        new Thread(thread1).start();

        new Thread(thread2).start();
    }
}
