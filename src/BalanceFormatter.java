import java.util.Scanner;

public class BalanceFormatter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter balance: ");
        int balance = scanner.nextInt();
        BalanceFormatter balanceFormatter = new BalanceFormatter();

        // Create an instance of BalanceHandler
        BalanceHandler balanceHandler = balanceFormatter.new BalanceHandler();

        // Get and format the balance
        String formattedBalance = balanceHandler.getFormattedBalance(balance);
        System.out.println("Formatted Balance: " + formattedBalance);
    }

    class BalanceHandler {
        // Method to get formatted balance
        public String getFormattedBalance(int balance) {
            return formatBalance(balance);
        }

        // Function to format the balance (instead of the nested Format class)
        public String formatBalance(int balance) {
            return String.format("%,d", balance);
        }
    }
}