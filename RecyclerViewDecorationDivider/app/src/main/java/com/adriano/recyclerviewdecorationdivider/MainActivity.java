package com.adriano.recyclerviewdecorationdivider;

import android.app.*;
import android.os.*;
import android.support.v7.widget.*;
import android.support.v7.app.*;
import java.util.*;
import android.content.*;
import android.view.*;
import android.widget.*;
import android.widget.PopupMenu;
import android.support.v4.widget.*;
import android.support.design.widget.*;

public class MainActivity extends AppCompatActivity {
	
	Context context; 
	//List<AndroidList> lista;
	ArrayList<AndroidList> lista;
	RecyclerView rv;
	RecyclerViewAdapter mRVAdapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		rv = (RecyclerView) findViewById(R.id.recyclerView);
		androidList();

		LinearLayoutManager layoutManager = new LinearLayoutManager(context); 
		rv.setHasFixedSize(true);
	
		rv.addItemDecoration(new DecorationItemDivider(this));
		//DividerItemDecoration itemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        //recyclerView.addItemDecoration(itemDecoration);
		rv.setLayoutManager(layoutManager);

		RecyclerViewAdapter adapter = new RecyclerViewAdapter(MainActivity.this, lista);
        rv.setAdapter(adapter);
		
		adapter.setOnItemClickListener(onItemClickListener);
	}

	private void androidList(){ 
		//lista = new ArrayList<>();
		lista = new ArrayList<AndroidList>();
		
		lista.add(new AndroidList("Pie","9.0", R.string.android_pie, R.drawable.pie));
		lista.add(new AndroidList("Oreo","8.0", R.string.android_oreo, R.drawable.oreo));
		lista.add(new AndroidList("Nougat","7.0", R.string.android_nougat, R.drawable.nougat));
		lista.add(new AndroidList("Marshmallow","6.0", R.string.android_marshmallow, R.drawable.marshmallow));
		lista.add(new AndroidList("Lolipop","5.0", R.string.android_lollipop, R.drawable.lollipop));
		lista.add(new AndroidList("Kitkat","4.4", R.string.android_kitkat, R.drawable.kitkat));
		lista.add(new AndroidList("JellyBean","4.1", R.string.android_jelly_bean, R.drawable.jellybean));
		lista.add(new AndroidList("Icecream sandwitch","4.0", R.string.android_ice_cream_sandwich, R.drawable.icecreamsandwich));
		lista.add(new AndroidList("HoneyComb","3.0, 3.1 e 3.2", R.string.android_honeycomb, R.drawable.honeycomb));
		lista.add(new AndroidList("Gingerbread","2.3, 2.4", R.string.android_gingerbread, R.drawable.gingerbread));
		lista.add(new AndroidList("Froyo","2.2", R.string.android_froyo, R.drawable.froyo));
		lista.add(new AndroidList("Eclair","2.0, 2.1", R.string.android_eclair, R.drawable.eclair));
		lista.add(new AndroidList("Donut","1.6", R.string.android_donut, R.drawable.donut));
		lista.add(new AndroidList("Cupcake","1.5", R.string.android_cupcake, R.drawable.cupcake));
		lista.add(new AndroidList("Beta","1.1", R.string.android_beta, R.drawable.beta));
		lista.add(new AndroidList("Alpha","1.0", R.string.android_alpha, R.drawable.alpha));
		
	}
	
	View.OnClickListener onItemClickListener = new View.OnClickListener() {
		@Override
        public void onClick(View view) {
			
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
            int position = viewHolder.getAdapterPosition();
			// viewHolder.getItemId();
            AndroidList aList = lista.get(position);
            Toast.makeText(MainActivity.this, "Android: " + aList.getName(), Toast.LENGTH_SHORT).show();
			Toast.makeText(MainActivity.this, "Version: " + aList.getVersion(), Toast.LENGTH_SHORT).show();
		}
    };
}
