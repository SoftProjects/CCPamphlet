package com.comicon.pamphlet.ui.main;

import java.util.ArrayList;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;
import com.comicon.pamphlet.R;
import com.comicon.pamphlet.data.model.WorkModel;
import com.comicon.pamphlet.ui.main.cirlesList.Fragment01;
import com.comicon.pamphlet.ui.main.eventInfo.Fragment03;
import com.comicon.pamphlet.ui.main.favourList.Fragment02;
import com.comicon.pamphlet.ui.main.searchlist.SearchListAdapter;
import com.comicon.pamphlet.ui.main.searchlist.SearchListener;
import com.common.actionBarActivity.FragmentAdapter;
import com.common.actionBarActivity.SimpleFragmentActivity;

public class HomeActivity extends SimpleFragmentActivity{

	private SearchListAdapter searchAdapter;
	public SearchListAdapter getSearchAdapter() {
		return searchAdapter;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_home);
		FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
		adapter.add(new Fragment01());
		adapter.add(new Fragment02());
		adapter.add(new Fragment03());
		setFragmentAdapter(adapter);
		
		ListView searchReult = (ListView) findViewById(R.id.search_result_list);
		
		searchAdapter = new SearchListAdapter(this, new ArrayList<WorkModel>());
		searchReult.setOnItemClickListener(new ItemClickListener(getApplicationContext(),searchAdapter));
		searchReult.setAdapter(searchAdapter);
		
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//右上角菜单
		getMenuInflater().inflate(R.menu.home, menu);
	    SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView(); 
	    searchView.setQueryHint("快捷搜索");
	    SearchListener listener = new SearchListener(this);
	    searchView.setOnQueryTextListener(listener);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
			default :break;
		}
		return super.onOptionsItemSelected(item);
	}
}
