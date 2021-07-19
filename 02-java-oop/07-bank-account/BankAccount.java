import java.util.Random;

public class BankAccount {
    private String accountNumber;
	private double checkingBalance;
	private double savingBalance;
    public static int numAccounts = 0;
	public static double totalAmount = 0.0;
    private static String ranAccNum() {
		String accNumber = "";
		Random r = new Random();
		for(int i = 0; i < 10; i++) {
			accNumber = accNumber.concat(String.valueOf(r.nextInt(10)));
		}
		return accNumber;

	}
    //constructor
    public BankAccount() {
		BankAccount.numAccounts ++;
		this.checkingBalance = 0;
		this.savingBalance = 0;
		this.accountNumber = BankAccount.ranAccNum();
	}
    //getter.
    public double getCheckingBalance() {
		return this.checkingBalance;
	}

	public double getSavingBalance() {
		return this.savingBalance;
	}
    // depoit money.
    public void depositMoney(double amount, String account) {
		if(account.equals("savings"))
			this.savingBalance += amount;
		else if(account.equals("checking"))
			this.checkingBalance += amount;
		BankAccount.totalAmount += amount;
	}
    // withdraw money.
    public void withdrawMoney(double amount, String account){
        if (account.equals("checings")){
            if (this.checkingBalance - amount < 0){
                System.out.println("Insuficient Funds in checkings account");
            }
            else {
                this.checkingBalance -= amount;
                BankAccount.totalAmount -= amount;
            }
                
        }
        else if (account.equals("savings")){
            if (this.savingBalance - amount < 0){
                System.out.println("Insuficient Funds in savings account");
            }
            else {
                this.savingBalance -= amount;
                BankAccount.totalAmount -= amount;
            }
        }
    }
    // display amount.
    public void displayAccountBalance() {
		System.out.println(String.format("Savings: %.2f, Checking: %.2f", this.savingBalance, this.checkingBalance));
	}
}






