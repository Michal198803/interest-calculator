public class Interest {

	private double futureMonthlyAddition;
	private final double depositInterestRate = 0.03;
	private final double tax = 0.19;
	private double age;
	private double ageWhenYouGoToRetirement;

	public double monthlyContribution;

	public Interest(double futureMonthlyAddition, double age, double ageWhenYouGoToRetirement) {
		this.futureMonthlyAddition = futureMonthlyAddition;

		this.age = age;
		this.ageWhenYouGoToRetirement = ageWhenYouGoToRetirement;

	}

	public double yearsOfWork() {
		double yearsOfWork = ageWhenYouGoToRetirement - age;
		return yearsOfWork;
	}

	public int toIntYearsOfWork() {

		int toIntYearsOfWork = (int) yearsOfWork();
		return toIntYearsOfWork;

	}

	public double numberToPowerReguiredAmountOfMoney() {
		double numberToPowerReguiredAmountOfMoney = 1 + (depositInterestRate * ((1 - tax) / 12));
		return numberToPowerReguiredAmountOfMoney;
	}

	public double nominativeCaseReguiredAmountOfMoneyPow() {

		double nominativeCaseReguiredAmountOfMoneyPow = Math.pow(numberToPowerReguiredAmountOfMoney(), 12);
		return nominativeCaseReguiredAmountOfMoneyPow;
	}

	public double nominativeCaseReguiredAmountOfMoney() {
		double nominativeCaseReguiredAmountOfMoney = nominativeCaseReguiredAmountOfMoneyPow() - 1;
		return nominativeCaseReguiredAmountOfMoney;
	}

	public double reguiredAmountOfMoneyToCollect() {

		double reguiredAmountOfMoneyToCollect = (12 * futureMonthlyAddition) / nominativeCaseReguiredAmountOfMoney();

		return reguiredAmountOfMoneyToCollect;
	}

	public double reguiredAmountOfMoneyToCollectToTheHundredths() {
		double reguiredAmountOfMoneyToCollectToTheHundredths = reguiredAmountOfMoneyToCollect();

		reguiredAmountOfMoneyToCollectToTheHundredths *= 100;
		reguiredAmountOfMoneyToCollectToTheHundredths = Math.round(reguiredAmountOfMoneyToCollectToTheHundredths);
		reguiredAmountOfMoneyToCollectToTheHundredths /= 100;
		return reguiredAmountOfMoneyToCollectToTheHundredths;
	}

	public String toStringReguiredAmountOfMoneyToCollect() {

		String toStringReguiredAmountOfMoneyToCollect = "After " + toIntYearsOfWork() + " yers You collect: "
				+ reguiredAmountOfMoneyToCollectToTheHundredths() + " PLN";

		return toStringReguiredAmountOfMoneyToCollect;
	}

	public double counter() {

		double counter = reguiredAmountOfMoneyToCollect() * ((depositInterestRate / 12) * (1 - tax ));

		return counter;
	}

	public double numberToPower() {

		double numberToPower = (1 + ((depositInterestRate / (12)) * (1 - tax )));
		return numberToPower;
	}

	public double nominativeCase() {
		double nominativeCase = (double) ((Math.pow(numberToPower(), yearsOfWork() * 12) - 1)
				* (1 + ((depositInterestRate / (12)) * (1 - tax ))));
		return nominativeCase;
	}

	public double monthlyContribution() {

		double monthlyContribution = counter() / nominativeCase();
		return monthlyContribution;

	}

	public double monthlyContributionToHundredths() {

		double monthlyContributionToHundredths = monthlyContribution();

		monthlyContributionToHundredths *= 100;
		monthlyContributionToHundredths = Math.round(monthlyContributionToHundredths);
		monthlyContributionToHundredths /= 100;
		return monthlyContributionToHundredths;

	}

	public String toStringMonthlyContribution() {
		String toStringMonthlyContribution = "Your monthly payment should be: " + monthlyContributionToHundredths()
				+ " PLN";
		return toStringMonthlyContribution;
	}

	public void setfutureMonthlyAddition(double futureMonthlyAddition) {
		this.futureMonthlyAddition = futureMonthlyAddition;
	}

	public void setage(double age) {
		this.age = age;
	}

	public void setageWhenYouGoToRetirement(double ageWhenYouGoToRetirement) {
		this.ageWhenYouGoToRetirement = ageWhenYouGoToRetirement;
	}

	public static void main(String[] args) {

		Interest calculation = new Interest(3000, 25, 65);
		calculation.monthlyContribution();
		System.out.println(calculation.toStringMonthlyContribution());

		System.out.println(calculation.toStringReguiredAmountOfMoneyToCollect());

	}

}
