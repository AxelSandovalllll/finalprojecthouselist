package edu.guilford;

import javafx.application.Application;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import edu.guilford.PropertyLists.PropertyList;

/**
 * JavaFX App
 */
public class PropertyDriver extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Set the title of the window
        primaryStage.setTitle("Welcome to House Market");

        // Create buttons for owner and customer login
        Button ownerLoginButton = new Button("Owner Login");
        Button customerLoginButton = new Button("Customer Login");

        // Set event handlers for the buttons to their respective methods
        ownerLoginButton.setOnAction(event -> openOwnerLogin());
        customerLoginButton.setOnAction(event -> openCustomerLogin());

        // Apply styling to the buttons
        ownerLoginButton.setStyle("-fx-font-size: 22px; -fx-padding: 10px 20px;-fx-font-weight: bold");
        customerLoginButton.setStyle("-fx-font-size: 22px; -fx-padding: 10px 20px;-fx-font-weight: bold");

        // Create a label for the website description
        Label descriptionLabel = new Label("           Buy-Sell-Rent \n The Cribbo Experience");

        // Apply styling to the label
        descriptionLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-font-family: 'Impact';");
        descriptionLabel.setAlignment(Pos.CENTER);

        // Create a vertical layout and add the label and buttons to the center
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle(
                "-fx-background-image: url('file:src/main/resources/edu/guilford/backgroundhouse.jpg'); -fx-background-size: cover; -fx-padding: 40px;");
        layout.getChildren().addAll(descriptionLabel, ownerLoginButton, customerLoginButton);

        // Set the layout as the scene content
        Scene scene = new Scene(layout, 500, 300);

        // Show the window
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // This method is called when the owner login button is clicked
    private void openOwnerLogin() {
        // Create a dialog for login
        // A Dialog window is an independent sub window meant to carry temporary notice
        // apart from the main Swing Application Window
        // textinputdialog is a dialog window that takes text input from the user
        TextInputDialog loginDialog = new TextInputDialog();
        // sets the title of the dialog window
        loginDialog.setTitle("Owner Login");
        // sets the header text of the dialog window
        loginDialog.setHeaderText("Please enter your username and password:");
        // sets the content text of the dialog window
        loginDialog.setContentText("Username:");

        // Show the login dialog and wait for user input
        // optional is a container object which may or may not contain a non-null value
        // showandwait() shows the dialog and waits for the user to provide a response
        Optional<String> usernameResult = loginDialog.showAndWait();

        // if the user enters a username
        if (usernameResult.isPresent()) {
            // Username entered, prompt for password
            // clears the text field
            loginDialog.getEditor().clear();
            loginDialog.setContentText("Password:");

            // optional is a container object which may or may not contain a non-null value
            // showandwait() shows the dialog and waits for the user to provide a response
            Optional<String> passwordResult = loginDialog.showAndWait();

            // if the user enters a password
            if (passwordResult.isPresent()) {
                // Password entered, validate login credentials
                // get() returns the value if it is stored/present, otherwise throws
                // NoSuchElementException
                String username = usernameResult.get();
                String password = passwordResult.get();

                // Perform validateOwnerLogin method with the username and password entered
                // from two different users
                boolean isLoginValid = validateOwnerLogin(username, password);
                boolean isLoginValid2 = validateOwnerLogin2(username, password);

                // if the login is true for owner 1
                if (isLoginValid) {
                    // Login successful, open owner screen
                    openOwnerScreen(username);
                    // if the login is true for owner 2
                } else if (isLoginValid2) {
                    // Login successful, open owner screen
                    openOwnerScreen2(username);
                    // if the login is false
                } else {
                    // Login failed, show an error message using alert, which is a dialog window
                    // that shows a message and waits for the user to respond to it. this is an
                    // ERROR alert type
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    // sets the title of the alert window
                    alert.setTitle("Login Failed");
                    // sets the header text of the alert window
                    alert.setHeaderText("Invalid username or password.");
                    // sets the content text of the alert window
                    alert.setContentText("Please try again.");
                    // shows the alert window and waits for the user to respond to it
                    // The showAndWait() method is a method in the Alert class of JavaFX that
                    // displays the alert dialog and waits for the user to interact with it before
                    // continuing the execution of the program.
                    alert.showAndWait();
                }

            }
        }
    }

    // This method is called when the owner login button is clicked to make sure the
    // username and password are correct and in the system
    private boolean validateOwnerLogin(String username, String password) {

        // return true but reaching for multiple different users
        return username.equals("owner") && password.equals("owner1");

    }

    // This method is called when the owner login button is clicked to make sure the
    // username and password are correct and in the system
    private boolean validateOwnerLogin2(String username, String password) {

        // return true but reaching for multiple different users
        return username.equals("owner2") && password.equals("owner2");

    }

    // This method is called when the owner login information for the first oqwneris
    // correct
    private void openOwnerScreen(String username) {
        // Create a new stage for the owner screen
        Stage ownerStage = new Stage();
        ownerStage.setTitle("Owner Screen");

        // Create GUI components for the owner screen
        // Label is a non-editable text control that displays a string
        Label titleLabel = new Label("Properties Owned by " + username + ":");
        // ListView is a control that displays a list of items
        ListView<String> propertyListView = new ListView<>();

        // Add sample property details to the property list view
        // int propertyCount = 3;
        // creating an array of properties and filling it with randomly generated
        // properties
        // Property[] properties = new Property[propertyCount];
        // for (int i = 0; i < propertyCount; i++) {
        // properties[i] = new Property<>();
        // }
        // for every property object in the array properties, print it out.
        // for (Property property : properties) {
        // System.out.println(property);
        // }

        propertyListView.getItems().addAll(
                "OWNER 1 DATA\nProperty 1: For Sale - $250,000\n" +
                        "Available Dates: May 15, 2023\n" +
                        "Lease Duration: N/A\n" +
                        "Rooms: 3\n" +
                        "Bathrooms: 2\n" +
                        "Closets: 4\n" +
                        "Garage: Yes\n" +
                        "Property Type: House\n" +
                        "Size: 2000 sq ft\n" +
                        "Address: 123 Main St, Anytown, USA",
                "Property 2: For Rent - $1,200/month\n" +
                        "Available Dates: June 1, 2023\n" +
                        "Lease Duration: 1 year\n" +
                        "Rooms: 2\n" +
                        "Bathrooms: 1\n" +
                        "Closets: 2\n" +
                        "Garage: No\n" +
                        "Property Type: Apartment\n" +
                        "Size: 800 sq ft\n" +
                        "Address: 456 Elm St, Anytown, USA");

        // Create a button to add a new property
        Button addPropertyButton = new Button("Add Property");
        // openaddpropertydialog method is called when the button is clicked
        addPropertyButton.setOnAction(e -> openAddPropertyDialog(propertyListView));

        // Create a vertical layout for the owner screen
        // Ro recommedned to use GridPane so we can add pictures
        VBox layout = new VBox(10);
        // sets the alignment of the layout
        layout.getChildren().addAll(titleLabel, propertyListView, addPropertyButton);

        // Set the layout as the scene content
        Scene scene = new Scene(layout, 400, 300);
        ownerStage.setScene(scene);

        // Show the owner screen
        ownerStage.show();
    }

    // This method is called when the owner2 login information is correct
    private void openOwnerScreen2(String username) {
        // Create a new stage for the owner screen
        Stage ownerStage = new Stage();
        ownerStage.setTitle("Owner Screen");

        // Create GUI components for the owner screen
        Label titleLabel = new Label("Properties Owned by " + username + ":");
        ListView<String> propertyListView = new ListView<>();

        // Add sample property details to the property list view that are different from
        // the first owner

        // print here all the random properties from the propertylist class

        // instantaite random property list
        // PropertyList propertyList = new PropertyList();
        // //call the method to generate random properties
        // PropertyLists.generateRandomPropertyList(10);
        // //call the method to print the random properties
        // PropertyLists.printRandomProperties();

        propertyListView.getItems().addAll(
                "OWNER 2 DATA\n" +
                        "Available Dates: May 15, 2023\n" +
                        "Lease Duration: N/A\n" +
                        "Rooms: 3\n" +
                        "Bathrooms: 2\n" +
                        "Closets: 4\n" +
                        "Garage: Yes\n" +
                        "Property Type: House\n" +
                        "Size: 2000 sq ft\n" +
                        "Address: 123 Main St, Anytown, USA",
                "Property 2: For Rent - $1,200/month\n" +
                        "Available Dates: June 1, 2023\n" +
                        "Lease Duration: 1 year\n" +
                        "Rooms: 2\n" +
                        "Bathrooms: 1\n" +
                        "Closets: 2\n" +
                        "Garage: No\n" +
                        "Property Type: Apartment\n" +
                        "Size: 800 sq ft\n" +
                        "Address: 456 Elm St, Anytown, USA");

        // Create a button to add a new property
        Button addPropertyButton = new Button("Add Property");
        addPropertyButton.setOnAction(e -> openAddPropertyDialog(propertyListView));

        // Create a vertical layout for the owner screen
        VBox layout = new VBox(10);
        layout.getChildren().addAll(titleLabel, propertyListView, addPropertyButton);

        // Set the layout as the scene content
        Scene scene = new Scene(layout, 400, 300);
        ownerStage.setScene(scene);

        // Show the owner screen
        ownerStage.show();
    }

    // This method is called when the addproperty button is clicked
    // it contains the listview of the properties
    private void openAddPropertyDialog(ListView<String> propertyListView) {
        // Create a dialog (small window) called addPropertyDialog for adding a new
        // property string values

        // maybe here is where we can create a class that already creates a new
        // propertylistview
        // that replaces new Dialog<>()
        Dialog<String> addPropertyDialog = new Dialog<>();

        // Set the dialog title and header text
        addPropertyDialog.setTitle("Add Property");
        addPropertyDialog.setHeaderText("Enter property details:");

        // instantiate a gridpane
        GridPane grid = new GridPane();

        // add the grid to the dialog pane
        addPropertyDialog.getDialogPane().setContent(grid);

        // create a label for the property details
        // create text labels and fields for the dialog
        Label addressLabel = new Label("Address:");
        TextField addressField = new TextField();
        Label cityLabel = new Label("City:");
        TextField cityField = new TextField();
        Label stateLabel = new Label("State:");
        TextField stateField = new TextField();
        Label zipLabel = new Label("Zip:");
        TextField zipField = new TextField();
        Label leaseLabel = new Label("Lease (months):");
        TextField leaseField = new TextField();
        Label roomsLabel = new Label("Rooms:");
        TextField roomsField = new TextField();
        Label bathsLabel = new Label("Bathrooms:");
        TextField bathsField = new TextField();
        Label closetsLabel = new Label("Closets:");
        TextField closetsField = new TextField();
        Label garageLabel = new Label("Garage:");
        TextField garageField = new TextField();
        Label typeLabel = new Label("Property Type:");
        TextField typeField = new TextField();
        Label sqftLabel = new Label("Size:");
        TextField sqftField = new TextField();
        Label priceLabel = new Label("Price:");
        TextField priceField = new TextField();
        Label statusLabel = new Label("Status:");
        TextField statusField = new TextField();

        // add the labels and fields to the grid
        grid.add(addressLabel, 1, 1);
        grid.add(addressField, 2, 1);
        grid.add(cityLabel, 1, 2);
        grid.add(cityField, 2, 2);
        grid.add(stateLabel, 1, 3);
        grid.add(stateField, 2, 3);
        grid.add(zipLabel, 1, 4);
        grid.add(zipField, 2, 4);
        grid.add(leaseLabel, 1, 5);
        grid.add(leaseField, 2, 5);
        grid.add(roomsLabel, 1, 6);
        grid.add(roomsField, 2, 6);
        grid.add(bathsLabel, 1, 7);
        grid.add(bathsField, 2, 7);
        grid.add(closetsLabel, 1, 8);
        grid.add(closetsField, 2, 8);
        grid.add(garageLabel, 1, 9);
        grid.add(garageField, 2, 9);
        grid.add(typeLabel, 1, 10);
        grid.add(typeField, 2, 10);
        grid.add(sqftLabel, 1, 11);
        grid.add(sqftField, 2, 11);
        grid.add(priceLabel, 1, 12);
        grid.add(priceField, 2, 12);
        grid.add(statusLabel, 1, 13);
        grid.add(statusField, 2, 13);

        // Add buttons to the dialog
        // addButton has a button data of ok_done that means that the dialog will close
        // when the button is clicked successfully
        ButtonType addButton = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        // cancelButton has a button data of cancel_close that means that the dialog
        // will close when the button is clicked to cancel
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        // add the buttons to the dialog
        addPropertyDialog.getDialogPane().getButtonTypes().addAll(addButton, cancelButton);

        // Enable or disable the Add button based on the text input
        Node addButtonNode = addPropertyDialog.getDialogPane().lookupButton(addButton);
        addButtonNode.setDisable(true);

        // add a listener to all the text fields to enable the add button when all
        // fields are filled
        addressField.textProperty().addListener((observable, oldValue, newValue) -> {
            addButtonNode.setDisable(newValue.trim().isEmpty());
        });

        // Set the result converter for the addPropertyDialog

        // this is where we can create a new property object and add it to the listview
        // and the database

        addPropertyDialog.setResultConverter(dialogButton -> {
            if (dialogButton == addButton) {
                try {
                    return "Owner: \n" + "Address: " + addressField.getText() + "\n" + "City: " + cityField.getText()
                            + "\n"
                            + "State: " + stateField.getText() + "\n" + "Zip: " + zipField.getText() + "\n"
                            + "Lease Duration: " + leaseField.getText() + "\n"
                            + "Rooms: " + roomsField.getText() + "\n" + "Bathrooms: " + bathsField.getText() + "\n"
                            + "Closets: " + closetsField.getText() + "\n"
                            + "Garage: " + garageField.getText() + "\n" + "Property Type: " + typeField.getText() + "\n"
                            + "Size: " + sqftField.getText() + "\n"
                            + "Price: " + priceField.getText() + "\n" + "Status: " + statusField.getText() + "\n";
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        });

        //create a new Listview object 
        ListView<String> propertyList = new ListView<String>();
        //add the property details to the listview
        propertyList.getItems().add(addPropertyDialog.showAndWait().get());
        




        // once the add button is clicked, the property is added to the bottow of the
        // list view

        // add an event listener on the address field to check if the address is well
        // formed
        addressField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (addressField.getText().matches("^[a-zA-Z0-9\\s]*$")) {
                    addressField.setStyle("-fx-border-color: green");
                } else {
                    addressField.setStyle("-fx-border-color: red");
                }
            }
        });

        // add an event listener on the city field to check if the city is well formed
        cityField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (cityField.getText().matches("^[a-zA-Z\\s]*$")) {
                    cityField.setStyle("-fx-border-color: green");
                } else {
                    cityField.setStyle("-fx-border-color: red");
                }
            }
        });

        // add an event listener on the state field to check if the state is well formed
        stateField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (stateField.getText().matches("^[a-zA-Z\\s]*$")) {
                    stateField.setStyle("-fx-border-color: green");
                } else {
                    stateField.setStyle("-fx-border-color: red");
                }
            }
        });

        // add an event listener on the zip field to check if the zip is well formed
        zipField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (zipField.getText().matches("^[0-9]{5}(?:-[0-9]{4})?$")) {
                    zipField.setStyle("-fx-border-color: green");
                } else {
                    zipField.setStyle("-fx-border-color: red");
                }
            }
        });

        // add an event listener on the lease field to check if the lease is well formed
        leaseField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (leaseField.getText().matches("^[0-9]*$")) {
                    leaseField.setStyle("-fx-border-color: green");
                } else {
                    leaseField.setStyle("-fx-border-color: red");
                }
            }
        });

        // add an event listener on the rooms field to check if the rooms is well formed
        roomsField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (roomsField.getText().matches("^[0-9]*$")) {
                    roomsField.setStyle("-fx-border-color: green");
                } else {
                    roomsField.setStyle("-fx-border-color: red");
                }
            }
        });

        // add an event listener on the baths field to check if the baths is well formed
        bathsField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (bathsField.getText().matches("^[0-9]*$")) {
                    bathsField.setStyle("-fx-border-color: green");
                } else {
                    bathsField.setStyle("-fx-border-color: red");
                }
            }
        });

        // add an event listener on the closets field to check if the closets is well
        // formed
        closetsField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (closetsField.getText().matches("^[0-9]*$")) {
                    closetsField.setStyle("-fx-border-color: green");
                } else {
                    closetsField.setStyle("-fx-border-color: red");
                }
            }
        });

        // add an event listener on the garage field to check if the garage is well
        // formed
        garageField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (garageField.getText().matches("^[0-9]*$")) {
                    garageField.setStyle("-fx-border-color: green");
                } else {
                    garageField.setStyle("-fx-border-color: red");
                }
            }
        });

        // add an event listener on the type field to check if the type is well formed

        typeField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (typeField.getText().matches("^[a-zA-Z\\s]*$")) {
                    typeField.setStyle("-fx-border-color: green");
                } else {
                    typeField.setStyle("-fx-border-color: red");
                }
            }
        });

        // add an event listener on the sqft field to check if the sqft is well formed
        sqftField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (sqftField.getText().matches("^[0-9]*$")) {
                    sqftField.setStyle("-fx-border-color: green");
                } else {
                    sqftField.setStyle("-fx-border-color: red");
                }
            }
        });

        // add an event listener on the price field to check if the price is well formed

        priceField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (priceField.getText().matches("^[0-9]*$")) {
                    priceField.setStyle("-fx-border-color: green");
                } else {
                    priceField.setStyle("-fx-border-color: red");
                }
            }
        });

        // // Create dialog components
        // // MAYBE THIS CAN BE PUT IN THE CLASS THAT CREATES THE NEW PROPERTYLISTVIEW
        // TextField propertyDetailsField = new TextField();
        // propertyDetailsField.setPromptText("Enter property details");

        // // Set the dialog content to the property details text field
        // addPropertyDialog.getDialogPane().setContent(propertyDetailsField);

        // // Add buttons to the dialog
        // // addButton has a button data of ok_done that means that the dialog will
        // close
        // // when the button is clicked successfully
        // ButtonType addButton = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        // // cancelButton has a button data of cancel_close that means that the dialog
        // // will close when the button is clicked to cancel
        // ButtonType cancelButton = new ButtonType("Cancel",
        // ButtonBar.ButtonData.CANCEL_CLOSE);

        // // Add buttons to the dialog
        // addPropertyDialog.getDialogPane().getButtonTypes().addAll(addButton,
        // cancelButton);

        // // Enable or disable the Add button based on the text input
        // // Node is the base class for all UI components that can be added to a scene
        // // graph. It represents a single element that can be displayed on the screen,
        // // such as a button, label, or image.
        // // lookupButton() method is used to lookup a button based on the button type
        // Node addButtonNode =
        // addPropertyDialog.getDialogPane().lookupButton(addButton);
        // // setDisable() method is used to disable the button
        // addButtonNode.setDisable(true);
        // // textProperty() method is used to get the text property of the text field
        // propertyDetailsField.textProperty()
        // // addListener() method is used to add a change listener to the text property
        // // (observable, oldValue, newValue) ->
        // // addButtonNode.setDisable(newValue.trim().isEmpty())
        // .addListener((observable, oldValue, newValue) ->
        // addButtonNode.setDisable(newValue.trim().isEmpty()));

        // // Set the result converter to return the property details entered
        // addPropertyDialog.setResultConverter(dialogButton -> {
        // if (dialogButton == addButton)
        // return propertyDetailsField.getText();
        // return null;
        // });

        // Show the add property dialog and wait for user input
        addPropertyDialog.showAndWait().ifPresent(propertyDetails -> {
            // Add the new property to the property list view
            propertyListView.getItems().add(propertyDetails);
        });
    }

    // This method is called when the customer login button is clicked
    private void openCustomerLogin() {
        // Create a dialog for login
        TextInputDialog loginDialog = new TextInputDialog();
        loginDialog.setTitle("Customer Login");
        loginDialog.setHeaderText("Please enter your username and password:");
        loginDialog.setContentText("Username:");

        // Show the login dialog and wait for user input
        Optional<String> usernameResult = loginDialog.showAndWait();

        // if the user enters a username
        if (usernameResult.isPresent()) {
            // Username entered, prompt for password
            loginDialog.getEditor().clear();
            loginDialog.setContentText("Password:");
            Optional<String> passwordResult = loginDialog.showAndWait();

            if (passwordResult.isPresent()) {
                // Password entered, validate login credentials
                String username = usernameResult.get();
                String password = passwordResult.get();

                // Perform login validation with the username and password entered, check if the
                // login is saved somewhere in the system
                boolean isLoginValid = validateCustomerLogin(username, password);

                // if the login is true
                if (isLoginValid) {
                    // Login successful, open owner screen method
                    openCustomerScreen(username);

                    // if the login is false
                } else {
                    // Login failed, show an error message ERROR EXCEPTION HANDLER (WE HAVE TO BUILD
                    // ONE)
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Login Failed");
                    alert.setHeaderText("Invalid username or password.");
                    alert.setContentText("Please try again.");
                    alert.showAndWait();
                }
            }
        }
    }

    // This method is called when the customer login information is correct
    private void openCustomerScreen(String username) {
        Stage customerStage = new Stage();
        customerStage.setTitle("Customer Login");
        Label titleLabel = new Label("Properties Available:");

        // Sets number of properties to display
        ArrayList<PropertyList> propertiesList = PropertyList.generateRandomPropertyList(14);

        // Create the grid pane
        GridPane gridPane = new GridPane();
        gridPane.setHgap(30);
        gridPane.setVgap(40);
        gridPane.setPadding(new Insets(20));
        gridPane.setAlignment(Pos.TOP_CENTER);

        int row = 0; // Row and col for gridpane
        int col = 0;

        // Method to add properties to gridpane
        for (PropertyList property : propertiesList) {
            String propertyString = String.format("%s %s %s %s\n %s %s", property.getAddress(),
                    property.getCity(), property.getState(), property.getZip(), "           Price: ",
                    property.getPrice(),
                    "Status:  ", property.getStatus());
            Label propertyLabel = new Label(propertyString);

            // Image for property
            String imagePath = PropertyImages.IMAGE_PATHS[(int) (Math.random() * PropertyImages.IMAGE_PATHS.length)];
            File image = new File(imagePath);
            ImageView propertyImage = new ImageView(new Image(image.toURI().toString()));
            propertyImage.setFitWidth(200);
            propertyImage.setFitHeight(150);
            propertyImage.setPreserveRatio(true);

            // VBox for image and label
            VBox propertyBox = new VBox(40);
            // make propertybox bold when mouse hovers
            // propertyBox.setOnMouseEntered(event ->
            // propertyLabel.setStyle("-fx-font-weight: bold"));
            propertyBox.getChildren().addAll(propertyImage, propertyLabel);
            gridPane.add(propertyBox, col, row);

            col++;
            while (col == 3) {
                col = 0;
                row++;
            }
        }

        // Add scroller to see all properties
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(gridPane);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        Scene scene = new Scene(scrollPane, 1100, 700);
        customerStage.setScene(scene);
        customerStage.show();

        // Add event listener for property
        for (Node node : gridPane.getChildren()) {
            if (node instanceof VBox) {
                VBox propertyBox = (VBox) node;
                Label propertyLabel = (Label) propertyBox.getChildren().get(1);
                PropertyList property = propertiesList.get(GridPane.getRowIndex(propertyBox));
                // make a property bold when mouse hovers over it
                propertyLabel
                        .setOnMouseEntered(event -> propertyLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12)));
                propertyLabel
                        .setOnMouseExited(event -> propertyLabel.setFont(Font.font("Verdana", FontWeight.NORMAL, 12)));
                // event listener for property that opens openPropertyDetails method
                propertyLabel.setOnMouseClicked(event -> openPropertyDetails(property));
            }
        }

    }

    /**
     * 
     * @param property
     */
    private void openPropertyDetails(PropertyList property) {
        Stage propertyStage = new Stage();
        propertyStage.setTitle("Property Details");
        Label titleLabel = new Label("Property Details:");

        // sets number of properties to display
        ArrayList<PropertyList> propertiesList = PropertyList.generateRandomPropertyList(27);

        // method to add properties to gridpane
        String propertyString = String.format("%s\n %s\n %s\n %s\n %s\n %s\n %s\n %s\n %s\n", "Address:  " +
                property.getAddress(), "Lease Duration:  " + property.getLease() + " months",
                "Rooms:  " + property.getRooms(),
                "Bathrooms:  " + property.getBaths(), "Closets:  " + property.getClosets(),
                "Garage:  " + property.getGarage(), "Property Type:  " + property.getType(),
                "Size:  " + property.getSqft() + " sq ft", "Price:  " + property.getPrice(),
                "Status:  " + property.getStatus());

        // NEED TO ADD *property.getBedrooms(), property.getBathrooms(),
        // property.getSquareFootage(),

        Label propertyLabel = new Label(propertyString);

        // Create a vertical layout for the owner screen
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.TOP_CENTER);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(titleLabel, propertyLabel);

        // Set the layout as the scene content
        Scene scene = new Scene(layout, 400, 300);
        propertyStage.setScene(scene);

        // Show the owner screen
        propertyStage.show();

    }

    // This method is called when the customer login information is correct
    private boolean validateCustomerLogin(String username, String password) {
        // Return true if the login is valid, false otherwise
        return username.equals("custo") && password.equals("custo1");
    }
}