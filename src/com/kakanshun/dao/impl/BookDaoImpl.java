package com.kakanshun.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kakanshun.dao.BookDao;
import com.kakanshun.domain.Book;
import com.kakanshun.util.JdbcUtil;

public class BookDaoImpl implements BookDao {

	private ResultSet rs = null;
	private JdbcUtil dao = new JdbcUtil();

	@Override
	public boolean addBook(Book book) {
		String sql = "insert into book(booknum,bookname,booktype,bookauthor,money) values(?,?,?,?,?)";
		int result = -1;
		try {
			result = dao.executeUpdate(
					sql,
					new Object[] { book.getBooknum(), book.getBookname(),
							book.getBooktype(), book.getBookauthor(),
							book.getMoney() });
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dao.closeStatement();
			dao.closeConnection();
		}
		return result > 0 ? true : false;
	}

	@Override
	public boolean updateBook(Book book) {
		String sql = "update book set bookname = ?,booktype = ?,bookauthor = ?,money = ? where booknum = ?";
		int result = -1;
		try {
			result = dao.executeUpdate(sql, new Object[] { book.getBookname(),
					book.getBooktype(), book.getBookauthor(), book.getMoney(),
					book.getBooknum() });
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dao.closeStatement();
			dao.closeConnection();
		}
		return result > 0 ? true : false;
	}

	@Override
	public boolean deleteBookByBookNum(String booknum) {
		String sql = "delete from book where booknum = ?";
		int result = -1;
		try {
			result = dao.executeUpdate(sql, new Object[] { booknum });
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dao.closeStatement();
			dao.closeConnection();
		}
		return result > 0 ? true : false;
	}

