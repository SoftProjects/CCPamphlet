package com.comicon.pamphlet.ui.main.cirlesList.sortlist;

import java.util.Comparator;

import com.comicon.pamphlet.data.model.CircleModel;

/**
 * 
 * @author xiaanming
 *
 */
public class PinyinComparator implements Comparator<CircleModel> {

	public int compare(CircleModel o1, CircleModel o2) {
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
