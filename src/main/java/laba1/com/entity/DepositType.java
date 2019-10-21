package laba1.com.entity;

public class DepositType {
    private int depositTypeId;
    private String depositType;

    public DepositType() {
    }

    public DepositType(int depositTypeId, String depositType) {
        this.depositTypeId = depositTypeId;
        this.depositType = depositType;
    }

    public int getDepositTypeId() {
        return depositTypeId;
    }

    public void setDepositTypeId(int depositTypeId) {
        this.depositTypeId = depositTypeId;
    }

    public String getDepositType() {
        return depositType;
    }

    public void setDepositType(String depositType) {
        this.depositType = depositType;
    }

    @Override
    public String toString() {
        return "DepositType{" +
                "depositTypeId=" + depositTypeId +
                ", depositType='" + depositType + '\'' +
                '}';
    }
}
