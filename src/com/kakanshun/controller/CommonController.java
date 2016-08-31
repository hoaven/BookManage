package com.kakanshun.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kakanshun.dao.BookDao;
import com.kakanshun.dao.UserDao;
import com.kakanshun.dao.impl.BookDaoImpl;
import com.kakanshun.dao.impl.UserDaoImpl;
import com.kakanshun.domain.Book;
import com.kakanshun.domain.User;

@Controller
@RequestMapping("/common")
public class CommonController {

	private UserDao userdao = new UserDaoImpl();
	private BookDao bookdao = new BookDaoImpl();

	@RequestMapping(value = "/regist.do")
	public ModelAndView regist(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(); // 返回首页
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String num = request.getParameter("num");
		User user = userdao.findUserByUsername(username);
		System.out.println("用户名：" + username);
		if (user != null && user.getUsername() != null
				&& user.getUsername() != "") {
			request.setAttribute("message", "<script>"
					+ "alert('对不起，该用户名已经存在！');" + "</script>");
			mav.setViewName("common/regist.jsp");
		} else {
			User u = new User();
			u.setNum(num);
			u.setPassword(password);
			u.setUsername(username);

			userdao.addUser(u);
			request.setAttribute("message", "<script>" + "alert('恭喜您，注册成功');"
					+ "</script>");
			mav.setViewName("");
		}
		return mav;

	}

	@RequestMapping(value = "/login.do")
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(); // 返回首页
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userdao.findUserByUsernameAndPassword(username, password);
		if (user != null && user.getUsername() != null
				&& user.getUsername() != "") {
			HttpSession session = request.getSession();// 用户登录会话开始
			session.setAttribute("user", user);
			request.setAttribute("message", "<script>" + "alert('恭喜您，登录成功！');"
					+ "</script>");
			mav.setViewName("/");
		} else {
			request.setAttribute("message", "<script>"
					+ "alert('用户名或密码错误，请重新登录');" + "</script>");
			mav.setViewName("common/login.jsp");
		}
		return mav;
	}

	@RequestMapping(value = "/findbook_{findtype}.do")
	public ModelAndView findbook(@PathVariable("findtype") String findtype,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(); // 返回首页
		request.getSession().setAttribute("findtype", findtype);
		mav.setViewName("common/inputinfo.jsp");
		return mav;
	}

	@RequestMapping(value = "/inputinfo.do")
	public ModelAndView findbookbytype(HttpServletRequest request) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView(); // 返回首页
		HttpSession session = request.getSession();
		String findtype = (String) session.getAttribute("findtype");
		String inputinfo = "";
		Book book = new Book();
		List<Book> list = new ArrayList<Book>();
		inputinfo = request.getParameter("inputinfo");
