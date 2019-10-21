package laba1.com.entity;

public class FrequencyStrictDeposit {
    private int id;
    private int depositTypeId;
    private int frequency;

    public FrequencyStrictDeposit() {
    }

    public FrequencyStrictDeposit(int id, int depositTypeId, int frequency) {
        this.id = id;
        this.depositTypeId = depositTypeId;
        this.frequency = frequency;
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

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "FrequencyStrictDeposit{" +
                "id=" + id +
                ", depositTypeId=" + depositTypeId +
                ", frequency=" + frequency +
                '}';
    }
}
