package org.vsp.mup.helper;

import java.util.Comparator;
import org.vsp.mup.domain.Tag;

public class TagComparator<T> implements Comparator<T> {

	@Override
	public int compare(T o1, T o2) {
		return -((Tag)o1).getPopularity().compareTo(((Tag)o2).getPopularity());
	}
	
}
