package au.com.auspost.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {

    private Account account;

    @BeforeEach
    public void setUp() {
        this.account = new Account();
    }

    @Test
    public void testDeposit_1() {
        this.account.deposit(1);
        assertEquals(1, this.account.getBalance());
    }

    @Test
    public void testDeposit_negative_1() {
        var exception = assertThrows(
                InvalidParameterException.class,
                () -> this.account.deposit(-1)

        );
        assertEquals("Amount can not be less than 1", exception.getMessage());
    }

    @Test
    public void testWithdrawal_negative_1() {
        var exception = assertThrows(
                InvalidParameterException.class,
                () -> this.account.withdraw(-1)
        );
        assertEquals("Amount can not be less than 1", exception.getMessage());
    }

    @Test
    public void testWithdrawalWithInsufficientFunds() {
        this.account.deposit(1);
        var exception = assertThrows(
                RuntimeException.class,
                () -> this.account.withdraw(2)
        );
        assertEquals("Insufficient funds", exception.getMessage());
    }
}
