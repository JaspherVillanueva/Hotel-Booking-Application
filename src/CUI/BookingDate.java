package CUI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class BookingDate //validates date inputs and returns validated booking dates
{

    private static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static LocalDate checkInDate;
    private static LocalDate checkOutDate;
    private static boolean isValid = false;

    public static boolean isValidCheckIn(String dateInput) //validates check in date
    {
        try {
            checkInDate = LocalDate.parse(dateInput, dateFormat);
            if (checkInDate.isBefore(LocalDate.now())) {
                System.out.println("Invalid input: Please enter an later date.");
                return isValid;
            } else {
                System.out.println("Selected check-in date: " + dateInput);
                isValid = true;
            }
        } catch (Exception e) {
            System.out.println("Invalid input: Please enter a date in format (dd-mm-yyyy)");
            isValid = false;
        }
        return isValid;
    }

    public static boolean isValidCheckOut(String dateInput, String checkIn) //validates check out date
    {
        isValid = false;
        try {
            checkInDate = LocalDate.parse(checkIn, dateFormat);
            checkOutDate = LocalDate.parse(dateInput, dateFormat);
            if (checkOutDate.compareTo(checkInDate) <= 0) {
                System.out.println("Invalid input: Check out date must not be earlier than or on check-in date");
                return isValid;
            } else {
                System.out.println("Selected check out date: " + dateInput + "\n");
                isValid = true;
            }
        } catch (Exception e) {
            System.out.println("Invalid input: Please enter a date in format (dd-mm-yyyy)");
            isValid = false;
        }
        return isValid;
    }

    public static LocalDate convertCheckInDate(String dateInput) //converts check in date 
    {
        checkInDate = LocalDate.parse(dateInput, dateFormat);
        return checkInDate;
    }

    public static LocalDate convertCheckOutDate(String dateInput) {
        checkOutDate = LocalDate.parse(dateInput, dateFormat);
        return checkOutDate;
    }

    public static int getTotalDays(LocalDate checkInDate, LocalDate checkOutDate) //Calculates the days between the check-in date and check out date.
    {
        long diff = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
        int days = (int) diff;
        return days;
    }
}
