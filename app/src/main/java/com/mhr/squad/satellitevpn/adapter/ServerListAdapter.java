package com.mhr.squad.satellitevpn.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mhr.squad.satellitevpn.R;
import com.mhr.squad.satellitevpn.model.Servers;

import java.util.ArrayList;

public class ServerListAdapter extends RecyclerView.Adapter <ServerListAdapter.MyViewHolder>{


    private Context context;
    private ArrayList<Servers> ServerList;

    public ServerListAdapter(Context context, ArrayList<Servers> serverList) {
        this.context = context;
        ServerList = serverList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.serverlayout,parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Servers servers=ServerList.get(position);
        holder.countryname.setText(ServerList.get(position).getServerCountry());

        // for adding imageUrl use Glide Library---//
        Glide.with(context).load(servers.getFlagUrl()).into(holder.serverIcon);

    }


    @Override
    public int getItemCount() {
        return ServerList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView serverIcon, serversignal;
        TextView countryname;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            serverIcon=itemView.findViewById(R.id.server_Icon);
            serversignal=itemView.findViewById(R.id.signal);
            countryname=itemView.findViewById(R.id.country_Name);



        }
    }
}
