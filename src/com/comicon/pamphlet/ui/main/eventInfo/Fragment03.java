package com.comicon.pamphlet.ui.main.eventInfo;

import java.io.File;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.comicon.pamphlet.R;
import com.common.actionBarActivity.PageFragment;
import com.common.imageLoader.*;

public class Fragment03 extends PageFragment {
	public static final String ARG_SECTION_NUMBER = "section_number";
	public static final String IMAGE_CACHE = "/mnt/sdcard/ComiCon/";
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.even_info,container, false);
		ImageLoader il = new ImageLoader(IMAGE_CACHE);
		final ImageView siteMap = (ImageView)rootView.findViewById(R.id.site_map);
		final ImageView localMap = (ImageView)rootView.findViewById(R.id.local_map);
		il.setBitmap(siteMap, "http://bbs.comicon1111.org/pics/cc12/CC12PLANO3.jpg",new Handler(){
			@Override
			public void handleMessage(Message msg) {
				super.handleMessage(msg);
				siteMap.setBackgroundColor(Color.WHITE);
				siteMap.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						show(new File(IMAGE_CACHE+"CC12PLANO3.jpg"));
					}
				});
			}
		});
		il.setBitmap(localMap, "http://bbs.comicon1111.org/pics/cc13/map2.jpg",new Handler(){
			@Override
			public void handleMessage(Message msg) {
				super.handleMessage(msg);
				localMap.setBackgroundColor(Color.WHITE);
				localMap.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						show(new File(IMAGE_CACHE+"map2.jpg"));
					}
				});
			}
		});
		return rootView;
	}

	@Override
	public String getTitle() {
		return "活动信息";
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
	}
	
	private void show(File file){
		Intent intent = new Intent();
		intent.setAction(android.content.Intent.ACTION_VIEW);
		intent.setDataAndType(Uri.fromFile(file), "image/*");
		startActivity(intent);
	}

}
