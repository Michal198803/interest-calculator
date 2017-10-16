
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InterestWindow extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel YourAge, AgeOfRetirement, YourPlannedAddition, Tax, DepositInterestRate, ShowWynik, ShowWynik2;
	JTextField SetYourAge, SetAgeOfRetirement, SetYourPlannedAddition, SetTax, SetDepositInterestRate;
	JButton Calculate;

	public InterestWindow() {
		setSize(500, 330);
		setTitle("Pension supplement calculator");
		setLayout(null);

		YourPlannedAddition = new JLabel("Set your planned addition in [PLN]: ");
		YourPlannedAddition.setBounds(20, 100, 200, 20);
		setLayout(null);
		add(YourPlannedAddition);

		SetYourPlannedAddition = new JTextField("");
		SetYourPlannedAddition.setBounds(240, 100, 60, 20);
		setLayout(null);
		add(SetYourPlannedAddition);

	

		YourAge = new JLabel("Set your current age: ");
		YourAge.setBounds(20, 20, 150, 20);
		setLayout(null);
		add(YourAge);

		SetYourAge = new JTextField("");
		SetYourAge.setBounds(240, 20, 60, 20);
		setLayout(null);
		add(SetYourAge);

		AgeOfRetirement = new JLabel("Set your retirement age: ");
		AgeOfRetirement.setBounds(20, 60, 150, 20);
		setLayout(null);
		add(AgeOfRetirement);

		SetAgeOfRetirement = new JTextField("");
		SetAgeOfRetirement.setBounds(240, 60, 60, 20);
		setLayout(null);
		add(SetAgeOfRetirement);

		Calculate = new JButton("Calculate");
		Calculate.setBounds(325, 20, 100, 20);
		add(Calculate);
		Calculate.addActionListener(this);

		ShowWynik = new JLabel("You should monthly pay: ");
		ShowWynik.setBounds(20, 160, 350, 50);
		setLayout(null);
		add(ShowWynik);

		ShowWynik2 = new JLabel("Amount collected: ");
		ShowWynik2.setBounds(20, 140, 350, 50);
		setLayout(null);
		add(ShowWynik2);
	}

	public static void main(String[] args) {

		InterestWindow windowObj = new InterestWindow();
		windowObj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowObj.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		double futureMonthlyAddition = Double.parseDouble(SetYourPlannedAddition.getText());
	
		double age = Double.parseDouble(SetYourAge.getText());

		double ageWhenYouGoToRetirement = Double.parseDouble(SetAgeOfRetirement.getText());

		Interest calculation = new Interest(futureMonthlyAddition, age,
				ageWhenYouGoToRetirement);
		String monthlyContribution = calculation.toStringMonthlyContribution();
		ShowWynik.setText(monthlyContribution);
		String reguiredAmountOfMoneyToCollect = calculation.toStringReguiredAmountOfMoneyToCollect();
		ShowWynik2.setText(reguiredAmountOfMoneyToCollect);

	}

}
