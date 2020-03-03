package br.com.api.awesome.service;

import br.com.api.awesome.Entity.Contato;
import br.com.api.awesome.error.ResourceNotFoundException;
import br.com.api.awesome.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {
    @Autowired
    private ContatoRepository contatoRepository;

    public Contato save(Contato contato) {
        return contatoRepository.save(contato);
    }

    public Contato getById(Long id) {
        Optional<Contato> optionalContato = contatoRepository.findById(id);
        if (optionalContato.isPresent())
            return optionalContato.get();
        throw new ResourceNotFoundException("Contato not found for ID: " + id);
    }

    public List<Contato> getAll() {
        return (List<Contato>) contatoRepository.findAll();
    }

    public void delete(Contato contato) {
        contatoRepository.delete(contato);
    }

    public Contato update(Contato contato) {
        return contatoRepository.save(contato);
    }


}
