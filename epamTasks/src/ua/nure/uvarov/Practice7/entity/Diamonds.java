package ua.nure.uvarov.Practice7.entity;

import java.util.ArrayList;
import java.util.List;

public class Diamonds {

	private List<Gem> gems;

	public List<Gem> getGems() {
		if (gems == null) {
			gems = new ArrayList<Gem>();
		}
		return gems;
	}
	
	@Override
	public String toString() {
		if (gems == null || gems.size() == 0) {
			return "No more gems";
		}
		StringBuilder result = new StringBuilder();
		for (Gem gem : gems) {
			result.append(gem).append(System.lineSeparator());
		}
		return result.toString();
	}
}