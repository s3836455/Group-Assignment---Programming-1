public class Address {
    private String houseNumber;
    private String street;

    public Address(String houseNumber, String street) {
        this.houseNumber = houseNumber;
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getStreet() {
        return street;
    }
}
