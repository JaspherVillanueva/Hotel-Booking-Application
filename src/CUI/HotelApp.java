package CUI;

import java.util.*;
import java.io.*;

public class HotelApp {

    private static Scanner keyboard;
    private static ArrayList<GuestInfo> guestList = new ArrayList<GuestInfo>();
    private static ArrayList<Integer> allRooms = new ArrayList<Integer>(); //list of integers, each representing a type of room
    private static RoomDatabase roomList = new RoomDatabase();   //database of all hard coded rooms

    private static Booker bookerDetailsInput() //Retrieves booker details from input and validates if booker is above the age of 18.
    {
        keyboard = new Scanner(System.in);

        boolean isEmpty = true;
        String fullName = "";

        boolean isOver = false;
        int age = 0;

        boolean isInt = false;
        int numberOfGuests = 0;

        int totalGuests;

        do {
            System.out.println("Please enter your full name: ");
            fullName = keyboard.nextLine();

            if (fullName == null || fullName.isEmpty()) {
                System.out.println("Invalid Input: Please enter a full name.\n");
            } else {
                isEmpty = false;
            }
        } while (isEmpty);

        do {
            System.out.println("Please state your age (Must be over 18 to book):");
            if (keyboard.hasNextInt()) {
                age = keyboard.nextInt();
                keyboard.nextLine();
                if (age >= 18 && age <= 125) {
                    isOver = true;
                } else {
                    System.out.println("You must be 18 or over to book. \n");
                }
            } else {
                System.out.println("Invalid Input: Please enter an integer. \n");
                keyboard.nextLine();
            }
        } while (!isOver);

        do {
            System.out.println("Please state the number of guests accompanying you: ");
            if (keyboard.hasNextInt()) {
                numberOfGuests = keyboard.nextInt();
                keyboard.nextLine();
                isInt = true;
            } else {
                System.out.println("Invalid Input: Please enter an integer. \n");
                keyboard.nextLine();
            }
        } while (!isInt);

        totalGuests = numberOfGuests + 1;

        try {
            File bookerInfo = new File("BookerInfo.txt");
            PrintWriter writer = new PrintWriter(new FileOutputStream(bookerInfo, true));
            writer.append(fullName + "\n" + age + "\n" + numberOfGuests + "\n" + totalGuests + "\n");
            writer.close();
        } catch (Exception e) {
        }

        return new Booker(fullName, age, numberOfGuests, totalGuests); //returns a customer object to the main
    }

    private static GuestInfo extraDetailsInput(int guestCounter) //Retrieves extra guests details from input.
    {
        keyboard = new Scanner(System.in);

        boolean isEmpty = true;
        String gFullName = "";

        boolean isInt = false;
        int gAge = 0;

        do {
            System.out.println("Please enter the full name of guest # " + guestCounter + ":");
            gFullName = keyboard.nextLine();
            if (gFullName == null || gFullName.isEmpty()) {
                System.out.println("Please enter a full name.\n");
            } else {
                isEmpty = false;
            }
        } while (isEmpty);

        do {
            System.out.println("Please enter the age of guest # " + guestCounter + ":");
            if (keyboard.hasNextInt()) {
                gAge = keyboard.nextInt();
                keyboard.nextLine();
                isInt = true;
            } else {
                System.out.println("Invalid Input: Please enter an integer. \n");
                keyboard.nextLine();
            }
        } while (!isInt);

        try //writes guest info into ta save file(name, age)
        {
            File guestInfo = new File("GuestInfo.txt");
            PrintWriter writer = new PrintWriter(new FileOutputStream(guestInfo, true));
            writer.append(gFullName + "\n" + gAge + "\n");
            writer.close();
        } catch (Exception e) {
        }

        return new GuestInfo(gFullName, gAge);
    }

