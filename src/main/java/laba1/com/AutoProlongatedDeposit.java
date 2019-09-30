package laba1.com;

public class AutoProlongatedDeposit extends Deposit {

    private boolean prolongate;

    public AutoProlongatedDeposit(String instance, int percentage, int minimumSum, int depositedSum,
                                  String currency, boolean cancellation, int depositDuration, boolean prolongate) {
        super(instance, percentage, minimumSum, depositedSum, currency, cancellation, depositDuration);
        this.prolongate = prolongate;
    }

    public boolean isProlongate() {
        return prolongate;
    }

    public void takeAdditionalSum(Deposit deposit, int month) {
        switch (getDepositedSum()) {
            case 0:
                System.out.println(String.format("You have 0 %s on your deposit. Please add money first.", getCurrency()));
                break;
            default:
                int monthDiffer = 0;
                if (month > getDepositDuration()) {
                    monthDiffer = (month - getDepositDuration()) / 12;
                    if (monthDiffer == 0) monthDiffer += 1;
                    setPercentage(getPercentage() + monthDiffer);
                    System.out.println(String.format("Your new percentage per month would be: %s", getPercentage()));
                }
                int sum = getDepositedSum() / 100 * getPercentage() * month;
                System.out.println(String.format("You have received %s %s.", sum, getCurrency()));
                break;
        }
    }

    @Override
    public String toString() {
        return "Auto Prolongated Deposit{" +
                "Title = " + getInstance() +
                ", percentage = " + getPercentage() +
                ", minimum sum = " + getMinimumSum() +
                ", deposited sum = " + getDepositedSum() +
                ", currency = " + getCurrency() +
                ", cancellation avaliability = " + isCancellation() +
                ", deposit duration = " + getDepositDuration() +
                ", auto prolongate deposit = " + isProlongate() +
                '}';
    }
}
