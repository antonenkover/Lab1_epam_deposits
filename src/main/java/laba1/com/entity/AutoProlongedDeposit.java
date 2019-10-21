package laba1.com.entity;

public class AutoProlongedDeposit {
    private int id;
    private int depositTypeId;
    private int autoProlongate;

    public AutoProlongedDeposit() {
    }

    public AutoProlongedDeposit(int id, int depositTypeId, int autoProlongate) {
        this.id = id;
        this.depositTypeId = depositTypeId;
        this.autoProlongate = autoProlongate;
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

    public int getAutoProlongate() {
        return autoProlongate;
    }

    public void setAutoProlongate(int autoProlongate) {
        this.autoProlongate = autoProlongate;
    }

    @Override
    public String toString() {
        return "AutoProlongedDeposit{" +
                "id=" + id +
                ", depositTypeId=" + depositTypeId +
                ", autoProlongate=" + autoProlongate +
                '}';
    }
}
