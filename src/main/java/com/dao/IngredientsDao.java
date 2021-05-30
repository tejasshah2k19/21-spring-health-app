package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

	public List<IngredientsBean> getAllIngredients() {

		List<IngredientsBean> allIngredients = stmt.query("select * from ingredients",
				new BeanPropertyRowMapper<IngredientsBean>(IngredientsBean.class));

		return allIngredients;
	}

	public void deleteIngredientById(int id) {
		stmt.update("delete from ingredients where ingredientsId  = " + id);

	}

	public List<IngredientsBean> searchIngredientsByName(String name) {
		name = name+"%";
		List<IngredientsBean> allIngredients = stmt.query("select * from ingredients where name like ?",
				new Object[] {name},new BeanPropertyRowMapper<IngredientsBean>(IngredientsBean.class));

		return allIngredients;
	}

}
