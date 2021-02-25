import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;

public class gpaframe extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField CHETextfield;
    private JLabel CHElabel;
    private JLabel CGPA;
    private JTextField CGPAfield;
    private JLabel NOC;
    private JComboBox NOCbox;
    private JTextField textField;
	private ArrayList<JTextField> textfield;
	private ArrayList<JComboBox> combobox;
	private ArrayList<JComboBox> Gcombobox;
	private JPanel panel;
	private JScrollPane scroll;
	private JLabel CourseCode;
	private JLabel CH;
	private JLabel Grade;
	private JPanel panelC;
	private JPanel panelG;
	private JButton Calculate;
	private JLabel YGPA;
	private JComboBox cbox;
	private JComboBox gbox;
	private double grades;
	private JTextField GPAtextfield;
	private JTextField cumulativetextfield;
	
	
	public gpaframe() {
		initialize();
		addcomponents();
		action();
		this.CHETextfield.addActionListener(this);
		this.CGPAfield.addActionListener(this);
		this.NOCbox.addActionListener(this);
		
	}
	
	
	public void initialize()
	{setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 578, 373);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	}
    
		
	
	
	public void addcomponents()
	{
		contentPane.setLayout(null);
		CHElabel = new JLabel("Credit Hours Earned");
		CHElabel.setBounds(5, 5, 134, 19);
		CHElabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(CHElabel);
		
		CHETextfield = new JTextField();
		CHETextfield.setBounds(179, 5, 25, 19);
		contentPane.add(CHETextfield);
		CHETextfield.setColumns(10);
		
		CGPA = new JLabel("Previous GPA");
		CGPA.setBounds(375, 5, 103, 18);
		CGPA.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(CGPA);
	    
	    CGPAfield = new JTextField();
	    CGPAfield.setBounds(502, 5, 52, 19);
	    contentPane.add(CGPAfield);
	    CGPAfield.setColumns(10);
	    
	    //JCombobox Label 
	    NOC = new JLabel("Number of Courses");
	    NOC.setBounds(375, 30, 122, 18);
	    NOC.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
	    contentPane.add(NOC);
		
	    //Number of course JCombo box 
	    NOCbox = new JComboBox();
	    NOCbox.setBounds(502, 29, 52, 19);
	    NOCbox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
	    contentPane.add(NOCbox);
	    
	    //Course Code Label 
	    CourseCode = new JLabel("Course Code");
	    CourseCode.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
	    CourseCode.setBounds(50, 119, 89, 19);
	    contentPane.add(CourseCode);
	    
	    //Credit Hour Label 
	    CH = new JLabel("Credit Hour");
	    CH.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
	    CH.setBounds(240, 119, 89, 19);
	    contentPane.add(CH);
	    
	    //Grade Label
	    Grade = new JLabel("Grade");
	    Grade.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
	    Grade.setBounds(430, 119, 89, 19);
	    contentPane.add(Grade);
	    
	    //Calculate button 
	    Calculate = new JButton("Calculate");
	    Calculate.setBounds(451, 305, 103, 21);
	    contentPane.add(Calculate);

	    
	    
	    
	    //Jlabel to print the GPA
	    YGPA = new JLabel("Current GPA");
	    YGPA.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
	    YGPA.setBounds(5, 308, 115, 13);
	    contentPane.add(YGPA);
	    
        //ScrollPane for Number of courses
	    this.scroll=new JScrollPane();
	    this.scroll.setBounds(35,148,108,142);
	    contentPane.add(scroll);
	    GridBagLayout grid= new GridBagLayout();
	    this.panel=new JPanel();
	    this.panel.setLayout(grid);
	    scroll.setViewportView(panel);
	    
	    //ScrollPane for Credit hour combo box
	    JScrollPane scrollC= new JScrollPane();
	    scrollC.setBounds(196,148,335,142);
	    contentPane.add(scrollC);
	    GridBagLayout gridC= new GridBagLayout();
	    gridC.columnWeights = new double[]{};
	    this.panelC=new JPanel(gridC);
	    scrollC.setViewportView(panelC);
	    
	    GPAtextfield = new JTextField();
	    GPAtextfield.setBounds(130, 306, 39, 19);
	    contentPane.add(GPAtextfield);
	    GPAtextfield.setColumns(10);
	    
	    JLabel CumulativeGpalabel = new JLabel("Cumulative GPA");
	    CumulativeGpalabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
	    CumulativeGpalabel.setBounds(179, 309, 122, 13);
	    contentPane.add(CumulativeGpalabel);
	    
	    cumulativetextfield = new JTextField();
	    cumulativetextfield.setBounds(306, 306, 39, 19);
	    contentPane.add(cumulativetextfield);
	    cumulativetextfield.setColumns(10);
	    
	    
	    
	}


	@Override
	public void actionPerformed(ActionEvent event) {
	
	//Arraylist 
    textfield= new ArrayList<JTextField>();
    combobox=new ArrayList<JComboBox>();
    Gcombobox=new ArrayList<JComboBox>();
    
    if(event.getSource()==this.NOCbox)
	{
    	
    //Grid Constraints
     GridBagConstraints N = new GridBagConstraints();
     GridBagConstraints C = new GridBagConstraints();
     GridBagConstraints G = new GridBagConstraints();
     
    int counter=0;
    
    
	 
     for(int i=0;i<=this.NOCbox.getSelectedIndex();i++)
	{  
    
      counter++;
      
      if(counter!=1)
      {
    
      // Generates Textfields for number of courses	  
      textfield.add(new JTextField());
       N.gridx=0;
       N.gridy=i;
       N.gridwidth=2;
       N.gridwidth=1;
       N.insets=new Insets(0,0,10,0);
       textfield.get(i).setPreferredSize(new Dimension(87,20));
       panel.add(textfield.get(i),N);
		
	
	   
       //Generates Combobox for Credit hours
       JComboBox cbox= new JComboBox();
	   combobox.add(cbox);
	   C.gridx=0;
	   C.gridy=i;
	   C.insets=new Insets(0,0,10,0);
	   combobox.get(i).setPreferredSize(new Dimension(87,20));
	   combobox.get(i).setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	   combobox.get(i).setModel(new DefaultComboBoxModel(new String[]{"1", "2", "3", "4", "5", "6"}));
	   panelC.add(combobox.get(i),C);
	   
	 
	   //Generates Combobox for the grades
	   JComboBox gbox= new JComboBox();
	   Gcombobox.add(gbox);
	   G.gridx=20;
	   G.gridy=i;
	   G.insets=new Insets(0,0,10,0);
	   Gcombobox.get(i).setPreferredSize(new Dimension(87,20));
       Gcombobox.get(i).setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	   Gcombobox.get(i).setModel(new DefaultComboBoxModel(new String[] {"A+ (90-100%)", "A (80-89%)", "B+(75-79%)",
			   "B (70-74%)", "C+ (65-69%)", "C (60-64%)", "D+ (55-59%)", "D (50-54%)", "F (0-49%)" }));
	   panelC.add(Gcombobox.get(i),G);
	   
	 

	   panel.add(textfield.get(i),N);
	   panelC.add(combobox.get(i),C);
	   panelC.add(Gcombobox.get(i),G);
      

	  revalidate();
	  repaint();


      }
	  

	 else{
       panel.removeAll();
       panelC.removeAll();
       revalidate();
       repaint();
   	   
       //Generate TextField for Number of Course
       textfield.add(new JTextField());
       N.gridx=0;
       N.gridy=i;
       N.insets=new Insets(0,0,7,0);
       textfield.get(i).setPreferredSize(new Dimension(87,20));
       panel.add(textfield.get(i),N);
         
     
  		
  		
  	 //Generate Combox for number of Credit hours
  	  combobox.add(new JComboBox());
  	  C.gridx=0;
  	  C.gridy=i;
  	  
  	  C.insets=new Insets(0,0,5,0);
  	  
  	  combobox.get(i).setPreferredSize(new Dimension(87,20));
  	  combobox.get(i).setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  	  combobox.get(i).setModel(new DefaultComboBoxModel(new String[]{"1", "2", "3", "4", "5", "6"}));
  	  panelC.add(combobox.get(i),C);
  	  
  	  
  	  

	   //Generates Combobox for the grades
	   JComboBox gbox= new JComboBox();
	   Gcombobox.add(gbox);
	   G.gridx=15;
	   G.gridy=i;
	   G.insets=new Insets(0,0,10,0);
	   Gcombobox.get(i).setPreferredSize(new Dimension(87,20));
       Gcombobox.get(i).setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	   Gcombobox.get(i).setModel(new DefaultComboBoxModel(new String[]{"A+ (90-100%)", "A (80-89%)", "B+(75-79%)", "B (70-74%)", "C+ (65-69%)", "C (60-64%)", "D+ (55-59%)", "D (50-54%)", "F (0-49%)"}));
	   panelC.add(Gcombobox.get(i),G);
	   
  	  
  	  

  	  revalidate();
  	  repaint();
      
      }  
      
    	  
	}
	}
	
	}
	private void action() {
    this.Calculate.addActionListener(new ActionListener() {
    	
    	

		public void actionPerformed(ActionEvent event) {
		
	    double Totalcredithours=0;
		double qualitypoints;
		double Totalqualitypoints=0;
		double gradepoints;
		double gpoints;
		
		double h;
        for(int index=0;index<=Gcombobox.size() - 1;index++)
        {
          switch(Gcombobox.get(index).getSelectedIndex())
          {
          case 0:
        	  
        	  gpoints=4.5;
        	  Totalcredithours=combobox.get(index).getSelectedIndex()+1+Totalcredithours;
        	  qualitypoints=(combobox.get(index).getSelectedIndex()+1)*gpoints;
        	  Totalqualitypoints=qualitypoints+Totalqualitypoints;
        	  
        	  break;
          case 1:

        	  gpoints=4.0;
        	  Totalcredithours=combobox.get(index).getSelectedIndex()+1+Totalcredithours;
        	  qualitypoints=(combobox.get(index).getSelectedIndex()+1)*gpoints;
        	  Totalqualitypoints=qualitypoints+Totalqualitypoints;
        	  
        	  
        	  break;
          case 2:

        	  gpoints=3.5;
        	  Totalcredithours=combobox.get(index).getSelectedIndex()+1+Totalcredithours;
        	  qualitypoints=(combobox.get(index).getSelectedIndex()+1)*gpoints;
        	  Totalqualitypoints=qualitypoints+Totalqualitypoints;
        	  break;
          case 3:

        	  gpoints=3.0;
        	  Totalcredithours=combobox.get(index).getSelectedIndex()+1+Totalcredithours;
        	  qualitypoints=(combobox.get(index).getSelectedIndex()+1)*gpoints;
        	  Totalqualitypoints=qualitypoints+Totalqualitypoints;
        	  break;
          case 4:

        	  gpoints=2.5;
        	  Totalcredithours=combobox.get(index).getSelectedIndex()+1+Totalcredithours;
        	  qualitypoints=(combobox.get(index).getSelectedIndex()+1)*gpoints;
        	  Totalqualitypoints=qualitypoints+Totalqualitypoints;
        	  break;
          case 5:

        	  gpoints=2.0;
        	  Totalcredithours=combobox.get(index).getSelectedIndex()+1+Totalcredithours;
        	  qualitypoints=(combobox.get(index).getSelectedIndex()+1)*gpoints;
        	  Totalqualitypoints=qualitypoints+Totalqualitypoints;
        	  break;
          case 6:
        	  gpoints=1.5;
        	  Totalcredithours=combobox.get(index).getSelectedIndex()+1+Totalcredithours;
        	  qualitypoints=(combobox.get(index).getSelectedIndex()+1)*gpoints;
        	  Totalqualitypoints=qualitypoints+Totalqualitypoints;
        	  break;
          case 7:
              gpoints=1.0;
        	  Totalcredithours=combobox.get(index).getSelectedIndex()+1+Totalcredithours;
        	  qualitypoints=(combobox.get(index).getSelectedIndex()+1)*gpoints;
        	  Totalqualitypoints=qualitypoints+Totalqualitypoints;
        	  break;
          
        	
          case 8:
          
        	  gpoints=0;
        	  Totalcredithours=combobox.get(index).getSelectedIndex()+1+Totalcredithours;
        	  qualitypoints=(combobox.get(index).getSelectedIndex()+1)*gpoints;
        	  Totalqualitypoints=qualitypoints+Totalqualitypoints;
        	  break;
       }

  		repaint();
  		revalidate();
        }
        System.out.println(Totalcredithours);
        System.out.println(Totalqualitypoints);
        String H =  String.valueOf(Totalqualitypoints/Totalcredithours);
        
  		GPAtextfield.setText("" + H);
  		
  		
  		//Cumulative GPA
  		
  		//Calculation for the old GPA
  		double _inputcredithours=Double.parseDouble((String) CHETextfield.getText());
  		double _inputCurrentGpa=Double.parseDouble((String)CGPAfield.getText());
  		double _newQualitypoints=_inputCurrentGpa*_inputcredithours;
  		
  		
  		//Calculations for the cumulative GPA
  		double _Totalnewqualitypoints=_newQualitypoints+Totalqualitypoints;
  		double _Totalnewcredithours=_inputcredithours+Totalcredithours;
  		double _NewGpa=_Totalnewqualitypoints/_Totalnewcredithours;
  		cumulativetextfield.setText(""+_NewGpa);
  		System.out.println(_NewGpa);
  		
  		
  		
  		
  		
		}
		
		});
	}
}

    	  
    	  
    	  
      
	  
	  
	  
		
	
