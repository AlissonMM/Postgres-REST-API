package alisson.FirstWebAPI;

import alisson.FirstWebAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import alisson.FirstWebAPI.model.User;

import java.util.List;

public class AppRunner implements CommandLineRunner {
    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {

}
}
