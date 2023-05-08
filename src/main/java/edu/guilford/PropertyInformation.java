package edu.guilford;

import java.util.ArrayList;

public class PropertyInformation {
    private String saleRent;
    private Double price;
    private int lease;
    private int rooms;
    private int baths;
    private int closets;
    private String garage;
    private String type;
    private Double sqft;
    private String address;

    // constructor for PropertyInformation
    public PropertyInformation(String saleRent, Double price, int lease, int rooms, int baths, int closets,
            String garage, String type, Double sqft, String address) {
        this.saleRent = saleRent;
        this.price = price;
        this.lease = lease;
        this.rooms = rooms;
        this.baths = baths;
        this.closets = closets;
        this.garage = garage;
        this.type = type;
        this.sqft = sqft;
        this.address = address;
    }

    // Generate random property information
    public static ArrayList<PropertyInformation> generateRandomPropertyInformation(int numProperties) {
        ArrayList<PropertyInformation> properties = new ArrayList<>();
        String[] saleRents = { "For Sale", "For Rent" };
        String[] garages = { "None", "1 Car", "2 Car", "3 Car", "4 Car" };
        String[] types = { "House", "Townhouse", "Condo", "Apartment", "Duplex",
                "Triplex", "Fourplex",
                "Mobile Home", "Manufactured Home" };
        String[] addresses = { "123 Main St", "456 Elm St", "789 Oak St", "1011 Pine St", "1213 Maple St",
                "1415 Cedar St", "1617 Ash St", "1819 Walnut St", "2021 Spruce St", "2223 Chestnut St" };

        for (int i = 0; i < numProperties; i++) {
            String saleRent = saleRents[(int) (Math.random() * saleRents.length)];
            Double price = (Math.random() * 1000000) + 100000;
            int lease = (int) (Math.random() * 24) + 1;
            int rooms = (int) (Math.random() * 6) + 1;
            int baths = (int) (Math.random() * 6) + 1;
            int closets = (int) (Math.random() * 10) + 1;
            String garage = garages[(int) (Math.random() * garages.length)];
            String type = types[(int) (Math.random() * types.length)];
            Double sqft = (Math.random() * 10000) + 1000;
            String address = addresses[(int) (Math.random() * addresses.length)];

            PropertyInformation property = new PropertyInformation(saleRent, price, lease, rooms, baths, closets,
                    garage, type, sqft, address);
            properties.add(property);
        }

        return properties;
    }
    // Constructor
    // public Property(String saleRent, Double price, int lease, int rooms, int
    // baths, int closets, String garage,
    // String type, Double sqft, String address) {
    // this.saleRent = saleRent;
    // this.price = price;
    // this.lease = lease;
    // this.rooms = rooms;
    // this.baths = baths;
    // this.closets = closets;
    // this.garage = garage;
    // this.type = type;
    // this.sqft = sqft;
    // this.address = address;
    // }

    // Getters
    public String getSaleRent() {
        return saleRent;
    }

    public Double getPrice() {
        return price;
    }

    public int getLease() {
        return lease;
    }

    public int getRooms() {
        return rooms;
    }

    public int getBaths() {
        return baths;
    }

    public int getClosets() {
        return closets;
    }

    public String getGarage() {
        return garage;
    }

    public String getType() {
        return type;
    }

    public Double getSqft() {
        return sqft;
    }

    public String getAddress() {
        return address;
    }

    // Setters
    public void setSaleRent(String saleRent) {
        this.saleRent = saleRent;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setLease(int lease) {
        this.lease = lease;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public void setBaths(int baths) {
        this.baths = baths;
    }

    public void setClosets(int closets) {
        this.closets = closets;
    }

    public void setGarage(String garage) {
        this.garage = garage;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSqft(Double sqft) {
        this.sqft = sqft;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // toString
    @Override
    public String toString() {
        return "OWNER 1 DATA\nProperty: " + saleRent +
                "\n" + "Price: $" + price + "\n" + "Lease Duration: " + lease + " months\n" +
                "Rooms: " + rooms + "\n"
                + "Bathrooms: " + baths + "\n" + "Closets: " + closets + "\n" + "Garage: " +
                garage + "\n"
                + "Property Type: " + type + "\n" + "Size: " + sqft + " sq ft\n" + "Address: " + address + "\n";
    }
}
