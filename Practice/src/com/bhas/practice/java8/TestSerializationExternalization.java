package com.bhas.practice.java8;

import java.io.*;
import java.util.Objects;

public class TestSerializationExternalization {

    public static void main(String[] args) {
        Human h = new Human();
        h.setPersonType("Musician");
        h.setName("Test");
        h.setAddress("Test Address");
        try{
            FileOutputStream file = new FileOutputStream
                    ("/tmp/data.txt");
            ObjectOutputStream out = new ObjectOutputStream
                    (file);

            // Method for serialization of object
            out.writeObject(h);

            out.close();
            file.close();
        }catch(Exception ex){
            System.out.println("Error serialization class ");
        }

        try{
            FileInputStream file = new FileInputStream
                    ("/tmp/data.txt");
            ObjectInputStream in = new ObjectInputStream
                    (file);

            // Method for deserialization of object
            Human obj = (Human)in.readObject();
            System.out.println(obj);
        }catch(Exception ex){
            System.out.println("Error serialization class ");
        }
    }

}

class Person{

    private static long SERIALVERSION_UID = 23424234234234234l;

    private String name;

    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getName(), person.getName()) &&
                Objects.equals(getAddress(), person.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAddress());
    }
}

class Human extends Person implements Serializable{

    private String personType;

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    @Override
    public String toString() {
        return "Human{" +
                "personType='" + personType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return Objects.equals(getPersonType(), human.getPersonType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPersonType());
    }
}