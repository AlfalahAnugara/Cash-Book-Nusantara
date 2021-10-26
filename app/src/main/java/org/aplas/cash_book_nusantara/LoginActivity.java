package org.aplas.cash_book_nusantara;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText idUsername, idPassword;
    Button loginButton ;

    DBHelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbhelper = new DBHelper(getApplicationContext());

        idUsername = (EditText)findViewById(R.id.idUsername);
        idPassword = (EditText)findViewById(R.id.idPassword);
        loginButton = (Button)findViewById(R.id.loginButton);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = idUsername.getText().toString();
                String password = idPassword.getText().toString();

                Account account = dbhelper.login(username, password);
                if(account != null){
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    intent.putExtra("account", account);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this, "Username or Password Doesn't Match", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}