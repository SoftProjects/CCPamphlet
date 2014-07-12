package com.comicon.pamphlet.ui.main;

import android.content.Context;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Toast;
import android.widget.SearchView.OnCloseListener;

public class SearchListener implements OnFocusChangeListener,OnQueryTextListener{
	private Context context;
	public SearchListener(Context context) {
		this.context = context;
	}

	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		// TODO Auto-generated method stub
		Toast.makeText(context, "onFocusChange", Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onQueryTextChange(String newText) {
		// TODO Auto-generated method stub
		Toast.makeText(context, "onQueryTextChange", Toast.LENGTH_LONG).show();
		return false;
	}

	@Override
	public boolean onQueryTextSubmit(String query) {
		// TODO Auto-generated method stub
		Toast.makeText(context, "onQueryTextSubmit", Toast.LENGTH_LONG).show();

		return false;
	}
}
