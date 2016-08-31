package com.kakanshun.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
@RequestMapping("/manage")
public class ManageController {
	private UserDao userdao = new UserDaoImpl();
	private BookDao bookdao = new BookDaoImpl();

	@RequestMapping(value = "/manage.do")
	public ModelAndView regist(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(); // 返回首页
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			if (user.getUlimit() == 0) {
				request.setAttribute("message", "<script>"
						+ "alert('欢迎来到图书管理后台中心！');" + "</script>");
				mav.setViewName("manage/index.jsp");
			} else {
				request.setAttribute("message", "<script>"
						+ "alert('对不起，您当前用户没有管理权限，请切换账号进行登录！');" + "</script>");
				mav.setViewName("manage/login.jsp");
			}
		} else {
			request.setAttribute("message", "<script>" + "alert('对不起，您还未登录！');"
					+ "</script>");
			mav.setViewName("manage/login.jsp");
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
			if (user.getUlimit() == 0) {
				HttpSession session = request.getSession();// 用户登录会话开始
				session.setAttribute("user", user);
				request.setAttribute("message", "<script>"
						+ "alert('恭喜您，登录成功！');" + "</script>");
				mav.setViewName("manage/index.jsp");
			} else {
				request.setAttribute("message", "<script>"
						+ "alert('对不起，该用户没有操作权限，请重新登录！');" + "</script>");
				mav.setViewName("manage/login.jsp");
			}
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
		mav.setViewName("manage/inputinfo.jsp");
		return mav;
	}

	@RequestMapping(value = "/inputinfo.do")
	public ModelAndView findbookbytype(HttpServletRequest request)
			throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView(); // 返回首页
		HttpSession session = request.getSession();
		String findtype = (String) session.getAttribute("findtype");
		String inputinfo = "";
		List<Book> list = new ArrayList<Book>();
		Book book = new Book();

		if (request.getParameter("inputinfo") != null
				&& request.getParameter("inputinfo") != "") {
			inputinfo = new String(request.getParameter("inputinfo").getBytes(
					"ISO-8859-1"), "UTF-8"); // 获得版块名称
		}

		if ("bylentbook".equals(findtype)) {
			list = bookdao.findAllLentBooks();
			mav.setViewName("manage/findalllentbook.jsp");
		} else if ("bynotlentbook".equals(findtype)) {
			list = bookdao.findAllNotLentBooks();
			mav.setViewName("manage/findallnotlentbook.jsp");
		} else if ("bybookname".equals(findtype)) {
			list = bookdao.findBookByBookName(inputinfo);
			mav.setViewName("manage/findallbook.jsp");
		} else if ("bybooktype".equals(findtype)) {
			list = bookdao.findBookByBookType(inputinfo);
			mav.setViewName("manage/findallbook.jsp");
		} else if ("bybooknum".equals(findtype)) {
			book = bookdao.findBookByBookNum(inputinfo);
			list.add(book);
			mav.setViewName("manage/findallbook.jsp");
		} else if ("bybookauthor".equals(findtype)) {
			list = bookdao.findBookByBookAuthor(inputinfo);
			mav.setViewName("manage/findallbook.jsp");
		}
		session.setAttribute("booklist", list);

