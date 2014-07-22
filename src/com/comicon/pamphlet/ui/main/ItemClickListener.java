package com.comicon.pamphlet.ui.main;


import com.comicon.pamphlet.data.model.CircleModel;
import com.comicon.pamphlet.data.model.ItemModel;
import com.comicon.pamphlet.ui.circle.CircleActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
//		Toast.makeText(context, ((ItemModel)adapter.getItem(position)).getCircle().getName(), Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(view.getContext(),CircleActivity.class);
		CircleModel circle = ((ItemModel)adapter.getItem(position)).getCircle();
		Bundle data = new Bundle();
		data.putSerializable("circle", circle);
		intent.putExtras(data);
		view.getContext().startActivity(intent);
	}
}