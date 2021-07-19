public class BankAccountTest{
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();
        account1.depositMoney(400.49, "checking");
		account1.depositMoney(300.00, "savings");
        account1.withdrawMoney(150.50, "checking");
		account1.withdrawMoney(100.70, "savings");
        account1.displayAccountBalance();
        System.out.println(BankAccount.totalAmount);

        account2.depositMoney(200.49, "checking");
		account2.depositMoney(100.00, "savings");
        account2.withdrawMoney(100.30, "checking");
		account2.withdrawMoney(50.60, "savings");
        account2.displayAccountBalance();
        System.out.println(BankAccount.totalAmount);
    }
}