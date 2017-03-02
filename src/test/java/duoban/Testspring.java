package duoban;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yc.bean.Book;
import com.yc.bean.Category;
import com.yc.biz.impl.BookBizImpl;

import junit.framework.TestCase;

public class Testspring  extends TestCase{
	
	@Test
	public void testSpring(){
		Book book  =new Book();
		Category category =new Category();
		BigDecimal big =new BigDecimal(136);
		
		category.setTid(1);
		
		book.setBid(1);
		book.setAuthor("bbc");
		book.setBname("我操");
		book.setIsbn(12563);
		book.setCategory(category);
		book.setDescription("csdfsdfsdfsdfsdfs");
		
		book.setPrice(big);
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		BookBizImpl biz = (BookBizImpl) ac.getBean("bookBizImpl");
		biz.addBook(book);
	}
}
