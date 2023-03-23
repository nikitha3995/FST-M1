import org.junit.jupiter.api.Test;
import activityPrograms.BankAccount;
import activityPrograms.NotEnoughFundsException;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.Assert.assertThrows;

public class activity2 {
    @Test
    void notEnoughFunds() {
        // Create an object for BankAccount class
        BankAccount account = new BankAccount(9);

        // Assertion for exception
        assertThrows(NotEnoughFundsException.class, () -> account.withdraw(10),
                "Balance must be greater than amount of withdrawal");
    }

    @Test
    void enoughFunds() {
        // Create an object for BankAccount class
        BankAccount account = new BankAccount(100);

        // Assertion for no exceptions
        assertDoesNotThrow(() -> account.withdraw(100));
    }
}
