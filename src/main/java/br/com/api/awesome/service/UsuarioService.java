package br.com.api.awesome.service;


import br.com.api.awesome.Entity.Usuario;
import br.com.api.awesome.error.ResourceNotFoundException;
import br.com.api.awesome.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UserRepository userRepository;

    public Usuario save(Usuario user) {
        return userRepository.save(user);
    }

    public Usuario getById(Long id) {
        Optional<Usuario> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent())
            return optionalUser.get();
        throw new ResourceNotFoundException("User not found for id: " + id);
    }

    public List<Usuario> getAll() {
        return (List<Usuario>) userRepository.findAll();
    }


    public List<Usuario> getByName(String nome) {
        return userRepository.findByNomeIgnoreCaseContaining(nome);
    }

    public Usuario getByEmail(Usuario user) {
        return userRepository.findByEmailIgnoreCaseContaining(user.getEmail());
    }

    public void delete(Usuario user) {
        Optional<Usuario> u = userRepository.findById(user.getId());
        if (u.isPresent()) {
            userRepository.delete(user);
        } else {
            throw new ResourceNotFoundException("User not found for id: " + user.getId());
        }
    }

    public Usuario update(Usuario user) {
        Optional<Usuario> u = userRepository.findById(user.getId());
        if (u.isPresent())
            return userRepository.save(user);
        throw new ResourceNotFoundException("Object not found for id: " + user.getId());
    }


}
