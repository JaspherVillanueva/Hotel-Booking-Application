package CUI;

public enum RoomType {
    SINGLE(50), TWIN(70), QUEENSINGLE(70), KINGSINGLE(90), QUEENDOUBLE(120);

    private int price;

    private RoomType(int price) {
        this.setPrice(price);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String toString() {

        if (this.name() == "SINGLE") {
            return "Single";
        } else if (this.name() == "TWIN") {
            return "Twin";
        } else if (this.name() == "QUEENSINGLE") {
            return "Queen Single";
        } else if (this.name() == "KINGSINGLE") {
            return "King Single";
        } else if (this.name() == "QUEENDOUBLE") {
            return "Queen Double";
        } else {
            return this.name();
        }
    }
}
