package com.comicon.pamphlet.ui.main.searchlist;

import java.util.List;

import com.comicon.pamphlet.R;
import com.comicon.pamphlet.data.model.CircleModel;
import com.comicon.pamphlet.data.model.WorkModel;
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

public class SearchListAdapter extends BaseAdapter{
	
	private List<WorkModel> list = null;
	private Context mContext;
	
	public SearchListAdapter(Context mContext, List<WorkModel> list) {
		this.mContext = mContext;
		this.list = list;
	}
	
	/**
	 * 当ListView数据发生变化时,调用此方法来更新ListView
	 * @param list
	 */
	public void updateListView(List<WorkModel> list){
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
		view = LayoutInflater.from(mContext).inflate(R.layout.search_item, null);
		TextView tvTitle = (TextView) view.findViewById(R.id.title);
		TextView tvSubTitle = (TextView) view.findViewById(R.id.sub_title);
		TextView tvPrice = (TextView) view.findViewById(R.id.work_privce);
		TextView tvCategory = (TextView) view.findViewById(R.id.work_category);
		TextView tvTheme = (TextView) view.findViewById(R.id.work_theme);

		WorkModel work = this.list.get(position);
		tvTitle.setText(work.getName());
		tvSubTitle.setText(work.getCircle().getName());
		tvPrice.setText("价格："+(work.getPrice().trim().equals("")?"不详":work.getPrice()));
		tvTheme.setText("主题："+(work.getTheme().trim().equals("")?"不详":work.getTheme()));
		tvCategory.setText("类型："+(work.getCategory().trim().equals("")?"不详":work.getCategory()));
		return view;

	}
	
}