    private static int countingRooms(int totalGuests) //Room selection to make sure each guest/s has a room and sums up room price per night.
    {
        keyboard = new Scanner(System.in);

        boolean isInt = false;
        int price = 0;
        int selection = 0;

        while (totalGuests > 0) {
            do {
                System.out.println("Please select a room for " + totalGuests + " more guest/s from the list below:");
                System.out.println("1) " + RoomType.SINGLE + " - ($" + RoomType.SINGLE.getPrice() + ")");
                System.out.println("2) " + RoomType.TWIN + " - ($" + RoomType.TWIN.getPrice() + ")");
                System.out.println("3) " + RoomType.QUEENSINGLE + " - ($" + RoomType.QUEENSINGLE.getPrice() + ")");
                System.out.println("4) " + RoomType.KINGSINGLE + " - ($" + RoomType.KINGSINGLE.getPrice() + ")");
                System.out.println("5) " + RoomType.QUEENDOUBLE + " - ($" + RoomType.QUEENDOUBLE.getPrice() + ")");

                if (keyboard.hasNextInt()) {
                    selection = keyboard.nextInt();
                    keyboard.nextLine();
                    isInt = true;
                } else {
                    System.out.println("Invalid Input: Please enter an integer. \n");
                    keyboard.nextLine();
                    isInt = false;
                }
            } while (!isInt);

            switch (selection) {
                case 1:
                    totalGuests = totalGuests - 1;
                    price = price + RoomType.SINGLE.getPrice();
                    allRooms.add(selection);
                    break;
                case 2:
                    totalGuests = totalGuests - 2;
                    price = price + RoomType.TWIN.getPrice();
                    allRooms.add(selection);
                    break;
                case 3:
                    totalGuests = totalGuests - 2;
                    price = price + RoomType.QUEENSINGLE.getPrice();
                    allRooms.add(selection);
                    break;
                case 4:
                    totalGuests = totalGuests - 2;
                    price = price + RoomType.KINGSINGLE.getPrice();
                    allRooms.add(selection);
                    break;
                case 5:
                    totalGuests = totalGuests - 4;
                    price = price + RoomType.QUEENDOUBLE.getPrice();
                    allRooms.add(selection);
                    break;
            }
        }
        return price;
    }

    private static int[] listBookedRooms(int totalGuests) //Prints out the quantity of rooms booked based on room type selected.
    {
        System.out.println("\nYou have booked the following rooms for " + totalGuests + " guests");
        int[] rooms = {0, 0, 0, 0, 0};

        for (int counter = 0; counter < allRooms.size(); counter++) {

            switch (allRooms.get(counter)) {
                case 1:
                    rooms[0]++;
                    break;
                case 2:
                    rooms[1]++;
                    break;
                case 3:
                    rooms[2]++;
                    break;
                case 4:
                    rooms[3]++;
                    break;
                case 5:
                    rooms[4]++;
                    break;
            }
        }
        if (rooms[0] > 0) {
            System.out.println("Single room/s x" + rooms[0]);
        }
        if (rooms[1] > 0) {
            System.out.println("Twin room/s x" + rooms[1]);
        }
        if (rooms[2] > 0) {
            System.out.println("Queen Single room/s x" + rooms[2]);
        }
        if (rooms[3] > 0) {
            System.out.println("King Single room/s x" + rooms[3]);
        }
        if (rooms[4] > 0) {
            System.out.println("Queen Double room/s x" + rooms[4]);
        }

        int[] saved = {0, 0, 0, 0, 0};

        for (int counter = 0; counter <= 4; counter++) {
            saved[counter] = rooms[counter];
        }

        for (int counter = 0; counter <= 4; counter++) {
            rooms[counter] = 0;
        }
        try //writes the booked rooms to a savefile in the form of an array of 5 ints
        {
            File bookedRooms = new File("Rooms.txt");
            PrintWriter writer = new PrintWriter(new FileOutputStream(bookedRooms, true));
            for (int counter = 0; counter < 5; counter++) {
                writer.append(saved[counter] + "\n");
            }
            writer.close();
        } catch (Exception e) {
        }

        return saved;
    }

    private static String getCheckInDate() //Retrieves and validates check-in date.
    {
        keyboard = new Scanner(System.in);

        boolean isValid = false;
        String dateInput = "";

        do {
            System.out.println("\nPlease enter your check-in date (dd-mm-yyyy): ");
            dateInput = keyboard.nextLine();
            isValid = BookingDate.isValidCheckIn(dateInput);
        } while (!isValid);

        try //writes check in dates to a savefile
        {
            File checkInDate = new File("CheckInDate.txt");
            PrintWriter writer = new PrintWriter(new FileOutputStream(checkInDate, true));
            writer.append(dateInput + "\n");
            writer.close();
        } catch (Exception e) {
        }

        return dateInput;
    }

    private static String getCheckOutDate(String checkIn) //Retrieves and validates check out date.
    {
        keyboard = new Scanner(System.in);

        boolean isValid = false;
        String dateInput = "";

        do {
            System.out.println("\nPlease enter your check out date (dd-mm-yyyy): ");
            dateInput = keyboard.nextLine();
            isValid = BookingDate.isValidCheckOut(dateInput, checkIn);
        } while (!isValid);

        try //writes check out dates to a savefile
        {
            File checkOutDate = new File("CheckOutDate.txt");
            PrintWriter writer = new PrintWriter(new FileOutputStream(checkOutDate, true));
            writer.append(dateInput + "\n");
            writer.close();
        } catch (Exception e) {
        }

        return dateInput;
    }

