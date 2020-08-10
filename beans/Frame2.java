// an eg of Next Frame
import java.awt.*;
import java.awt.event.*;

class Frame2 extends Frame implements ActionListener
{
	Button btnexit;

	// v. imp. no main(), can be called only from main frame i.e. Frame1 only

	Frame2()
	{
		setBounds(400,250,500,500);
		setLayout(new FlowLayout());

		btnexit = new Button("Terminate Application");

		add(btnexit);

		btnexit.addActionListener(this);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae)
	{
		System.exit(0);
	}
}
	











