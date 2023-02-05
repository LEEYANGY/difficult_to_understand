package xyz.leeyangy.service.impl;

import org.springframework.stereotype.Component;
import xyz.leeyangy.service.BookService;

/**
 * @Package: xyz.leeyangy.service.impl
 * @Author: LEEYANGYANG
 * @Create: 2022/10/9 20:43
 * @Description:
 */
@Component("bookService")
public class BookServiceImpl implements BookService {
    @Override
    public void save() {
        System.out.println("book service save...");
    }
}
