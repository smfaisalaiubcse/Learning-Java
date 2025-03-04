import java.util.Scanner;
public class BalanceFomatter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter balance: ");
        int balance = scanner.nextInt();
        // Create an instance of BalanceHandler
        BalanceHandler balanceHandler = new BalanceHandler();

        // Get and format the balance
        String formattedBalance = balanceHandler.getFormattedBalance(balance);
        System.out.println("Formatted Balance: " + formattedBalance);
    }
}

class BalanceHandler {
    // Method to get formatted balance
    public String getFormattedBalance(int balance) {
        Format formatter = new Format();
        return formatter.formatBalance(balance);
    }

    // Nested non-static class for formatting
    class Format {
        // Method to format the balance
        public String formatBalance(int balance) {
            return String.format("%,d", balance);
        }
    }
}