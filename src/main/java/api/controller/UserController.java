package api.controller;

import api.domain.user.User;
import api.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public List<User> getAll(){
        return this.userRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") String id){
        Optional<User> userOptional = this.userRepository.findById(id);
        return userOptional.isPresent() ? userOptional.get() : null;
    }

    @PutMapping("/insert")
    public void insert(@RequestBody User user){
        this.userRepository.insert(user);
    }

    @PostMapping("/update")
    public void update(@RequestBody User user){
        this.userRepository.save(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id){
        this.userRepository.deleteById(id);
    }
}
