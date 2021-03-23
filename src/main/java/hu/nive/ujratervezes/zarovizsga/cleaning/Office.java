package hu.nive.ujratervezes.zarovizsga.cleaning;

public class Office implements Cleanable {
    private final int area;
    private final int floorNumber;
    private final String address;
    private static final int PRICE = 100;


    public Office(String address, int area, int floorNumber) {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address is empty!");
        }
        this.area = area;
        this.floorNumber = floorNumber;
        this.address = address;
    }

    @Override
    public int clean() {
        return area * floorNumber * PRICE;
    }

    @Override
    public String getAddress() {
        return address;
    }
}
