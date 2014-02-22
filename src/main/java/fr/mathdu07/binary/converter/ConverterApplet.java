package fr.mathdu07.binary.converter;

import java.awt.BorderLayout;

import javax.swing.JApplet;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import fr.mathdu07.binary.converter.panel.AboutPanel;
import fr.mathdu07.binary.converter.panel.AsciiPanel;

public class ConverterApplet extends JApplet
{

    /**
     * 
     */
    private static final long serialVersionUID = -6010840076506008851L;
    
    private JTabbedPane tabs;

    @Override
    public void init()
    {
        super.init();
        SwingUtilities.invokeLater(new Runnable() {
        	public void run()
        	{
        		buildApplet();
        	}
        });
    }
    
    private void buildApplet()
    {
        tabs = new JTabbedPane();
        tabs.addTab("ASCII", new AsciiPanel());
        tabs.addTab("À propos", new AboutPanel());
        setLayout(new BorderLayout());
        add(tabs, BorderLayout.CENTER);
        try
        {
        	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        	SwingUtilities.updateComponentTreeUI(this);
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        }
    }

    @Override
	public void destroy()
	{
	    super.destroy();
	}

	@Override
    public void start()
    {
        super.start();
    }

    @Override
    public void stop()
    {
        super.stop();
    }

}
