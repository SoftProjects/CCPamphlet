package com.common.actionBarActivity;

import java.util.ArrayList;
import java.util.List;

import com.comicon.pamphlet.R;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;

public class SimpleFragmentActivity extends FragmentActivity{
	private ActionBar actionBar;
	private ViewPager mViewPager;
	protected FragmentAdapter mSectionsPagerAdapter;
	private List<Tab> tabs;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		if(savedInstanceState!=null && savedInstanceState.getInt("pagerId")!=0){
			mViewPager = (ViewPager) findViewById(savedInstanceState.getInt("pagerId"));
		}else{
			mViewPager = (ViewPager) findViewById(R.id.pager);
		}

		mViewPager.setAdapter(mSectionsPagerAdapter);
		mViewPager.setOnPageChangeListener(new OnPageChangeListener(mSectionsPagerAdapter));
		mViewPager.setOffscreenPageLimit(2);
		tabs = new ArrayList<Tab>();
		for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
			Tab tab = actionBar.newTab();
			tab.setText(mSectionsPagerAdapter.getPageTitle(i));
			tab.setTabListener(new MainTabListener(mSectionsPagerAdapter.getTabListener(i)));
			tabs.add(tab);
		}
		resetTabs();
	}
	
	public void hideTab(){
		actionBar.removeAllTabs();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
	}
	
	public void resetTabs(){
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.removeAllTabs();
		for(Tab tab:tabs){
			actionBar.addTab(tab);
		}
	}
	
	protected void setFragmentAdapter(FragmentAdapter	mSectionsPagerAdapter){
		this.mSectionsPagerAdapter = mSectionsPagerAdapter;
	}
	
	private class MainTabListener implements TabListener {
		private TabListener tabListener;
		public MainTabListener(TabListener tabListener) {
			this.tabListener = tabListener;
		}
		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			tabListener.onTabReselected(tab, ft);
		}
		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			mViewPager.setCurrentItem(tab.getPosition());
			tabListener.onTabSelected(tab, ft);
		}
		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			tabListener.onTabUnselected(tab, ft);
		}
	}
	
	private class OnPageChangeListener extends SimpleOnPageChangeListener {
		private List<TabListener> tabListenerList;
		
		public OnPageChangeListener(FragmentAdapter mSectionsPagerAdapter) {
			tabListenerList = new ArrayList<TabListener>();
			for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
				tabListenerList.add(mSectionsPagerAdapter.getTabListener(i));
			}
		}

				@Override
		public void onPageSelected(int position) {
			actionBar.setSelectedNavigationItem(position);
			tabListenerList.get(position).onTabSelected(actionBar.getSelectedTab(), null);
		}
	}
}
