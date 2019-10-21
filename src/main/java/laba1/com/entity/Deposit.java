package laba1.com.entity;

public class Deposit {
    private int id;
    private int depositTypeId;
    private String depositName;
    private int minimumSum;
    private int depositedSum;
    private int cancellation;
    private int depositDuration;
    private int bankId;

    public Deposit() {
    }

    public Deposit(int id, int depositTypeId, String depositName, int minimumSum, int depositedSum, int cancellation, int depositDuration, int bankId) {
        this.id = id;
        this.depositTypeId = depositTypeId;
        this.depositName = depositName;
        this.minimumSum = minimumSum;
        this.depositedSum = depositedSum;
        this.cancellation = cancellation;
        this.depositDuration = depositDuration;
        this.bankId = bankId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepositTypeId() {
        return depositTypeId;
    }

    public void setDepositTypeId(int depositTypeId) {
        this.depositTypeId = depositTypeId;
    }

    public String getDepositName() {
        return depositName;
    }

    public void setDepositName(String depositName) {
        this.depositName = depositName;
    }

    public int getMinimumSum() {
        return minimumSum;
    }

    public void setMinimumSum(int minimumSum) {
        this.minimumSum = minimumSum;
    }

    public int getDepositedSum() {
        return depositedSum;
    }

    public void setDepositedSum(int depositedSum) {
        this.depositedSum = depositedSum;
    }

    public int getCancellation() {
        return cancellation;
    }

    public void setCancellation(int cancellation) {
        this.cancellation = cancellation;
    }

    public int getDepositDuration() {
        return depositDuration;
    }

    public void setDepositDuration(int depositDuration) {
        this.depositDuration = depositDuration;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "id=" + id +
                ", depositTypeId=" + depositTypeId +
                ", depositName='" + depositName + '\'' +
                ", minimumSum=" + minimumSum +
                ", depositedSum=" + depositedSum +
                ", cancellation=" + cancellation +
                ", depositDuration=" + depositDuration +
                ", bankId=" + bankId +
                '}';
    }
}
