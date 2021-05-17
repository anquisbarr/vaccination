package controller;

import business.UserService;
import data.dtos.UserDTO;
import data.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Logger;
import java.util.Calendar;

@RestController
@RequestMapping("/users")
public class UserController {

    static final Logger logger = Logger.getLogger(UserController.class.getName());
    
    @Autowired
    private UserService userService;

    @PostMapping
    public User postUser(@RequestBody UserDTO userDTO){
        logger.info("Save user");
        return userService.save(userDTO);
    }

    @GetMapping("/{dni}")
    public User getUserById(@PathVariable String dni){
        logger.info("Get user by dni");
            return userService.findOneById(dni);
    }
    
    @GetMapping("/vacunacion/{dni}")
    public Calendar getFechaVacunacionById(@PathVariable String dni){
        return userService.findFechaById(dni);
    }
}