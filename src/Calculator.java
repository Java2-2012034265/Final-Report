import java.awt.*;
import javax.swing.*;

public class Calculator extends JFrame {
	

	public JTextField text;
	public double operand1= 0;
	public double operand2 = 0;
	public String operator = "";
	public boolean mode = false;
	
	public Calculator() {
		setTitle("Cal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		makeLayout();
	}
	
	public void makeLayout() {
		JPanel panel = new JPanel();
		text = new JTextField("0", 33);		
		text.setHorizontalAlignment(JTextField.RIGHT);
		
		panel.add(text);
		add(panel, "North");
		Dimension d = new Dimension(70, 50);		
		
	
		JButton operator[] = new JButton[10];		
		operator[0] = new JButton("+");		
		operator[1] = new JButton("-");
		operator[2] = new JButton("*");
		operator[3] = new JButton("/");
		operator[4] = new JButton("=");
		operator[5] = new JButton("C");		
		operator[6] = new JButton("root");	
		operator[7] = new JButton("x^");	
		operator[8] = new JButton("?");	
		operator[9] = new JButton("?");	
		
		for (int i = 0; i < 10; i++) {
			operator[i].setPreferredSize(d);
		}
		
		JPanel[] p = new JPanel[4];
		for (int i = 0; i < 4; i++) {			
			p[i] = new JPanel();
			p[i].setLayout(new FlowLayout());
			p[i].setAlignmentX(JPanel.LEFT_ALIGNMENT);
		}
		
		JButton[] button = new JButton[10];
		for (int i = 0; i < 10; i++) {
			button[i] = new JButton(i+"");
			button[i].setPreferredSize(d);
		}
		
		p[0].add(button[7]);
		p[0].add(button[8]);
		p[0].add(button[9]);
		p[0].add(operator[0]);
		p[0].add(operator[6]);
		
		p[1].add(button[4]);
		p[1].add(button[5]);
		p[1].add(button[6]);
		p[1].add(operator[1]);
		p[1].add(operator[7]);
		
		p[2].add(button[1]);
		p[2].add(button[2]);
		p[2].add(button[3]);
		p[2].add(operator[2]);
		p[2].add(operator[8]);
		
		
		p[3].add(operator[5]);
		p[3].add(button[0]);
		p[3].add(operator[4]);
		p[3].add(operator[3]);
		p[3].add(operator[9]);
		

		
		JPanel pad = new JPanel();
		pad.setLayout(new BoxLayout(pad, BoxLayout.Y_AXIS));
		
		for (int i = 0; i < 4;  i++)
			pad.add(p[i]);
		
		add(pad, BorderLayout.CENTER);
        pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Calculator();
	}
}
	
	
