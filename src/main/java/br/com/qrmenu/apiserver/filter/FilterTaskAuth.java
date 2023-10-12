package br.com.qrmenu.apiserver.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Pega Usuario e Senha ->
        var auth = request.getHeader("Authorization");
        var authEncoded = auth.substring("Basic".length()).trim();

        byte[] authDecode = Base64.getDecoder().decode(authEncoded);
        var authString = new String(authDecode);

        String[] credentials = authString.split(":");
        String username = credentials[0];
        String password = credentials[1];

        System.out.println("Authorization: ");
        System.out.println(username);
        System.out.println(password);
        // Valida Usuario ->

        // Valida Senha ->

        // Segue viagem
        filterChain.doFilter(request, response);
    }

}
