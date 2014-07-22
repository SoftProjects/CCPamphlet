package com.comicon.pamphlet.ui.main;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.comicon.pamphlet.R;
import com.comicon.pamphlet.data.cotroller.Controller;
import com.comicon.pamphlet.data.model.WorkModel;
import com.comicon.pamphlet.ui.main.cirlesList.Fragment01;
import com.comicon.pamphlet.ui.main.eventInfo.Fragment03;
import com.comicon.pamphlet.ui.main.favourList.Fragment02;
import com.comicon.pamphlet.ui.main.searchlist.SearchListAdapter;
import com.comicon.pamphlet.ui.main.searchlist.SearchListener;
import com.common.actionBarActivity.FragmentAdapter;
import com.common.actionBarActivity.PageFragment;
import com.common.actionBarActivity.SimpleFragmentActivity;

public class HomeActivity extends SimpleFragmentActivity{

	private SearchListAdapter searchAdapter;
	public SearchListAdapter getSearchAdapter() {
		return searchAdapter;
	}

	private PageFragment[] fragments=new PageFragment[]{
			new Fragment01(),
			new Fragment02(), 
			new Fragment03(),
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Controller.instance(this).initial();
		setContentView(R.layout.activity_home);
		FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
		for(PageFragment pf:fragments){
			adapter.add(pf);
		}
		
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
			case R.id.action_refresh:
				Controller.instance(this).update(new UpdateHandler());break;
			case R.id.action_response:respond();break;
			default :break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	private class UpdateHandler extends Handler{
		private AlertDialog alert;
		private UpdateHandler(){
			mDialog = ProgressDialog.show(HomeActivity.this, "请等待……", "正在建立连接",true);
			alert = new AlertDialog.Builder(HomeActivity.this).setPositiveButton("确定",null).create();
			
		}
		private ProgressDialog mDialog;
		@Override
		public void handleMessage(Message msg) {
			switch(msg.what){
				case 0:break;
				case 1:mDialog.setMessage("下载中……");break;
				case 2:mDialog.setMessage("数据保存中……");break;
				case 3:mDialog.dismiss();
						alert.setTitle("成功");
						alert.show();
						fresh();
						break;
				case 4: mDialog.dismiss();
						alert.setTitle("失败");
						alert.show();
						break;
				default:break;
			}
			super.handleMessage(msg);
		}
	}

	private void fresh(){
		for(PageFragment pf:fragments){
			pf.refresh();
		}
	}
	private void respond(){
		final EditText input = new EditText(this);

		AlertDialog dialog= new AlertDialog.Builder(this)
		.setPositiveButton("发送", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Controller.instance(HomeActivity.this).sendResponse(input.getText().toString());
			}
		})
		.setTitle("意见反馈")
		.create();
		dialog.setView(input,20,0,20,0);
		dialog.show();
	}
}
