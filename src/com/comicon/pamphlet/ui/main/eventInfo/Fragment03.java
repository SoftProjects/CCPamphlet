package com.comicon.pamphlet.ui.main.eventInfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.comicon.pamphlet.R;
import com.comicon.pamphlet.R.id;
import com.comicon.pamphlet.R.layout;
import com.common.actionBarActivity.PageFragment;

public class Fragment03 extends PageFragment {
	public static final String ARG_SECTION_NUMBER = "section_number";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_home_dummy,container, false);
		TextView text = (TextView) rootView.findViewById(R.id.section_label);
		text.setText("aaaa");
		return rootView;
	}

	@Override
	public String getTitle() {
		return "活动信息";
	}
}
