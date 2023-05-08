package edu.guilford;

public class Property {
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

    // Constructor
    public Property() {
        String[] saleRents = { "For Sale", "For Rent" };

        String[] garages = { "None", "1 Car", "2 Car", "3 Car", "4 Car" };

        String[] types = { "House", "Townhouse", "Condo", "Apartment", "Duplex", "Triplex", "Fourplex",
                "Mobile Home", "Manufactured Home" };

        // string list of addresses
        String[] addresses = { "123 Main St", "456 Elm St", "789 Oak St", "1011 Pine St", "1213 Maple St",
                "1415 Cedar St", "1617 Ash St", "1819 Walnut St", "2021 Spruce St", "2223 Chestnut St" };

        // Randomly generate values for each property
        this.saleRent = saleRents[(int) (Math.random() * saleRents.length)];
        this.price = (Math.random() * 1000000) + 100000;
        this.lease = (int) (Math.random() * 24) + 1;
        this.rooms = (int) (Math.random() * 6) + 1;
        this.baths = (int) (Math.random() * 6) + 1;
        this.closets = (int) (Math.random() * 10) + 1;
        this.garage = garages[(int) (Math.random() * garages.length)];
        this.type = types[(int) (Math.random() * types.length)];
        this.sqft = (Math.random() * 10000) + 1000;
        this.address = addresses[(int) (Math.random() * addresses.length)];
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
                "\n" + "Price: $" + price + "\n" + "Lease Duration: " + lease + " months\n" + "Rooms: " + rooms + "\n"
                + "Bathrooms: " + baths + "\n" + "Closets: " + closets + "\n" + "Garage: " + garage + "\n"
                + "Property Type: " + type + "\n" + "Size: " + sqft + " sq ft\n" + "Address: " + address + "\n";
    }
}
