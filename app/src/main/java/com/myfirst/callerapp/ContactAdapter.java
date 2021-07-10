package com.myfirst.callerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.CheckedOutputStream;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private ArrayList<Contact> arrayList;
    private ItemClickListener itemClickListener;

    public ContactAdapter(ArrayList<Contact> arrayList,ItemClickListener itemClickListener){
        this.arrayList = arrayList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull

    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_conatct,parent,false);
        return new ContactViewHolder(view,itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.setData(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
