package com.example.second;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.second.databinding.ActivityMainBinding;

import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.btnWriteWish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.etMyWish.setVisibility(View.VISIBLE);
                binding.btnWriteWish.setVisibility(View.INVISIBLE);
                binding.btnPassWish.setVisibility(View.VISIBLE);
            }
        });

        binding.btnPassWish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wishText = binding.etMyWish.getText().toString();
                if (wishText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "НЕТ ТОГО, ЧТО МОЖНО ОТПРАВИТЬ", Toast.LENGTH_SHORT).show();
                } else {
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, wishText);
                    sendIntent.setType("text/plain");
                    startActivity(sendIntent);
                }
            }
        });

    }
}