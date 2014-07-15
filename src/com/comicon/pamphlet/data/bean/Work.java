package com.comicon.pamphlet.data.bean;

import com.comicon.pamphlet.data.model.CirclesModel;
import com.comicon.pamphlet.data.model.WorkModel;

public class Work implements WorkModel {
	private CirclesModel circle;
	private String name;
	public Work(CirclesModel circle,String name){
		this.circle = circle;
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public CirclesModel getCircle() {
		return circle;
	}

}
