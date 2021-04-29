package someshbose.github.io;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import someshbose.github.io.domain.model.Address;
import someshbose.github.io.domain.model.User;
import someshbose.github.io.domain.repo.AddressRepo;
import someshbose.github.io.domain.repo.UserRepo;
import java.util.Scanner;

@SpringBootApplication
public class LibraryMainApplication implements CommandLineRunner {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AddressRepo addressRepo;

    public static void main(String[] args) {
            SpringApplication.run(LibraryMainApplication.class, args);
        }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World!");

        User user =User.builder().name("Somesh").build();
        userRepo.save(user);
        Address address = Address.builder().user(user).build();
        addressRepo.save(address);

        int t =0;
        Scanner sc =new Scanner(System.in);
        while(t==0){
            t= sc.nextInt();
        }

    }
}
