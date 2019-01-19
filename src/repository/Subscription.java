package repository;

public class Subscription {
    private int subscriptionId;
    private String name;
    private String street;
    private String number;
    private String city;

    public Subscription(int subscriptionId, String name, String street, String number, String city) {
        this.subscriptionId = subscriptionId;
        this.name = name;
        this.street = street;
        this.number = number;
        this.city = city;
    }

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
