package CUI;

public class GuestInfo {

    protected String fullName;
    protected int age;

    public GuestInfo() {								//No-argument Constructor
        this.setFullName("Unknown");
        this.setAge(0);
    }

    public GuestInfo(String fullName, int age) {
        this.setFullName(fullName);
        this.setAge(age);
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return ("Guest Name: " + this.fullName + " Age: " + this.age + "\n");
    }
}
