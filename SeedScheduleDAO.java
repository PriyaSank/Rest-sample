package com.priya.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.priya.model.SeedScheduleModel;
import com.priya.util.ConnectionUtil;

public class SeedScheduleDAO {
JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	
	public void save(SeedScheduleModel seed) {

		String sql = "insert into seed_schedule(ID,NAME,FROM_TIME,TO_TIME) values(?,?,?,?)";
		Object[] params = { seed.getId(), seed.getName(),seed.getFromTime(),seed.getToTime() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);
	}
	
	public void update1(SeedScheduleModel seed) {

		String sql = "update seed-schedule set SET FROM_TIME=? ,TO_TIME=? where ID=?";
		Object[] params = { seed.getFromTime(),seed.getToTime(),seed.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void update2(SeedScheduleModel seed) {

		String sql = "update seed_schedule set SET NAME=? where ID=?";
		Object[] params = { seed.getName(),seed.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	
	public void delete(int id) {

		String sql = "delete from seed_schedule where id=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);

	}
	
	public List<SeedScheduleModel> list() {
		String sql = "select * from seed_schedule";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			SeedScheduleModel seed= convert(rs);
			return seed;
		});

}

	private SeedScheduleModel convert(ResultSet rs) throws SQLException {
		SeedScheduleModel seed=new SeedScheduleModel();
		seed.setId(rs.getInt("ID"));
		seed.setName(rs.getString("NAME"));
		seed.setFromTime(rs.getTime("FROM_TIME").toLocalTime());
		seed.setFromTime(rs.getTime("TO_TIME").toLocalTime());
		return seed;
	}
}
