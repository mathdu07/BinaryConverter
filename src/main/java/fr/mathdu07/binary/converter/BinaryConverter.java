package fr.mathdu07.binary.converter;

import java.lang.System;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

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
            
            final JProgressBar loading = new JProgressBar();
            loading.setString("Lancement de l'applet");
            loading.setIndeterminate(true);
            add(loading);
            
            applet = new ConverterApplet();
            applet.init();
            applet.start();
            remove(loading);
            add(applet);
            
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setResizable(false);
            this.setSize(400, 300);
            this.setVisible(true);
        }
    }

}
