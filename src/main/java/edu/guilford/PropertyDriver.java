package edu.guilford;

import javafx.application.Application;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
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
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
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
    // start() method is the main entry point for all JavaFX applications
    public void start(Stage primaryStage) {

        // sets the title of the window
        primaryStage.setTitle("Welcome Screen");

        // Create buttons for owner and customer login
        Button ownerLoginButton = new Button("Owner Login");
        Button customerLoginButton = new Button("Customer Login");

        // Set event handlers for the buttons to their respective methods
        ownerLoginButton.setOnAction(event -> openOwnerLogin());
        customerLoginButton.setOnAction(event -> openCustomerLogin());

        // Create a vertical layout and add the buttons to the center
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        // layout.setPadding(new Insets(20));
        layout.getChildren().addAll(ownerLoginButton, customerLoginButton);

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

        // Create dialog components
        // MAYBE THIS CAN BE PUT IN THE CLASS THAT CREATES THE NEW PROPERTYLISTVIEW
        TextField propertyDetailsField = new TextField();
        propertyDetailsField.setPromptText("Enter property details");

        // Set the dialog content to the property details text field
        addPropertyDialog.getDialogPane().setContent(propertyDetailsField);

        // Add buttons to the dialog
        // addButton has a button data of ok_done that means that the dialog will close
        // when the button is clicked successfully
        ButtonType addButton = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        // cancelButton has a button data of cancel_close that means that the dialog
        // will close when the button is clicked to cancel
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        // Add buttons to the dialog
        addPropertyDialog.getDialogPane().getButtonTypes().addAll(addButton, cancelButton);

        // Enable or disable the Add button based on the text input
        // Node is the base class for all UI components that can be added to a scene
        // graph. It represents a single element that can be displayed on the screen,
        // such as a button, label, or image.
        // lookupButton() method is used to lookup a button based on the button type
        Node addButtonNode = addPropertyDialog.getDialogPane().lookupButton(addButton);
        // setDisable() method is used to disable the button
        addButtonNode.setDisable(true);
        // textProperty() method is used to get the text property of the text field
        propertyDetailsField.textProperty()
                // addListener() method is used to add a change listener to the text property
                // (observable, oldValue, newValue) ->
                // addButtonNode.setDisable(newValue.trim().isEmpty())
                .addListener((observable, oldValue, newValue) -> addButtonNode.setDisable(newValue.trim().isEmpty()));

        // Set the result converter to return the property details entered
        addPropertyDialog.setResultConverter(dialogButton -> {
            if (dialogButton == addButton)
                return propertyDetailsField.getText();
            return null;
        });

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
        ArrayList<PropertyList> propertiesList = PropertyList.generateRandomPropertyList(27);

        // Create the grid pane
        GridPane gridPane = new GridPane();
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(20));
        gridPane.setAlignment(Pos.TOP_CENTER);

        int row = 0; // Row and col for gridpane
        int col = 0;

        // Method to add properties to gridpane
        for (PropertyList property : propertiesList) {
            String propertyString = String.format("%s, %s, %s %s - %s %s", property.getAddress(),
                    property.getCity(), property.getState(), property.getZip(), property.getPrice(),
                    property.getStatus());
            Label propertyLabel = new Label(propertyString);

            // Image for property
            String imagePath = PropertyImages.IMAGE_PATHS[(int) (Math.random() * PropertyImages.IMAGE_PATHS.length)];
            File image = new File(imagePath);
            ImageView propertyImage = new ImageView(new Image(image.toURI().toString()));
            propertyImage.setFitWidth(200);
            propertyImage.setFitHeight(200);
            propertyImage.setPreserveRatio(true);

            // VBox for image and label
            VBox propertyBox = new VBox(10);
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
                // event listener for property that opens openPropertyDetails method
                // propertyLabel.setOnMouseClicked(event -> openPropertyDetails(property));
            }
        }
    }

    private void openPropertyDetails(PropertyInformation property) {
        Stage propertyStage = new Stage();
        propertyStage.setTitle("Property Details");
        Label titleLabel = new Label("Property Details:");

        // Sets number of properties to display
        ArrayList<PropertyInformation> propertiesList = PropertyInformation.generateRandomPropertyInformation(27);

        // Method to add properties to gridpane
        String propertyString = String.format("%s, %s, %s %s \n%s \n%s \n%s \n%s\n%s", property.getAddress(),
                property.getSaleRent(), property.getPrice(), property.getLease(), property.getRooms(),
                property.getBaths(), property.getClosets(), property.getGarage(), property.getType(),
                property.getSqft());

        Text propertyText = new Text(propertyString);
        propertyText.setWrappingWidth(350);

        // Create a vertical layout for the owner screen
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.TOP_CENTER);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(titleLabel, propertyText);
        // Set the layout as the scene content
        Scene scene = new Scene(layout, 400, 300);
        propertyStage.setScene(scene);

        // Show the property details screen
        propertyStage.show();
    }

    // This method is called when the customer login information is correct
    private boolean validateCustomerLogin(String username, String password) {
        // Return true if the login is valid, false otherwise
        return username.equals("custo") && password.equals("custo1");
    }
}