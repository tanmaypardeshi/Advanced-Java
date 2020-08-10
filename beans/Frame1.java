// an eg of Main Frame
import java.awt.*;
import java.awt.event.*;

class Frame1 extends Frame implements ActionListener
{
	Button btnnext;

	public static void main(String args[ ])
	{
		new Frame1();
	}

	Frame1()
	{
		setBounds(400,250,500,500);
		setLayout(new FlowLayout());

		btnnext = new Button("Go To Next Frame");
		
		add(btnnext);
		
		btnnext.addActionListener(this);
		
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae)
	{
		dispose();
		new Frame2();
	}
}
	











