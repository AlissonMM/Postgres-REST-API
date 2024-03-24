package alisson.FirstWebAPI.controller;

import alisson.FirstWebAPI.handler.BusinessException;
import alisson.FirstWebAPI.handler.RequiredFieldException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import alisson.FirstWebAPI.model.User;
import alisson.FirstWebAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import alisson.FirstWebAPI.beansFactory.Beans;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ObjectMapper objectMapper;


    //GetMapping is used to define which http will be used
    @GetMapping()
    public String getUsers() throws JsonProcessingException {
        List<User> users = userRepository.findAll();
        //ObjectMapper is used to convert Java objects to JSON
        return objectMapper.writeValueAsString(users);
    }

//    public ResponseEntity<Object> getUsers(){
//        try {
//            return ResponseEntity.ok(userRepository.findAll());
//        } catch (Exception ex){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
//        }
//    }


    @GetMapping("/{id}")
    public Optional<User> getById (@PathVariable("id") Integer id){
        return userRepository.findById(id);
    }

    //Navigators can only make GET HTTP requests.
    // To perform PUT or DELETE requests, we need to use a client.
    // Personally, I use Postman.”
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id")Integer id){
        userRepository.deleteById(id);
    }

    //To use a Post method we need to pass a body, I'm doing it using Postman
    //Text type: Json
    //{"login":"postTest","password":"testPassword"}
    @PostMapping()
    public void postUser(@RequestBody User user){
//        if (user.getLogin().isEmpty() || user.getPassword() == null || user.getPassword() == "") {
//            throw new BusinessException("All attributes must be valid!");
//        }

        //passwordRequirements
        boolean isThereCapital = Pattern.compile("[A-Z]").matcher(user.getPassword()).find();
        boolean isCommonSequence = !user.getPassword().matches(".*(?i)123456.*|.*(?i)abcdef.*");
        boolean isCommonWord = !user.getPassword().equalsIgnoreCase("password") && !user.getPassword().equalsIgnoreCase("123456") && !user.getPassword().equalsIgnoreCase("qwerty");


        if (user.getLogin().isEmpty() || user.getLogin() == ""){
            throw new RequiredFieldException("Login");
        }

        else if(user.getPassword() == null || user.getPassword() == ""){
            throw new RequiredFieldException("Password");
        }

        else if(!isThereCapital){
            throw new BusinessException("Password must have at least one Capital Letter");
        }

        else if(!isCommonSequence){
            throw new BusinessException("Password is too common");
        }

        else if(!isCommonWord){
            throw new BusinessException("Password is too common");
        }

        else {
            userRepository.save(user);
        }

    }

    @PutMapping()
    public void putUser(@RequestBody User user){
        //passwordRequirements
        boolean isThereCapital = Pattern.compile("[A-Z]").matcher(user.getPassword()).find();
        boolean isCommonSequence = !user.getPassword().matches(".*(?i)123456.*|.*(?i)abcdef.*");
        boolean isCommonWord = !user.getPassword().equalsIgnoreCase("password") && !user.getPassword().equalsIgnoreCase("123456") && !user.getPassword().equalsIgnoreCase("qwerty");


        if (user.getLogin().isEmpty() || user.getLogin() == ""){
            throw new RequiredFieldException("Login");
        }

        else if(user.getPassword() == null || user.getPassword() == ""){
            throw new RequiredFieldException("Password");
        }

        else if(!isThereCapital){
            throw new BusinessException("Password must have at least one Capital Letter");
        }

        else if(!isCommonSequence){
            throw new BusinessException("Password is too common");
        }

        else if(!isCommonWord){
            throw new BusinessException("Password is too common");
        }

        else {
            userRepository.save(user);
        }

    }

}
