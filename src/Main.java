import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static CentralBank createAccount(ArrayList<CentralBank> C){
        boolean found;
        String name, acc_no, acc_type;
        long balance;
        int choice;

        CentralBank c;

        System.out.println("Enter your bank");
        System.out.println("1. UNB 2. NBD 3. FGB");

        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();

        System.out.println("Enter your name:");
        name = sc.next();
        System.out.println("Enter your account number:");
        acc_no = sc.next();
        System.out.println("Enter your account type:");
        acc_type = sc.next();
        System.out.println("Enter your initial balance:");
        balance = sc.nextLong();

        found = false;
        for (int i = 0; i < C.size(); i++) {
            found = C.get(i).search(acc_no);
            if(found){
                System.out.println("Account already exists.");
                break;
            }
        };
        if(!found){
            switch (choice){
                case 1:
                    if(balance < 1000){
                        System.out.println("Minimum balance for unb is 1000.");
                    }else{
                        c = new nbd(name, acc_no, acc_type, balance);
                        System.out.println("Account created successfully with UNB.");
                        return c;
                    }
                    break;
                case 2:
                    if(balance < 2000) {
                        System.out.println("Minimum balance for nbd is 2000.");
                    }else{
                        c = new nbd(name, acc_no, acc_type, balance);
                        System.out.println("Account created successfully with NBD.");
                        return c;
                    }
                    break;
                case 3:
                    if (balance < 3000) {
                        System.out.println("Minimum balance for fgb is 3000.");
                    }else {
                        c = new fgb(name, acc_no, acc_type, balance);
                        System.out.println("Account created successfully with FGB.");
                        return c;
                    }
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        return null;
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<CentralBank> C = new ArrayList<>();

        System.out.println("No accounts created yet.");
        CentralBank c = createAccount(C);

        if(c !=null){
            C.add(c);
        }

        int choice;
        do {
            System.out.println("1. Create Account 2. Show Account 3. Deposit 4. Withdraw 5. Remove Account 6. Search 7. Exit");
            System.out.println("Enter your choice:");
            choice = sc.nextInt();

            switch (choice){
                case 1:
                    CentralBank newAccount = createAccount(C);
                    if(newAccount != null){
                        C.add(newAccount);
                        System.out.println("Account created successfully.");
                    }
                    break;
                case 2:
                    if(C.isEmpty()){
                        System.out.println("No accounts available.");
                    } else {
                        for (CentralBank account : C) {
                            account.showAccount();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter account number to deposit:");
                    String depositAccNo = sc.next();
                    boolean foundAccNo = false;
                    for (CentralBank account : C){
                        foundAccNo = account.search(depositAccNo);
                        if(foundAccNo){
                            System.out.println("Enter amount to deposit:");
                            long depositAmount = sc.nextLong();
                            account.deposit(depositAmount);
                            break;
                        }
                    }
                    if(!foundAccNo){
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:
                    System.out.println("Enter account number to withdraw:");
                    String withdrawAccNo = sc.next();
                    boolean foundWithdrawAccNo = false;
                    for(CentralBank account : C){
                        foundWithdrawAccNo = account.search(withdrawAccNo);
                        if(foundWithdrawAccNo){
                            System.out.println("Enter amount to withdraw: ");
                            long withdrawAmount = sc.nextLong();
                            account.withdraw(withdrawAmount);
                            break;
                        }
                    }
                    if(!foundWithdrawAccNo){
                        System.out.println("Account not found.");
                    }
                    break;
                case 5:
                    System.out.println("Enter account number to remove:");
                    String removeAccNo = sc.next();
                    boolean foundRemoveAccNo = false;

                    for(CentralBank account : C){
                        foundRemoveAccNo = account.search(removeAccNo);
                        if(foundRemoveAccNo){
                            C.remove(c);
                            System.out.println("Account removed successfully.");
                            break;
                        }
                    }

                    if(!foundRemoveAccNo){
                        System.out.println("Search failed, account not found.");
                    }
                    break;
                case 6:
                    System.out.println("Enter account number to search: ");
                    String searchAccNo = sc.next();
                    boolean foundSearchAccNo = false;

                    for (CentralBank account : C) {
                        foundSearchAccNo = account.search(searchAccNo);
                        if (foundSearchAccNo) {
                            break;
                        }
                    }
                    if(!foundSearchAccNo) {
                        System.out.println("Search failed, account not found.");
                    };
                    break;
                case 7:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Search failed, invalid choice.");
            }
        } while (choice!=7);
    }
}