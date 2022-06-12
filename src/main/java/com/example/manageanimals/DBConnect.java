package com.example.manageanimals;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DBConnect{
    private Connection connection;

    public DBConnect() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/animals", "root", ""
            );
            System.out.println("Connect successfully!!!");

        } catch (SQLException e) {
            connection = null;
            System.out.println(e);
        }
    }
    public List<Animals> getAnimals() {
        ArrayList<Animals> animals = new ArrayList<>();
        try {
            ResultSet result = connection.prepareStatement("SELECT * FROM animals").executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String type = result.getString("type");
                String gender = result.getString("gender");
                String image = result.getString("image");
                float weight = result.getFloat("weight");
                float height = result.getFloat("height");
                String birthday = result.getString("birthday");
                float price =result.getFloat("price");

                System.out.println(id);
                System.out.println(name);
                System.out.println(type);
                System.out.println(gender);
                System.out.println(image);
                System.out.println(weight);
                System.out.println(height);
                System.out.println(birthday);
                System.out.println(price);

                animals.add(new Animals(id,name,type,gender,image,weight,height,birthday,price));
            }
            System.out.println("Success!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return animals;
    }
    public void insertAnimals(Animals animals){

        String sql = "INSERT INTO animals (name,type,gender,image,weight,height,birthday,price) VALUES ('"+animals.name+"','"+animals.type+"','"
                +animals.gender+"','"+animals.image+"',"+animals.weight+","+
                animals.height+",'"+animals.birthday+"',"+animals.price+")";
        System.out.println(sql);
        try {
            connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateAnimals(Animals animals){
        String sql = "UPDATE animals SET name = '"+ animals.name +"', type = '"+animals.type+"', gender = '"
                +animals.gender+"', image = '"+animals.image+"',weight='"+animals.weight+"',height='"+animals.height
                +"',birthday='"+animals.birthday+"',price='"+animals.price
                +"' WHERE id = "+ animals.id;
    try {
        connection.prepareStatement(sql).executeUpdate();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
    public void deleteAnimals (int id){
        String sql= "DELETE from animals WHERE id="+id;
        System.out.println(sql);
        try {
            connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

