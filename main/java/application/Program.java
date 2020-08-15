package application;

import entities.LegalPerson;
import entities.NormalPerson;
import entities.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Person> list = new ArrayList<>();

        System.out.println("Enter the number of tax payers: ");
        int n = sc.nextInt() + 1;

        for (int i = 1; i < n; i++) {
            System.out.println("Tax payer #" + i + " data: ");
            System.out.println("Individual or company? (i/c): ");
            char type = sc.next().charAt(0);
            System.out.println("Name: ");
            String name = sc.next();
            System.out.println("Annual Income: ");
            Double annualIncome = sc.nextDouble();

            switch (type) {
                case 'i':
                    System.out.println("Health expenditures: ");
                    Double healthExpenditures = sc.nextDouble();
                    NormalPerson np = new NormalPerson(healthExpenditures, name, annualIncome);
                    list.add(np);
                    break;
                case 'c':
                    System.out.println("Number of Employee: ");
                    Integer numerOfEmployee = sc.nextInt();
                    LegalPerson lp = new LegalPerson(numerOfEmployee, name, annualIncome);
                    list.add(lp);
                    break;
                default:
                    throw new IllegalStateException();
            }
        }
        sc.close();

        System.out.println();
        System.out.println("TAXES PAID: ");
        Double totalTaxes = 0.0;
        for (Person person : list) {
            System.out.println(person.getName() + " $" + person.taxCal());
            totalTaxes += person.taxCal();
        }

        System.out.println();
        System.out.println("TOTAL TAXES");
        System.out.println(totalTaxes);

    }
}
