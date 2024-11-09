package com.example.reza;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText UserName = findViewById(R.id.editTextUserName);
        EditText Password = findViewById(R.id.editTextPassword);
        Button btnOk = findViewById(R.id.btnOk);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = UserName.getText().toString();
                String password = Password.getText().toString();
                if (username.isEmpty() && password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "fields are empty", Toast.LENGTH_SHORT).show();
                } else {
                    if (username.equals("reza") && password.equals("1320")) {
                        Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, LinkActivity.class);
                        intent.putExtra("userName" ,username);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}