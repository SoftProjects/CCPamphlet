package com.comicon.pamphlet.ui.main.favourList;

import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.comicon.pamphlet.R;
import com.comicon.pamphlet.data.cotroller.Controller;
import com.comicon.pamphlet.data.cotroller.Resourcer;
import com.comicon.pamphlet.data.model.CircleModel;
import com.comicon.pamphlet.ui.main.ItemClickListener;
import com.comicon.pamphlet.ui.main.cirlesList.sortlist.PinyinComparator;
import com.common.actionBarActivity.PageFragment;

public class Fragment02 extends PageFragment {
	public static final String ARG_SECTION_NUMBER = "section_number";
	private Resourcer resourcer;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		resourcer = Controller.instance(this.getActivity().getApplicationContext());
		super.autoRefresh = true;
		View rootView = inflater.inflate(R.layout.normal_list,container, false);
		initViews(rootView);
		return rootView;
	}

	@Override
	public String getTitle() {
		return "我的收藏";
	}
	private ListAdapter adapter;
	private void initViews(View rootView) {
		Context context = rootView.getContext();
		ListView sortListView = (ListView) rootView.findViewById(R.id.normal_lvcountry);
		//获取数据
		List<CircleModel> SourceDateList = resourcer.getFavouriteList();
		Collections.sort(SourceDateList,  new PinyinComparator());

		adapter = new ListAdapter(context, SourceDateList);
		sortListView.setOnItemClickListener(new ItemClickListener(context,adapter));
		sortListView.setAdapter(adapter);
	}

	@Override
	public void refresh() {
		if(adapter!=null)
			adapter.updateListView(resourcer.getFavouriteList());
	}
}
