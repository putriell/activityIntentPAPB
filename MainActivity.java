package com.example.menu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.menu.SecondActivity;
import com.example.menu.R;


public class MainActivity extends AppCompatActivity {

    EditText Pesanan;
    Button Makanan;
    Button Minuman;
    TextView Hasil;
    public static final String MESSAGE_EXTRA = "MESSAGE_KEY";
    public static final String MESSAGE_EXTRA2 = "MESSAGE_KEY2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MAIN ACTIVITY", "on create");
        Pesanan = findViewById(R.id.Pesanan);
        Makanan = findViewById(R.id.Makanan);
        Minuman = findViewById(R.id.Minuman);
        Hasil = findViewById(R.id.Hasil);

        Makanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SecondActivity.class);
                String message = Pesanan.getText().toString();
                String message2 = "Makanan";
                intent.putExtra(MESSAGE_EXTRA2, message2);
                intent.putExtra(MESSAGE_EXTRA, message);
                startActivityForResult(intent, 1);
            }
        });

        Minuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SecondActivity.class);
                String message = Pesanan.getText().toString();
                String message2 = "Minuman";
                intent.putExtra(MESSAGE_EXTRA2, message2);
                intent.putExtra(MESSAGE_EXTRA, message);
                startActivityForResult(intent, 1);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            String replyText = data.getStringExtra(SecondActivity.REPLY_EXTRA);
            Hasil.setText(replyText);
        }
    }

}