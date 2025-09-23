package utils;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakerDataGenerator {

    static Faker faker = new Faker();

    public static String firstName =faker.name().firstName();
    public static String address =faker.address().cityName();
    public static String surname =faker.name().lastName();

}
