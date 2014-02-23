package fr.mathdu07.binary.converter.panel;

import java.io.IOException;
import java.io.InputStream;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.mathdu07.binary.converter.BinaryConverter;

public class AboutPanel extends JPanel
{

    /**
     * 
     */
    private static final long serialVersionUID = 2353601682384242704L;
    
    private JLabel aboutLabel;
    
    public AboutPanel()
    {
        super();
        aboutLabel = new JLabel("Erreur lors du chargement");
        
        try
        {
            String text = readAbout(getClass().getResourceAsStream("/about.html"));
            text = text.replace("$VERSION", BinaryConverter.VERSION);
            text = text.replace("$JRE_VERSION", System.getProperty("java.version"));
            text = text.replace("$OS_NAME", System.getProperty("os.name"));
            text = text.replace("$OS_VERSION", System.getProperty("os.version"));
            aboutLabel.setText(text);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        add(aboutLabel);
    }
    
    private String readAbout(InputStream is) throws IOException
    {
        String str = new String();
        byte[] buffer = new byte[16];
        
        while (is.read(buffer) != -1)
            str += new String(buffer, "utf8");
        
        is.close();
        
        return str;
    }
    
    
    
    

}
