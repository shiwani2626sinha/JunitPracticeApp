package patientIntake;

import java.util.Scanner;

public class ClinicMain {
    private static ClinicCalendar calendar;

    public static void main(String[] args) throws Throwable{
        calendar = new ClinicCalendar();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Patient intake Computer System!\n\n");
        String lastOption = "";
        while(!lastOption.equalsIgnoreCase("x")){
            lastOption = displayMenu(scanner);
        }
        System.out.println("\nExiting System...\n");
    }

    private static String displayMenu(Scanner scanner) throws  Throwable{
        System.out.println("Please select an option");
        System.out.println("1. Enter a Patient Appointment");
        System.out.println("2.View The Appointment List");
        System.out.println("Enter x for exit");
        System.out.println("Option: ");
        String option = scanner.next();
        switch (option){
            case "1" : performPatientEntry(scanner);
                        return option;
            case "2" : performAllAppointments();
                        return  option;
            default: System.out.println("Invalid option");
                        return option;
        }
    }

}
