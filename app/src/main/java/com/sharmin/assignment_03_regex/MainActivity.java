package com.sharmin.assignment_03_regex;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Ensure your XML layout file name is correct


        final EditText firstName = findViewById(R.id.firstName_input);
        final EditText lastName = findViewById(R.id.lastName_input);
        final EditText email = findViewById(R.id.email_input);
        final EditText password = findViewById(R.id.password_input);
        final EditText confirmPassword = findViewById(R.id.confirmPassword_input);

        // Email validation
        final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        // Sign-up button
        TextView signUpBtn = findViewById(R.id.signUpBtn);

        // Set up click listener for sign-up button
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // input values as strings
                String firstNameInput = firstName.getText().toString().trim();
                String lastNameInput = lastName.getText().toString().trim();
                String emailInput = email.getText().toString().trim();
                String passwordInput = password.getText().toString().trim();
                String confirmPasswordInput = confirmPassword.getText().toString().trim();

                // Validate the inputs
                if (firstNameInput.isEmpty()) {
                    firstName.setError("First Name can't be empty");
                    firstName.requestFocus();
                } else if (lastNameInput.isEmpty()) {
                    lastName.setError("Last Name can't be empty");
                    lastName.requestFocus();
                } else if (emailInput.isEmpty()) {
                    email.setError("Email can't be empty");
                    email.requestFocus();
                } else if (!emailInput.matches(emailPattern)) {
                    email.setError("Enter a valid email address");
                    email.requestFocus();
                } else if (passwordInput.isEmpty()) {
                    password.setError("Password can't be empty");
                    password.requestFocus();
                } else if (confirmPasswordInput.isEmpty()) {
                    confirmPassword.setError("Confirm Password can't be empty");
                    confirmPassword.requestFocus();
                } else if (!confirmPasswordInput.equals(passwordInput)) {
                    confirmPassword.setError("Passwords do not match");
                    confirmPassword.requestFocus();
                } else {

                    Toast.makeText(MainActivity.this, "Successfully created account", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Add TextWatchers to clear error messages
        addTextWatchers(firstName);
        addTextWatchers(lastName);
        addTextWatchers(email);
        addTextWatchers(password);
        addTextWatchers(confirmPassword);
    }


    private void addTextWatchers(final EditText editText) {
        editText.addTextChangedListener(new android.text.TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editText.setError(null);
            }

            @Override
            public void afterTextChanged(android.text.Editable s) {}
        });
    }
}
