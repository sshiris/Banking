public class fgb implements CentralBank{
    String name;
    String acc_no;
    String acc_type;
    long balance;

    public fgb(String name, String acc_no, String acc_type, long balance) {
        this.name = name;
        this.acc_no = acc_no;
        this.acc_type = acc_type;
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public void withdraw(long amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Balance after withdrawal: " + balance);
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
    }

    public void deposit(long amount) {
        balance += amount;
        System.out.println("Balance after deposit: " + balance);
    }

    public void showAccount() {
        System.out.println("Account Holder Name: " + name);
        System.out.println("Account Number: " + acc_no);
        System.out.println("Account Type: " + acc_type);
        System.out.println("Current Balance: " + balance);
    }

    public boolean search(String search_acc_no) {
        if (acc_no.equals(search_acc_no)) {
            showAccount();
            return true;
        }
        return false;
    }
}
