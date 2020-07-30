package com.pallab.ttsenginesample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TTS tts;
    private Button text_to_speech;
    private EditText text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tts = new TTS(this, Locale.ENGLISH);
        text_to_speech = findViewById(R.id.button_text_to_speech);
        text = findViewById(R.id.editText);

        text_to_speech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts.speak(text.getText().toString());
            }
        });

    }
    @Override
    protected void onDestroy() {

        if(tts != null && tts.isSpeaking()) {
            tts.stop();
        }

        if(tts != null) {
            tts.shutdown();
        }

        tts = null;

        super.onDestroy();
    }

}