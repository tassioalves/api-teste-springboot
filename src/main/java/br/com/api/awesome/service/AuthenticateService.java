package br.com.api.awesome.service;

import br.com.api.awesome.Entity.Usuario;
import br.com.api.awesome.error.ResourceNotFoundException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateService {

    @Autowired
    private UsuarioService userService;

    private static String key = "SECRET_TOKEN";
    public static final String TOKEN_HEADER = "Authentication";

    public String authenticate(Usuario user) {
        Usuario user1 = userService.getByEmail(user);

        if (null == user1) {
            throw new ResourceNotFoundException("E-mail ou Senha invalidosssss!");
        }

        boolean isEquals = user.getEmail().equals(user1.getEmail());

        if (!isEquals) {
            throw new ResourceNotFoundException("E-mail ou Senha invalidos!");
        }

        String token = Jwts.builder()
                .setSubject(user1.getNome())
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();

        System.out.println(token);
        return token;
    }

    public static Jws<Claims> decode(String token) {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token);
    }
}
