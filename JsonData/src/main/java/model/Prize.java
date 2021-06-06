package model;

import java.util.List;

public class Prize {
	private int year;
	private String category;
	private String overallMotivation;
	private List<Laureates> laureates;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getOverallMotivation() {
		return overallMotivation;
	}
	public void setOverallMotivation(String overallMotivation) {
		this.overallMotivation = overallMotivation;
	}
	public List<Laureates> getLaureates() {
		return laureates;
	}
	public void setLaureates(List<Laureates> laureates) {
		this.laureates = laureates;
	}
	


}
