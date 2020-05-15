package com.example.sqlitedatabase;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editname,editsurname,editmarks;
    Button add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        myDb = new DatabaseHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editname= (EditText)findViewById(R.id.editname);
        editsurname= (EditText)findViewById(R.id.editsurname);
        editmarks= (EditText)findViewById(R.id.editmarks);
        add=(Button)findViewById(R.id.add);
        addData();



    }

    public void addData(){

        add.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        boolean isInserted= myDb.insertData(editname.getText().toString(),editsurname.getText().toString(),editmarks.getText().toString());
                        if (isInserted==true)
                            Toast.makeText(MainActivity.this,"Data is inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "Data is not inserted", Toast.LENGTH_LONG).show();
                    }
                }
        );

    }


}
