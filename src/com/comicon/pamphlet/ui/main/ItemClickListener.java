package com.comicon.pamphlet.ui.main;


import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ItemClickListener implements OnItemClickListener{
	private Context context;
	private BaseAdapter adapter;
	public ItemClickListener(Context context, BaseAdapter adapter){
		this.context=context;
		this.adapter = adapter;
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
		//这里要利用adapter.getItem(position)来获取当前position所对应的对象
		Toast.makeText(context, ((SortModel)adapter.getItem(position)).getName(), Toast.LENGTH_SHORT).show();
	}
}