package edu.neu.ccs.cs5004.mvc;

import java.awt.*;

import javax.swing.*;


/**
 * Creates the GUI window and passes everything off to the controller.
 */
public class Application extends JFrame{

    public Application() {
        initUI();
    }

    private void initUI() {

        MastermindController controller = new MastermindController();

        // puts board in the center of JFrame container
        add(controller.getGui());

        // sets size of window
        setSize(500, 500);

        setTitle("Application");

        // close application when you click close
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // center window
        setLocationRelativeTo(null);


    }

    public static void main(String[] args) {

        /* This is a concurrency thing. Basically, all Swing processes are in the Event Dispatching
           Thread. invokeLater posts Runnable (an event) at the end of the Swing event list and
           processes it after all the previous GUI stuff is processed. Keeps GUI responsive.
         */


        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                // create new instance and display
                Application ex = new Application();
                ex.setVisible(true);
            }
        });
    }
}
