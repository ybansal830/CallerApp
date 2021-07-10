package com.myfirst.callerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener{

    private RecyclerView mRecyclerView;
    private final int requestCode = 1;
    private ArrayList<Contact> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] permissions = {Manifest.permission.CALL_PHONE};
        ActivityCompat.requestPermissions(this,permissions,requestCode);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String[] permissions,int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0] == PackageManager.PERMISSION_DENIED)
            Toast.makeText(this,"no contacts available",Toast.LENGTH_SHORT).show();
        else{
            mRecyclerView = findViewById(R.id.recyclerView);
            ArrayList<Contact> arrayList = new ArrayList<>();
            for(int i=0;i<10;i++) {
                arrayList.add(new Contact("Harry Dutt", "8665487596"));
                arrayList.add(new Contact("Mayank Mittal", "9665887296"));
                arrayList.add(new Contact("Sonya Gupta", "7665227336"));
                arrayList.add(new Contact("Shivu Mehta", "5665667446"));
                arrayList.add(new Contact("Gayatri Singh", "6665489996"));
            }
            ContactAdapter contactAdapter = new ContactAdapter(arrayList,this);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            mRecyclerView.setAdapter(contactAdapter);
            mRecyclerView.setLayoutManager(linearLayoutManager);
        }
    }

    @Override
    public void onClick(String phoneNo) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phoneNo));
        startActivity(intent);
    }
}