	@Override
	public Book findBookByBookNum(String booknum) {
		String sql = "select * from book  where booknum = ?";
		Book book = new Book();
		try {
			rs = dao.executeQuery(sql, new Object[] { booknum });// 执行查询
			while (rs != null && rs.next()) { // 如果查找到记录
				book.setBooknum(rs.getString("booknum"));
				book.setBookname(rs.getString("bookname"));
				book.setBookauthor(rs.getString("bookauthor"));
				book.setBooktype(rs.getString("booktype"));
				book.setLendtime(rs.getDate("lendtime"));
				book.setMoney(rs.getFloat("money"));
				book.setUser_id(rs.getInt("user_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dao.closeResultSet();
			dao.closeStatement();
			dao.closeConnection();
		}
		return book;
	}

	@Override
	public List<Book> findBookByBookName(String bookname) {
		String sql = "select * from book  where bookname = ?";
		List<Book> list = new ArrayList<Book>();
		try {
			rs = dao.executeQuery(sql, new Object[] { bookname });// 执行查询
			while (rs != null && rs.next()) { // 如果查找到记录
				Book book = new Book();
				book.setBooknum(rs.getString("booknum"));
				book.setBookname(rs.getString("bookname"));
				book.setBookauthor(rs.getString("bookauthor"));
				book.setBooktype(rs.getString("booktype"));
				book.setLendtime(rs.getDate("lendtime"));
				book.setMoney(rs.getFloat("money"));
				book.setUser_id(rs.getInt("user_id"));
				list.add(book);
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
	public List<Book> findBookByBookAuthor(String bookauthor) {
		String sql = "select * from book  where bookauthor = ?";
		List<Book> list = new ArrayList<Book>();
		try {
			rs = dao.executeQuery(sql, new Object[] { bookauthor });// 执行查询
			while (rs != null && rs.next()) { // 如果查找到记录
				Book book = new Book();
				book.setBooknum(rs.getString("booknum"));
				book.setBookname(rs.getString("bookname"));
				book.setBookauthor(rs.getString("bookauthor"));
				book.setBooktype(rs.getString("booktype"));
				book.setLendtime(rs.getDate("lendtime"));
				book.setMoney(rs.getFloat("money"));
				book.setUser_id(rs.getInt("user_id"));
				list.add(book);
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
	public List<Book> findBookByBookType(String booktype) {
		String sql = "select * from book  where booktype = ?";
		List<Book> list = new ArrayList<Book>();
		try {
			rs = dao.executeQuery(sql, new Object[] { booktype });// 执行查询
			while (rs != null && rs.next()) { // 如果查找到记录
				Book book = new Book();
				book.setBooknum(rs.getString("booknum"));
				book.setBookname(rs.getString("bookname"));
				book.setBookauthor(rs.getString("bookauthor"));
				book.setBooktype(rs.getString("booktype"));
				book.setLendtime(rs.getDate("lendtime"));
				book.setMoney(rs.getFloat("money"));
				book.setUser_id(rs.getInt("user_id"));
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
	public boolean updateBookLendByBookNum(Date lendtime, int user_id,
			String booknum) {
		String sql = "update book set lendtime = ?,user_id = ? where booknum = ?";
		int result = -1;
		try {
			result = dao.executeUpdate(sql, new Object[] { lendtime, user_id,
					booknum });
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dao.closeStatement();
			dao.closeConnection();
		}
		return result > 0 ? true : false;
	}

	@Override
	public int bookCount() {
		String sql = "select * from book";
		int count = 0;
		try {
			rs = dao.executeQuery(sql, new Object[] {});// 执行查询
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
	public List<Book> findAllBook() {
		String sql = "select * from book";
		List<Book> list = new ArrayList<Book>();
		try {
			rs = dao.executeQuery(sql, new Object[] {});// 执行查询
			while (rs != null && rs.next()) { // 如果查找到记录
				Book book = new Book();
				book.setBooknum(rs.getString("booknum"));
				book.setBookname(rs.getString("bookname"));
				book.setBookauthor(rs.getString("bookauthor"));
				book.setBooktype(rs.getString("booktype"));
				book.setLendtime(rs.getDate("lendtime"));
				book.setMoney(rs.getFloat("money"));
				book.setUser_id(rs.getInt("user_id"));
				list.add(book);
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
	public List<Book> findBooksByUserId(int id) {
		String sql = "select * from book where user_id=?";
		List<Book> list = new ArrayList<Book>();
		try {
			rs = dao.executeQuery(sql, new Object[] { id });// 执行查询
			while (rs != null && rs.next()) { // 如果查找到记录
				Book book = new Book();
				book.setBooknum(rs.getString("booknum"));
				book.setBookname(rs.getString("bookname"));
				book.setBookauthor(rs.getString("bookauthor"));
				book.setBooktype(rs.getString("booktype"));
				book.setLendtime(rs.getDate("lendtime"));
				book.setMoney(rs.getFloat("money"));
				book.setUser_id(rs.getInt("user_id"));
				list.add(book);
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
	public List<Book> findAllLentBooks() {
		String sql = "select * from book where user_id>0";
		List<Book> list = new ArrayList<Book>();
		try {
			rs = dao.executeQuery(sql, new Object[] { });// 执行查询
			while (rs != null && rs.next()) { // 如果查找到记录
				Book book = new Book();
				book.setBooknum(rs.getString("booknum"));
				book.setBookname(rs.getString("bookname"));
				book.setBookauthor(rs.getString("bookauthor"));
				book.setBooktype(rs.getString("booktype"));
				book.setLendtime(rs.getDate("lendtime"));
				book.setMoney(rs.getFloat("money"));
				book.setUser_id(rs.getInt("user_id"));
				list.add(book);
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
	public List<Book> findAllNotLentBooks() {
		String sql = "select * from book where user_id=0";
		List<Book> list = new ArrayList<Book>();
		try {
			rs = dao.executeQuery(sql, new Object[] { });// 执行查询
			while (rs != null && rs.next()) { // 如果查找到记录
				Book book = new Book();
				book.setBooknum(rs.getString("booknum"));
				book.setBookname(rs.getString("bookname"));
				book.setBookauthor(rs.getString("bookauthor"));
				book.setBooktype(rs.getString("booktype"));
				book.setLendtime(rs.getDate("lendtime"));
				book.setMoney(rs.getFloat("money"));
				book.setUser_id(rs.getInt("user_id"));
				list.add(book);
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

}
