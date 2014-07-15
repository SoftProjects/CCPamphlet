package com.comicon.pamphlet.ui.main;

import java.util.List;

import com.comicon.pamphlet.data.model.CirclesModel;
import com.comicon.pamphlet.data.model.WorkModel;

public interface Resourcer {
	public List<CirclesModel> getAllList();
	public List<CirclesModel> getFavouriteList();
	public List<WorkModel> getSearchResult(String search);
}
