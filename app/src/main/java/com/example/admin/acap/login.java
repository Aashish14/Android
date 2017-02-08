package com.example.admin.acap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity
{
    Button btLogin;
    com.example.admin.acap.LoginDataBaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        loginDataBaseAdapter = new com.example.admin.acap.LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();

        //btLogin = (Button) findViewById(R.id.btlogin);
        final EditText etUsername = (EditText)findViewById(R.id.etusername);
        final EditText etPassword = (EditText)findViewById(R.id.etpassword);

        Button btLogin = (Button)findViewById(R.id.btlogin);

        btLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String Username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String storedPassword = loginDataBaseAdapter.getSinlgeEntry(Username);
                if (password.equals(storedPassword))
                {
                    Toast.makeText(login.this,"Congrats: Login Successfull", Toast.LENGTH_LONG).show();
                    EditText ed1;
                    ed1 = (EditText)findViewById(R.id.etusername);
                    String value = ed1.getText().toString();
                    Intent intent = new Intent(login.this, choice.class);
                    intent.putExtra("Username",value);
                    startActivity(intent);


                    //startActivity(intent);
                }
                else
                {
                    Toast.makeText(login.this,"User Name or Password does not match",
                            Toast.LENGTH_LONG).show();
                }
            }
        });



    }





    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginDataBaseAdapter.close();
    }
    public void register1(View view)
    {
        Intent intent = new Intent(this, register.class);
        startActivity(intent);
    }
}

