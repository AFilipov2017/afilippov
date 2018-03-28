package ru.job4j.bank;

import org.junit.Assert;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 28.03.2018
 */
public class BankTest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenAddUser() {
        Bank bank = new Bank();
        User user = new User("John", "Lennon");
        bank.addUser(user);
        Assert.assertTrue(bank.getMapUser().keySet().contains(user));
    }

    @Test
    public void whenDeleteUser() {
        Bank bank = new Bank();
        User user = new User("John", "Lennon");
        User userTwo = new User("Ringo", "Star");
        bank.addUser(user);
        bank.addUser(userTwo);
        bank.deleteUser(user);
        Assert.assertFalse(bank.getMapUser().keySet().contains(user));
    }

    @Test
    public void whenAddAccount() {
        Bank bank = new Bank();
        User user = new User("John", "Lennon");
        bank.addUser(user);
        bank.addAccountToUser("Lennon", new Account("001112234", 0.0));
        Assert.assertThat(bank.getMapUser().get(user).get(0).getRequisites(), is("001112234"));
        Assert.assertThat(bank.getMapUser().get(user).get(0).getValue(), is(0.0));
    }

    @Test
    public void whenDeleteAccount() {
        Bank bank = new Bank();
        User user = new User("John", "Lennon");
        Account account = new Account("001112234", 0.0);
        bank.addUser(user);
        bank.addAccountToUser("Lennon", account);
        bank.deleteAccountFromUser("Lennon", account);
        Assert.assertTrue(bank.getMapUser().get(user).isEmpty());
    }

    @Test
    public void whenGetUserAccounts() {
        Bank bank = new Bank();
        User user = new User("John", "Lennon");
        Account accountOne = new Account("00112234", 0.0);
        Account accountTwo = new Account("00111122234", 0.0);
        bank.addUser(user);
        bank.addAccountToUser("Lennon", accountOne);
        bank.addAccountToUser("Lennon", accountTwo);
        List<Account> expected = new ArrayList<>();
        expected.add(accountOne);
        expected.add(accountTwo);
        List<Account> result = bank.getUserAccounts("Lennon");
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void whenTransferEnoughMoney() {
        Bank bank = new Bank();
        User user = new User("John", "Lennon");
        User userTwo = new User("Ringo", "Star");
        bank.addUser(user);
        bank.addUser(userTwo);
        Account accountOne = new Account("1", 100.0);
        Account accountTwo = new Account("2", 0.0);
        bank.addAccountToUser("Lennon", accountOne);
        bank.addAccountToUser("Star", accountTwo);
        boolean result = bank.transferMoney("Lennon", "1", "Star", "2", 25.0);
        System.out.println(accountOne.getValue());
        System.out.println(accountTwo.getValue());
        Assert.assertThat(result, is(true));
    }

    @Test
    public void whenTransferNotEnoughMoney() {
        Bank bank = new Bank();
        User user = new User("John", "Lennon");
        User userTwo = new User("Ringo", "Star");
        bank.addUser(user);
        bank.addUser(userTwo);
        Account accountOne = new Account("1", 100.0);
        Account accountTwo = new Account("2", 0.0);
        bank.addAccountToUser("Lennon", accountOne);
        bank.addAccountToUser("Star", accountTwo);
        boolean result = bank.transferMoney("Lennon", "1", "Star", "2", 250.0);
        System.out.println(accountOne.getValue());
        System.out.println(accountTwo.getValue());
        Assert.assertThat(result, is(true));
    }

}
