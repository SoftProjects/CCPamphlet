package com.comicon.pamphlet.ui.main.favourList;

import java.util.List;

import com.comicon.pamphlet.R;
import com.comicon.pamphlet.data.model.CirclesModel;
import com.comicon.pamphlet.ui.main.FavourateListener;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SectionIndexer;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter{
	
	private List<CirclesModel> list = null;
	private Context mContext;
	
	public ListAdapter(Context mContext, List<CirclesModel> list) {
		this.mContext = mContext;
		this.list = list;
	}
	
	/**
	 * 当ListView数据发生变化时,调用此方法来更新ListView
	 * @param list
	 */
	public void updateListView(List<CirclesModel> list){
		this.list = list;
		notifyDataSetChanged();
	}

	public int getCount() {
		return this.list.size();
	}

	public Object getItem(int position) {
		return list.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(final int position, View view, ViewGroup arg2) {
		CirclesModel mContent = list.get(position);
		view = LayoutInflater.from(mContext).inflate(R.layout.sircles_item, null);
		TextView tvTitle = (TextView) view.findViewById(R.id.title);
		ImageButton tvButton = (ImageButton) view.findViewById(R.id.favour);
	
		tvTitle.setText(this.list.get(position).getName());
		tvButton.setImageResource(mContent.isFavorite()?R.drawable.rating_important:R.drawable.rating_not_important);
		tvButton.setOnClickListener(new FavourateListener(mContent));
		return view;

	}
	

}