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
    public Account(long clientID, long accountID, long bankID,  float balance, String[] array, List<String> skills ) {
        this.clientID = clientID;
        this.accountID = accountID;
        this.bankID = bankID;
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


    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

}

