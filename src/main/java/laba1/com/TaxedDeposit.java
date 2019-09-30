package laba1.com;

public class TaxedDeposit extends Deposit {

    private int tax;

    public TaxedDeposit(String instance, int percentage, int minimumSum, int depositedSum,
                        String currency, boolean cancellation, int depositDuration, int tax) {
        super(instance, percentage, minimumSum, depositedSum, currency, cancellation, depositDuration);
        this.tax = Math.abs(tax);
    }

    public int getTax() {
        return tax;
    }

    @Override
    public void terminateDeposit(Deposit deposit, int months) {
        switch (getDepositedSum()) {
            case 0:
                System.out.println(String.format("You have 0 %s on your deposit. Please add money first.", getCurrency()));
            default:
                if (deposit.isCancellation()) {
                    int sum = deposit.getDepositedSum() + (deposit.getDepositedSum() * deposit.getPercentage() / 100 * months);
                    sum -= sum / 100 * getTax();
                    System.out.println(String.format("Your %s deposit is terminated. You have received %s %s",
                            deposit.getInstance(), sum, deposit.getCurrency()));
                } else
                    System.out.println(String.format("Can not cancel %s before the end of term!", deposit.getInstance()));
                break;
        }
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "Name = " + getInstance() +
                ", percentage = " + getPercentage() +
                ", minimum sum = " + getMinimumSum() +
                ", deposited sum = " + getDepositedSum() +
                ", currency = " + getCurrency() +
                ", cancellation = " + isCancellation() +
                ", deposit duration = " + getDepositDuration() +
                ", taxes = " + getTax() +
                '}';
    }

}
