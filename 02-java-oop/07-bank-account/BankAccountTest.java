public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount personal = new BankAccount();
        personal.depositMoney(300, "checking");
        personal.depositMoney(500, "savings");
        System.out.println(BankAccount.totalAmount);
        personal.withdraw(100, "checking");
        personal.withdraw(200, "savings");
        personal.accountBalance();
        System.out.println(BankAccount.totalAmount);
        
    }
    
}
