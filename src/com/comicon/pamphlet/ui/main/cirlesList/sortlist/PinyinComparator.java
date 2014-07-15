package com.comicon.pamphlet.ui.main.cirlesList.sortlist;

import java.util.Comparator;

import com.comicon.pamphlet.data.model.CirclesModel;

/**
 * 
 * @author xiaanming
 *
 */
public class PinyinComparator implements Comparator<CirclesModel> {

	public int compare(CirclesModel o1, CirclesModel o2) {
		if (o1.getSortLetters().equals("@")
				|| o2.getSortLetters().equals("#")) {
			return -1;
		} else if (o1.getSortLetters().equals("#")
				|| o2.getSortLetters().equals("@")) {
			return 1;
		} else {
			return o1.getSortLetters().compareTo(o2.getSortLetters());
		}
	}

}
