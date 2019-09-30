package laba1.com;

public class FrequencyStrictDeposit extends Deposit {

    private int frequency;

    public FrequencyStrictDeposit(String instance, int percentage, int minimumSum, int depositedSum, String currency,
                                  boolean cancellation, int depositDuration, int frequency) {
        super(instance, percentage, minimumSum, depositedSum, currency, cancellation, depositDuration);
        this.frequency = frequency;
    }

    public int getFrequency() {
        return frequency;
    }

    @Override
    public void takeAdditionalSum(Deposit deposit, int month) {
        switch (getDepositedSum()) {
            case 0:
                System.out.println(String.format("You have 0 %s on your deposit. Please add money first.", getCurrency()));
                break;
            default:
                if (month % getFrequency() != 0) {
                    month = month / getFrequency();
                    int sum = getDepositedSum() / 100 * getPercentage() * month;
                    System.out.println(String.format("You can't withdraw money this month. You have received %s %s for %s months",
                            sum, deposit.getCurrency(), month));
                } else {
                    int sum = getDepositedSum() / 100 * getPercentage() * month;
                    System.out.println(String.format("You have received %s %s", sum, getCurrency()));
                }
                break;
        }
    }

    @Override
    public String toString() {
        return "Frequency Strict Deposit{" +
                "Name = " + getInstance() +
                ", percentage = " + getPercentage() +
                ", minimum sum = " + getMinimumSum() +
                ", deposited sum = " + getDepositedSum() +
                ", currency = " + getCurrency() +
                ", cancellation avaliability = " + isCancellation() +
                ", deposit duration = " + getDepositDuration() +
                ", frequency of withdrawal (once per x months) = " + getFrequency() +
                '}';
    }

}
