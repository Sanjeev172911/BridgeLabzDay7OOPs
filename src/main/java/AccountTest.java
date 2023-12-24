import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

class Account{
    long AccountNumber;
    long balance;

    public Account(long AccNumber){
        this.AccountNumber=AccNumber;
        this.balance=0;
    }

    public String debit(int amountToDebit){
        if(amountToDebit>this.balance){
            return "Debit amount exceeded account balance.";
        }
        this.balance-=amountToDebit;
        return "Remaining Balance : "+this.balance;
    }

    public String addMoney(int money){
        this.balance+=money;
        return "Account Balance : "+this.balance;
    }
}

class AccountTest {
    static Scanner input=new Scanner(System.in);
    static Map<Long,Account>AccountDetails;
    public static void main(String[] args) {
        AccountDetails=new HashMap<>();
        System.out.println("Enter Your Account Number : ");
//        Random random=new Random();
//        long accountNumber=random.nextLong(10000000000L,100000000000L);
//        Account newAcc=new Account(accountNumber);
//        AccountDetails.put(accountNumber,newAcc);
//        System.out.println("Enter the money you want to add");
//        int money=input.nextInt();
        long accNumber=input.nextLong();
        Account acc = AccountDetails.get(accNumber);
        System.out.println("Enter the amount you want to Debit");
        int debitMoney = input.nextInt();
        acc.debit(debitMoney);
    }
}


