package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainB {
    public static void main(String[] args) {
        try {
            URL documentForms = new URL("https://docs.google.com/forms/d/e/1FAIpQLSdV5QvhChK0fBpAMo5pN7sIvktqwHGu1vdoWJFvBguCeMvYUw/formResponse");
            HttpURLConnection connection = (HttpURLConnection) documentForms.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            try (OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream())) {
                writer.write("entry.835030737=Jonathan Carralerot&entry.1616686619=Si");
            }

            System.out.println("Resposta del codi: " + connection.getResponseCode());
        } catch (Exception e) {
            System.out.println("No s'han pogut enviar les dades al document forms de docs.");
        }
    }

}
