package laba1.com;

public class SortDeposits {

    public static void sortDeposits(Bank bank, Deposit.Fields sortingType) {
        switch (sortingType) {
            case Percentage:
                bank.bankdeposits.sort(Deposit::compareByPercentage);
                break;
            case DepositDuration:
                bank.bankdeposits.sort(Deposit::compareByDepositDuration);
                break;
            case MinimumSum:
                bank.bankdeposits.sort(Deposit::compareByMinimumSum);
                break;
            case Cancellation:
                bank.bankdeposits.sort(Deposit::compareByCancellationAvaliability);
                break;
        }
    }

}
