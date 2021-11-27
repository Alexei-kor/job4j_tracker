package ru.job4j.stream;

import java.util.List;

public class Profile {

    private Address address;
    private String client;

    public Profile(String client, Address address) {
        this.client = client;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Profile{"
                + "address=" + address
                + ", client='" + client + '\''
                + '}';
    }
}
