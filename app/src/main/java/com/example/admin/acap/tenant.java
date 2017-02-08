package com.example.admin.acap;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class tenant extends AppCompatActivity
{
    LoginDataBaseAdapter loginDataBaseAdapter;
    Button btmatch;
    Spinner sp;
    TextView text;
    ArrayList<String> names = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tenant);

       loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();
        sp = (Spinner)findViewById(R.id.spinner);

        //adapter
        adapter= new ArrayAdapter<String>(this,R.layout.list,R.id.a, names);
        sp.setAdapter(adapter);

       sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
           public void onItemSelected(AdapterView<?> parentView, View v, int position, long id)
            {
                Toast.makeText(getBaseContext(),parentView.getItemIdAtPosition(position)+"selected",Toast.LENGTH_SHORT).show();
                Intent ii = new Intent(tenant.this, match.class);
                startActivity(ii);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });


        String username= getIntent().getStringExtra("Username");
        TextView tv = (TextView)(findViewById(R.id.etusername));
        tv.setText(username);



     }





    public void matchh(View V)
    {


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginDataBaseAdapter.close();
    }

}