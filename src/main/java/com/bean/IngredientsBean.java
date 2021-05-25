package com.bean;

public class IngredientsBean {

	int ingredientsId;
	String name;
	String description;
	String effects;
	String source;
	int active;
	String notConsumeBy;

	public int getIngredientsId() {
		return ingredientsId;
	}

	public void setIngredientsId(int ingredientsId) {
		this.ingredientsId = ingredientsId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEffects() {
		return effects;
	}

	public void setEffects(String effects) {
		this.effects = effects;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getNotConsumeBy() {
		return notConsumeBy;
	}

	public void setNotConsumeBy(String notConsumeBy) {
		this.notConsumeBy = notConsumeBy;
	}

}
