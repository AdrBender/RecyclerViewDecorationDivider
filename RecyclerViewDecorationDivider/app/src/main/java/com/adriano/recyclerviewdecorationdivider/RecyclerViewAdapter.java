package com.adriano.recyclerviewdecorationdivider;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import android.widget.*;
import android.view.*;
import android.support.v7.app.*;
import android.support.design.widget.*;
import android.support.v7.view.menu.*;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

	Context context; 
	ArrayList<AndroidList> lista;
	View.OnClickListener mOnItemClickListener;
	
	
	public RecyclerViewAdapter(Context context, ArrayList<AndroidList> lista) { 
		this.context = context; 
		this.lista = lista; 
	} 

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list, parent, false);
		ViewHolder holder = new ViewHolder(view);
		return holder;
	}
	
	public class ViewHolder extends RecyclerView.ViewHolder{

		ImageView androidImage;
		TextView androidName;
		TextView androidVersion;
		TextView androidDesc;
		Button buttonPopup;

		public ViewHolder(View itemView) {
			super(itemView);
			
			androidImage = itemView.findViewById(R.id.android_image);
			androidName = itemView.findViewById(R.id.android_name);
			androidVersion = itemView.findViewById(R.id.android_version);
			androidDesc = itemView.findViewById(R.id.android_desc);
			buttonPopup = itemView.findViewById(R.id.button_popup);

			itemView.setTag(this);
			itemView.setOnClickListener(mOnItemClickListener);
		}
	}

	@Override
	public void onBindViewHolder(final ViewHolder holder, final int position) {
		
		holder.androidImage.setImageResource(lista.get(position).image);
		holder.androidName.setText(lista.get(position).getName());
		holder.androidVersion.setText(lista.get(position).getVersion());
		holder.androidDesc.setText(lista.get(position).getDesc());
		
		//final Button button_Popup = holder.buttonPopup;

        holder.buttonPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
				MenuBuilder menuBuilder =new MenuBuilder(context);
				MenuInflater inflater = new MenuInflater(context);
				inflater.inflate(R.menu.popup_menu, menuBuilder);
				MenuPopupHelper optionsMenu = new MenuPopupHelper(context, menuBuilder, view);
				optionsMenu.setForceShowIcon(true);
				menuBuilder.setCallback(new MenuBuilder.Callback() {
				
				//Poppup menu sem icone
                /*PopupMenu popup = new PopupMenu(context, button_Popup);
                popup.inflate(R.menu.popup_menu);
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
				*/
                    @Override
                    public boolean onMenuItemSelected(MenuBuilder p1, MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.deletaItem:

                                lista.remove(holder.getAdapterPosition());
                                notifyItemRemoved(holder.getAdapterPosition());
								
								/*Snackbar snackbar = Snackbar
									.make(rv, context.getString(R.string.item_removed), Snackbar.LENGTH_LONG);
									.setAction(R.string.undo, new View.OnClickListener() {

										public void onClick(View view) {
											
											RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
											
											int mAdapterPosition = viewHolder.getAdapterPosition();
											final AndroidList mList = lista.get(mAdapterPosition);
											
											lista.add(mAdapterPosition, mList);
											notifyItemInserted(mAdapterPosition);
											rv.scrollToPosition(mAdapterPosition);
										
										}
										
									});
								 snackbar.show();*/
								return true;
                        }
                        return false;
                    }
                
			@Override
			public void onMenuModeChange(MenuBuilder menu) {}
		});

	optionsMenu.show();
                //popup.show();
            }
        });
	}

	@Override
	public int getItemCount() {
		return lista.size();
	}
	
	public void setOnItemClickListener(View.OnClickListener itemClickListener) {
        mOnItemClickListener = itemClickListener;
    }
	
	@Override 
	public void onAttachedToRecyclerView(RecyclerView recyclerView) { 
		super.onAttachedToRecyclerView(recyclerView); 
	}
}
