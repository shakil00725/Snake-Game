import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class list extends JFrame {

	   String input;
	   String name;
       int score1;		

		
		 private JLabel LabelName = new JLabel("Name   ");
		 private JLabel LabelScore = new JLabel("Score");
		 
		 public dataArray p1;
		 
		 dataArray[] q = dataArray.dataArrayset(12);
		 
	list()
	{
		
		read();
		
		SwingJPanelDemo();	
		
	}
	
	 public void SwingJPanelDemo() {
		 
	       JLabel label1st = new JLabel(String.valueOf(q[0].name));
	       JLabel label2nd= new JLabel(String.valueOf(q[1].name));
		   JLabel label3rd = new JLabel(String.valueOf(q[2].name));
		   JLabel label4th = new JLabel(String.valueOf(q[3].name));
		   JLabel label5th = new JLabel(String.valueOf(q[4].name));
	       JLabel label6th = new JLabel(String.valueOf(q[5].name));
	       JLabel label7th = new JLabel(String.valueOf(q[6].name));
	       JLabel label8th = new JLabel(String.valueOf(q[7].name));
	       JLabel label9th = new JLabel(String.valueOf(q[8].name));
	       JLabel label10th = new JLabel(String.valueOf(q[9].name));
	       
	       JLabel labelscore1st = new JLabel(String.valueOf(q[0].number));
	       JLabel labelscore2nd= new JLabel(String.valueOf(q[1].number));
		   JLabel labelscore3rd = new JLabel(String.valueOf(q[2].number));
		   JLabel labelscore4th = new JLabel(String.valueOf(q[3].number));
		   JLabel labelscore5th = new JLabel(String.valueOf(q[4].number));
	       JLabel labelscore6th = new JLabel(String.valueOf(q[5].number));
	       JLabel labelscore7th = new JLabel(String.valueOf(q[6].number));
	       JLabel labelscore8th = new JLabel(String.valueOf(q[7].number));
	       JLabel labelscore9th = new JLabel(String.valueOf(q[8].number));
	       JLabel labelscore10th = new JLabel(String.valueOf(q[9].number));
		
	       
		    setVisible(true);
		    
		    
	   
	        JPanel newPanel = new JPanel(new GridBagLayout());
	        newPanel.setBackground(Color.CYAN);
	        newPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	        GridBagConstraints constraints = new GridBagConstraints();
	        constraints.anchor = GridBagConstraints.WEST;
	        setSize(400,500);
	        constraints.insets = new Insets(10, 75, 1, 50);
	         
	        constraints.gridx = 0;
	        constraints.gridy = 0;     
	        newPanel.add(LabelName, constraints);
	 
	        
	         
	        constraints.gridx = 1;
	        constraints.gridy = 0;     
	        newPanel.add(LabelScore, constraints);
	        
	        //1st player
	        
	        constraints.gridx = 0;
	        constraints.gridy = 1;     
	        newPanel.add(label1st, constraints);
	 
	        
	         
	        constraints.gridx = 1;
	        constraints.gridy = 1;     
	        newPanel.add(labelscore1st, constraints);
	        
	        //2nd player
	        
	        constraints.gridx = 0;
	        constraints.gridy = 2;     
	        newPanel.add(label2nd, constraints);
	 
	        
	         
	        constraints.gridx = 1;
	        constraints.gridy = 2;     
	        newPanel.add(labelscore2nd, constraints);
	        
	         

	        
	        constraints.gridx = 0;
	        constraints.gridy = 3;     
	        newPanel.add(label3rd, constraints);
	 
	        
	         
	        constraints.gridx = 1;
	        constraints.gridy = 3;     
	        newPanel.add(labelscore3rd, constraints);
	        
	        

	        
	        constraints.gridx = 0;
	        constraints.gridy = 4;     
	        newPanel.add(label4th, constraints);
	 
	        
	         
	        constraints.gridx = 1;
	        constraints.gridy = 4;     
	        newPanel.add(labelscore4th, constraints);
	        

	        
	        constraints.gridx = 0;
	        constraints.gridy = 5;     
	        newPanel.add(label5th, constraints);
	 
	        
	         
	        constraints.gridx = 1;
	        constraints.gridy = 5;     
	        newPanel.add(labelscore5th, constraints);
	        

	        
	        constraints.gridx = 0;
	        constraints.gridy = 6;     
	        newPanel.add(label6th, constraints);
	 
	        
	         
	        constraints.gridx = 1;
	        constraints.gridy = 6;     
	        newPanel.add(labelscore6th, constraints);
	        

	        
	        constraints.gridx = 0;
	        constraints.gridy = 7;     
	        newPanel.add(label7th, constraints);
	 
	        
	         
	        constraints.gridx = 1;
	        constraints.gridy = 7;     
	        newPanel.add(labelscore7th, constraints);
	        

	        
	        constraints.gridx = 0;
	        constraints.gridy = 8;     
	        newPanel.add(label8th, constraints);
	 
	        
	         
	        constraints.gridx = 1;
	        constraints.gridy = 8;     
	        newPanel.add(labelscore8th, constraints);

	        
	        constraints.gridx = 0;
	        constraints.gridy = 9;     
	        newPanel.add(label9th, constraints);
	 
	        
	         
	        constraints.gridx = 1;
	        constraints.gridy = 9;     
	        newPanel.add(labelscore9th, constraints);
	        

	        
	        constraints.gridx = 0;
	        constraints.gridy = 10;     
	        newPanel.add(label10th, constraints);
	 
	        
	         
	        constraints.gridx = 1;
	        constraints.gridy = 10;     
	        newPanel.add(labelscore10th, constraints);
	     
	         
	        
	        newPanel.setBorder(BorderFactory.createTitledBorder(
	                BorderFactory.createEtchedBorder(), "Score Board"));
	         
	        add(newPanel);
	         
	        pack();
	        setLocationRelativeTo(null);
	        
	                
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
	
		            	{    	q[j].name = line.trim();
		            			
		            			o=1;
		            	}
		            	else if(o==1)
		            	{
		            
		                     q[j].number =Integer.parseInt(line.trim()); 
		            	              			         			       
		            		 o=0;
		            		 j++;
		            	}
		            	 
		            		            		         		              						
		            } catch (NumberFormatException e1) {
		              //  System.err.println("ignoring invalid score: " + line);
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
	
