import java.util.*;

public class IncomeExpanse {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter income : ");
        int income = s.nextInt();

        expanseDetails1(income, s);
        // expanseDetails2(income, s);

    }

    public static void expanseDetails1(int income, Scanner s) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        String category = "";
        do {
            System.out.print("Enter expanse or type or done : ");
            category = s.next();
            if (category.equalsIgnoreCase("done"))
                break;
            System.out.print("Enter price of expanse : ");
            int expense = s.nextInt();

            map.put(category, map.getOrDefault(category, 0) + expense);

        } while (!category.equalsIgnoreCase("done"));

        int total_exp = 0;
        for (Map.Entry<String, Integer> set : map.entrySet()) {
            total_exp = total_exp + set.getValue();
        }
        int saving = income - total_exp;

        System.out.println("Summary of Expanses ");
        System.out.println("Total Income : " + income + "$");
        System.out.println("Total Expanse : " + total_exp + "$");
        System.out.println("Total Saving : " + saving + "$");
        System.out.println("Analysis: \n Expanse & price : ");
        for (Map.Entry<String, Integer> set : map.entrySet()) {
            System.out.println("-" + set.getKey() + ": " + set.getValue() + "$");
        }

    }

    public static void expanseDetails2(int income, Scanner s) {
        int food = 0;
        int transport = 0;
        int misc = 0;

        String category = "";
        do {
            System.out.print("Enter expanse or type or done : ");
            category = s.next();
            if (category.equalsIgnoreCase("done"))
                break;

            if (category.equalsIgnoreCase("food")) {
                System.out.print("Enter price of expanse : ");
                food = s.nextInt();
            } else if (category.equalsIgnoreCase("transport")) {
                System.out.print("Enter price of expanse : ");
                transport = s.nextInt();
            } else {
                System.out.print("Enter price of expanse : ");
                misc = s.nextInt();
            }

        } while (!category.equalsIgnoreCase("done"));

        int saving = 0;
        int total_exp = 0;
        total_exp = food + transport + misc;
        saving = income - total_exp;

        System.out.println("Summary of Expanses ");
        System.out.println("Total Income : " + income + "$");
        System.out.println("Total Expanse : " + total_exp + "$");
        System.out.println("Total Saving : " + saving + "$");
        System.out.println("Analysis: \n Expanse & price : ");
        System.out.println("-food: " + food + "$");
        System.out.println("-transport: " + transport + "$");
        System.out.println("-misc: " + misc + "$");

    }

}