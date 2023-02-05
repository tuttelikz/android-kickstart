package com.soialab.askaruly.internalstorage1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SecondActivity extends AppCompatActivity {

    TextView username;
    TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        username = (TextView)findViewById(R.id.usermnameTextView);
        password = (TextView)findViewById(R.id.passwordTextView);
    }

    public void load(View view) {
        try {
            FileInputStream fileInputStream = openFileInput("vivz.txt");
            int read = -1;
            StringBuffer buffer = new StringBuffer();
            while((read=fileInputStream.read())!=-1) {
                buffer.append((char) read);
            }
            Log.d("VIVZ",buffer.toString());
            String text1 = buffer.substring(0,buffer.indexOf(" "));
            String text2 = buffer.substring(buffer.indexOf(" "+1));

            username.setText(text1);
            password.setText(text2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Toast.makeText(this,"Load successful",Toast.LENGTH_SHORT).show();
    }

    public void previous(View view) {
        Toast.makeText(this,"Previous called",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
