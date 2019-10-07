package laba1.com;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class SearchDeposits {
    private static final Logger LOG = Logger.getLogger(SearchDeposits.class);

    public static void search(List<Deposit> deposits, Deposit.Fields searchType, int from, int to) {
        LOG.info("Deposits list for search: " + deposits.toString());
        List<Deposit> searchedList = new ArrayList<>();
        switch (searchType) {
            case Percentage:
                searchByPercentage(deposits, from, to, searchedList);
                LOG.info("Chosen search parameter: " + searchType);
                break;
            case MinimumSum:
                searchByMinumumSum(deposits, from, to, searchedList);
                LOG.info("Chosen search parameter: " + searchType);
                break;
            case DepositDuration:
                searchByDepositDuration(deposits, from, to, searchedList);
                LOG.info("Chosen search parameter: " + searchType);
                break;
        }
    }

    public static void searchByDepositDuration(List<Deposit> deposits, int from, int to, List<Deposit> searchedList) {
        for (Deposit deposit : deposits) {
            if (deposit.getDepositDuration() >= from && deposit.getDepositDuration() <= to)
                searchedList.add(deposit);
        }
        searchedList.forEach(System.out::println);
        LOG.info(String.format("Searched list by Deposit duration: from %s to %s", from, to) + searchedList.toString());
        if (searchedList.isEmpty())
            System.out.println("Deposit was not found\n");
    }

    public static void searchByMinumumSum(List<Deposit> deposits, int from, int to, List<Deposit> searchedList) {
        for (Deposit deposit : deposits) {
            if (deposit.getMinimumSum() >= from && deposit.getMinimumSum() <= to)
                searchedList.add(deposit);
        }
        searchedList.forEach(System.out::println);
        LOG.info(String.format("Searched list by Minimum Sum: from %s to %s", from, to) + searchedList.toString());
        if (searchedList.isEmpty())
            System.out.println("Deposit was not found\n");
    }

    public static void searchByPercentage(List<Deposit> deposits, int from, int to, List<Deposit> searchedList) {
        for (Deposit deposit : deposits) {
            if (deposit.getPercentage() >= from && deposit.getPercentage() <= to)
                searchedList.add(deposit);
        }
        searchedList.forEach(System.out::println);
        LOG.info(String.format("Searched list by Percentage: from %s to %s", from, to) + searchedList.toString());
        if (searchedList.isEmpty())
            System.out.println("Deposit was not found\n");
    }
}
