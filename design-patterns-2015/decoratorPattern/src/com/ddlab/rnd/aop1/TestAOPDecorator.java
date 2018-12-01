package com.ddlab.rnd.aop1;
public class TestAOPDecorator {

    public static void main(String[] args) {

        RetailAccount account = new RetailAccount();
//        BeforeDecorator beforeDecorator = new BeforeDecorator(account);
        AroundDecorator aroundDecorator = new AroundDecorator(account);
        aroundDecorator.withdraw("1122334455",500);
    }
}
