package patientIntake;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ClinicMain {
    private static ClinicCalendar calendar;

    public static void main(String[] args) throws Throwable{
        calendar = new ClinicCalendar();
        Scanner scanner = new Scanner(System.in);
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

    private static void performPatientEntry(Scanner scanner) {
        scanner.nextLine();
        System.out.println("\n\nPlease Enter Appointment Info");
        System.out.print(" Patient Last Name: ");
        String lastName = scanner.nextLine();
        System.out.println(" Patient First Name: ");
        String firstName = scanner.nextLine();
        System.out.print(" Appointment Date (M/d/yyyy h:m a): ");
        String when = scanner.nextLine();
        System.out.print(" Enter Doctors Last Name: ");
        String doc = scanner.nextLine();
        try {
            calendar.addAppointment(lastName,firstName,doc,when);
        }
        catch (Throwable t){
            System.out.println("Error! " + t.getMessage());
            return;
        }
        System.out.println("Patient entered successfully. \n\n");
    }

    private static void performAllAppointments() throws Throwable {
        System.out.println("\n\nAll Appointments in System:");
        for (PatientAppointment appointment : calendar.getAppointments()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a");
            String apptTime = formatter.format(appointment.getAppointmentDateTime());
            System.out.println(String.format("%s:  %s,  %s\t\tDoctor: %s", apptTime,appointment.getPatientLastName()
                    ,appointment.getPatientFirstName(),appointment.getDoctor().getName()));
        }
        System.out.println("Press Any key to exit....");

    }

}
