import java.util.Random;

public class BankAccount {
    protected String accountNumber;
    private Double checkingAccount;
    private Double savingsAccount;
    public static int numberOfAccounts = 0;
    public static double totalAmount = 0.00;

    private static String RandomBankAccount(){
        String num = "";
        Random r = new Random();
        for(int i = 0; i <= 10; i++){
            num += r.nextInt(10);
        }
        return num;
    }

    public BankAccount() {
        this.accountNumber = BankAccount.RandomBankAccount();
        this.checkingAccount= 0.00;
        this.savingsAccount = 0.00;
        BankAccount.numberOfAccounts++;
        System.out.println("Checking account number is: " + this.checkingAccount);
        System.out.println("Savings account number is: " + this.savingsAccount);        
    }
    public void displayBankAccount() {
        System.out.println(accountNumber);
        
    }
    public double getCheckingAccountBal() {
        System.out.printf("Checking Account balance: $%.2f",this.checkingAccount);
        return this.checkingAccount;
    }
    public double getSavingsAccountBal() {
        System.out.printf("Savings Account balance: $%.2f", this.savingsAccount);
        return this.savingsAccount;
    }
    public void depositMoney(double amount, String account) {
        if(account.equals("checking")) 
            this.checkingAccount += amount;
        else if(account.equals("savings"))
            this.savingsAccount += amount;
            BankAccount.totalAmount += amount;       
    }
    public void withdraw(double amount, String account) {
        boolean sufficientFunds = false;
        if(account.equals("checking")){
            if(this.checkingAccount >= 0){
                sufficientFunds = true;
                this.checkingAccount -= amount;
            }else{
                System.out.println("Insufficient Funds");
            }
        }
        if(account.equals("savings")){
            if(this.savingsAccount >= 0){
                sufficientFunds = true;
                this.savingsAccount -= amount;
            }else{
                System.out.println("Insufficient Funds");
            }
        }
        if(sufficientFunds){
            BankAccount.totalAmount -= amount;
        }        
    }
    public void accountBalance() {
        System.out.println(this.checkingAccount + this.savingsAccount);
    }    
}