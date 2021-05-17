package business;

import business.custom_exceptions.CustomNotFoundException;
import data.dtos.UserDTO;
import data.entities.User;
import data.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Calendar;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(UserDTO userDTO){
        User user = new User(
            userDTO.getDtoDni(), userDTO.getDtoNombres(), userDTO.getDtoApellidoP(),
            userDTO.getDtoApellidoM(),userDTO.getDtoFechaNacimiento(),
            userDTO.getDtoTelefono(),userDTO.getDtoCorreoElectronico()
        );
        return userRepository.save(user);
    }

    public User findOneById(String dni){
        Optional<User> userOptional = userRepository.findById(dni);
        if(userOptional.isPresent()) return userOptional.get();
        else throw new CustomNotFoundException("El usuario con el dni " + dni + " no existe!");
    }

    public Calendar findFechaById(String dni){
        Optional<User> userOptional = userRepository.findById(dni);
        if(userOptional.isPresent()) return userOptional.get().getFechaVacunacion();
        else throw new CustomNotFoundException("El usuario con el dni " + dni + " no existe!");
    }
}