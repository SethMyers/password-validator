package com.example.sethmyers1.passwordvalidator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public String validate(String s){
        String result;
        int pass=0;
        boolean digit=false;
        boolean up=false;
        boolean low=false;
        boolean special=false;
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i)))
                digit=true;
            if(Character.isUpperCase(s.charAt(i)))
                up=true;
            if(Character.isLowerCase(s.charAt(i)))
                low=true;
            if(!Character.isLetterOrDigit(s.charAt(i)))
                special=true;
        }
        if(special)
            pass++;
        if(low&&up)
            pass++;
        if(digit)
            pass++;
        if(s!="password")
            pass++;
        if(s.length()>8)
            pass++;
        if (pass<3)
            result="password strength: weak";
        else if(pass<5)
            result="password strength: medium";
        else
            result="password strength: strong";
        return result;
    }
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = validate(editText.getText().toString());
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
