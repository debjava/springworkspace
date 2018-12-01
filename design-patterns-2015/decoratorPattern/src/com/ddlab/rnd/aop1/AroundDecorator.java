package com.ddlab.rnd.aop1;
public class AroundDecorator extends AbstractAccount {

    private RetailAccount retailAccount;

    public AroundDecorator(RetailAccount retailAccount) {
        this.retailAccount = retailAccount;
    }

    @Override
    public void withdraw(String actNo, int amount) {

        System.out.println("Doing before withdrawing money .........");
        retailAccount.withdraw(actNo, amount);
        System.out.println("Doing after withdrawing money .........");

    }
}
