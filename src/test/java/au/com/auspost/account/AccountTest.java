package au.com.auspost.account;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    @Test
    public void testDeposit_1() {
        Account account = new Account();
        account.deposit(1);
        assertEquals(1, account.getBalance());
    }
}
