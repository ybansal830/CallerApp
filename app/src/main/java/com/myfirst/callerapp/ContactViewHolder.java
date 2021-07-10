package com.myfirst.callerapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ContactViewHolder extends RecyclerView.ViewHolder {

    private ItemClickListener itemClickListener;
    private TextView mTvname;
    private ConstraintLayout mClClick;

    public ContactViewHolder(@NonNull View itemView,ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        mTvname = itemView.findViewById(R.id.tvName);
        mClClick = itemView.findViewById(R.id.clClick);
    }
    public void setData(Contact contact){
        mTvname.setText(contact.getName());
        mClClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onClick(contact.getPhoneNo());
            }
        });
    }
}
