import com.bookstore.dao.BooksDao;
import com.bookstore.daoimpl.BooksDaoImpl;

public class Main {
    public static void main(String[] args) {

        try {
            BooksDao booksDao = new BooksDaoImpl();
            booksDao.loadBooks();
            booksDao.filterBooks();
            booksDao.roundPrice();
            booksDao.sortBooks();
            booksDao.saveBooks();
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
            e.printStackTrace();
        }
    }


}