    private static boolean assigningRooms(int[] bookedRooms) //Assigns room numbers and validates availability of rooms.
    {
        System.out.println("\nYour room number/s are:\n");
        for (int type = 0; type < 5; type++) {
            if (bookedRooms[type] > 0) //cycles through each room type
            {
                ArrayList<Integer> rooms = new ArrayList<Integer>();
                int position = type;
                for (int counter = 0; counter < bookedRooms[type]; counter++) //loops thea same amount as amount of roomms booked of that type
                {
                    while (roomList.getRoomNumber(position).getIsReserved() == true) //if the room is reserved, move on to the next room of the same type
                    {
                        position = position + 5;
                        if (position > roomList.getRoom().size() - 5) //if room position exceeds database size, decline
                        {
                            System.out.println("\nSorry, we don't have any more room/s of this type available\n");
                            return false;
                        }
                    }
                    rooms.add(counter, position);  //add the room to the list of booked rooms
                    if (position < roomList.getRoom().size() - 5) {
                        position = position + 5; //move the position to the next availible room of the same type
                    }
                }
                for (int print = 0; print < rooms.size(); print++) //prints out the booked rooms and sets reserved to true for those rooms
                {
                    System.out.print(roomList.getRoomNumber(rooms.get(print)));
                    roomList.getRoomNumber(rooms.get(print)).setIsReserved(true);
                }
                rooms.clear(); // clears the array list for the next room type
            }
        }
        return true;
    }

    private static boolean repeat() //Asks user if they wish to book again.
    {
        boolean exit = false;

        System.out.println("\nWould you like to make another booking?");
        System.out.println("1) Yes");
        System.out.println("2) No, proceed to checkout ");
        System.out.println("3) Cancel my booking and exit the program");

        int selection = keyboard.nextInt();
        if (selection == 1) //loops back to make another booking, savefiles not deleted
        {
            System.out.println("Please wait while we restart the system for another booking: . . . ");
            System.out.println("Your current booking information has been saved");
            System.out.println("Please make another booking: ");
            exit = false;
        } else if (selection == 2) //save the savefiles and ends the program
        {
            System.out.println("Great! Your information has been saved and your rooms have been reserved for you!");
            System.out.println("Have a nice day and see you soon!");
            exit = true;
        } else if (selection == 3) //deletes the savefiles, ends the program
        {
            System.out.println("Sorry to see you go :(");
            System.out.println("Your booking has been canceled");

            File guestInfo = new File("GuestInfo.txt");
            if (guestInfo.exists()) {
                guestInfo.delete();
            }

            File bookerInfo = new File("BookerInfo.txt");
            if (bookerInfo.exists()) {
                bookerInfo.delete();
            }

            File checkInDdate = new File("CheckInDate.txt");
            if (checkInDdate.exists()) {
                checkInDdate.delete();
            }

            File checkOutDdate = new File("CheckOutDate.txt");
            if (checkOutDdate.exists()) {
                checkOutDdate.delete();
            }
            File rooms = new File("Rooms.txt");
            if (rooms.exists()) {
                rooms.delete();
            }
            exit = true;
        }

        return exit;
    }

    public static void main(String args[]) {
        boolean exit = false;

        do //to make another booking
        {
            keyboard = new Scanner(System.in);

            System.out.println("------------------------------------");
            System.out.println("Welcome to the Hotel Booking System");
            System.out.println("------------------------------------");

            Booker aBooker = bookerDetailsInput();
            guestList.add(aBooker);

            if (aBooker.getNumberOfGuests() > 0) {
                for (int counter = 1; aBooker.getNumberOfGuests() + 1 > counter; counter++) {
                    GuestInfo extraGuest = extraDetailsInput(counter);
                    guestList.add(extraGuest);
                }
            }

            String checkInDate = getCheckInDate();
            String checkOutDate = getCheckOutDate(checkInDate);

            int price = 0;
            int[] bookedRooms;
            int days = 0;
            boolean isValid = false;

            do //if rooms are not availible, start again to make user select a different combination of rooms
            {
                price = countingRooms(aBooker.getTotalGuests());

                System.out.println("----------------------------------------------------");
                System.out.println("----------------------Receipt-----------------------");
                System.out.println("----------------------------------------------------");

                bookedRooms = listBookedRooms(aBooker.getTotalGuests());

                System.out.println("\nFrom: " + checkInDate + " to: " + checkOutDate);

                days = BookingDate.getTotalDays(BookingDate.convertCheckInDate(checkInDate), BookingDate.convertCheckOutDate(checkOutDate));
                isValid = assigningRooms(bookedRooms);
                System.out.print("\n");

                allRooms.clear();

            } while (!isValid);

            for (GuestInfo info : guestList) {
                System.out.println(info);
            }

            System.out.println("Total Price: $" + price + " per night" + " for " + days + " day/s = $" + price * days);
            System.out.println("----------------------------------------------------");

            guestList.clear();

            exit = repeat();
        } while (!exit);
        keyboard.close();
    }
}
