package io.sahil.f1dashboard.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Season {

	@Id
	private int year;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	
}
