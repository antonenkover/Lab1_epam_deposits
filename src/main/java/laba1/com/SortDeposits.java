package laba1.com;

import org.apache.log4j.Logger;

public class SortDeposits {

    private static final Logger LOG = Logger.getLogger(SortDeposits.class);

    public static void sortDeposits(Bank bank, Deposit.Fields sortingType) {
        switch (sortingType) {
            case Percentage:
                bank.bankdeposits.sort(Deposit::compareByPercentage);
                LOG.info(String.format("SortDeposits of %s by %s", bank.getName(), sortingType));
                break;
            case DepositDuration:
                bank.bankdeposits.sort(Deposit::compareByDepositDuration);
                LOG.info(String.format("SortDeposits of %s by %s", bank.getName(), sortingType));
                break;
            case MinimumSum:
                bank.bankdeposits.sort(Deposit::compareByMinimumSum);
                LOG.info(String.format("SortDeposits of %s by %s", bank.getName(), sortingType));
                break;
            case Cancellation:
                bank.bankdeposits.sort(Deposit::compareByCancellationAvaliability);
                LOG.info(String.format("SortDeposits of %s by %s", bank.getName(), sortingType));
                break;
        }
    }

}
