package com.comicon.pamphlet.ui.main.searchlist;

import java.util.List;

import com.comicon.pamphlet.R;
import com.comicon.pamphlet.data.cotroller.Controller;
import com.comicon.pamphlet.data.model.WorkModel;
import com.comicon.pamphlet.ui.main.HomeActivity;
import com.comicon.pamphlet.ui.main.Resourcer;

import android.view.View;
import android.widget.SearchView.OnQueryTextListener;

public class SearchListener implements OnQueryTextListener{
	private HomeActivity context;
	public SearchListener(HomeActivity context) {
		this.context = context;
		resource = Controller.instance(context);
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
		if(open){
			context.findViewById(R.id.search_result).setVisibility(View.VISIBLE);
			context.hideTab();
		}else{
			context.findViewById(R.id.search_result).setVisibility(View.GONE);
			context.resetTabs();
		}
	}
	
	private Resourcer resource;
	private void doQuery(String query){
		query = query.trim();
		if(query.equals("")) toggleSearch(false);
		else toggleSearch(true);
		//获取数据
		List<WorkModel> result = resource.getSearchResult(query);
		context.getSearchAdapter().updateListView(result);
	}
}
