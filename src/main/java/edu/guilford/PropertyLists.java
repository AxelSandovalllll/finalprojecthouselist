package edu.guilford;

import java.util.ArrayList;
import java.util.Random;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class PropertyLists {

    public static class PropertyList {
        // attributes of properties
        // private String address;
        private String city;
        private String state;
        private String zip;
        // private String price;
        private String owner;
        private String status;
        private String duration;
        // private String type;
        private String ownerID;
        private String propertyID;

        private String saleRent;
        private String price;
        private int lease;
        private int rooms;
        private int baths;
        private int closets;
        private String garage;
        private String type;
        private Double sqft;
        private String address;

        // constructor for property description that shows for customer
        public PropertyList(String address, String city, String state, String zip,
                String price, String owner, String status, String duration, String type, String ownerID,
                String propertyID, String saleRent, int lease, int rooms, int baths, int closets,
                String garage, Double sqft) {
            this.address = address;
            this.city = city;
            this.state = state;
            this.zip = zip;
            this.price = price;
            this.owner = owner;
            this.status = status;
            this.duration = duration;
            this.type = type;
            this.ownerID = ownerID;
            this.propertyID = propertyID;
            this.saleRent = saleRent;
            this.price = price;
            this.lease = lease;
            this.rooms = rooms;
            this.baths = baths;
            this.closets = closets;
            this.garage = garage;
            this.sqft = sqft;

        }

        // constructor that creates the property list for the owner
        // constructor for PropertyInformation
        // public PropertyList(String saleRent, String price, int lease, int rooms, int
        // baths, int closets,
        // String garage, String type, Double sqft, String address) {
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

        // static method to generate a list of random properties
        /**
         * @param numProperties
         * @return
         */
        public static ArrayList<PropertyList> generateRandomPropertyList(int numProperties) {
            ArrayList<PropertyList> properties = new ArrayList<>();
            Random rand = new Random();
            // address
            String[] address = { "123 Green St", "456 Guilford St", "789 English St", "1011 East St", "1213 North St",
                    "1415 South St",
                    "1617 Bryan St", "1819 Hobs St", "2021 Rachels St", "2223 Founders St", "2425 Wendover St" };
            String[] cities = { "New York", "Los Angeles", "Chicago", "Houston", "Phoenix", "Philadelphia",
                    "San Antonio", "San Diego", "Dallas", "San Jose", "Greensboro" };
            String[] states = { "NY", "CA", "IL", "TX", "AZ", "PA", "TX", "CA", "TX", "CA", "NC" };
            String[] owner = { "Tyler Smith", "Jane lowk", "Axel Sandoval", "Kevin Buikpor", "Rob Whitnell",
                    "Rogelio Perez",
                    "Sam Williams", "Lex Mill", "Oscar Brown", "Carl Brown", "Jim Jones", "alex Jones" };
            String[] statuses = { "For Sale", "For Rent", "Under Contract", "Sold" };
            String[] types = { "Single Family House", "Condo", "Apartment", "Townhouse" };
            String[] garages = { "1 car", "2 car", "3 car", "4 car", "5 car" };

            for (int i = 0; i < numProperties; i++) { // loop to add random properties to list
                String randomAddress = address[rand.nextInt(address.length)];
                String city = cities[rand.nextInt(cities.length)];
                String state = states[rand.nextInt(states.length)];
                String zip = String.format("%05d", rand.nextInt(100000));
                String price = String.format("$%.2f", rand.nextDouble() * 100000);
                String ownerS = owner[rand.nextInt(owner.length)];
                String status = statuses[rand.nextInt(statuses.length)];
                String duration = String.valueOf(rand.nextInt(12) + 1) + " months";
                String type = types[rand.nextInt(types.length)];
                String ownerID = String.valueOf(rand.nextInt(1000));
                String propertyID = String.valueOf(rand.nextInt(10000));
                String saleRent = statuses[rand.nextInt(statuses.length)];

                int lease = rand.nextInt(12) + 1;
                int rooms = rand.nextInt(5) + 1;
                int baths = rand.nextInt(5) + 1;
                int closets = rand.nextInt(5) + 1;
                String garage = garages[rand.nextInt(garages.length)];
                Double sqft = Math.floor(rand.nextDouble() * 10000);

                PropertyList property = new PropertyList(randomAddress, city, state, zip, price, ownerS, status,
                        duration, type, ownerID, propertyID, saleRent, lease, rooms, baths, closets, garage, sqft);

                properties.add(property);
            }

            return properties;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getZip() {
            return zip;
        }

        public void setZip(String zip) {
            this.zip = zip;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getOwnerID() {
            return ownerID;
        }

        public void setOwnerID(String ownerID) {
            this.ownerID = ownerID;
        }

        public String getPropertyID() {
            return propertyID;
        }

        public void setPropertyID(String propertyID) {
            this.propertyID = propertyID;
        }

        public String getSaleRent() {
            return saleRent;
        }

        public void setSaleRent(String saleRent) {
            this.saleRent = saleRent;
        }

        public int getLease() {
            return lease;
        }

        public void setLease(int lease) {
            this.lease = lease;
        }

        public int getRooms() {
            return rooms;
        }

        public void setRooms(int rooms) {
            this.rooms = rooms;
        }

        public int getBaths() {
            return baths;
        }

        public void setBaths(int baths) {
            this.baths = baths;
        }

        public int getClosets() {
            return closets;
        }

        public void setClosets(int closets) {
            this.closets = closets;
        }

        public String getGarage() {
            return garage;
        }

        public void setGarage(String garage) {
            this.garage = garage;
        }

        public Double getSqft() {
            return sqft;
        }

        public void setSqft(Double sqft) {
            this.sqft = sqft;
        }

        // to method
        public String toString() {
            return "PropertyList [address=" + address + ", city=" + city + ", state=" + state + ", zip=" + zip
                    + ", price="
                    + price + ", owner=" + owner + ", status=" + status + ", duration=" + duration + ", type=" + type
                    + ", ownerID=" + ownerID + ", propertyID=" + propertyID + "]";
        }

        // 2nd String method
        public String toString2() {
            return "PropertyList [saleRent=" + saleRent + ", price=" + price + ", lease=" + lease + ", rooms=" + rooms
                    + ", baths=" + baths + ", closets=" + closets + ", garage=" + garage + ", type=" + type + ", sqft="
                    + sqft + ", address=" + address + "]";
        }

    }

    // create a method that opens a dialog box to add a property
    public void addProperty() {
        // create a new stage
        Stage addPropertyStage = new Stage();
        // create a new grid pane
        GridPane addPropertyPane = new GridPane();
        // set the padding
        addPropertyPane.setPadding(new Insets(10, 10, 10, 10));
        // set the vertical and horizontal gaps
        addPropertyPane.setVgap(8);
        addPropertyPane.setHgap(10);
        // set the alignment
        addPropertyPane.setAlignment(Pos.CENTER);
        // create a new scene
        Scene addPropertyScene = new Scene(addPropertyPane, 500, 500);
        // set the scene
        addPropertyStage.setScene(addPropertyScene);
        // set the title
        addPropertyStage.setTitle("Add Property");
        // create a new label
        Label addressLabel = new Label("Address:");
        // set the font
        addressLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        // add the label to the grid pane
        addPropertyPane.add(addressLabel, 0, 0);
        // create a new text field
        TextField addressField = new TextField();
        // add the text field to the grid pane
        addPropertyPane.add(addressField, 1, 0);
        // create a new label
        Label cityLabel = new Label("City:");
        // set the font
        cityLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        // add the label to the grid pane
        addPropertyPane.add(cityLabel, 0, 1);
        // create a new text field
        TextField cityField = new TextField();
        // add the text field to the grid pane
        addPropertyPane.add(cityField, 1, 1);
        // create a new label
        Label stateLabel = new Label("State:");
        // set the font
        stateLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        // add the label to the grid pane
        addPropertyPane.add(stateLabel, 0, 2);
        // create a new text field
        TextField stateField = new TextField();
        // add the text field to the grid pane
        addPropertyPane.add(stateField, 1, 2);
        // create a new label
        Label zipLabel = new Label("Zip:");
        // set the font

    }
}