package com.comicon.pamphlet.ui.main.favourList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.comicon.pamphlet.R;
import com.comicon.pamphlet.data.bean.Circles;
import com.comicon.pamphlet.ui.main.ItemClickListener;
import com.comicon.pamphlet.ui.main.SortModel;
import com.comicon.pamphlet.ui.main.cirlesList.sortlist.PinyinComparator;
import com.common.actionBarActivity.PageFragment;

public class Fragment02 extends PageFragment {
	public static final String ARG_SECTION_NUMBER = "section_number";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.normal_list,container, false);
		initViews(rootView);
		return rootView;
	}

	@Override
	public String getTitle() {
		return "我的收藏";
	}

	private void initViews(View rootView) {
		Context context = getActivity();
		ListView sortListView = (ListView) rootView.findViewById(R.id.normal_lvcountry);
		
		List<SortModel> SourceDateList = getSourceDateList();
		Collections.sort(SourceDateList,  new PinyinComparator());

		ListAdapter adapter = new ListAdapter(context, SourceDateList);
		sortListView.setOnItemClickListener(new ItemClickListener(context,adapter));
		sortListView.setAdapter(adapter);


	}
	
	private List<SortModel> getSourceDateList(){
		List<SortModel> SourceDateList = new ArrayList<SortModel>();
		
		SourceDateList.add(new Circles("aa"));
		SourceDateList.add(new Circles("你好"));
		SourceDateList.add(new Circles("你好"));
		SourceDateList.add(new Circles("你好"));
		SourceDateList.add(new Circles("你好"));
		SourceDateList.add(new Circles("你好"));
		SourceDateList.add(new Circles("你好"));
		SourceDateList.add(new Circles("你好"));
		SourceDateList.add(new Circles("你好"));
		SourceDateList.add(new Circles("你好"));
		SourceDateList.add(new Circles("你好"));
		SourceDateList.add(new Circles("你好"));
		SourceDateList.add(new Circles("你好"));
		SourceDateList.add(new Circles("gg好gg好"));
		SourceDateList.add(new Circles("烦烦烦"));
		SourceDateList.add(new Circles("烦烦烦"));
		SourceDateList.add(new Circles("烦烦烦"));
		SourceDateList.add(new Circles("烦烦烦"));
		SourceDateList.add(new Circles("烦烦烦"));
		SourceDateList.add(new Circles("烦烦烦"));
		SourceDateList.add(new Circles("烦烦烦"));
		SourceDateList.add(new Circles("烦烦烦"));
		SourceDateList.add(new Circles("烦烦烦"));
		SourceDateList.add(new Circles("烦烦烦"));
		SourceDateList.add(new Circles("烦烦烦"));
		SourceDateList.add(new Circles("烦烦烦"));
		SourceDateList.add(new Circles("烦烦烦"));
		return SourceDateList;
	}
}
