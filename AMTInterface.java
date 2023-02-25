import java.util.*;

public class ATMInterface {
    public static Scanner s = new Scanner(System.in);
    public static ArrayList<String> str = new ArrayList<>();
    public static void Transaction(float balance){
        for(String i : str){
            System.out.println(i);
        }
        Ask(balance);
    }
    public static void Transfer(float balance , float amount){
        if((amount <= balance)&& (amount >= 0)){
            System.out.println("Enter Account Name: ");
            String account_name = s.next();
            balance-=amount;
            System.out.println(amount +" ruppee/s sent to "+account_name);
            System.out.println("Transaction successful....");
            System.out.println("Balance is "+balance);
            str.add(amount+" Transfered to amount "+account_name);
            Ask(balance);
        }
        else{
            System.out.println("Enter amount :");
            Transfer(balance,s.nextFloat());
        }
    }
    public static void Login(String username , int pin){
        if(username.contains("Priyanshi") && pin == 4523){
            str.add("Logged in");
            Ask(6000);
        }
        else{
            System.out.println("Enter valid info !");
            System.out.println("Username follwed by pin seperated with a space :");
            Login(s.next() , s.nextInt());
        }
    }
    public static void Deposit(float balance , float amount ){
        if(amount >= 0){
            balance += amount;
            System.out.println("Transaction successful");
            System.out.println("Balance is "+balance);
            str.add(amount + "ruppee/s deposited!");
            Ask(balance);
        }
        else{
            System.out.println("Enter amount :");
            Deposit(balance,s.nextFloat());
        }
    }
    public static void Withdraw(float balance , float amount ){
        if(amount <= balance && amount >= 0){
            balance-= amount;
            System.out.println("Transaction successful , current balance is "+balance);
            str.add("Rupees/s" +amount +"Withdraw.");
            Ask(balance);
        }
        else{
            System.out.println("Enter amount");
            Withdraw(balance,s.nextFloat());
        }
    }


    public static void Quit(float balance , String quickResponse){
        if(quickResponse.equals("Yes") || quickResponse.equals("Yes")){
            System.out.println("Logged out");
            System.out.println();
        }
        else{
            Ask(balance);
        }
    }
    public static void Ask(float balance){
        System.out.println();
        System.out.println("Choose the action :");
        System.out.println(" 1 -> Transaction History.");
        System.out.println(" 2 -> Transfer");
        System.out.println(" 3 -> Deposit");
        System.out.println(" 4 -> Withdraw");
        System.out.println(" 5 -> Exit");
        int Operation =s.nextInt();
        System.out.println();
        switch (Operation){
            case 1:
                System.out.println("Transaction History ");
                Transaction(balance);
                break;
            case 2 :
                System.out.println("Enter transferred amount :");
                Transfer(balance,s.nextInt());
                break;
            case 3:
                System.out.println("Enter deposit amount :");
                Deposit(balance,s.nextInt());
                break;
            case 4:
                System.out.println("Enter amount to Withdraw :");
                Withdraw(balance,s.nextInt());
                break;
            case 5:
                System.out.println("Do you want to exit ?");
                System.out.println("Yes");
                System.out.println("No");
                String quickResponse = s.next();
                Quit(balance,quickResponse);
                break;
        }


    }
    public static void main(String[] args) {
        System.out.println("ATM");
        System.out.println("-*-*-*-*-*-*-*-*-*-*-LOGIN-*-*-*-*-*-*-*-*-*-*-");
        System.out.println("Enter username :");
        String username = s.next();
        System.out.println("Enter pin :");
        int pin = s.nextInt();
        Login(username, pin);
    }
}
