package br.com.api.awesome.endPoint;

import br.com.api.awesome.Entity.Objeto;
import br.com.api.awesome.service.ObjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("object")
public class ObjetoEndPoint {
    @Autowired
    private ObjetoService objectService;


    @PostMapping
    public ResponseEntity<?> save(@RequestBody Objeto object) {
        return new ResponseEntity<>(objectService.save(object), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(objectService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(objectService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Objeto object) {
        objectService.delete(object);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Objeto object) {
        return new ResponseEntity<>(objectService.update(object), HttpStatus.OK);
    }
}
