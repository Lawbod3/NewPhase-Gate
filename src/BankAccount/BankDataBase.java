package BankAccount;

import java.util.HashMap;

public class BankDataBase {
    private HashMap<String, AccountInfo> accounts = new HashMap<String, AccountInfo>();



    public boolean isEmpty() {
        if (accounts.isEmpty()) return true;
        return false;
    }


    public void add(AccountInfo accountInfo) {
        if (accounts.containsKey(accountInfo.getAccountNumber())) {
           throw new IllegalArgumentException("Account number already exists");
        }
        accounts.put(accountInfo.getAccountNumber(), accountInfo);
    }

    public int numberOfAccounts() {
        return accounts.size();
    }

    public void remove(AccountInfo accountInfo2) {
        accounts.remove(accountInfo2.getAccountNumber());
    }
}