//		if (request.getParameter("inputinfo") != null
//				&& request.getParameter("inputinfo") != "") {
//			inputinfo = new String(request.getParameter("inputinfo").getBytes(
//					"ISO-8859-1"), "UTF-8");		// 获得版块名称
//			System.out.println("输入的值2："+inputinfo);
//		}
		if("bybookname".equals(findtype)) {
			list = bookdao.findBookByBookName(inputinfo);
		}else if("bybooktype".equals(findtype)) {
			list = bookdao.findBookByBookType(inputinfo);
		}else if("bybooknum".equals(findtype)) {
			book = bookdao.findBookByBookNum(inputinfo);
			list.add(book);
		}else if("bybookauthor".equals(findtype)) {
			list = bookdao.findBookByBookAuthor(inputinfo);
		}
		session.setAttribute("booklist", list);
		mav.setViewName("common/findallbook.jsp");
		return mav;
	}

	@RequestMapping(value = "/updateuser_{id}.do")
	public ModelAndView updateuser(@PathVariable("id") String id,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(); // 返回首页
		Integer uid = Integer.parseInt(id.trim());
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String num = request.getParameter("num");
		User u = new User();
		u.setNum(num);
		u.setPassword(password);
		u.setUsername(username);
		u.setId(uid);

		System.out.println(u);

		userdao.updateUser(u);
		request.setAttribute("message", "<script>" + "alert('恭喜您，修改信息成功');"
				+ "</script>");
		mav.setViewName("");
		return mav;
	}

	@RequestMapping(value = "/lendbook_{booknum}.do")
	public ModelAndView lendbook(@PathVariable("booknum") String booknum,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(); // 返回首页
		Book book = bookdao.findBookByBookNum(booknum);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		if (user != null) {
			if (user.getUlimit() > 0) {
				book.setUser_id(user.getId());
				Date date = new Date();
				book.setLendtime(date);
				System.out.println(book);
				bookdao.updateBookLendByBookNum(
						new java.sql.Date(date.getTime()), book.getUser_id(),
						book.getBooknum());
				request.setAttribute("message", "<script>"
						+ "alert('恭喜您借阅成功！');" + "</script>");
				mav.setViewName("");
			} else {
				request.setAttribute("message", "<script>"
						+ "alert('对不起，您所借书籍数目已达到最大数！');" + "</script>");
				mav.setViewName("");
			}
		} else {
			request.setAttribute("message", "<script>"
					+ "alert('对不起，您还未登录，无法借阅书籍！');" + "</script>");
			mav.setViewName("common/login.jsp");
		}

		return mav;
	}

	@RequestMapping(value = "/lendagain_{booknum}.do")
	public ModelAndView lendagain(@PathVariable("booknum") String booknum,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(); // 返回首页
		Book book = bookdao.findBookByBookNum(booknum);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		if (user != null) {
			book.setUser_id(user.getId());
			Date date = new Date();
			book.setLendtime(date);
			System.out.println(book);
			bookdao.updateBookLendByBookNum(new java.sql.Date(date.getTime()),
					book.getUser_id(), book.getBooknum());
			request.setAttribute("message", "<script>" + "alert('恭喜您借阅成功！');"
					+ "</script>");
			mav.setViewName("");
		} else {
			request.setAttribute("message", "<script>"
					+ "alert('对不起，您还未登录，无法借阅书籍！');" + "</script>");
			mav.setViewName("common/login.jsp");
		}

		return mav;
	}

	@RequestMapping(value = "/backbook_{booknum}.do")
	public ModelAndView backbook(@PathVariable("booknum") String booknum,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(); // 返回首页
		Book book = bookdao.findBookByBookNum(booknum);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		if (user != null) {
			book.setUser_id(user.getId());
			bookdao.updateBookLendByBookNum(null, 0, book.getBooknum());
			request.setAttribute("message", "<script>" + "alert('恭喜您归还图书成功！');"
					+ "</script>");
			mav.setViewName("");
		} else {
			request.setAttribute("message", "<script>"
					+ "alert('对不起，您还未登录，无法归还书籍！');" + "</script>");
			mav.setViewName("common/login.jsp");
		}

		return mav;
	}

	@RequestMapping(value = "/exit.do")
	public ModelAndView exit(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(); // 返回首页
		HttpSession session = request.getSession();

		session.invalidate();
		request.setAttribute("message", "<script>" + "alert('恭喜您登出成功！');"
				+ "</script>");
		mav.setViewName("");

		return mav;
	}

	@RequestMapping(value = "/lentbook.do")
	public ModelAndView lentbook(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(); // 返回首页
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		if (user != null) {
			List<Book> lentbook = bookdao.findBooksByUserId(user.getId());
			request.setAttribute("lentbook", lentbook);
			if(lentbook!=null) {
				System.out.println(lentbook.size());
			}
			mav.setViewName("common/lent.jsp");
		} else {
			request.setAttribute("message", "<script>"
					+ "alert('对不起，您还未登录，无法查看自己借阅的书籍！');" + "</script>");
			mav.setViewName("common/login.jsp");
		}

		return mav;
	}

	@RequestMapping(value = "/findallbook.do")
	public ModelAndView findallbook(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(); // 返回首页
		List<Book> booklist = bookdao.findAllBook();
		HttpSession session = request.getSession();
		session.setAttribute("booklist", booklist);

		mav.setViewName("common/findallbook.jsp");
		return mav;
	}

	@RequestMapping(value = "/findbookbybookname.do")
	public ModelAndView findbookbybookname(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(); // 返回首页
		List<Book> booklist = bookdao.findAllBook();
		HttpSession session = request.getSession();
		session.setAttribute("booklist", booklist);

		mav.setViewName("common/findallbook.jsp");
		return mav;
	}
}
