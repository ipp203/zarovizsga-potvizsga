package hu.nive.ujratervezes.zarovizsga.cleaning;

public class House implements Cleanable {
    private final int area;
    private final String address;
    private static final int PRICE = 80;

    public House(String address, int area) {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address is empty!");
        }
        this.area = area;
        this.address = address;
    }

    @Override
    public int clean() {
        return area * PRICE;
    }

    @Override
    public String getAddress() {
        return address;
    }
}
