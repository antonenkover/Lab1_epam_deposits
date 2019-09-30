package laba1.com;

public abstract class Deposit {

    private String instance;
    private int percentage;
    private int minimumSum;
    private int depositedSum;
    private boolean cancellation;
    private String currency;
    private int depositDuration;

    public Deposit(String instance, int percentage, int minimumSum, int depositedSum,
                   String currency, boolean cancellation, int depositDuration) {
        this.instance = instance;
        this.percentage = percentage;
        this.minimumSum = minimumSum;
        this.depositedSum = depositedSum;
        this.currency = currency;
        this.cancellation = cancellation;
        this.depositDuration = depositDuration;
    }

    public String getInstance() {
        return instance;
    }

    public int getMinimumSum() {
        return minimumSum;
    }

    public int getDepositedSum() {
        return depositedSum;
    }

    public void setDepositedSum(int depositedSum) {
        this.depositedSum = Math.abs(depositedSum);
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = Math.abs(percentage);
    }

    public boolean isCancellation() {
        return cancellation;
    }

    public String getCurrency() {
        return currency;
    }

    public int getDepositDuration() {
        return depositDuration;
    }

    public int compareByPercentage(Deposit deposit) {
        int percent1 = this.percentage;
        int percent2 = deposit.getPercentage();
        if (percent1 == percent2) return 0;
        return percent1 > percent2 ? 1 : -1;
    }

    public int compareByMinimumSum(Deposit deposit) {
        int sum1 = this.minimumSum;
        int sum2 = deposit.getMinimumSum();
        if (sum1 == sum2) return 0;
        return sum1 > sum2 ? 1 : -1;
    }

    public int compareByCancellationAvaliability(Deposit deposit) {
        boolean cancel1 = this.cancellation;
        boolean cancel2 = deposit.isCancellation();
        if (cancel1 == cancel2) return 0;
        else if (cancel1 == false && cancel2 == true) return 1;
        else return -1;
    }

    public int compareByDepositDuration(Deposit deposit) {
        int duration1 = this.depositDuration;
        int duration2 = deposit.getDepositDuration();
        if (duration1 == duration2) return 0;
        return duration1 > duration2 ? 1 : -1;
    }

    public void terminateDeposit(Deposit deposit, int months) {
        switch (getDepositedSum()) {
            case 0:
                System.out.println(String.format("You have 0 %s on your deposit. Please add money first.", getCurrency()));
                break;
            default:
                if (deposit.isCancellation() || months >= deposit.getDepositDuration()) {
                    if (months > getDepositDuration()) months = getDepositDuration();
                    int sum = deposit.getDepositedSum() + deposit.getDepositedSum() * deposit.getPercentage() / 100 * months;
                    System.out.println(String.format("Your %s deposit is terminated. You have received %s %s",
                            deposit.getInstance(), sum, deposit.getCurrency()));
                    setDepositedSum(0);
                } else
                    System.out.println(String.format("Can not cancel %s before the end of contract!", deposit.getInstance()));
                break;
        }
    }

    public void takeAdditionalSum(Deposit deposit, int month) {
        int sum = 0;
        if (getDepositedSum() == 0) {
            System.out.println(String.format("You have 0 %s on your deposit. Please add money first.", getCurrency()));
        } else {
            sum = getDepositedSum() / 100 * getPercentage() * month;
        }
        System.out.println(String.format("You have received %s %s", sum, getCurrency()));
    }

    public void addingFundsToDeposit(Deposit deposit, int addFunds) {
        if (deposit.getDepositedSum() == 0 && addFunds < deposit.getMinimumSum())
            System.out.println("You can't add less than minimum sum!");
        else {
            int funds = deposit.getDepositedSum() + addFunds;
            deposit.setDepositedSum(funds);
        }
        System.out.println(String.format("You have added %s%s to %s deposit", deposit.getDepositedSum(),
                deposit.getCurrency(), deposit.getInstance()));
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "Name = " + getInstance() +
                ", percentage = " + getPercentage() +
                ", minimum sum = " + getMinimumSum() +
                ", deposited sum = " + getDepositedSum() +
                ", currency = " + getCurrency() +
                ", cancellation avaliability = " + isCancellation() +
                ", deposit duration = " + getDepositDuration() +
                '}';
    }

    public enum Fields {Percentage, MinimumSum, Cancellation, DepositDuration}

}
