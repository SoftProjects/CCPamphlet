package com.comicon.pamphlet.data.bean;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;

import com.comicon.pamphlet.data.model.CirclesModel;
import com.comicon.pamphlet.data.model.WorkModel;
import com.comicon.pamphlet.ui.main.cirlesList.sortlist.CharacterParser;

@SuppressLint("DefaultLocale")
public class Circles implements CirclesModel{
	private String name;
	private String sortLetters;
	
	public Circles(String name){
		this.name = name;
		String pinyin = CharacterParser.getInstance().getSelling(name);
		sortLetters = pinyin.substring(0, 1).toUpperCase();
		works = new ArrayList<WorkModel>();
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getSortLetters() {
		return sortLetters;
	}

	boolean isFavourite = false;
	@Override
	public boolean isFavorite() {
		return (isFavourite =!isFavourite);
	}

	List<WorkModel> works;
	public void addWork(WorkModel work){
		works.add(work);
	}
	
	@Override
	public List<WorkModel> getWorks() {
		return works;
	}

	@Override
	public CirclesModel getCircle() {
		return this;
	}

}
