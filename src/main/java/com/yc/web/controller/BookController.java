package com.yc.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.yc.bean.Book;
import com.yc.bean.Category;
import com.yc.biz.BookBiz;
import com.yc.dao.BaseDao;
import com.yc.web.utils.UploadFileUtil;
import com.yc.web.utils.UploadFileUtil.UploadFile;

@Controller
public class BookController {
	private BookBiz bookBiz;
	private Book book ;
	private Category cate ;
	private String pdfRootName ="uploadPdfs";
	
	/**
	 * Resource 资源
	 * @param bookBiz
	 */
	@Resource(name="bookBizImpl")
	public void setBookBiz(BookBiz bookBiz) {
		this.bookBiz = bookBiz;
	}
	@Resource(name="category")
	public void setCategory(Category category) {
		this.cate = category;
	}
	@Resource(name="book")
	public void setBook(Book book) {
		this.book = book;
	}
	
	
	/**
	 * 查出所有的书，跳往 list_book页面
	 * @param request
	 * @param book
	 * @return
	 */
	@RequestMapping(value="/admin/book.action")
	public ModelAndView add4() {
		ModelAndView mv =new ModelAndView("list_book");
		List<Book> list =bookBiz.SelectAll(book);
		mv.addObject("book", list);
		return mv;
	}
	
	/**
	 * 查出所有的类别  , 跳往添加书的页面, to -> input_book
	 * @return
	 */
	@RequestMapping("/admin/toinput_book.action")
	public ModelAndView addBook(){
		ModelAndView mv =new ModelAndView("input_book");
		List<Category> list =bookBiz.SelectAllCate(cate);
		mv.addObject("cate", list);
		return mv;
	}
	
	/**
	 * 点击添加书按钮，执行添加操作  saveBook
	 * @param book
	 * @param request
	 * @return
	 */
	@RequestMapping("/admin/save_book.action")//HttpServletRequest request ,@ModelAttribute Book book
	public ModelAndView saveBook(Book book,HttpServletRequest request){
		ModelAndView mv =new ModelAndView("redirect:/admin/book.action");
		String tid=request.getParameter("tid");
		Integer it = Integer.valueOf(tid);
		cate.setTid(it);
		book.setCategory(cate);
		
		String pdfs="";
		//上传
		Map<String,UploadFile> map = UploadFileUtil.uploadFile(request, book.getPdfsUrl(), pdfRootName);
		for(Entry<String,UploadFile> entry:map.entrySet() ){
			UploadFile uploadFile=entry.getValue();
			pdfs+= uploadFile.getNewFileUrl()+",";
		}
		book.setPdfs(pdfs);
		System.out.println(book);
		
		bookBiz.addBook(book);
		return mv;
	}
	
	/**
	 * 跳往编辑 (更新) 页面    to -> edit_book
	 * @param bid
	 * @return
	 */
	@RequestMapping(value="/admin/toedit_book/{bid}.action")
	public ModelAndView editBook(@PathVariable("bid") int bid ){
		ModelAndView mv =new ModelAndView("edit_book");
		List<Category> list =bookBiz.SelectAllCate(cate);
		mv.addObject("cate", list);
		book.setBid(bid);
		mv.addObject("bookOne", bookBiz.SelectOne(book).get(0));
		
		System.out.println( bookBiz.SelectOne(book).get(0) );
		return mv;
	}
	
	/**
	 * 点击修改按钮， 实施更新
	 * @param book
	 * @param request
	 * @return
	 */
	@RequestMapping("/admin/saveEdit_book.action")
	public ModelAndView updateBook(Book book,HttpServletRequest request){
		ModelAndView mv =new ModelAndView("redirect:/admin/book.action");
		String tid=request.getParameter("tid");
		String bid=request.getParameter("bid");
		
		Integer ti = Integer.valueOf(tid);
		Integer bi = Integer.valueOf(bid);
		cate.setTid(ti);
		book.setCategory(cate);
		book.setBid(bi);
		
		String pdfs="";
		//上传
		Map<String,UploadFile> map = UploadFileUtil.uploadFile(request, book.getPdfsUrl(), pdfRootName);
		for(Entry<String,UploadFile> entry:map.entrySet() ){
			UploadFile uploadFile=entry.getValue();
			pdfs+= uploadFile.getNewFileUrl()+",";
		}
		book.setPdfs(pdfs);
		System.out.println(book);
		
		bookBiz.UpdateBook(book);
		return mv;
	}
	
	/**
	 * 跳往  toLogin，页面
	 * @return
	 */
	@RequestMapping(value="/toLogin.action")
	public String toLodin(){
		return "login";
	}
	
	/**
	 * 点击登录按钮
	 * @param validateCode
	 * @param uname
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/adminLogin.action")
	public String adminLogin(@RequestParam String validateCode,@RequestParam String uname,
			@RequestParam String password,HttpSession session ){
		String randCode = (String) session.getAttribute("rand");
		if(!validateCode.equals(randCode) ){
			session.setAttribute("errmsg", "验证码错误");
			return "login";
		}
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("adminLogin.properties");
		Properties p = new Properties();
		try{
			p.load(inputStream);
		}catch(IOException e1){
			e1.printStackTrace();
		}
		if(p.getProperty("uname").equals(uname) && p.getProperty("password").equals(password) ){
			session.setAttribute("uname", uname);
			return "redirect:/admin/book.action";
		}else{
			session.setAttribute("errmsg", "用户名或密码错误");
			return "login";
		}
	}
	
	/**
	 * 跳往前台页面
	 * @return
	 */
	@RequestMapping("/toStudentBookListForm")
	public ModelAndView toStudentBookListForm(){
		ModelAndView mv =new ModelAndView("studentBookListForm");
		mv.addObject("book", bookBiz.SelectAll(book));
		mv.addObject("cate",  bookBiz.SelectAllCate(cate));
		return mv;
	}
	
	/**
	 * 跳往  详情页面 ->toDetailForm
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/toDetailForm/{id}.action")
	public String toDetailBookForm(Model model,@PathVariable int id){
		model.addAttribute("cate",bookBiz.SelectAllCate(cate));
		book.setBid(id);
		model.addAttribute("book",(Book) this.bookBiz.SelectOne(book).get(0));
		return "detailBook";
	}
	
	/**
	 * 分类别查找,筛选
	 * @param model
	 * @param cid
	 * @return
	 */
	@RequestMapping(value="/findBookByCategory/{cid}",produces="text/html;charset=UTF-8")
	public @ResponseBody String findBookByCategory(Model model,@PathVariable int cid){
		cate.setTid(cid);
		book.setCategory(cate);
		List<Book> bookList;
		
		if(cid<=0){
			bookList= bookBiz.SelectAll(book);
		}else{
			bookList = this.bookBiz.getBooksByCategory(book);
		}
		
		System.out.println("bookList   "+bookList);
		Gson gson =new Gson();
		return gson.toJson(bookList);
	}
	
}
