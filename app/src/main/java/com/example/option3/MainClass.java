package com.example.option3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainClass {

    // Load native library
    static {
        System.loadLibrary("native-lib");
    }

    public static void main(String[] args) {
        String publicKeyUrl = "https://demo.api.piperks.com/.well-known/pi-xcels.json";
        String publicKey = downloadPublicKey(publicKeyUrl);

        if (publicKey != null) {
            String input = "SensitiveData";
            // Call the native method for hashing and encryption
            String encryptedData = new MainClass().hashAndEncrypt(input, publicKey);
            System.out.println("Encrypted Hash: " + encryptedData);
        } else {
            System.err.println("Failed to download public key.");
        }
    }

    // Download the public key from the specified URL
    private static String downloadPublicKey(String publicKeyUrl) {
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(publicKeyUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000); // Set timeout
            connection.setReadTimeout(5000);

            // Check if the request was successful
            if (connection.getResponseCode() == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
                reader.close();
            } else {
                System.err.println("Error: " + connection.getResponseCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    // Declare the native method
    public native String hashAndEncrypt(String input, String publicKey);
}
