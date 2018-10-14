package com.wbg.dao;

import com.wbg.entity.Book;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class BookDao {
    public Book getBookById(int id){
        //使用类加载器加载mybatis的配置文件
        InputStream inputStream=BookDao.class.getClassLoader().getResourceAsStream("config.xml");
        //构建sqlSession的工厂
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        //创建能执行映射文件中的sql
        SqlSession sqlSession=sqlSessionFactory.openSession();

        Book book=sqlSession.selectOne("com.wbg.dao.bookMapper.selectBookById",2);
          return book;
    }

    public static void main(String[] args) {
        BookDao bookDao=new BookDao();
        System.out.println(bookDao.getBookById(1));
    }
}
