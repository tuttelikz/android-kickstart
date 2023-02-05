package com.soialab.askaruly.internalstorage1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.usermnameTextEdit);
        password = (EditText)findViewById(R.id.passwordTextEdit);
    }

    public void save(View view) {
        String text1 = username.getText().toString();
        String text2 = password.getText().toString();

        text1 = text1 + " ";
        File file = null;
        FileOutputStream fileOutputStream = null;
        try {
            file=getFilesDir();
            fileOutputStream = openFileOutput("vivz.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(text1.getBytes());
            fileOutputStream.write(text2.getBytes());

        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            Log.d("VIVZ",e.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Toast.makeText(this,"Saved successfully " +file+"/vivz.txt",Toast.LENGTH_SHORT).show();
    }

    public void next(View view) {
        Toast.makeText(this,"Next called",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
}
