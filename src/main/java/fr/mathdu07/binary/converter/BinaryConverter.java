package fr.mathdu07.binary.converter;

import java.awt.BorderLayout;
import java.lang.System;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

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
    
    private static final class ConverterApplication extends JFrame implements Runnable
    {
        /**
         * 
         */
        private static final long serialVersionUID = 7952427666672666473L;
        final ConverterApplet applet;
        
        private final JPanel loadingPanel;
        private JProgressBar progress;

        public ConverterApplication()
        {
            super("Convertisseur Binaire");
            
            this.loadingPanel = buildLoadingPanel();
            add(loadingPanel);
            
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setResizable(false);            
            this.setSize(400, 325);
            this.setLocationRelativeTo(null);
            this.setVisible(true);
            
            applet = new ConverterApplet();
            
            Thread t = new Thread(this);
            t.start();
        }
        
        private JPanel buildLoadingPanel()
        {
        	JPanel panel = new JPanel();
        	
        	panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        	
            this.progress = new JProgressBar();
            progress.setStringPainted(true);
            progress.setString("Lancement de l'applet");
            progress.setIndeterminate(true);
            panel.add(progress, BorderLayout.CENTER);
            
            return panel;
        }

		@Override
		public void run()
		{
            applet.init();
            applet.start();
            
            SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
		            remove(loadingPanel);
		            add(applet);
		            
		            SwingUtilities.updateComponentTreeUI(applet.getParent());
				}
            	
            });
		}
        
    }

}
