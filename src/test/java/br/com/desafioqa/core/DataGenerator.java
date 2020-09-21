package br.com.desafioqa.core;

import com.github.javafaker.Faker;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataGenerator {
    Faker faker = new Faker();
    private final String firstName = faker.name().firstName();
    private final String lastName = faker.name().lastName();
    private final String fullName = firstName + " " + lastName;
    private final String company = faker.company().name();
    private final String name = faker.name().fullName();
    private final Date birthDate = faker.date().birthday(18, 100);
    private final String email = name.toLowerCase().replace(" ", "").concat("@gmail.com");
    private SimpleDateFormat formatter;
    private final String phoneNumber = faker.phoneNumber().phoneNumber();
    private final String password = "PassWord@20";
    private final String zipCode = faker.address().zipCode();

    @Test
    public void testzipcode(){
        System.out.println(zipCode);



    }
    public DataGenerator(){
        this.formatter = new SimpleDateFormat("yyyyMMdd");
    }

    public String getCompany(){return company; }
    public String getAddressLine1(){return faker.address().streetAddress(); }
    public String getAddressLine2(){return faker.address().buildingNumber();}
    public String getCity(){return faker.address().city(); }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }



}