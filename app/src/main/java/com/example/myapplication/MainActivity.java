package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    EditText FirstName, LastName, Email, Password;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FirstName = findViewById(R.id.FirstName);
        LastName = findViewById(R.id.LastName);
        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);
        btnRegister = findViewById(R.id.btnRegister);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String firstName = FirstName.getText().toString().trim();
                String lastName = LastName.getText().toString().trim();
                String email = Email.getText().toString().trim();
                String password = Password.getText().toString().trim();


                if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Uzupełnij wszystkie pola", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (!email.contains("@") || !email.contains(".")) {
                    Email.setError("Podaj poprawny adres email");
                    return;
                }


                boolean hasUpper = false;
                boolean hasLower = false;
                boolean hasSpecial = false;
                String specialCharacters = "!@#$%^&*()_+-=[]{};':\",.<>/?\\|`~";


                for (int i = 0; i < password.length(); i++) {
                    char c = password.charAt(i);
                    if (Character.isUpperCase(c)) {
                        hasUpper = true;
                    } else if (Character.isLowerCase(c)) {
                        hasLower = true;
                    } else if (specialCharacters.contains(String.valueOf(c))) {
                        hasSpecial = true;
                    }
                }


                if (password.length() < 8 || !hasUpper || !hasLower || !hasSpecial) {
                    String errorMsg = "Hasło musi mieć co najmniej 8 znaków";

                    if (!hasUpper) {
                        errorMsg += ", Dużą literę";
                    }
                    if (!hasLower) {
                        errorMsg += ", Małą literę";
                    }
                    if (!hasSpecial) {
                        errorMsg += ", znak specjalny";
                    }

                    Password.setError(errorMsg);
                    return;
                }


                Toast.makeText(MainActivity.this, "Dane są poprawne", Toast.LENGTH_LONG).show();
            }
        });
    }
}
