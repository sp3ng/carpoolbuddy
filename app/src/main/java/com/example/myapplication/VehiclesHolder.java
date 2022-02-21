package com.example.myapplication;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VehiclesHolder extends RecyclerView.ViewHolder
{
    TextView deVehicle;
    TextView deseatsleft;
    TextView destatusoc;
    Button bookride;
    Button seedetails;
    Button seereviews;

    public VehiclesHolder(@NonNull View itemView, VehicleAdapter.OnItemClickListener vListener)
    {
        super(itemView);
        deVehicle = (TextView) itemView.findViewById(R.id.vehicle);
        deseatsleft = (TextView) itemView.findViewById(R.id.seatsleft);
        destatusoc = (TextView) itemView.findViewById(R.id.price);
        seedetails = itemView.findViewById(R.id.gotoprofile);
        seedetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(vListener != null)
                {
                    int position = getAdapterPosition();
                    if (position!=RecyclerView.NO_POSITION)
                    {
                        vListener.onItemClick(position);
                    }
                }
            }
        });
    }
}
