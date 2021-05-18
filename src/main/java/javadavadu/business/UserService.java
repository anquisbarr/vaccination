package business;

import business.custom_exceptions.CustomNotFoundException;
import data.dtos.UserDTO;
import data.entities.User;
import data.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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
        if (validateWithAPI(userDTO.getDtoDni())){
            return userRepository.save(user);
        } else throw new CustomNotFoundException("El usuario con el dni " + userDTO.getDtoDni() + " no existe!");
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

    public boolean validateWithAPI(String dni){
        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(URI.create("https://ws-consultas.herokuapp.com/api/dni/" + dni)).header("accept", "application/json").build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.body().isEmpty())
               return false;
            return true;
        } catch (Exception e){
            return false;
        }
   }
}