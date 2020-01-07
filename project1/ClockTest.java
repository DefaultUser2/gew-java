import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.Timer;

import java.util.*;


public class ClockTest<CsvFile> extends JFrame {
	
//Main function that displays all the info and attaches listeners for buttons.
//Would have prefered to have the listeners in the button classes but couldnt get it working there.	
  public ClockTest() {
    super("Clock Demo");
    setSize(500, 500);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    //Label for the time display
    ClockLabel clock = new ClockLabel();
    getContentPane().add(clock, BorderLayout.PAGE_START);
    //Show csv info button
    CsvButton c = new CsvButton();
    c.setBounds(10,100,200,40);
    getContentPane().add(c, BorderLayout.CENTER);
    //Show days until xmas button
    XmasButton b = new XmasButton();
    b.setBounds(10,50,200,40);
    getContentPane().add(b, BorderLayout.CENTER);
    //Days until xmas label
    XmasLabel xtime = new XmasLabel();
    getContentPane().add(xtime, BorderLayout.CENTER);
    xtime.setVisible(false);
    b.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        	xtime.setVisible(true);   
        }
    }); 
    //Read info from csv file
    List<CsvFile> lines = readInfoFromCSV("test2.csv");
    System.out.println(lines);
    CsvLabel d = new CsvLabel();
    getContentPane().add(d, BorderLayout.SOUTH);
    c.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
               d.setText(lines.toString());
        }
    });
  }
  
  //Create content pane where everything will be shown
  public static void main(String args[]) {
    ClockTest ct = new ClockTest();
    ct.setVisible(true);
  }

   
  private static  List<CsvFile> readInfoFromCSV(String fileName) {
      List<CsvFile> lines = new ArrayList<>();
      Path pathToFile = Paths.get(fileName);

      // create an instance of BufferedReader
      try (BufferedReader br = Files.newBufferedReader(pathToFile,
              StandardCharsets.US_ASCII)) {
          // read the first line from the text file
          String line = br.readLine();
          // loop until all lines are read
          while (line != null) {
        	 // System.out.println(line);
              // use string.split to load a string array with the values from
              // each line of
              // the file, using a comma as the delimiter
              String[] attributes = line.split(",");
              System.out.println(attributes);
              CsvFile info = createInfo(attributes);
              // add info to line
              lines.add(info);
              // read next line before looping
              // if end of file reached, line would be null
              line = br.readLine();
          }

      } catch (IOException ioe) {
          ioe.printStackTrace();
      }

      return lines;
  }



//CsvFile class
  public static class CsvFile {
	    private String info;

	    public CsvFile(String info) {
	        this.info = info;

	    }

	    public String getInfo() {
	        return info;
	    }

	    public void setInfo(String name) {
	        this.info = info;
	    }
	    
	    public String toString() {
	        return info+ "test";
	    }
  }
//writes the info into a readable string
public static CsvFile createInfo(String[] metadata) {
	int i = 0;
	String data = "";

	while(i < metadata.length)
	{
		//System.out.println("meta: "+metadata[i]);
		data += metadata[i] + ",";
		i++;
	}
    // create and return book of this metadata
    return new CsvFile(data);
}
}

//Basic timer class
class ClockLabel extends JLabel implements ActionListener {
  public ClockLabel() {
    super("" + new Date());
    Timer t = new Timer(1000, this);
    t.start();
  }

  public void actionPerformed(ActionEvent ae) {
    setText((new Date()).toString());
  }
}

//Csv info label class
class CsvLabel extends JLabel {
	  public CsvLabel() {
	    super("Csv Placeholder");
	  }
	}

//Xmasbutton class
class XmasButton extends JButton{
	  public XmasButton() {
	    super("Show Days Until Xmas");
	  }
	}

//CSV button class
class CsvButton extends JButton{
	public CsvButton()
	{
		setText("Load CSV");
	}
}

//Xmas Label class, to show days until xmas.
class XmasLabel extends JLabel  {
  public XmasLabel() {
   super("Days until xmas:");
    Calendar c = new GregorianCalendar();
  c.set(Calendar.YEAR, 2020);
  c.set(Calendar.MONTH, 11); // 11 = december
  c.set(Calendar.DAY_OF_MONTH, 25);
  Date xmas = c.getTime();
   Date today = new Date();
   long diff = xmas.getTime() - today.getTime();
   diff = diff / (1000L*60L*60L*24L);
   setText("Days until xmas: "+diff);
  }
}

