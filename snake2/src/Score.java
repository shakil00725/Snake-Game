
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.io.*;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;




public class Score extends JFrame {
	
	   JPanel jp = new JPanel();
	   JLabel jl = new JLabel();
	   JLabel jl1 = new JLabel();
	   JTextField textField = new JTextField(20);
	   JButton jBtnSelection = new JButton("Selection");
	   String input;
	   
	   public dataArray data ;
		
	   private SideP op;
	   dataArray[] q = dataArray.dataArrayset(12);
	
	   Score(int score)
	 {
		setSize(300,200);
		setTitle("Snake");
		setVisible(true);
		jp.add(textField);
		add(jp);

	
		jBtnSelection.addActionListener(new ActionListener() {
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	  input = textField.getText();
            	
            	  
            	  if(textField.getText().equals(""))
            	  {
            		  JOptionPane.showMessageDialog(null, "Please insert the name of yours !!!");
            		  
            	  }
            	  
            	  else{
            	
            	  dataArray[] p = dataArray.dataArrayset(11);
            	  read();
            	 
            	  PrintWriter writer = null;
				try {
					writer = new PrintWriter("checkbook.dat");
				} catch (FileNotFoundException e1) {
				
					e1.printStackTrace();
				}
            	 writer.print("");
            	 writer.close();
            	 
            	 
         		 for(int i=0;i<10;i++)
         		 {
         		   p[i].name=q[i].name;
         		   p[i].number=q[i].number;
         		 }
         		 
         		 	p[10].name =input;
         		 	p[10].number=score;
      		    
      		   
      		   if(p[0].name!=null)
      		   			appendToCheckbook(p[0].name,p[0].number); 
      		   if(p[1].name!=null)
 			   		appendToCheckbook(p[1].name,p[1].number);
      		   if(p[2].name!=null)
		   			appendToCheckbook(p[2].name,p[2].number);
      		   
      		 
    		   if(p[3].name!=null)
    			   		appendToCheckbook(p[3].name,p[3].number);
      		   if(p[4].name!=null)
 		   			appendToCheckbook(p[4].name,p[4].number); 
      		   if(p[5].name!=null)
			   		appendToCheckbook(p[5].name,p[5].number);
      		   if(p[6].name!=null)
		   			appendToCheckbook(p[6].name,p[6].number); 
      		   if(p[7].name!=null)
			   		appendToCheckbook(p[7].name,p[7].number);
      		   if(p[8].name!=null)
		   			appendToCheckbook(p[8].name,p[8].number); 
      		   if(p[9].name!=null)
			   		appendToCheckbook(p[9].name,p[9].number);
      		 if(p[10].name!=null)
			   		appendToCheckbook(p[10].name,p[10].number);
      		                
      		      new list(); 	 
            	 setVisible(false);            	 
            	  }
    	 
                
            }
        });
		    
		jp.add(jBtnSelection);
		add(jp);	
	}

	   public void appendToCheckbook (String x, int y) {
		   
		  
	      BufferedWriter bw = null;

	      try {
	     bw = new BufferedWriter(new FileWriter("checkbook.dat", true));
		 bw.write(x);
		 
		 bw.newLine();
		 bw.write(String.valueOf(y));
		 bw.newLine();
		 bw.flush();
	      } catch (IOException ioe) {
		 ioe.printStackTrace();
	      } finally {                      
		 if (bw != null) try {
		    bw.close();
		 } catch (IOException ioe2) {
		
			// System.out.println(" "+input);
		 }
	      } 

	   }
	   
public void read()
	{
		    try {
		    	
		        BufferedReader reader = new BufferedReader(new FileReader("checkbook.dat"));
		        String line = reader.readLine();
		        int o=0;
		        int j=0;
		        while (line != null)               
		        {
		        	
		         try {
		            	
		            if(o==0)
		            	{
		            	    q[j].name = line.trim();
			            	o=1;
		            	}
		            	else if(o==1)
		            	{
		            		q[j].number =Integer.parseInt(line.trim()); 
		    		        o=0;
			        		j++;
		            	}
		            	 
		            		            		         		              						
		            } catch (NumberFormatException e1) {
		                //System.err.println("ignoring invalid score: " + line);
		            }
		            line = reader.readLine();
		        }        
		        
		        reader.close();
		     
		       
		        dataArray[] temp = dataArray.dataArrayset(11);
		        
		       
	        int j1;
            boolean flag = true;   
	  
	        while ( flag )
	        {
	               flag= false;   
	             //  System.out.println( q.length -1);
	               
	               for( j1=0;  j1 < q.length -1;  j1++ )
	               {
	                      if ( q[j1].number< q[j1+1].number )  
                      {   
	                    	  temp[0].number = q[ j1 ].number;   
                              temp[0].name = q[ j1 ].name; 
                              q[j1].number = q[j1+1].number;
                              q[j1].name = q[j1+1].name;
                              q[j1+1].number = temp[0].number;
                              q[j1+1].name = temp[0].name;
                              flag = true;           
	                     } 
		               } 
	         } 
 
		    } catch (IOException ex) {
		        System.err.println("ERROR reading scores from file");
		    }
	}
	
}

