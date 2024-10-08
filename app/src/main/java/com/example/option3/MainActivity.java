package com.example.option3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.example.option3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Set Layout

        // Download the public key from the URL
        String publicKey = PublicKeyDownloader.downloadPublicKey("https://demo.api.piperks.com/.well-known/pi-xcels.json");

        if (publicKey != null) {
            String input = "SensitiveData";
            // Pass the public key and input data to the native method for hashing and encryption
            String encryptedData = hashAndEncrypt(input, publicKey);
            Log.d("EncryptionResult", "Encrypted Hash: " + encryptedData);
        } else {
            Log.e("EncryptionError", "Failed to download public key");
        }
    }

    // Declare the native method that takes input and public key (Implemented in C++)
    public native String hashAndEncrypt(String input, String publicKey);
}
