package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.Book;
import com.yc.bean.Category;
import com.yc.biz.BookBiz;
import com.yc.dao.BaseDao;


@Service
public class BookBizImpl implements BookBiz {
	
	private BaseDao baseDao;
	private Category cate;
	
	@Override
	public List SelectAll(Book book) {
		List<Book> list=this.baseDao.findAll(book, "getAllBooks");
		return list;
	}
	
	@Override
	public List SelectAllCate(Category cate) {
		List<Book> list=this.baseDao.findAll(cate, "selectAllCate");
		return list;
	}
	
	@Override
	public void addBook(Book book) {
		baseDao.add(book, "savebook");
	}
	
	@Override
	public List SelectOne(Book book) {
		List<Book> list=this.baseDao.findAll(book,"selectOneBook");
		return list;
	}

	@Override
	public void UpdateBook(Book book) {
		baseDao.update(book, "updatbook");
		
	}


	@Resource(name="baseDaoMybatisImpl")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<Book> getBooksByCategory(Book book) {
		return this.baseDao.findAll(book, "selectCate");
	}
	
}
