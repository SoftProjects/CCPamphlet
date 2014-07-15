package com.comicon.pamphlet.data.cotroller;

import java.util.ArrayList;
import java.util.List;

import android.app.ApplicationErrorReport.CrashInfo;
import android.content.Context;

import com.comicon.pamphlet.data.bean.Circles;
import com.comicon.pamphlet.data.bean.Work;
import com.comicon.pamphlet.data.model.CirclesModel;
import com.comicon.pamphlet.data.model.WorkModel;
import com.comicon.pamphlet.ui.main.Resourcer;

public class Controller implements Resourcer {
	public static Resourcer instance(Context context){
		return new Controller(context);
	}
	
	private Context context;
	private List<CirclesModel> testCircle;

	private Controller(Context context){
		this.context = context;
		testCircle = getTestCircle();
	}
	@Override
	public List<CirclesModel> getAllList() {
		// TODO Auto-generated method stub
		return testCircle;
	}
	@Override
	public List<CirclesModel> getFavouriteList() {
		// TODO Auto-generated method stub
		List<CirclesModel> ret = new ArrayList<CirclesModel>();
		for(CirclesModel cirecle:testCircle){
			if(cirecle.isFavorite()){
				ret.add(cirecle);cirecle.isFavorite();
			}
		}
		return ret;
	}
	@Override
	public List<WorkModel> getSearchResult(String search) {
		// TODO Auto-generated method stub
		List<WorkModel> ret = new ArrayList<WorkModel>();
		for(CirclesModel cirecle:testCircle){
			List<WorkModel> works = cirecle.getWorks();
			for(WorkModel work:works){
				if(work.getName().contains(search)){
					ret.add(work);
				}
			}
		}
		return ret;
	}
	
	private List<CirclesModel> getTestCircle(){
		List<CirclesModel> ret = new ArrayList<CirclesModel>();
		Circles c = new Circles("你好");
		c.addWork(new Work(c,"你好2"));
		c.addWork(new Work(c,"你好3"));
		c.addWork(new Work(c,"你好4"));
		c.addWork(new Work(c,"你好5"));
		c.addWork(new Work(c,"你1好2"));
		ret.add(c);
		
		ret.add(new Circles("不好"));
		ret.add(new Circles("真不好"));
		ret.add(new Circles("2不好"));
		ret.add(new Circles("4不好"));
		ret.add(new Circles("4水电费水电费师傅的说法改变的方式非共和国发生的沟通好不够分的人好"));
		ret.add(new Circles("超不好"));
		
		Circles d = new Circles("伽马和哥哥");
		d.addWork(new Work(d,"d"));
		ret.add(d);
		return ret;
	}
}
