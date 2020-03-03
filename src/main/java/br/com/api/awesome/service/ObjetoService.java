package br.com.api.awesome.service;

import br.com.api.awesome.Entity.Objeto;
import br.com.api.awesome.error.ResourceNotFoundException;
import br.com.api.awesome.repository.ObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObjetoService {
    @Autowired
    private ObjectRepository objectRepository;


    public Objeto save(Objeto object) {
        return objectRepository.save(object);
    }

    public Objeto getById(Long id) {
        Optional<Objeto> optionalObject = objectRepository.findById(id);
        if (optionalObject.isPresent())
            return optionalObject.get();
        throw new ResourceNotFoundException("Object not found for id: " + id);
    }

    public List<Objeto> getAll() {
        return (List<Objeto>) objectRepository.findAll();
    }

    public void delete(Objeto object) {
        Optional<Objeto> obj = objectRepository.findById(object.getId());
        if (obj.isPresent()) {
            objectRepository.delete(object);
        } else {
            throw new ResourceNotFoundException("User not found for id: " + object.getId());
        }
    }

    public Objeto update(Objeto object) {
        Optional<Objeto> obj = objectRepository.findById(object.getId());
        if (obj.isPresent())
            return objectRepository.save(object);
        throw new ResourceNotFoundException("Object not found for id: " + object.getId());
    }


}
