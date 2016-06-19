import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
	

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
			operator[i].addActionListener(this);
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
			button[i].addActionListener(this);
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
	public String cal() {
		
		String result = "";
		if(operator.equals("+")) {
			operand1 += operand2;
			result = operand1 + "";
		} else if(operator == "-") {
			operand1 -= operand2;
			result = operand1 + "";
		} else if(operator == "*") {
			operand1 *= operand2;
			result = operand1 + "";
		} else if(operator == "/") {
			if (operand2 != 0) {
				operand1 /= operand2;
				result = operand1 + "";
			} else {
				result = "NaN";
			}
		}
		
		if (result.endsWith(".0")) {
			result = result.substring(0, result.length()-2);
		}
		return result;
	}
	
	public void cal(String op) {
		
		if (text.getText().equals("") || text.getText() == null)
			return;
		
		if (operator.equals("")) {
		
			operand1 = Double.parseDouble(text.getText());
			operator = op;
			text.setText("");
		} else {
		
			operand2 = Double.parseDouble(text.getText());
			text.setText(cal());
			operator = op;
			mode = true;
		}
	}
	
	public void actionPerformed(ActionEvent ae) {
		String cmd = ae.getActionCommand();
		if(cmd.equals("+") || cmd.equals("-") || cmd.equals("*") || cmd.equals("/")) {
			cal(cmd);
		} else if (cmd.equals("=")) {
			if (operator.equals(""))
				return;
			operand2 = Double.parseDouble(text.getText());			
			text.setText(cal());

			operand1 = 0;
			operand2 = 0;
			operator = "";			
			mode = true;
		} else if (cmd.equals("C")) {
			operand1 = 0;
			operand2 = 0;
			operator = "";
			text.setText("0");
		} else {
			if (mode == true) {
				mode = false;
				text.setText(cmd);
			} else  {
				if (text.getText().equals("0")) {
					text.setText(cmd);
				} else {
					text.setText(text.getText() + cmd);
				}
			}
		}
	}
}
	
	
