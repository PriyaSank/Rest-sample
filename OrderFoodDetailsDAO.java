package com.priya.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.priya.model.FoodItemModel;
import com.priya.model.OrderDetailsModel;
import com.priya.model.OrderFoodDetailsModel;

import com.priya.util.ConnectionUtil;

public class OrderFoodDetailsDAO {
JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	
	public void save(OrderFoodDetailsModel orderFood) {

		String sql = "insert into order_food_details(ORDER_ID,FOOD_ID,FOOD_COUNT) values(?,?,?)";
		Object[] params = { orderFood.getOrder().getId(),orderFood.getFood().getId(),orderFood.getFoodCount() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);
	}
	
	public void update(OrderFoodDetailsModel orderFood) {

		String sql = "update order_food_details set SET ORDER_STATUS=? where ORDER_ID=?";
		Object[] params = { orderFood.getOrderStatus(),orderFood.getOrder().getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}
	
	public void delete(int id) {

		String sql = "delete from order_food_details where id=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);

	}
	
	public List<OrderFoodDetailsModel> list1() {
		String sql = "select * from order_food_details";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			OrderFoodDetailsModel orderFood=new OrderFoodDetailsModel();
			orderFood.setId(rs.getInt("ID"));
			OrderDetailsModel order=new OrderDetailsModel();
			order.setId(rs.getInt("ORDER_ID"));
			orderFood.setOrder(order);
			orderFood.setOrderTimestamp(rs.getTimestamp("ORDER_TIMESTAMP").toLocalDateTime());
			FoodItemModel food=new FoodItemModel();
			food.setId(rs.getInt("FOOD_ID"));
			orderFood.setFood(food);
			orderFood.setFoodCount(rs.getInt("FOOD_COUNT"));
			orderFood.setOrderStatus(rs.getString("STATUS"));
			return orderFood;	
		});

}

	public OrderFoodDetailsModel list2(int id) {
		String sql = "select * from order_food_details where ID=?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql,params, (rs, rowNum) -> {
			OrderFoodDetailsModel orderFood=new OrderFoodDetailsModel();
			orderFood.setId(rs.getInt("ID"));
			OrderDetailsModel order=new OrderDetailsModel();
			order.setId(rs.getInt("ORDER_ID"));
			orderFood.setOrder(order);
			orderFood.setOrderTimestamp(rs.getTimestamp("ORDER_TIMESTAMP").toLocalDateTime());
			FoodItemModel food=new FoodItemModel();
			food.setId(rs.getInt("FOOD_ID"));
			orderFood.setFood(food);
			orderFood.setFoodCount(rs.getInt("FOOD_COUNT"));
			orderFood.setOrderStatus(rs.getString("STATUS"));
			return orderFood;
		});
}
	public List<OrderFoodDetailsModel> list3(int id) {
		String sql = "select * from order_food_details where ORDER_ID=?";
		Object[] params = { id };
		return jdbcTemplate.query(sql,params, (rs, rowNum) -> {
			OrderFoodDetailsModel orderFood=new OrderFoodDetailsModel();
			orderFood.setId(rs.getInt("ID"));
			OrderDetailsModel order=new OrderDetailsModel();
			order.setId(rs.getInt("ORDER_ID"));
			orderFood.setOrder(order);
			orderFood.setOrderTimestamp(rs.getTimestamp("ORDER_TIMESTAMP").toLocalDateTime());
			FoodItemModel food=new FoodItemModel();
			food.setId(rs.getInt("FOOD_ID"));
			orderFood.setFood(food);
			orderFood.setFoodCount(rs.getInt("FOOD_COUNT"));
			orderFood.setOrderStatus(rs.getString("STATUS"));
			return orderFood;
		});
		}
	
	
}
