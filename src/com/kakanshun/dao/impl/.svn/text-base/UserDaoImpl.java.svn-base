package com.kakanshun.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kakanshun.dao.UserDao;
import com.kakanshun.domain.User;
import com.kakanshun.util.JdbcUtil;

public class UserDaoImpl implements UserDao {

	private ResultSet rs = null;
	private JdbcUtil dao = new JdbcUtil();
	
	@Override
	public boolean addUser(User user) {
		String sql = "insert into muser(username,password,num) values(?,?,?)";
		System.out.println(user);
		int result = -1;
		try {
			result = dao.executeUpdate(sql, new Object[] { user.getUsername(),user.getPassword(),user.getNum() });
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dao.closeStatement();
			dao.closeConnection();
		}
		return result > 0 ? true : false;
	}

	@Override
	public boolean updateUser(User user) {
		String sql = "update muser set username = ?,num = ?,ulimit = ? where id = ?";
		int result = -1;
		try {
			result = dao.executeUpdate(sql, new Object[] { user.getUsername(),user.getNum(),user.getUlimit(),user.getId() });
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dao.closeStatement();
			dao.closeConnection();
		}
		return result > 0 ? true : false;
	}

	@Override
	public boolean deleteUserById(int id) {
		String sql = "delete from muser where id = ?";
		int result = -1;
		try {
			result = dao.executeUpdate(sql, new Object[] { id });
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dao.closeStatement();
			dao.closeConnection();
		}
		return result > 0 ? true : false;
	}

	@Override
	public User findUserByUsername(String username) {
		String sql = "select * from muser  where username = ?";
		User user = new User();
		try {
			rs = dao.executeQuery(sql, new Object[] { username });// 执行查询
			while (rs != null && rs.next()) { // 如果查找到记录
				user.setId(rs.getInt("id")); 
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setNum(rs.getString("num")); 
				user.setUlimit(rs.getInt("ulimit"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dao.closeResultSet(); 
			dao.closeStatement(); 
			dao.closeConnection(); 
		}
		return user; 
	}

	@Override
	public User findUserByUsernameAndPassword(String username, String password) {
		String sql = "select * from muser  where username = ? and password = ?";
		User user = new User();
		try {
			rs = dao.executeQuery(sql, new Object[] { username,password });// 执行查询
			while (rs != null && rs.next()) { // 如果查找到记录
				user.setId(rs.getInt("id")); 
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setNum(rs.getString("num")); 
				user.setUlimit(rs.getInt("ulimit"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dao.closeResultSet(); 
			dao.closeStatement(); 
			dao.closeConnection(); 
		}
		return user; 
	}

	@Override
	public User findUserById(int id) {
		String sql = "select * from muser  where id = ?";
		User user = new User();
		try {
			rs = dao.executeQuery(sql, new Object[] { id });// 执行查询
			while (rs != null && rs.next()) { // 如果查找到记录
				user.setId(rs.getInt("id")); 
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setNum(rs.getString("num")); 
				user.setUlimit(rs.getInt("ulimit"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dao.closeResultSet(); 
			dao.closeStatement(); 
			dao.closeConnection(); 
		}
		return user; 
	}

	@Override
	public List<User> findAllUser() {
		String sql = "select * from muser";
		List<User> list = new ArrayList<User>();
		try {
			rs = dao.executeQuery(sql, new Object[] { });// 执行查询
			while (rs != null && rs.next()) { // 如果查找到记录
				User user = new User();
				user.setId(rs.getInt("id")); 
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setNum(rs.getString("num")); 
				user.setUlimit(rs.getInt("ulimit"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dao.closeResultSet(); 
			dao.closeStatement(); 
			dao.closeConnection(); 
		}
		return list; 
	}

	@Override
	public int findUserCount() {
		String sql = "select * from muser";
		int count = 0;
		try {
			rs = dao.executeQuery(sql, new Object[] { });// 执行查询
			while (rs != null && rs.next()) { // 如果查找到记录
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dao.closeResultSet(); 
			dao.closeStatement(); 
			dao.closeConnection(); 
		}
		return count; 
	}

	@Override
	public List<User> findAllGeneralUser() {
		String sql = "select * from muser where ulimit > 0";
		List<User> list = new ArrayList<User>();
		try {
			rs = dao.executeQuery(sql, new Object[] { });// 执行查询
			while (rs != null && rs.next()) { // 如果查找到记录
				User user = new User();
				user.setId(rs.getInt("id")); 
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setNum(rs.getString("num")); 
				user.setUlimit(rs.getInt("ulimit"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dao.closeResultSet(); 
			dao.closeStatement(); 
			dao.closeConnection(); 
		}
		return list; 
	}

	@Override
	public List<User> findAllForbiddenUser() {
		String sql = "select * from muser where ulimit = -1";
		List<User> list = new ArrayList<User>();
		try {
			rs = dao.executeQuery(sql, new Object[] { });// 执行查询
			while (rs != null && rs.next()) { // 如果查找到记录
				User user = new User();
				user.setId(rs.getInt("id")); 
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setNum(rs.getString("num")); 
				user.setUlimit(rs.getInt("ulimit"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dao.closeResultSet(); 
			dao.closeStatement(); 
			dao.closeConnection(); 
		}
		return list; 
	}

	@Override
	public boolean updateUserLimitById(int limit,int id) {
		String sql = "update muser set ulimit = ? where id = ?";
		int result = -1;
		try {
			result = dao.executeUpdate(sql, new Object[] { limit,id });
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dao.closeStatement();
			dao.closeConnection();
		}
		return result > 0 ? true : false;
	}

	@Override
	public boolean updateUserPassword(String password,int id) {
		String sql = "update muser set password = ? where id = ?";
		int result = -1;
		try {
			result = dao.executeUpdate(sql, new Object[] { password,id });
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dao.closeStatement();
			dao.closeConnection();
		}
		return result > 0 ? true : false;
	}

}
