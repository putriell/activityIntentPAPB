package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.menu.MainActivity;
import com.example.menu.R;

public class SecondActivity extends AppCompatActivity {

    TextView Pesanan;
    TextView Pesanan2;
    Button btnOK;
    EditText Jumlah;
    public static final String REPLY_EXTRA = "REPLY_KEY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Pesanan = findViewById(R.id.Pesanan);
        Pesanan2 = findViewById(R.id.Pesanan2);
        btnOK = findViewById(R.id.btnOK);
        Jumlah = findViewById(R.id.Jumlah);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.MESSAGE_EXTRA);
        String message2 = intent.getStringExtra(MainActivity.MESSAGE_EXTRA2);
        Pesanan.setText(message);
        Pesanan2.setText(message2);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String messageReply = Jumlah.getText().toString();
                intent.putExtra(REPLY_EXTRA,messageReply);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}