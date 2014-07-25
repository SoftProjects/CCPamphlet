package com.comicon.pamphlet.ui.circle;

import java.util.List;

import com.comicon.pamphlet.R;
import com.comicon.pamphlet.data.model.CircleModel;
import com.comicon.pamphlet.data.model.WorkModel;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

public class CircleActivity extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.circle_activity);
		
		TextView name = (TextView)findViewById(R.id.circle_name);
		TextView order = (TextView)findViewById(R.id.circle_order);
		TextView site = (TextView)findViewById(R.id.circle_site);
		TextView property = (TextView)findViewById(R.id.circle_property);
		
		CircleModel circle  = (CircleModel) getIntent().getSerializableExtra("circle");
		
		name.setText(circle.getName());
		order.setText(circle.getOrder());

		SpannableString ss = new SpannableString(circle.getSite());
		ss.setSpan(new URLSpan(circle.getSite()), 0, circle.getSite().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		site.setText(ss);
		site.setMovementMethod(LinkMovementMethod.getInstance());
		
		property.setText(circle.getProperty());
		
		List<WorkModel> works = circle.getWorks();
		
		ListView listView = (ListView) findViewById(R.id.work_lvcountry);
		WorksListAdapter worksAdapter = new WorksListAdapter(this,works);
//		searchReult.setOnItemClickListener(new ItemClickListener(getApplicationContext(),searchAdapter));
		listView.setAdapter(worksAdapter);

		int totalHeight = 0; 
		for (int i = 0; i < worksAdapter.getCount(); i++) { 
			View listItem = worksAdapter.getView(i, null, listView); 
			listItem.measure(0, 0); 
			totalHeight += listItem.getMeasuredHeight(); 
		} 	
        ViewGroup.LayoutParams params = listView.getLayoutParams(); 
        params.height = totalHeight + (listView.getDividerHeight() * (worksAdapter.getCount() - 1)); 
        listView.setLayoutParams(params); 

        ScrollView sv = (ScrollView) findViewById(R.id.circle_scroll);
        sv.smoothScrollTo(0, 0);
        
        ActionBar bar = getActionBar(); 
        bar.setDisplayHomeAsUpEnabled(true);  

		super.onCreate(savedInstanceState);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){ 
        	case android.R.id.home:finish();return true; 
        	default:break; 
        } 
    return super.onOptionsItemSelected(item); 
	}
	
}
