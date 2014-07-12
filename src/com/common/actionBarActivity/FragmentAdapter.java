package com.common.actionBarActivity;

import java.util.ArrayList;

import android.app.ActionBar.TabListener;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentAdapter extends FragmentPagerAdapter {
	ArrayList<PageFragment> fragments = new ArrayList<PageFragment>();
	public FragmentAdapter(FragmentManager fm) {
		super(fm);
	}

	public void add(PageFragment f){
		fragments.add(f);
	}
	
	@Override
	public Fragment getItem(int arg0) {
		return fragments.get(arg0);
	}

	@Override
	public int getCount() {
		return fragments.size();
	}
	
	@Override
	public CharSequence getPageTitle(int position) {
		return fragments.get(position).getTitle();
	}
	
	public TabListener getTabListener(int position){
		return fragments.get(position).getTabListener();
	}
}
