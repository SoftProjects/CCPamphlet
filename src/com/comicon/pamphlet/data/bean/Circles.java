package com.comicon.pamphlet.data.bean;

import android.annotation.SuppressLint;

import com.comicon.pamphlet.ui.main.SortModel;
import com.comicon.pamphlet.ui.main.cirlesList.sortlist.CharacterParser;

@SuppressLint("DefaultLocale")
public class Circles implements SortModel{
	private String name;
	private String sortLetters;
	
	public Circles(String name){
		this.name = name;
		String pinyin = CharacterParser.getInstance().getSelling(name);
		sortLetters = pinyin.substring(0, 1).toUpperCase();
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getSortLetters() {
		return sortLetters;
	}

	@Override
	public boolean isFavorite() {
		return false;
	}

}
