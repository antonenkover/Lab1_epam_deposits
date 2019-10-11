package laba1.com;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    String name;
    int numOfDeposits;
    List<Deposit> bankdeposits;

    public Bank(String name, int numOfDeposits) {
        this.name = name;
        this.numOfDeposits = numOfDeposits;
        this.bankdeposits = new ArrayList<>();
    }

    public String getName() {
        return name;
    }


    public void setNumOfDeposits(int numOfDeposits) {
        this.numOfDeposits = numOfDeposits;
    }

    public void addDeposit(Deposit deposit) {
        if (!bankdeposits.contains(deposit))
            bankdeposits.add(deposit);
        setNumOfDeposits(bankdeposits.size());
    }

    public void getDeposits() {
        bankdeposits.forEach(deposit -> System.out.println(bankdeposits.indexOf(deposit) + 1 + ". "+ deposit));
    }

    public void addMoneyToDeposit(int num, int money) {
        bankdeposits.get(num).addingFundsToDeposit(bankdeposits.get(num), money);
    }


    public void takeAllMoneyfromDeposit(int num, int months) {
        bankdeposits.get(num).terminateDeposit(bankdeposits.get(num), months);
    }

    public void takeMoneyPerMonth(int num, int month) {
        bankdeposits.get(num).takeAdditionalSum(bankdeposits.get(num), month);
    }


    public void getDepositByNum(int num) {
        System.out.println(bankdeposits.get(num));
    }


}
