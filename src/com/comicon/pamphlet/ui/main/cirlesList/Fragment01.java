package com.comicon.pamphlet.ui.main.cirlesList;

import java.util.Collections;
import java.util.List;
import com.comicon.pamphlet.R;
import com.comicon.pamphlet.data.cotroller.Controller;
import com.comicon.pamphlet.data.cotroller.Resourcer;
import com.comicon.pamphlet.data.model.CircleModel;
import com.comicon.pamphlet.ui.main.ItemClickListener;
import com.comicon.pamphlet.ui.main.cirlesList.sortlist.PinyinComparator;
import com.comicon.pamphlet.ui.main.cirlesList.sortlist.SideBar;
import com.comicon.pamphlet.ui.main.cirlesList.sortlist.SortAdapter;
import com.comicon.pamphlet.ui.main.cirlesList.sortlist.SideBar.OnTouchingLetterChangedListener;
import com.common.actionBarActivity.PageFragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class Fragment01 extends PageFragment {
	private Resourcer resourcer;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		resourcer = Controller.instance(this.getActivity().getApplicationContext());
		View rootView = inflater.inflate(R.layout.sircles_list,container, false);
		initViews(rootView);
		super.autoRefresh = true;
		return rootView;
	}

	@Override
	public String getTitle() {
		return "社团列表";
	}
	private SortAdapter adapter;
	private void initViews(View rootView) {
		Context context = rootView.getContext();
		SideBar sideBar = (SideBar) rootView.findViewById(R.id.sidrbar);
		TextView dialog = (TextView) rootView.findViewById(R.id.dialog);
		sideBar.setTextView(dialog);
		
		final ListView sortListView = (ListView) rootView.findViewById(R.id.country_lvcountry);
		//获取数据
		List<CircleModel> SourceDateList = resourcer.getAllList();
		Collections.sort(SourceDateList,  new PinyinComparator());
		
		adapter = new SortAdapter(context, SourceDateList);
		sortListView.setOnItemClickListener(new ItemClickListener(context,adapter));
		sortListView.setAdapter(adapter);

		sideBar.setOnTouchingLetterChangedListener(new OnTouchingLetterChangedListener() {
			@Override
			public void onTouchingLetterChanged(String s) {
				//该字母首次出现的位置
				int position = adapter.getPositionForSection(s.charAt(0));
				if(position != -1){
					sortListView.setSelection(position);
				}
			}
		});
	}

	@Override
	public void refresh() {
		if(adapter!=null){
			List<CircleModel> SourceDateList = resourcer.getAllList();
			Collections.sort(SourceDateList,  new PinyinComparator());
			adapter.updateListView(SourceDateList);
		}
	}
}
