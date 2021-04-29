package someshbose.github.io;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import someshbose.github.io.app.BookService;

import java.util.Scanner;

@SpringBootApplication
public class LibraryMainApplication implements CommandLineRunner {

    private BookService bookService;

    @Autowired
    LibraryMainApplication(BookService bookService){
        this.bookService=bookService;
    }

    public static void main(String[] args) {
            SpringApplication.run(LibraryMainApplication.class, args);
        }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("welcome to Library Management System!");
        int option = -1;

        while(option <= 5){
            System.out.println(" 1. Add Book\n 2. Add Reader\n 3. Borrow\n 4. Return \n 5. Exit");
            Scanner sc = new Scanner(System.in);
            option= Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1: bookService.addBook();
                    break;
                case 2:break;
                case 3:break;
                case 4: break;
                case 5: break;
            }
        }
    }
}
