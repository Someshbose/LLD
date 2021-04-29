package someshbose.github.io.app;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import someshbose.github.io.domain.model.Book;
import someshbose.github.io.domain.model.Publisher;
import someshbose.github.io.domain.repo.BookRepo;
import someshbose.github.io.domain.repo.PublisherRepo;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@Service
public class BookService {
    private BookRepo bookRepo;
    private PublisherService publisherService;

    @Autowired
    public BookService(BookRepo bookRepo, PublisherService publisherService){
        this.bookRepo=bookRepo;
        this.publisherService=publisherService;
    }

    public void addBook(){
        System.out.println("Existing publisher?");
        publisherService.getAll();
        Scanner sc = new Scanner(System.in);
        long option = Integer.parseInt(sc.nextLine());
        Publisher publisher;
        if (option==-1){
            System.out.println("Name of publisher");
            String name = sc.nextLine();

            System.out.println("Year of publication");
            String date= sc.nextLine();
            publisher=publisherService.addPublisher(name,date);
        }else{
            publisher = publisherService.findById(option).get();
        }

        System.out.println("Name of book");
        String book_name = sc.nextLine();

        System.out.println("category of book");
        String book_category = sc.nextLine();

        System.out.println("price of book");
        double book_price = Double.parseDouble(sc.nextLine());

        System.out.println("author of book");
        String book_author = sc.nextLine();

        System.out.println("book edition");
        long book_edition = Long.parseLong(sc.nextLine());

        Book book = Book.builder().author_name(book_author)
                .category(book_category).publisher(publisher).price(book_price)
                .title(book_name).edition(book_edition).build();

        bookRepo.save(book);
    }
}