		return mav;
	}

	@RequestMapping(value = "/findlentbook.do")
	public ModelAndView findlentbook(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(); // 返回首页
		List<Book> list = new ArrayList<Book>();

		list = bookdao.findAllLentBooks();
		mav.setViewName("manage/findalllentbook.jsp");
		request.getSession().setAttribute("booklist", list);

		return mav;
	}

	@RequestMapping(value = "/findnotlentbook.do")
	public ModelAndView findnotlentbook(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(); // 返回首页
		HttpSession session = request.getSession();
		List<Book> list = new ArrayList<Book>();

		list = bookdao.findAllNotLentBooks();
		mav.setViewName("manage/findallnotlentbook.jsp");
		session.setAttribute("booklist", list);

		return mav;
	}

	@RequestMapping(value = "/findallbook.do")
	public ModelAndView findallbook(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(); // 返回首页
		List<Book> booklist = bookdao.findAllBook();
		HttpSession session = request.getSession();
		session.setAttribute("booklist", booklist);

		mav.setViewName("manage/findallbook.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/findalluser.do")
	public ModelAndView findalluser(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(); // 返回首页
		List<User> userlist = new ArrayList<User>();
		HttpSession session = request.getSession();
		
		userlist = userdao.findAllUser();
		session.setAttribute("userlist", userlist);
		if(userlist!=null) {
			System.out.println(userlist.size());
		}
		mav.setViewName("manage/findalluser.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/findallgeneraluser.do")
	public ModelAndView findallgeneraluser(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(); // 返回首页
		List<User> userlist = new ArrayList<User>();
		HttpSession session = request.getSession();
		
		userlist = userdao.findAllGeneralUser();
		session.setAttribute("userlist", userlist);
		if(userlist!=null) {
			System.out.println(userlist.size());
		}
		mav.setViewName("manage/findalluser.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/findallforbiddenuser.do")
	public ModelAndView findallforbiddenuser(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(); // 返回首页
		List<User> userlist = new ArrayList<User>();
		HttpSession session = request.getSession();
		
		userlist = userdao.findAllForbiddenUser();
		session.setAttribute("userlist", userlist);
		if(userlist!=null) {
			System.out.println(userlist.size());
		}
		mav.setViewName("manage/findalluser.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/bookmanage.do")
	public ModelAndView bookmanage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(); // 返回首页
		List<Book> booklist = new ArrayList<Book>();
		HttpSession session = request.getSession();
	
		booklist = bookdao.findAllBook();
		session.setAttribute("booklist", booklist);
		mav.setViewName("manage/bookmanage.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/addbook.do")
	public ModelAndView addbook(Book book) {
		ModelAndView mav = new ModelAndView(); // 返回首页
		bookdao.addBook(book);
		mav.setViewName("manage/bookmanage.do");
		return mav;
	}
	
	@RequestMapping(value = "/updatebook_{booknum}.do")
	public ModelAndView updatebook(@PathVariable("booknum") String booknum,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(); // 返回首页
		Book book = bookdao.findBookByBookNum(booknum);
		request.getSession().setAttribute("updatebook", book);
		mav.setViewName("manage/updatebook.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/updatebook.do")
	public ModelAndView updatebook(Book book) {
		ModelAndView mav = new ModelAndView(); // 返回首页
		bookdao.updateBook(book);
		mav.setViewName("manage/bookmanage.do");
		return mav;
	}
	
	@RequestMapping(value = "/deletebook_{booknum}.do")
	public ModelAndView deletebook(@PathVariable("booknum") String booknum,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(); // 返回首页
		bookdao.deleteBookByBookNum(booknum);
		request.setAttribute("message", "<script>"
				+ "alert('删除信息成功！');" + "</script>");
		mav.setViewName("manage/bookmanage.do");
		return mav;
	}
	
	@RequestMapping(value = "/usermanage.do")
	public ModelAndView usermanage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(); // 返回首页
		List<User> userlist = new ArrayList<User>();
		HttpSession session = request.getSession();
	
		userlist = userdao.findAllUser();
		session.setAttribute("userlist", userlist);
		mav.setViewName("manage/usermanage.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/adduser.do")
	public ModelAndView adduser(User user) {
		ModelAndView mav = new ModelAndView(); // 返回首页
		userdao.addUser(user);
		mav.setViewName("manage/usermanage.do");
		return mav;
	}
	
	@RequestMapping(value = "/updateuser_{id}.do")
	public ModelAndView updateuser(@PathVariable("id") String id,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(); // 返回首页
		Integer uid = Integer.parseInt(id.trim());
		User user = userdao.findUserById(uid);
		request.getSession().setAttribute("updateuser", user);
		mav.setViewName("manage/updateuser.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/updateuser.do")
	public ModelAndView updateuser(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(); // 返回首页
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("updateuser");
		System.out.println(u);
//		if(u!=null) {
//			user.setId(u.getId());
//			user.setPassword(u.getPassword());
//		}
		u.setUsername(request.getParameter("username"));
		u.setUlimit(Integer.parseInt(request.getParameter("ulimit")));
		u.setNum(request.getParameter("num"));
		userdao.updateUser(u);
		System.out.println(u);
		mav.setViewName("manage/usermanage.do");
		return mav;
	}
	
	@RequestMapping(value = "/deleteuser_{id}.do")
	public ModelAndView deleteuser(@PathVariable("id") String id,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(); // 返回首页
		Integer uid = Integer.parseInt(id.trim());
		userdao.deleteUserById(uid);
		request.setAttribute("message", "<script>"
				+ "alert('删除信息成功！');" + "</script>");
		mav.setViewName("manage/usermanage.do");
		return mav;
	}
}
