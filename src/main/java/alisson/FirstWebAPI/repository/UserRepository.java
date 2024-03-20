package alisson.FirstWebAPI.repository;

import java.util.*;

import alisson.FirstWebAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAll();

    Optional<User> findById(Integer id);
    List<User> findByLogin(String login);
    @Override
    void deleteById(Integer id);

}
