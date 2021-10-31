package application;
import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department's name: ");
        String department = sc.nextLine();
        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Level: ");
        String level = sc.nextLine();
        System.out.print("Base salary: ");
        Double baseSalary = sc.nextDouble();

        System.out.print("How many contracts to this worker? ");
        int contracts = sc.nextInt();
        Worker worker = null;

        for (int i = 1; i <= contracts; i++) {
            System.out.println("Enter contract #" + i + " data:");
            System.out.print("Date (DD/MM/YYYY): ");
            String data = sc.next();
            System.out.print("Value per hour: ");
            Double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            Integer hours = sc.nextInt();

            Date dataFormat = sdf.parse(data);
            HourContract contract = new HourContract(dataFormat,valuePerHour,hours);

            worker = new Worker(name,WorkerLevel.valueOf(level),baseSalary,new Department(department));
            worker.addContract(contract);
        }

        System.out.println();
        System.out.printf("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();

        int month = Integer.parseInt(monthAndYear.substring(0,2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + worker.income(year,month));


    }


}
