package com.ddlab.rnd.aop1;
public class RetailAccount extends AbstractAccount {

    @Override
    public void withdraw(String actNo, int amount) {

        System.out.println("Amount " + amount + " is debited from the account no " + actNo);
    }
}
