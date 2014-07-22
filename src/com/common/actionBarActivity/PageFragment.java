package com.common.actionBarActivity;

import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.support.v4.app.Fragment;

public abstract class PageFragment extends Fragment {
	protected boolean autoRefresh = false;
	public abstract String getTitle();
	public abstract void refresh();
	public TabListener getTabListener(){
		return new TabListener() {
			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			}
			
			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				if(autoRefresh)refresh();
			}
			
			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
			}
		};
	}
}
