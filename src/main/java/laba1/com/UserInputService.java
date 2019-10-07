package laba1.com;

import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserInputService {

    private static final Logger LOG = Logger.getLogger(UserInputService.class);

    public void main(Bank bank1, Bank bank2, Bank bank3) {
        chooseBank(bank1, bank2, bank3);
    }

    public void sort(Bank bank) {
        while (true) {
            System.out.printf("\nSort by:\n1. %s\n2. %s\n3. %s\n4. %s\n5. Exit\n",
                    Deposit.Fields.Percentage,
                    Deposit.Fields.MinimumSum,
                    Deposit.Fields.Cancellation,
                    Deposit.Fields.DepositDuration);

            Deposit.Fields depositField = Deposit.Fields.Percentage;
            try {
                switch (new Scanner(System.in).nextInt()) {
                    case 1:
                        depositField = Deposit.Fields.Percentage;
                        LOG.info("Sorting field = " + depositField);
                        break;
                    case 2:
                        depositField = Deposit.Fields.MinimumSum;
                        LOG.info("Sorting field = " + depositField);
                        break;
                    case 3:
                        depositField = Deposit.Fields.Cancellation;
                        LOG.info("Sorting field = " + depositField);
                        break;
                    case 4:
                        depositField = Deposit.Fields.DepositDuration;
                        LOG.info("Sorting field = " + depositField);
                        break;
                    case 5:
                        LOG.info("Action chosen: Exit");
                        return;
                    default:
                        System.out.println("Invalid input. Please try again.\n");
                        LOG.error("Invalid input. Please try again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please try again.\n");
                LOG.error("Invalid input. Please try again.");
            }
            SortDeposits.sortDeposits(bank, depositField);
            bank.bankdeposits.forEach(System.out::println);
        }
    }

    public void searchDeposit(Bank bank, Deposit.Fields searchType) {
        System.out.println("\nEnter the interval values for search(eg. 10-15). Values must be positive");
        try {
            String input = new Scanner(System.in).nextLine();
            List<Integer> ints = Arrays.stream(input.split("-"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            try {
                int from = ints.get(0);
                int to = ints.get(1);
                SearchDeposits.search(bank.bankdeposits, searchType, from, to);
                LOG.info(String.format("Search field: " + searchType + ". Interval: %s - %s", from, to));
            } catch (java.lang.IndexOutOfBoundsException e) {
                System.out.println("Invalid input. Please try again.");
                LOG.error("Invalid input. Please try again.");
            }
        } catch (java.lang.NumberFormatException e) {
            System.out.println("Invalid input. Please try again.\n");
            LOG.error("Invalid input. Please try again.");
        }
    }

    public void chooseSearchType(Bank bank) {
        while (true) {
            System.out.printf("\nSearch by:\n1. %s\n2. %s\n3. %s\n4. Exit\n",
                    Deposit.Fields.Percentage,
                    Deposit.Fields.MinimumSum,
                    Deposit.Fields.DepositDuration);
            try {
                switch (new Scanner(System.in).nextInt()) {
                    case 1:
                        searchDeposit(bank, Deposit.Fields.Percentage);
                        break;
                    case 2:
                        searchDeposit(bank, Deposit.Fields.MinimumSum);
                        break;
                    case 3:
                        searchDeposit(bank, Deposit.Fields.DepositDuration);
                        break;
                    case 4:
                        LOG.info("Action chosen: Exit");
                        return;
                    default:
                        System.out.println("Invalid input. Please try again.\n");
                        LOG.error("Invalid input. Please try again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please try again.\n");
                LOG.error("Invalid input. Please try again.");
            }
        }
    }

    private void manipulateBank(Bank bank) {
        while (true) {
            System.out.println("\nSort deposits:\n1. Sort\n2. Exit\n");
            try {
                switch (new Scanner(System.in).nextInt()) {
                    case 1:
                        sort(bank);
                        break;
                    case 2:
                        LOG.info("Action chosen: Exit");
                        return;
                    default:
                        System.out.println("Invalid input. Please try again.\n");
                        LOG.error("Invalid input. Please try again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please try again.\n");
                LOG.error("Invalid input. Please try again.");
            }
        }

    }

    public void chooseDeposits(Bank bank) {
        while (true) {
            System.out.println(String.format("\nChoose actions with %s deposits:\n1. Show\n2. Search\n3. Sort\n4. Work with money\n5. Exit\n", bank.getName()));
            try {
                switch (new Scanner(System.in).nextInt()) {
                    case 1:
                        showDeposit(bank);
                        LOG.info("Action chosen: Show");
                        break;
                    case 2:
                        chooseSearchType(bank);
                        LOG.info("Action chosen: Search");
                        break;
                    case 3:
                        manipulateBank(bank);
                        LOG.info("Action chosen: Sort");
                        break;
                    case 4:
                        moneyOperations(bank);
                        LOG.info("Action chosen: Work with money");
                    case 5:
                        LOG.info("Action chosen: Exit");
                        return;
                    default:
                        System.out.println("Invalid input. Please try again.\n");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please try again.\n");
            }
        }
    }

    public void chooseBank(Bank bank1, Bank bank2, Bank bank3) {
        while (true) {
            System.out.println("\nChoose a bank:\n1. Monobank\n2. PrivatBank\n3. AlphaBank\n4. Exit\n");
            try {
                switch (new Scanner(System.in).nextInt()) {
                    case 1:
                        chooseDeposits(bank1);
                        LOG.info("Bank chosen: " + bank1.getName());
                        break;
                    case 2:
                        chooseDeposits(bank2);
                        LOG.info("Bank chosen: " + bank2.getName());
                        break;
                    case 3:
                        chooseDeposits(bank3);
                        LOG.info("Bank chosen: " + bank3.getName());
                        break;
                    case 4:
                        LOG.info("Action chosen: Exit");
                        return;
                    default:
                        System.out.println("Invalid input. Please try again.\n");
                        LOG.error("Invalid input. Please try again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please try again.\n");
                LOG.error("Invalid input. Please try again.");
            }
        }
    }

    public void showDeposit(Bank bank) {
        bank.getDeposits();
        LOG.info("Show deposits of " + bank.getName());
        return;
    }

    public void addFunds(Bank bank, int num) {
        System.out.println("\nHow much money do you want to add to this deposit?");
        try {
            int money = new Scanner(System.in).nextInt();
            bank.addMoneyToDeposit(num, money);
            LOG.info(String.format("Adding %s to deposit num %s", money, num));
            System.out.println("\n");
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please try again.\n");
            LOG.error("Invalid input. Please try again.");
        }
        workWithFunds(bank, num);
    }

    public void terminateDeposit(Bank bank, int num) {
        System.out.println("\nAfter how many months you want to terminate your account?");
        try {
            int month = new Scanner(System.in).nextInt();
            bank.takeAllMoneyfromDeposit(num, month);
            LOG.info(String.format("Terminating deposit num %s after %s months", num, month));
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please try again.\n");
            LOG.error("Invalid input. Please try again.");
        }
        workWithFunds(bank, num);
    }

    public void takeMoneyAtCertainMonths(Bank bank, int num) {
        System.out.println("\nEnter the number of month at which you'll be withdrawing costs");
        try {
            int month = new Scanner(System.in).nextInt();
            bank.takeMoneyPerMonth(num, month);
            LOG.info(String.format("Take money from deposit num %s after %s months", num, month));
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please try again.\n");
            LOG.error("Invalid input. Please try again.");
        }
        workWithFunds(bank, num);
    }

    public void workWithFunds(Bank bank, int num) {
        while (true) {
            bank.getDepositByNum(num);
            System.out.println("\nChoose your actions:\n1. Add funds\n2. Terminate Deposit\n3. Calculate withdrawal costs\n4. Exit\n");
            try {
                switch (new Scanner(System.in).nextInt()) {
                    case 1:
                        addFunds(bank, num);
                        LOG.info("Action chosen: Add Funds");
                        return;
                    case 2:
                        terminateDeposit(bank, num);
                        LOG.info("Action chosen: Terminate Deposit");
                        return;
                    case 3:
                        takeMoneyAtCertainMonths(bank, num);
                        LOG.info("Action chosen: Calculate withdrawal costs");
                        return;
                    case 4:
                        LOG.info("Action chosen: Exit");
                        return;
                    default:
                        System.out.println("Invalid input. Please try again.\n");
                        LOG.error("Invalid input. Please try again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please try again.\n");
            }
        }
    }

    public void moneyOperations(Bank bank) {
        while (true) {
            bank.getDeposits();
            int num = 0;
            System.out.println("\nChoose deposit number to work with:\n1. Enter deposit number\n2. Exit\n");
            try {
                switch (new Scanner(System.in).nextInt()) {
                    case 1:
                        System.out.println("Enter deposit number:");
                        try {
                            num = new Scanner(System.in).nextInt();
                            workWithFunds(bank, num - 1);
                            LOG.info("Chosen deposit num to work with: " + --num);
                        } catch (java.lang.IndexOutOfBoundsException e) {
                            System.out.println("Enter a valid number.");
                            LOG.error("Enter a valid number.");
                        }
                        break;
                    case 2:
                        LOG.info("Action chosen: Exit");
                        return;
                    default:
                        System.out.println("Invalid input. Please try again.\n");
                        LOG.error("Invalid input. Please try again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please try again.\n");
                LOG.error("Invalid input. Please try again.");
            }

        }

    }
}
