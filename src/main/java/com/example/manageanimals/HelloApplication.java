package com.example.manageanimals;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;

public class HelloApplication extends Application {

    Label lbName = new Label("Enter name:");
    TextField tfName = new TextField();


    Label lbType = new Label("Enter type:");
    TextField tfType = new TextField();


    Label lbGender = new Label("Enter gender:");
    TextField tfGender = new TextField();


    Label lbImage = new Label("Enter image:");
    TextField tfImage = new TextField();


    Label lbWeight = new Label("Enter weight:");
    TextField tfWeight = new TextField();


    Label lbHeight = new Label("Enter height:");
    TextField tfHeight = new TextField();


    Label lbBirthday = new Label("Enter birthday:");
    TextField tfBirthday = new TextField();


    Label lbPrice = new Label("Enter price:");
    TextField tfPrice = new TextField();


    @Override
    public void start(Stage stage) throws IOException {

        boolean status = false;

        DBConnect connection = new DBConnect();

        VBox root = new VBox();

        VBox animalsRoot = new VBox();

        VBox vInsertAnimals = new VBox();

        Button btnAdd = new Button("Add");
        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                connection.insertAnimals(new Animals(tfName.getText(),tfType.getText(),
                        tfGender.getText(),tfImage.getText(),Float.parseFloat(tfWeight.getText()),
                        Float.parseFloat(tfHeight.getText()), tfBirthday.getText(), Float.parseFloat(tfPrice.getText())));
                getThenDisplayStudents(animalsRoot, connection);
            }
        });

        Button btnEdit = new Button("Update");
        btnEdit.setOnAction(event -> {
            connection.updateAnimals(new Animals(tfName.getText(),tfType.getText(),
                    tfGender.getText(),tfImage.getText(),Float.parseFloat(tfWeight.getText()),
                    Float.parseFloat(tfHeight.getText()), tfBirthday.getText(), Float.parseFloat(tfPrice.getText()),Integer.parseInt(tfName.getId())));
            getThenDisplayStudents(animalsRoot, connection);
        });

        vInsertAnimals.getChildren().addAll(lbName, tfName, lbType, tfType ,lbGender, tfGender,lbImage,tfImage,
                lbWeight,tfWeight,lbHeight, tfHeight, lbBirthday, tfBirthday,lbPrice, tfPrice, btnAdd, btnEdit);

        root.getChildren().addAll(vInsertAnimals, animalsRoot);

        getThenDisplayStudents(animalsRoot, connection);

        Scene scene = new Scene(root, 1500, 800);
        stage.setTitle("Welocome !");
        stage.setScene(scene);
        stage.show();
    }

    void displayStudents(DBConnect connection, VBox root, List<Animals> animals) {
        root.getChildren().clear();
        for (int i = 0; i < animals.size(); i++) {
            final int finialI = i;
            HBox animalBox = new HBox();
            Label lbId = new Label("" + animals.get(i).id);
            Label lbName = new Label(animals.get(i).name);
            Label lbType = new Label("" + animals.get(i).type);
            Label lbGender = new Label(animals.get(i).gender);
            Label lbImage = new Label("" + animals.get(i).image);
            Image image = new Image(""+animals.get(i).image);
            ImageView imageView = new ImageView();
            imageView.setImage(image);
            imageView.setFitWidth(100);
            imageView.setFitHeight(100);

            imageView.setPreserveRatio(true);



            Label lbWeight= new Label(""+animals.get(i).weight);
            Label lbHeight = new Label("" + animals.get(i).height);
            Label lbBirthday= new Label(""+animals.get(i).birthday);
            Label lbPrice = new Label("" + animals.get(i).price);


            Button btnDelete = new Button("Delete");
            btnDelete.setOnAction(actionEvent -> {
                System.out.println("Click delete " + animals.get(finialI).id);

                connection.deleteAnimals(animals.get(finialI).id);
                getThenDisplayStudents(root, connection);



            });
            Button btnUpdate = new Button("Update");
            btnUpdate.setOnAction(actionEvent->{
                tfName.setText(String.valueOf((animals.get(finialI).name)));
                tfType.setText(String.valueOf((animals.get(finialI).type)));
                tfName.setId(""+animals.get(finialI).id);
                tfGender.setText(String.valueOf((animals.get(finialI).gender)));
                tfImage.setText(String.valueOf((animals.get(finialI).image)));
                tfWeight.setText(String.valueOf((animals.get(finialI).weight)));
                tfHeight.setText(String.valueOf((animals.get(finialI).height)));
                tfBirthday.setText(String.valueOf((animals.get(finialI).birthday)));
                tfPrice.setText(String.valueOf((animals.get(finialI).price)));
            });
            animalBox.setSpacing(70);
            animalBox.getChildren().addAll(lbId, lbName, lbType,lbGender,imageView,lbWeight,lbHeight,lbBirthday,lbPrice, btnDelete, btnUpdate);
            root.getChildren().add(animalBox);
        }
    }

    private void getThenDisplayStudents(VBox root, DBConnect connection) {
        List<Animals> animals = connection.getAnimals();
        displayStudents(connection, root, animals);
    }

    public static void main(String[] args) {
        launch();
    }
}
