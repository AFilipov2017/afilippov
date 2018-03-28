package ru.job4j.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 25.03.318
 */
public class Bank {

    private Map<User, List<Account>> mapUser = new TreeMap<>();

    public Map<User, List<Account>> getMapUser() {
        return mapUser;
    }

    public void addUser(User user) {
        this.mapUser.put(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        this.mapUser.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        User key = getKeyByPassport(passport);
        List<Account> list = mapUser.get(key);
        list.add(account);
        mapUser.putIfAbsent(key, list);
    }

    public void deleteAccountFromUser(String passport, Account account) {
        List<Account> list = getUserAccounts(passport);
        int index = list.indexOf(account);
        list.remove(index);
    }

    public List<Account> getUserAccounts(String passport) {
        return this.mapUser.get(getKeyByPassport(passport));
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String dstPassport, String dstRequisite, double amount) {
        boolean result = false;
        User userSrc = getKeyByPassport(srcPassport);
        User userDest = getKeyByPassport(dstPassport);
        double credit;
        double debet;

        for (Account account : this.mapUser.get(userSrc)) {
            if (account.getRequisites().equals(srcRequisite) && account.getValue() >= amount) {
                credit = account.getValue() - amount;
                account.setValue(credit);
            }
        }
        for (Account account1 : this.mapUser.get(userDest)) {
            if (account1.getRequisites().equals(dstRequisite)) {
                debet = account1.getValue() + amount;
                account1.setValue(debet);
                result = true;
            }
        }
        return result;
    }

    public User getKeyByPassport(String passport) {
        User result = null;
        for (User user : this.mapUser.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = user;
                break;
            }
        }
        return result;
    }
}
