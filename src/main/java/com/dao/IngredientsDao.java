package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.IngredientsBean;

@Repository
public class IngredientsDao {

	@Autowired
	JdbcTemplate stmt;

	public void saveIngredient(IngredientsBean ingredient) {
		stmt.update(
				"insert into ingredients (name,description,effects,source,active,notConsumeBy) values (?,?,?,?,?,?)",
				ingredient.getName(), ingredient.getDescription(), ingredient.getEffects(), ingredient.getSource(),
				ingredient.getActive(), ingredient.getNotConsumeBy());
	}
}
