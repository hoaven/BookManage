package com.kakanshun.dao;

import java.sql.Date;
import java.util.List;

import com.kakanshun.domain.Book;

public interface BookDao {
	/**
	 * 添加图书
	 * @param book
	 * @return
	 */
	public boolean addBook(Book book);
	
	/**
	 * 修改整个图书信息
	 * @param book
	 * @return
	 */
	public boolean updateBook(Book book);
	
	/**
	 * 根据图书编号删除图书信息
	 * @param booknum
	 * @return
	 */
	public boolean deleteBookByBookNum(String booknum);
	
	/**
	 * 根据图书编号查找图书信息
	 * @param booknum
	 * @return
	 */
	public Book findBookByBookNum(String booknum);
	
	/**
	 * 根据图书名称查找图书信息
	 * @param bookname
	 * @return
	 */
	public List<Book> findBookByBookName(String bookname);
	
	/**
	 * 根据图书作者查找图书信息
	 * @param bookauthor
	 * @return
	 */
	public List<Book> findBookByBookAuthor(String bookauthor);
	
	/**
	 * 根据图书类别查找图书信息
	 * @param booktype
	 * @return
	 */
	public List<Book> findBookByBookType(String booktype);
	
	/**
	 * 根据图书编号修改图书借阅情况
	 * @param lendtime
	 * @param user_id
	 * @param booknum
	 * @return
	 */
	public boolean updateBookLendByBookNum(Date lendtime,int user_id,String booknum);
	
	/**
	 * 计算图书总数目
	 * @return
	 */
	public int bookCount();
	
	/**
	 * 查找所有图书
	 * @return
	 */
	public List<Book> findAllBook();
	
	/**
	 * 根据用户id查找所有书籍（查找用户所借的书籍）
	 * @param id
	 * @return
	 */
	public List<Book> findBooksByUserId(int id);
	
	/**
	 * 查询已借图书信息
	 * @return
	 */
	public List<Book> findAllLentBooks();
	
	/**
	 * 查询所有未接图书
	 * @return
	 */
	public List<Book> findAllNotLentBooks();
	
	
}
