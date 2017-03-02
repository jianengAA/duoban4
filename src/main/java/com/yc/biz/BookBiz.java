package com.yc.biz;

import java.util.List;

import com.yc.bean.Book;
import com.yc.bean.Category;

public interface BookBiz {
	
	public List SelectAll(Book book);

	public List SelectAllCate(Category cate);
	
	public void addBook(Book book);
	
	public List SelectOne(Book book);
	
	public void UpdateBook(Book book);

	public List<Book> getBooksByCategory(Book book);
}
