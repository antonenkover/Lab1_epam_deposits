package laba1.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.apache.log4j.Logger;

@SpringBootApplication
public class MainPanel implements CommandLineRunner {

    private static final Logger LOG = Logger.getLogger(MainPanel.class);

    public static void main(String[] args) {
        LOG.info("Starting application");
        SpringApplication.run(MainPanel.class, args);
        LOG.info("Application finished");
    }

    @Override
    public void run(String... args) throws Exception {

        UserInputService userInputService = new UserInputService();

        Bank monoBank = new Bank("Monobank", 6);

        monoBank.addDeposit(new TaxedDeposit("StandartMB", 12, 100, 0, "$", true, 16, 9));
        monoBank.addDeposit(new TaxedDeposit("LowTaxMB", 11, 1000, 0, "$", false, 10, 5));
        monoBank.addDeposit(new FrequencyStrictDeposit("Strict2MB", 13, -100, 0, "$", false, 6, 2));
        monoBank.addDeposit(new FrequencyStrictDeposit("Strict4MB", 6, -300, 0, "$", true, 28, 4));
        monoBank.addDeposit(new AutoProlongatedDeposit("NiceDepositMB", 6, 100, 0, "$", true, 12, true));
        monoBank.addDeposit(new AutoProlongatedDeposit("CoolDepositMB", 8, 10, 0, "$", true, 17, true));


        Bank privatBank = new Bank("PrivatBank", 6);

        privatBank.addDeposit(new TaxedDeposit("StandartPB", 10, 10, 0, "$", true, 11, 8));
        privatBank.addDeposit(new TaxedDeposit("LowTaxPB", 9, 10000, 0, "$", false, 2, 1));
        privatBank.addDeposit(new FrequencyStrictDeposit("Strict9PB", 17, -1000, 0, "$", false, 36, 9));
        privatBank.addDeposit(new FrequencyStrictDeposit("Strict5PB", 8, -1700, 0, "$", true, 15, 5));
        privatBank.addDeposit(new AutoProlongatedDeposit("NiceDepositPB", 12, 500, 0, "$", true, 26, true));
        privatBank.addDeposit(new AutoProlongatedDeposit("CoolDepositPB", 10, 600, 0, "$", false, 9, false));


        Bank alphaBank = new Bank("AlphaBank", 6);


        alphaBank.addDeposit(new TaxedDeposit("StandartAB", 8, 100000, 0, "$", true, 46, 4));
        alphaBank.addDeposit(new TaxedDeposit("LowTaxAB", 5, 100000, 0, "$", true, 13, 7));
        alphaBank.addDeposit(new FrequencyStrictDeposit("Strict3AB", 3, -10, 0, "$", true, 12, 3));
        alphaBank.addDeposit(new FrequencyStrictDeposit("Strict4AB", 14, -400, 0, "$", false, 9, 4));
        alphaBank.addDeposit(new AutoProlongatedDeposit("NiceDepositAB", 11, 800, 0, "$", true, 8, true));
        alphaBank.addDeposit(new AutoProlongatedDeposit("CoolDepositAB", 13, 1900, 0, "$", true, 14, false));

        userInputService.main(monoBank, privatBank, alphaBank);
    }
}

