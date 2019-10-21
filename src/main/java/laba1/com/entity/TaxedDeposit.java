package laba1.com.entity;

public class TaxedDeposit {
    private int id;
    private int depositTypeId;
    private int tax;

    public TaxedDeposit() {
    }

    public TaxedDeposit(int id, int depositTypeId, int tax) {
        this.id = id;
        this.depositTypeId = depositTypeId;
        this.tax = tax;
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

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return "TaxedDeposit{" +
                "id=" + id +
                ", depositTypeId=" + depositTypeId +
                ", tax=" + tax +
                '}';
    }
}
