package br.com.api.awesome.endPoint;

import br.com.api.awesome.Entity.Contato;
import br.com.api.awesome.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("contato")
public class ContatoEndPoint {
    @Autowired
    private ContatoService contatoService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Contato contato) {
        return new ResponseEntity<>(contatoService.save(contato), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(contatoService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(contatoService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Contato contato) {
        contatoService.delete(contato);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Contato contato){
        return new ResponseEntity<>(contatoService.update(contato), HttpStatus.OK);
    }


}
