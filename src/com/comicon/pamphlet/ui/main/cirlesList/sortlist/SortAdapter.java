package com.comicon.pamphlet.ui.main.cirlesList.sortlist;

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

public class SortAdapter extends BaseAdapter{
	
	private List<CirclesModel> list = null;
	private Context mContext;
	
	public SortAdapter(Context mContext, List<CirclesModel> list) {
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
		final CirclesModel mContent = list.get(position);
		view = LayoutInflater.from(mContext).inflate(R.layout.sircles_item, null);
		TextView tvTitle = (TextView) view.findViewById(R.id.title);
		TextView tvLetter = (TextView) view.findViewById(R.id.catalog);
		ImageButton tvButton = (ImageButton) view.findViewById(R.id.favour);
		
		//根据position获取分类的首字母的Char ascii值
		int section = getSectionForPosition(position);
		
		//如果当前位置等于该分类首字母的Char的位置 ，则认为是第一次出现
		if(position == getPositionForSection(section)){
			tvLetter.setVisibility(View.VISIBLE);
			tvLetter.setText(mContent.getSortLetters());
		}else{
			tvLetter.setVisibility(View.GONE);
		}
	
		tvTitle.setText(this.list.get(position).getName());
		tvButton.setImageResource(mContent.isFavorite()?R.drawable.rating_important:R.drawable.rating_not_important);
		tvButton.setOnClickListener(new FavourateListener(mContent));
		return view;

	}
	

	/**
	 * 根据ListView的当前位置获取分类的首字母的Char ascii值
	 */
	public int getSectionForPosition(int position) {
		return list.get(position).getSortLetters().charAt(0);
	}

	/**
	 * 根据分类的首字母的Char ascii值获取其第一次出现该首字母的位置
	 */
	public int getPositionForSection(int section) {
		for (int i = 0; i < getCount(); i++) {
			String sortStr = list.get(i).getSortLetters();
			char firstChar = sortStr.toUpperCase().charAt(0);
			if (firstChar == section) {
				return i;
			}
		}
		
		return -1;
	}
}