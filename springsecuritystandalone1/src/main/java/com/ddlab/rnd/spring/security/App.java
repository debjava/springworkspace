package com.ddlab.rnd.spring.security;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    //Only Manager or Admin can approve loan
    public static void approveLoan(BankTransaction bankTxn) {
        SecurityUtil.loginAs("Deb", "pqrs", "ROLE_MANAGER");
//		SecurityUtil.loginAs("Deb", "pqrs", "ROLE_ADMIN");//It will not work
        bankTxn.approvePersonalLoan("12345");
    }

    //Only Manager or Admin can approve house building loan
    public static void approveHouseLoan(BankTransaction bankTxn) {
//		SecurityUtil.loginAs("Deb", "pqrs", "ROLE_ADMIN");
        SecurityUtil.loginAs("Deb", "pqrs", "ROLE_MANAGER");
        bankTxn.approveHouseBuildingLoan(1234);
    }

    //Only user can open account
    public static void openAccount(BankTransaction bankTxn) {
        SecurityUtil.loginAs("Deb", "pqrs", "ROLE_USER");
        bankTxn.openAccount("Deb");
    }

    //Only MANAGER or TELLER can check the status
    public static void checkAccountStatus(BankTransaction bankTxn) {
//		SecurityUtil.loginAs("Deb", "pqrs", "ROLE_TELLER");
        SecurityUtil.loginAs("Deb", "pqrs", "ROLE_MANAGER");
        bankTxn.checkAccountStatus("11111");
    }

    //Only ADMIN can reset password
    public static void resetPassword(BankTransaction bankTxn) {
        SecurityUtil.loginAs("Deb", "pqrs", "ROLE_ADMIN");
        bankTxn.resetNetBankingPassword("Piku");
    }

    //Only admin who has write permission can edit the account
    public static void editAccount(BankTransaction bankTxn) {
        SecurityUtil.loginAs("Deb", "pqrs", "ROLE_ADMIN");
        bankTxn.editAccount("12345", new Permission("write"));
    }

    //Person having ADMIN authority can disburse loan
    public static void disburseLoan(BankTransaction bankTxn) {
        SecurityUtil.loginAs("Deb", "pqrs", "ADMIN");
        bankTxn.disburseLoan();
    }

    //Anybody properly authenticated can apply for credit card
    //If we remove the user and invoke the method, it will throw exception
    public static void applyCreditCard(BankTransaction bankTxn) {
//        SecurityUtil.loginAs("Deb", "pqrs", "ADMIN");
//        SecurityUtil.loginAs("Deb", "pqrs", "ROLE_MANAGER");
//        SecurityUtil.removeUser();//user removed, the following will throw exception
//        bankTxn.applyCreditCard();

        SecurityUtil.loginAs("Deb", "pqrs", "ROLE_MANAGER");
        bankTxn.applyCreditCard();
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans1.xml");
        BankTransaction bankTxn = (BankTransaction) applicationContext.getBean("bankTxn");
        approveLoan(bankTxn);
        approveHouseLoan(bankTxn);
        openAccount(bankTxn);
        checkAccountStatus(bankTxn);
        resetPassword(bankTxn);
        editAccount(bankTxn);
        disburseLoan(bankTxn);
        applyCreditCard(bankTxn);
    }
}
