package ua.nure.uvarov.Practice7.entity;

import java.util.ArrayList;
import java.util.List;

public class Gem {

	private String name;

	private List<Properties> properties;

	public String getGemName() {
		return name;
	}

	public void setGemName(String value) {
		this.name = value;
	}

	public List<Properties> getProperties() {
		if (properties == null) {
			properties = new ArrayList<Properties>();
		}
		return properties;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(name).append(System.lineSeparator());
		for (Properties properties : properties) {
			result.append(properties).append(System.lineSeparator());
		}
		return result.toString();
	}
}