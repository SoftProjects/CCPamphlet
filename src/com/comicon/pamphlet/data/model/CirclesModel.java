package com.comicon.pamphlet.data.model;

import java.util.List;

public interface CirclesModel extends ItemModel{
	public String getName();
	public String getSortLetters() ;
	public boolean isFavorite();
	public List<WorkModel> getWorks();
}
