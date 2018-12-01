package com.ddlab.rnd.aop1;
public class BeforeDecorator extends AbstractAccount {

    private RetailAccount retailAccount;

    public BeforeDecorator(RetailAccount retailAccount) {
        this.retailAccount = retailAccount;
    }

    @Override
    public void withdraw(String actNo, int amount) {
        System.out.println("Doing validation before debiting from acount...");
        retailAccount.withdraw(actNo,amount);
    }
}
