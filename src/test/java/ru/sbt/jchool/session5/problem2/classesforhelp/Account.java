package ru.sbt.jchool.session5.problem2.classesforhelp;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 */
public class Account {
    private long clientID;

    private long accountID;

    private long bankID;




    private Currency currency;

    private float balance;
    private String[] array;

    private List<String> fooElements = Arrays.asList("one", "two", "three");

    public String[] getArray() {
        return array;
    }

    public List<String> getSkills() {
        return skills;
    }

    List<String> skills;

    public Account() {
    }
    public List<String> getFooElements() {
        return fooElements;
    }
    public Account(long clientID, long accountID, long bankID, Currency currency, float balance, String[] array, List<String> skills ) {
        this.clientID = clientID;
        this.accountID = accountID;
        this.bankID = bankID;
        this.currency = currency;
        this.balance = balance;
        this.array=array;
        this.skills=skills;
    }

    public long getClientID() {
        return clientID;
    }

    public void setClientID(long clientID) {
        this.clientID = clientID;
    }

    public long getAccountID() {
        return accountID;
    }

    public void setAccountID(long accountID) {
        this.accountID = accountID;
    }

    public long getBankID() {
        return bankID;
    }

    public void setBankID(long bankID) {
        this.bankID = bankID;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Account account = (Account)o;
        return clientID == account.clientID &&
            accountID == account.accountID &&
            bankID == account.bankID &&
            Float.compare(account.balance, balance) == 0 &&
            currency == account.currency;
    }

    @Override public int hashCode() {
        return Objects.hash(clientID, accountID, bankID, currency, balance);
    }
}

