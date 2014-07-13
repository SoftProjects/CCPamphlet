package com.comicon.pamphlet.ui.main;

import com.comicon.pamphlet.R;
import com.common.actionBarActivity.SimpleFragmentActivity;

import android.app.ActionBar;
import android.app.Activity;
import android.view.View;
import android.widget.SearchView.OnQueryTextListener;

public class SearchListener implements OnQueryTextListener{
	private SimpleFragmentActivity context;
	public SearchListener(SimpleFragmentActivity context) {
		this.context = context;
	}

	@Override
	public boolean onQueryTextChange(String newText) {
		doQuery(newText);
		return false;
	}

	@Override
	public boolean onQueryTextSubmit(String query) {
		doQuery(query);
		return false;
	}
	
	private void toggleSearch(boolean open){
//		Toast.makeText(context, ""+open, Toast.LENGTH_LONG).show();
		if(open){
			context.findViewById(R.id.search_result).setVisibility(View.VISIBLE);
			context.hideTab();
		}else{
			context.findViewById(R.id.search_result).setVisibility(View.GONE);
			context.resetTabs();
		}
	}
	
	private void doQuery(String query){
		query = query.trim();
		if(query.equals("")) toggleSearch(false);
		else toggleSearch(true);
	}
}
