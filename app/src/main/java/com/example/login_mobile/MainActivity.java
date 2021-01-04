package com.example.login_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    //ATTRIBUTS
    Button btnValider;
    EditText courriel_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getElementReference();
    }

    public void getElementReference()
    {
        btnValider = (Button) findViewById(R.id.btnValider);
        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validerCourriel();
            }
        });
    }

    public void validerCourriel()
    {
        courriel_input = (EditText)findViewById(R.id.inputTextCourriel);
        String courriel = courriel_input.getText().toString();
        TextView msg = (TextView)findViewById(R.id.msgShow);

        //CREER LE REGEX POUR LE COURRIEL
        String courrielPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        Pattern p = Pattern.compile(courrielPattern);

        //CHECK IF MATCH
        Matcher m = p.matcher(courriel);

        //SI le courriel ne match pas
        if (!m.matches()){
            msg.setText("Courriel invalide!");
        }else
            msg.setText("Bravo!");
        // Tast.makeText(MainActivity.this, R.string.msg, //Toast.LENGHT_SHORT).show();
        // Toast.makeText(v.getContext(), "Bravo !  ", Toast.LENGTH_LONG).show();
    }

}