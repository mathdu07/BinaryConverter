package fr.mathdu07.binary.converter;

import java.lang.System;

import javax.swing.JFrame;

public class BinaryConverter
{
    public static final String VERSION = "0.1-SNAPSHOT";

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        System.out.println("Starting BinaryConverter v" + VERSION + " ...");
        ConverterApplication app = new ConverterApplication();
        app.applet.stop();
        app.applet.destroy();
    }
    
    private static final class ConverterApplication extends JFrame
    {
        /**
         * 
         */
        private static final long serialVersionUID = 7952427666672666473L;
        final ConverterApplet applet;

        public ConverterApplication() {
            super("Convertisseur Binaire");
            applet = new ConverterApplet();
            add(applet);
            applet.init();
            applet.start();
            
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setResizable(false);
            this.setSize(400, 300);
            this.setVisible(true);
        }
    }

}
