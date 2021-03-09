package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;

    public void GenerateRandomNumber()
    {
        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1;
    }


    public void Guess(View view)
    {
        EditText editText = (EditText)findViewById(R.id.editTextNumber);

        String message;

        if(editText.getText().toString().isEmpty())
        {
            Log.i("help","a");
            message = "Please enter a number";
        }
        else
        {
        int guessValue = Integer.parseInt(editText.getText().toString());

          if(guessValue > randomNumber)
            {
                message = "Lower";
            }
            else if(guessValue < randomNumber)
            {
                message = "Higher";
            }
            else
            {
                message="You got it";
                GenerateRandomNumber();
            }
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();


       // Log.i("info", Integer.toString(randomNumber));


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GenerateRandomNumber();

    }
}