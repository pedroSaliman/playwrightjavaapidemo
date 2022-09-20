package org.example;

public class Data {


    public static String api(){

        return "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
    }
    public static String put(){

        return "{\n" +
                "    \"name\": \"mohamed\",\n" +
                "    \"job\": \"tester\"\n" +
                "}";
    }
    public static String register() {
        return "{\n" +
                "    \"email\": \"eve.hffflt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}";


    }
    public static String login() {
        return "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"cityslicka\"\n" +
                "}";
    }
}
