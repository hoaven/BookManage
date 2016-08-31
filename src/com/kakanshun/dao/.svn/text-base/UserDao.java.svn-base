package com.kakanshun.dao;

import java.util.List;

import com.kakanshun.domain.User;

public interface UserDao {
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public boolean addUser(User user);
	
	/**
	 * 修改整个用户信息
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user);
	
	/**
	 * 根据id删除用户
	 * @param id
	 * @return
	 */
	public boolean deleteUserById(int id);
	
	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	public User findUserByUsername(String username);
	
	/**
	 * 根据用户名和密码查找用户
	 * @param username
	 * @param password
	 * @return
	 */
	public User findUserByUsernameAndPassword(String username,String password);
	
	/**
	 * 根据用户id查找用户
	 * @param id
	 * @return
	 */
	public User findUserById(int id);
	
	/**
	 * 查找所有用户
	 * @return
	 */
	public List<User> findAllUser();
	
	/**
	 * 查找用户总数目
	 * @return
	 */
	public int findUserCount();
	
	/**
	 * 查找所有普通用户
	 * @return
	 */
	public List<User> findAllGeneralUser();
	
	/**
	 * 查找所有禁用用户
	 * @return
	 */
	public List<User> findAllForbiddenUser();
	
	/**
	 * 根据用户id修改用户权限
	 * -1：禁用用户	 0：管理员	1-6：普通用户以及允许借阅书籍的数目
	 * @param id
	 * @return
	 */
	public boolean updateUserLimitById(int limit,int id);
	
	/**
	 * 根据用户id修改用户密码
	 * @param id
	 * @return
	 */
	public boolean updateUserPassword(String password,int id);
}
