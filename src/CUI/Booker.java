package CUI;

public class Booker extends GuestInfo //contains booker information(not guest information)
{

    private int numberOfGuests;
    private int totalGuests;

    public Booker(String fullName, int age, int numberOfGuests, int totalGuests) {
        super(fullName, age);
        this.setNumberOfGuests(numberOfGuests);
        this.setTotalGuests(totalGuests);
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public int getTotalGuests() {
        return totalGuests;
    }

    public void setTotalGuests(int totalGuests) {
        this.totalGuests = totalGuests;
    }

    public String toString() {
        return ("Booker Name: " + this.fullName + "  Age: " + this.age + "\n");
    }
}
