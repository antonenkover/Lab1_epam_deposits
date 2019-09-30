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

    public int getNumOfDeposits() {
        return numOfDeposits;
    }

    public void addDeposit(Deposit deposit) {
        if (!bankdeposits.contains(deposit))
            bankdeposits.add(deposit);
    }

    public void getDeposits() {
        int i = 1;
        for (Deposit bankdeposit : bankdeposits) {
            System.out.println(i + "). " + bankdeposit);
            i++;
        }
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
