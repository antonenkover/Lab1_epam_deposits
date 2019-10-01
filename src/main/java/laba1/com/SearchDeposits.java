package laba1.com;

import java.util.ArrayList;
import java.util.List;

public class SearchDeposits {
    public static void search(List<Deposit> deposits, Deposit.Fields searchType, int from, int to) {
        List<Deposit> searchedList = new ArrayList<>();
        switch (searchType) {
            case Percentage:
                searchByPercentage(deposits, from, to, searchedList);
                break;
            case MinimumSum:
                searchByMinumumSum(deposits, from, to, searchedList);
                break;
            case DepositDuration:
                searchByDepositDuration(deposits, from, to, searchedList);
                break;
        }
    }

    public static void searchByDepositDuration(List<Deposit> deposits, int from, int to, List<Deposit> searchedList) {
        for (Deposit deposit : deposits) {
            if (deposit.getDepositDuration() >= from && deposit.getDepositDuration() <= to)
                searchedList.add(deposit);
        }
        searchedList.forEach(System.out::println);
        if (searchedList.isEmpty())
            System.out.println("Deposit was not found\n");
    }

    public static void searchByMinumumSum(List<Deposit> deposits, int from, int to, List<Deposit> searchedList) {
        for (Deposit deposit : deposits) {
            if (deposit.getMinimumSum() >= from && deposit.getMinimumSum() <= to)
                searchedList.add(deposit);
        }
        searchedList.forEach(System.out::println);
        if (searchedList.isEmpty())
            System.out.println("Deposit was not found\n");
    }

    public static void searchByPercentage(List<Deposit> deposits, int from, int to, List<Deposit> searchedList) {
        for (Deposit deposit : deposits) {
            if (deposit.getPercentage() >= from && deposit.getPercentage() <= to)
                searchedList.add(deposit);
        }
        searchedList.forEach(System.out::println);
        if (searchedList.isEmpty())
            System.out.println("Deposit was not found\n");
    }
}
