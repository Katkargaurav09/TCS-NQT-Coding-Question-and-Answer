import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ExpenseTracker {
    static LinkedHashMap<String, Integer> expenses = new LinkedHashMap<>(); // Persistent storage

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter Income: ");
        int income = s.nextInt();
        addIncome(income);

        addExpense(s, income); // Pass Scanner to handle multiple inputs

        s.close();
    }

    public static void addIncome(int income) {
        System.out.println("Your Income: " + income + "$");
    }

    public static void addExpense(Scanner s, int income) {
        while (true) { // Loop until user types 'done'
            System.out.print("Enter expense or type 'done' to finish: ");
            String category = s.next();
            if (category.equalsIgnoreCase("done"))
                break;

            System.out.print("Enter the price of expense: ");
            int expense = s.nextInt();

            expenses.put(category, expenses.getOrDefault(category, 0) + expense); // Add expense
        }

        displaySummary(income);
    }

    public static void displaySummary(int income) {
        int total_exp = expenses.values().stream().mapToInt(Integer::intValue).sum(); // Sum all expenses
        int saving = income - total_exp;

        System.out.println("\nSummary of Expenses:");
        System.out.println("Total Income  : " + income + "$");
        System.out.println("Total Expense : " + total_exp + "$");
        System.out.println("Total Saving  : " + saving + "$");
        System.out.println("Expense Breakdown:");
        for (Map.Entry<String, Integer> entry : expenses.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue() + "$");
        }
    }
}
