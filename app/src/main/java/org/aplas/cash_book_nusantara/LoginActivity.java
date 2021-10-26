package org.aplas.cash_book_nusantara;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username, password ;
    Button loginbutton ;
    DBHelper DB ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        loginbutton = (Button) findViewById(R.id.loginbutton);
        DB = new DBHelper(this) ;

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")|pass.equals(""))
                    Toast.makeText(LoginActivity.this, "Please enter all the fields" ,Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamenamepassword(user,pass);
                    if(checkuserpass==true) {
                        Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), org.aplas.cash_book_nusantara.HomeActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                    }
                }



            }
        });
    }
}