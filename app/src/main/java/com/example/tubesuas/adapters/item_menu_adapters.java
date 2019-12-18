package com.example.tubesuas.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tubesuas.Models.ItemMenu;
import com.example.tubesuas.R;

import java.util.List;

public class item_menu_adapters extends RecyclerView.Adapter<item_menu_adapters.MyViewHolder> {
    List<ItemMenu> itemMenu;

    public item_menu_adapters(List<ItemMenu> itemMenu) {
        this.itemMenu = itemMenu;
    }

    @NonNull
    @Override
    public item_menu_adapters.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //object context diambil dari parent
        Context context = parent.getContext();
        //object context digunakan untuk membuat object layoutInflater
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        //object layoutInflater digunakan untuk membuat object view yang merupakan hasil inflate  layout ( mengubungkan adapter degnan layout)
        View superHeroView = layoutInflater.inflate(R.layout.item_paket_wisata,parent,false);
        //object superHeroView digunakan untuk membuat object viewHolder
        MyViewHolder viewHolder = new MyViewHolder(superHeroView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull item_menu_adapters.MyViewHolder holder, int position) {
        //ambil satu item hero
        ItemMenu menu = itemMenu.get(position);
        //set text heroName berdasarkan data dari model hero
        holder.item_menu.setText(menu.getItem_menu());
    }

    @Override
    public int getItemCount() {
        return (itemMenu != null) ? itemMenu.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView item_menu;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item_menu = itemView.findViewById(R.id.item_menu);
        }
    }
}
