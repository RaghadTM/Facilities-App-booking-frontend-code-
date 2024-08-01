// package com.example.sweproject;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class front1 extends Application {

    private String userType; // User type selected from the first code
    private String userName; // User name entered in the first interface
    private String userGender; // User gender selected in the first interface
    private Image logoImage; // Logo image
    private List<String> availableAppointments = new ArrayList<>();
    private Label cautionLabel; // Label for displaying caution message

    @Override
    public void start(Stage primaryStage) {
        // Create labels
        Label titleLabel = new Label("Registration System");
        Label nameLabel = new Label("Name:");
        Label emailLabel = new Label("Email:");
        Label passwordLabel = new Label("Password:");
        Label genderLabel = new Label("Gender:");
        Label contactLabel = new Label("Contact us: kfupmsystem.help@gmail.com");
        Label errorMessageLabel = new Label(""); // Label to display error messages

        // Set label colors and font
        titleLabel.setFont(Font.font("Arial", 20));
        nameLabel.setFont(Font.font("Arial", 16));
        emailLabel.setFont(Font.font("Arial", 16));
        passwordLabel.setFont(Font.font("Arial", 16));
        genderLabel.setFont(Font.font("Arial", 16));
        contactLabel.setFont(Font.font("Arial", 16));
        errorMessageLabel.setFont(Font.font("Arial", 14));
        errorMessageLabel.setTextFill(Color.RED); // Set text color to red for error messages

        // Create text fields
        TextField nameField = new TextField();
        PasswordField passwordField = new PasswordField();
        TextField emailField = new TextField();

        // Create choice box for gender selection
        ChoiceBox<String> genderChoiceBox = new ChoiceBox<>();
        genderChoiceBox.getItems().addAll("Male", "Female", "Other");

        // Create buttons
        Button studentButton = new Button("Student");
        Button adminButton = new Button("Admin");
        Button facultyButton = new Button("Faculty");

        // Set event handlers for the user type buttons
        studentButton.setOnAction(e -> {
            userType = "Student";
            userName = nameField.getText(); // Get the user name from the text field
            userGender = genderChoiceBox.getValue(); // Get the selected gender
            if (verifyCredentials(emailField.getText(), passwordField.getText())) {
                saveUserToFile("C:/Users/Ragha/IdeaProjects/swePROJECT/src/main/java/com/example/sweproject/user.txt", userName, userType, userGender); // Save user name, type,
                                                                                             // and gender to a text
                                                                                             // file
                openSecondInterface(primaryStage, logoImage); // Pass the logo image to the second interface
            } else {
                errorMessageLabel.setText("Incorrect email or password. Please try again.");
            }
        });
        adminButton.setOnAction(e -> {
            userType = "Admin";
            userName = nameField.getText(); // Get the user name from the text field
            userGender = genderChoiceBox.getValue(); // Get the selected gender
            if (verifyCredentials(emailField.getText(), passwordField.getText())) {
                saveUserToFile("C:/Users/Ragha/IdeaProjects/swePROJECT/src/main/java/com/example/sweproject/user.txt", userName, userType, userGender); // Save user name, type,
                                                                                             // and gender to a text
                                                                                             // file
                openSecondInterface(primaryStage, logoImage); // Pass the logo image to the second interface
            } else {
                errorMessageLabel.setText("Incorrect email or password. Please try again.");
            }
        });
        facultyButton.setOnAction(e -> {
            userType = "Faculty";
            userName = nameField.getText(); // Get the user name from the text field
            userGender = genderChoiceBox.getValue(); // Get the selected gender
            if (verifyCredentials(emailField.getText(), passwordField.getText())) {
                saveUserToFile("C:/Users/Ragha/IdeaProjects/swePROJECT/src/main/java/com/example/sweproject/user.txt", userName, userType, userGender); // Save user name, type,
                                                                                             // and gender to a text
                                                                                             // file
                openSecondInterface(primaryStage, logoImage); // Pass the logo image to the second interface
            } else {
                errorMessageLabel.setText("Incorrect email or password. Please try again.");
            }
        });

        // Load the logo image
        logoImage = new Image("file:C:/Users/Ragha/Downloads/kfupm-logo-en.png");

        // Create layout
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(
                titleLabel, nameLabel, nameField, emailLabel, emailField, passwordLabel, passwordField, genderLabel,
                genderChoiceBox, studentButton, adminButton, facultyButton, errorMessageLabel, contactLabel);

        // Set the background image
        Image backgroundImage = new Image("file:C:/Users/Ragha/Downloads/photo.jpg");
        BackgroundImage background = new BackgroundImage(
                backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        root.setBackground(new Background(background));
        // Add the logo image
        ImageView logoImageView = new ImageView(logoImage);
        logoImageView.setFitWidth(200); // Adjust the width as desired
        logoImageView.setPreserveRatio(true);

        // Create the logo label
        Label logoLabel = new Label();
        logoLabel.setGraphic(logoImageView);

        // Add the logo label to the layout
        root.getChildren().add(logoLabel);

        // Create the scene and set it on the stage
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Registration System");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void openSecondInterface(Stage primaryStage, Image logoImage) {
        // Read user name, type, and gender from file
        String[] userInfo = readUserFromFile("C:/Users/Ragha/IdeaProjects/swePROJECT/src/main/java/com/example/sweproject/user.txt");

        // Create labels for the second interface
        Label userLabel = new Label("User: " + userInfo[1]);
        userLabel.setFont(Font.font("Arial", 16));
        Label nameLabel = new Label("User Name: " + userInfo[0]);
        nameLabel.setFont(Font.font("Arial", 16));
        Label genderLabel = new Label("Gender: " + userInfo[2]);
        genderLabel.setFont(Font.font("Arial", 16));
        Label greetingLabel = new Label("Hello " + userInfo[0] + ", you are logged in as " + userInfo[1]);
        greetingLabel.setFont(Font.font("Arial", 16));
        Label titleLabel = new Label("Registration System");
        titleLabel.setFont(Font.font("Arial", 20));
        Label contactLabel = new Label("Contact us: kfupmsystem.help@gmail.com");
        contactLabel.setFont(Font.font("Arial", 14));

        // Create buttons for the second interface
        Button openRegistrationButton = createStyledButton("Start a Registration Event");
        Button viewRegistrationButton = createStyledButton("View My Registrations");
        Button reserveVenueButton = createStyledButton("Reserve a Venue");
        Button trackReservationButton = createStyledButton("View My Participations");
        Button registerEventButton = createStyledButton("Participate in an Event");

        // Set event handlers for buttons
        openRegistrationButton.setOnAction(e -> openRegistrationEventScene(primaryStage));
        viewRegistrationButton.setOnAction(e -> openViewReservationsScene(primaryStage,null));
        reserveVenueButton.setOnAction(e -> openVenueReservationPage(primaryStage, logoImage));
        trackReservationButton.setOnAction(e -> openviewParticipationScene(primaryStage,null));
        registerEventButton.setOnAction(e -> openParticipantRegistrationScene(primaryStage, availableAppointments));

        // Create layout for the second interface
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: white ; -fx-padding: 20;");
        root.getChildren().addAll(
                userLabel, nameLabel, genderLabel, greetingLabel, titleLabel, openRegistrationButton,
                viewRegistrationButton,
                reserveVenueButton, trackReservationButton, registerEventButton, contactLabel);

        // Add the logo image to the layout
        ImageView logoImageView = new ImageView(logoImage);
        logoImageView.setFitWidth(200); // Adjust the width as desired
        logoImageView.setPreserveRatio(true);

        // Create the logo label
        Label logoLabel = new Label();
        logoLabel.setGraphic(logoImageView);

        // Add the logo label to the layout
        root.getChildren().add(logoLabel);
        // Create a button to go back to the login scene
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            start(primaryStage); // Open the login scene
        });

        // Add the back button to the layout
        root.getChildren().add(backButton);
        // Create the scene and set it on the stage
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Registration System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private ComboBox<String> AllVenueComboBox(){
        ComboBox<String> venueComboBox = new ComboBox<>();
        File file=new File("C:/Users/Ragha/IdeaProjects/swePROJECT/src/main/java/com/example/sweproject/AllVenues.txt");
        String line="";
        try (Scanner sc = new Scanner(file)) {
            while(sc.hasNextLine()){
                line=sc.nextLine();
                if ((line.contains("Female") && userGender.equals("Male")) ||(line.contains("Male") && userGender.equals("Female"))) 
                {   
                    continue;
                }
                else if (userType.equals("Student") && ((line.startsWith("L")||line.startsWith("C"))))
                {
                        continue;
                }
                else{
                    venueComboBox.getItems().add(line);
                }

            }
        } catch (FileNotFoundException e1) {
            // e1.printStackTrace();
            System.out.println("File Not Found");
        }
        return venueComboBox;
    }
    private void openVenueReservationPage(Stage primaryStage, Image logoImage) {
        // Create labels and buttons for venue reservation
        Label venueLabel = new Label("Venue Name:");
        venueLabel.setFont(Font.font("Arial", 16));
        ComboBox<String> venueComboBox = AllVenueComboBox();
        venueComboBox.setPromptText("Select Venue");
        // Venue Reason Text Field
        Label reasonLabel = new Label("Venue Reason:");
        reasonLabel.setFont(Font.font("Arial", 16));
        TextField reasonTextField = new TextField();
        
        // Event Date DatePicker
        Label dateLabel = new Label("Event Date:");
        dateLabel.setFont(Font.font("Arial", 16));
        DatePicker datePicker = new DatePicker();
        
        // Event Time TextField
        Label timeLabel = new Label("Event Time:");
        timeLabel.setFont(Font.font("Arial", 16));
        TextField timeTextField = new TextField();
        
        // Submit Button
        Button submitButton = new Button("Submit");
        
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: white ; -fx-padding: 20;");
        root.getChildren().addAll(
                venueLabel, venueComboBox, reasonLabel, reasonTextField, dateLabel, datePicker, timeLabel, timeTextField, submitButton);
        
        // Add the logo image to the layout
        ImageView logoImageView = new ImageView(logoImage);
        logoImageView.setFitWidth(200);
        logoImageView.setPreserveRatio(true);
    
        // Create the logo label
        Label logoLabel = new Label();
        logoLabel.setGraphic(logoImageView);
    
        // Add the logo label to the layout
        root.getChildren().add(logoLabel);
    
        // Create a button to go back to the previous interface
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> openSecondInterface(primaryStage, logoImage));
        root.getChildren().add(backButton);
    
        // Create the scene and set it on the stage
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Venue Reservation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    

    private Button createVenueButton(String text, String venueType) {
        Button button = new Button(text);
        button.setFont(Font.font("Arial", 14));
        button.setStyle("-fx-background-color: darkgreen; -fx-text-fill: white; -fx-pref-width: 200;");
        button.setOnAction(e -> handleVenueReservation(venueType));
        return button;
    }

    private void handleVenueReservation(String venueType) {
        if (userType.equals("Student") && (venueType.equals("Labs") || venueType.equals("Classrooms"))) {
            // Display caution message for students trying to reserve labs or classrooms
            cautionLabel.setText("Note: Students cannot reserve Labs and Classrooms.");
        } else {
            // Handle reservation logic based on venue type
            // For now, just print the selected venue type
            System.out.println("Selected Venue: " + venueType);
        }
    }

    private Button createStyledButton(String text) {
        Button button = new Button(text);
        button.setFont(Font.font("Arial", 14));
        button.setStyle("-fx-background-color: darkgreen; -fx-text-fill: white; -fx-pref-width: 200;");
        return button;
    }

    private void saveUserToFile(String fileName, String userName, String userType, String userGender) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(userName + "," + userType + "," + userGender); // Write user name, type, and gender separated
                                                                        // by commas
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String[] readUserFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            return line.split(","); // Split the line into an array containing user name, type, and gender
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean verifyCredentials(String email, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Ragha/IdeaProjects/swePROJECT/src/main/java/com/example/sweproject/credentials.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(email) && parts[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }



    private void openRegistrationEventScene(Stage primaryStage) {
        // Create labels and input fields for event details
        Label eventNameLabel = new Label("Event Name:");
        TextField eventNameField = new TextField();
        Label eventDescriptionLabel = new Label("Event Reason:");
        TextArea eventDescriptionArea = new TextArea();
        Label maxParticipantsLabel = new Label("Maximum Participants:");
        Label minAttendeesLabel = new Label("Minimum Attendees:");
        TextField minAttendeesField = new TextField();
        TextField maxParticipantsField = new TextField();
        Label venueLabel = new Label("Select Venue:");
        ComboBox<String> venueChoiceBox = AllVenueComboBox();
        Label eventDateLabel = new Label("Event Date:");
        DatePicker eventDatePicker = new DatePicker();
        // Add available venues to the choice box
        Label eventTime=new Label("Event Time:");
        // Create a button to submit the event
        TextField eventTimeField = new TextField();
        Button submitButton = new Button("Submit Event");
        submitButton.setOnAction(e -> handleEventSubmission(eventNameField.getText(), eventDescriptionArea.getText(),
                Integer.parseInt(maxParticipantsField.getText()), venueChoiceBox.getValue()));

        // Create layout and scene
        VBox root = new VBox(10);
        root.getChildren().addAll(
                eventNameLabel, eventNameField,
                eventDescriptionLabel, eventDescriptionArea,
                maxParticipantsLabel, maxParticipantsField,minAttendeesLabel,minAttendeesField,eventDateLabel,eventDatePicker,eventTime,eventTimeField,
                venueLabel, venueChoiceBox,
                submitButton);
        Scene scene = new Scene(root, 500, 600);
        // Create a button to go back to the previous interface
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            openSecondInterface(primaryStage, logoImage); // Open the previous interface
        });

        // Add the back button to the layout
        root.getChildren().add(backButton);
        primaryStage.setTitle("Registration Event");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleEventSubmission(String eventName, String eventDescription, int maxParticipants, String venue) {
        // Handle the event submission logic here
        // You can save the event details to a file or database
        // and open a new scene for participants to register
    }

    private void openParticipantRegistrationScene(Stage primaryStage, List<String> eventNames) {
        // Create a dropdown to select event names
        Label eventNameLabel = new Label("Select Event:");
        eventNameLabel.setFont(Font.font("Arial", 16));
        ComboBox<String> eventNameComboBox = new ComboBox<>();
        eventNameComboBox.setPromptText("Select Event");
        eventNameComboBox.getItems().addAll(eventNames);
    
        // Create a button to participate in the selected event
        Button participateButton = new Button("Participate");
        participateButton.setOnAction(e -> handleParticipantRegistration(eventNameComboBox.getValue()));
    
        // Create layout and scene
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER); // Center align all elements
        root.getChildren().addAll(eventNameLabel, eventNameComboBox, participateButton);
    
        // Create a button to go back to the previous interface
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            openSecondInterface(primaryStage, logoImage); // Open the previous interface
        });
    
        // Add the back button to the layout
        root.getChildren().add(backButton);
    
        Scene scene = new Scene(root, 400, 200);
        primaryStage.setTitle("Participant Registration");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    

    private void handleParticipantRegistration(String participantName) {
        // Handle the participant registration logic here
        // You can add the participant name to the list view
        // and check if the maximum participants limit is reached
        // If reached, you can confirm the reservation and proceed to the next step
    }

    private void openViewReservationsScene(Stage primaryStage,ArrayList<Registration> reservations) {
        // Create a table view to display reservation details
        TableView<Registration> reservationTableView = new TableView<>();
        // Set up the table columns to display reservation details
        // Create layout and scene
        VBox root = new VBox(10);
        root.getChildren().addAll(
                new Label("Reservations:"),
                reservationTableView);
        // Create a button to go back to the previous interface
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            openSecondInterface(primaryStage, logoImage); // Open the previous interface
        });

        // Add the back button to the layout
        root.getChildren().add(backButton);
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("View My Reservations");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleReservationCancellation(Registration reservation) {
        // Handle the reservation cancellation logic here
        // You can remove the reservation from the list or database
        // and trigger the email sending process
        sendCancellationEmail(reservation.getParticipants());
    }

    private void sendCancellationEmail(List<String> participants) {
        // Open the default mail client on the machine
        // and prepare an email with a message body and title indicating the reservation
        // cancellation
        // You can use the `java.awt.Desktop` class to open the default mail client
    }

    private void openviewParticipationScene(Stage primaryStage,ArrayList<Registration> reservations) {
      // Create a table view to display reservation details
      TableView<Registration> reservationTableView = new TableView<>();
      // Set up the table columns to display reservation details
      // Create layout and scene
      VBox root = new VBox(10);
      root.getChildren().addAll(
              new Label("Participations:"),
              reservationTableView);
      // Create a button to go back to the previous interface
      Button backButton = new Button("Back");
      backButton.setOnAction(e -> {
          openSecondInterface(primaryStage, logoImage); // Open the previous interface
      });

      // Add the back button to the layout
      root.getChildren().add(backButton);
      Scene scene = new Scene(root, 600, 400);
      primaryStage.setTitle("View My Participations");
      primaryStage.setScene(scene);
      primaryStage.show();
    }    

    
    public static void main(String[] args) {
        launch(args);
    }
}
