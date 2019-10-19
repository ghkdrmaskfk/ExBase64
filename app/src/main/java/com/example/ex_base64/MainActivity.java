package com.example.ex_base64;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button encryptBtn, decryptBtn, okBtn, removeBtn;
    private EditText editText;
    private TextView textView;
    private String base64;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById();

        encryptBtn.setOnClickListener(this);
        decryptBtn.setOnClickListener(this);
        okBtn.setOnClickListener(this);
        removeBtn.setOnClickListener(this);

    }

    private void findViewById() {

        textView = findViewById(R.id.text_view);

        editText = findViewById(R.id.edit_text);

        encryptBtn = findViewById(R.id.encrypt_btn);
        decryptBtn = findViewById(R.id.decrypt_btn);
        okBtn = findViewById(R.id.ok_btn);
        removeBtn = findViewById(R.id.remove_btn);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.encrypt_btn:

                try {

                    byte[] encrypt = editText.getText().toString().getBytes("UTF-8");
                    base64 = Base64.encodeToString(encrypt, Base64.DEFAULT);

                    textView.setText(base64);

                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;

            case R.id.decrypt_btn:

                try {

                    byte[] decrypt = Base64.decode(base64, Base64.DEFAULT);
                    textView.setText(new String(decrypt,"UTF-8"));

                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;

            case R.id.ok_btn:

                textView.setText(editText.getText().toString());

                break;

            case R.id.remove_btn:

                textView.setText("");

                break;
        }
    }
}
