package book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookServiceTest {
    @Test
    public void findByIdTest() {
        BookRepository mockBookRepository = mock(BookRepository.class);
        Book book = new Book("5", "Title5", "Author5");
        when(mockBookRepository.findById("1")).thenReturn(book);
        BookService bookService = new BookService(mockBookRepository);
        Book result = bookService.findBookById("1");
        assertThat(result).isEqualTo(book);
    }
    @Test
    public void findAllBooksTest(){
        BookRepository mockBookRepository = mock(BookRepository.class);
        Map <String, Book> books = new HashMap <String,Book>();
        books.put("7", new Book("7", "Book7", "Author7"));
        books.put("3", new Book("3", "Book3", "Author3"));
        List<Book> reply = new ArrayList<Book>(books.values());
        when(mockBookRepository.findAll()).thenReturn(reply);
        BookService bookService = new BookService(mockBookRepository);
        List<Book>result = bookService.findAllBooks();
        assertThat(result).isEqualTo(reply);


    }

}