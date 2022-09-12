package com.example.guestvillaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import com.example.guestvillaproject.databinding.ActivityUserPageBinding;

import java.util.ArrayList;

public class userPage extends AppCompatActivity {
    ActivityUserPageBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        binding=ActivityUserPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId={R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6};
        String[] name={"JoyLand ladies PG","KMY Mens PG","Nirmala Ladies PG","Banglore Mens PG","Mens And Ladies PG","Harsraj Boys PG"};
        String[] lastMessage={"Near KMC Hospital, Mangalore,karnataka","Near KMC Hospital, Mangalore,karnataka","Near KMC Hospital, Mangalore,karnataka","Near KMC Hospital, Mangalore,karnataka","Near KMC Hospital, Mangalore,karnataka","Near KMC Hospital, Mangalore,karnataka"};
        String[] lastMsgTime={"Karnataka","karnataka","Karnataka","Karnataka","Karnataka","Karnataka"};
        String[] phoneNo={"987643210","876432190","9481189207","890764321","8769064321","46789012"};
        String[] country={"wi-fi","wi-fi","wi-fi","wi-fi","wi-fi","wifi"};

        ArrayList<User>userArrayList=new ArrayList<>();

        for(int i=0;i<imageId.length;i++){
            User user=new User(name[i],lastMessage[i],lastMsgTime[i],phoneNo[i],country[i],imageId[i]);
            userArrayList.add(user);
        }
        ListAdapter listAdapter=new ListAdapter(userPage.this,userArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Intent i=new Intent(userPage.this,UserActivity.class);
                i.putExtra("name",name[position]);
                i.putExtra("phone",phoneNo[position]);
                i.putExtra("country",country[position]);
                i.putExtra("imageid",imageId[position]);
                startActivity(i);


            }



        });




    }
}