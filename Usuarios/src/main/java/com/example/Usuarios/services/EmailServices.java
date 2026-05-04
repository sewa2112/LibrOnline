package com.example.Usuarios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Usuarios.models.entities.Email;
import com.example.Usuarios.models.request.ActualizarEmail;
import com.example.Usuarios.models.request.AgregarEmail;
import com.example.Usuarios.repositories.EmailRepository;

@Service
public class EmailServices {
    

    @Autowired
    private EmailRepository emailRepository;

    public List<Email> obtenerTodosLosEmail(){
        return emailRepository.findAll();
    }

    public Email obtenerEmailPorId(int id_email){
        Email email = emailRepository.findById(id_email).orElse(null);
        if (email == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"email no encontrado");
        }
        return email;
    }

    public Email agregarEmail(AgregarEmail nuevoeEmail){
        Email EmailNuevo = new Email();
        EmailNuevo.setEmail(nuevoeEmail.getEmail());
        return emailRepository.save(EmailNuevo);
    }

    public String eliminarEmail(int id_email){
        if(emailRepository.existsById(id_email)){
            emailRepository.deleteById(id_email);
            return "email eliminado correctamente.";
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"email no encontrado");
        }
    }

    public Email actualizarEmail(ActualizarEmail actualizaremail){
        Email email = emailRepository.findById(actualizaremail.getId_email()).orElse(null);
        if(email == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"email no encontrado");
        }else{

            email.setEmail(actualizaremail.getEmail());
            return emailRepository.save(email);
        }
    }
}
