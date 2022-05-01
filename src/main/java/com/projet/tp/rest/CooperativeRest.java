package com.projet.tp.rest;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projet.tp.entity.Cooperative;
import com.projet.tp.entity.Role;
import com.projet.tp.service.CooperativeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/cooperativ")
@EnableAutoConfiguration
@Slf4j
public class CooperativeRest {
    @Autowired
    CooperativeService service;

    @PostMapping("/save")
    public Cooperative saveCooperative(@RequestBody Cooperative cooperative)
    {
        service.saveOrUpdateCooperative(cooperative);
        return cooperative;

    }

    @PutMapping("/coo/update")
    public Cooperative updatecoperative(@RequestBody Cooperative cooperative)
    {
        service.saveOrUpdateCooperative(cooperative);
        return cooperative;

    }

    @GetMapping("/list")
    public List<Cooperative> listCooperative()
        {
            return service.getAllCooperatives();
        }

    @GetMapping("/list/email/{email}")
    public Cooperative listCooperativeBymail(@PathVariable String email)
        {
            return service.getAllCooperativesBymail(email);

        }

    @GetMapping("/{id}")
    public Cooperative getCooperativeById(@PathVariable int id)
    {
        return service.getCooperativeById(id);
    }

    @DeleteMapping("/coo/delete/{id}")
    public String deleteCooperative(@PathVariable(value = "id") int id )
    {
        service.deleteCooperative(id);
        return "cooperative with id="+id+" deleted successfuly";
    }

    @GetMapping("/list/nom/{nom}")
    public List<Cooperative> getCooperativeByNom(@PathVariable String nom)
    {
        return service.getCooperativeByNom(nom);
    }

    @GetMapping("/list/region/{region}")
    public List<Cooperative> getCooperativeByRegion(@PathVariable String region)
    {
        return service.getCooperativeByRegion(region);
    }

    @GetMapping("/list/secteur/{secteur}")
    public List<Cooperative> getCooperativeBySecteur(@PathVariable String secteur)
    {
        return service.getCooperativeBysecteur(secteur);
    }

    @GetMapping("/token/refresh")
    public void refreshtoken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader=request.getHeader(AUTHORIZATION);
        if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer "))
        {
            try{
                String refresh_token =authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm=Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier= JWT.require(algorithm).build();
                DecodedJWT decodedJWT=verifier.verify(refresh_token);
                String username = decodedJWT.getSubject();

                Cooperative user=service.getCopearibeBYemail(username);
                String access_token= JWT.create()
                        .withSubject(user.getEmail())//passing username unique!!!
                        .withExpiresAt(new Date(System.currentTimeMillis()+10*60*1000))//10:minutes, 60:seconds, 1000:millisecond
                        .withIssuer(request.getRequestURI().toString())
                        .withClaim("roles",user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String,String> tokrns=new HashMap<>();
                Map<String,String> tokens=new HashMap<>();
                tokens.put("access_token",access_token);
                tokens.put("refresh_token",refresh_token);
                response.setContentType(APPLICATION_JSON_VALUE);

                new ObjectMapper().writeValue(response.getOutputStream(),tokens);
            }catch(Exception exception){
                log.error("Error logging in:{}",exception.getMessage());
                response.setStatus(FORBIDDEN.value());
                response.setHeader("error",exception.getMessage());
                Map<String,String> error=new HashMap<>();
                error.put("error_message2",exception.getMessage());
                response.setContentType(MimeTypeUtils.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(),error);
            }

        }else{
            throw new RuntimeException("Refresh token is missing");
        }

    }



}
