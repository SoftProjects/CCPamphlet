package com.comicon.pamphlet.ui.main;

import com.comicon.pamphlet.R;
import com.comicon.pamphlet.ui.main.cirlesList.Fragment01;
import com.comicon.pamphlet.ui.main.eventInfo.Fragment03;
import com.comicon.pamphlet.ui.main.favourList.Fragment02;
import com.common.actionBarActivity.FragmentAdapter;
import com.common.actionBarActivity.SimpleFragmentActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

public class HomeActivity extends SimpleFragmentActivity{

	private SearchListener listener ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_home);
		FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
		adapter.add(new Fragment01());
		adapter.add(new Fragment02());
		adapter.add(new Fragment03());
		setFragmentAdapter(adapter);
		listener = new SearchListener(getApplicationContext());
		super.onCreate(savedInstanceState);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//右上角菜单
		getMenuInflater().inflate(R.menu.home, menu);
	    SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView(); 
	    searchView.setQueryHint("快捷搜索");
	    searchView.setOnQueryTextFocusChangeListener(listener);
	    searchView.setOnQueryTextListener(listener);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
//			case R.id.action_search:startActivity(new Intent(this,SearchActivity.class));break;
			default :break;
		}
		return super.onOptionsItemSelected(item);
	}
	
}
