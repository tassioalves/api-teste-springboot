package br.com.api.awesome.endPoint;

import br.com.api.awesome.Entity.Usuario;
import br.com.api.awesome.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("user")
public class UsuarioEndPoint {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody  Usuario user) {
        return new ResponseEntity<>(usuarioService.save(user), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(usuarioService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(usuarioService.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/getByName/{name}")
    public ResponseEntity<?> getUserByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(usuarioService.getByName(name), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Usuario user) {
        usuarioService.delete(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Usuario user) {
        return new ResponseEntity<>(usuarioService.update(user), HttpStatus.OK);
    }
}
