package com.example.guestvillaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.guestvillaproject.databinding.ActivityUserBinding;
import com.example.guestvillaproject.databinding.ActivityUserPageBinding;

public class UserActivity extends AppCompatActivity {
    ActivityUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent=this.getIntent();

        if(intent!=null){
            String name=intent.getStringExtra("name");
            String phone=intent.getStringExtra("phone");
//            String country=intent.getStringExtra("country");
            String lastMessage=intent.getStringExtra("lastMessage");
            int imageid=intent.getIntExtra("imageid",R.drawable.a);

            binding.nameProfile.setText(name);
            binding.phoneProfile.setText(phone);
            binding.countryProfile.setText(lastMessage);
            binding.profileImage.setImageResource(imageid);

        }
    }
}