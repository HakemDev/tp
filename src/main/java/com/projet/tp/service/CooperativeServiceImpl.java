package com.projet.tp.service;

import com.projet.tp.dao.AdministrateurRepository;
import com.projet.tp.dao.ClientRepo;
import com.projet.tp.dao.CooperativeRepository;
import com.projet.tp.dao.RoleRepo;
import com.projet.tp.entity.Administarteur;
import com.projet.tp.entity.Client;
import com.projet.tp.entity.Cooperative;
import com.projet.tp.entity.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CooperativeServiceImpl implements CooperativeService, UserDetailsService {
    @Autowired
    CooperativeRepository repository;
    private final AdministrateurRepository administrateurRepository;
    private final ClientRepo clientRepo;
    private final PasswordEncoder passwordEncoder;

    //fonction pour authentifier
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Cooperative cooperative= repository.findByEmail(username);
        if(cooperative==null)
            {
                Administarteur administarteurr=administrateurRepository.findByEmail(username);
                if(administarteurr==null)
                    {
                        log.error("User not found in the database");
                        throw new UsernameNotFoundException("User Not found in the database");
                    }
                else
                    {
                        log.info("User found in the database: {}",username);
                        System.out.println("admin "+administarteurr);
                    }
                Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();
                administarteurr.getRoles().forEach(role->{
                    authorities.add(new SimpleGrantedAuthority(role.getName()));
                });
                System.out.println("authorities "+authorities);

                return new org.springframework.security.core.userdetails.User(administarteurr.getEmail(),administarteurr.getPassword(),authorities);

            }
        else{
            log.info("User found in the database: {}",username);
            System.out.println("chaima "+cooperative);
        }
        Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();
        cooperative.getRoles().forEach(role->{
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        System.out.println("authorities "+authorities);

        return new org.springframework.security.core.userdetails.User(cooperative.getEmail(),cooperative.getPassword(),authorities);
    }

////////////////////Partie administrateur
    //ajouter ou modifier une admin
    @Override
    public Administarteur saveorUpdateAdmini(Administarteur administarteur) {
        administarteur.setPassword(passwordEncoder.encode(administarteur.getPassword()));
        administrateurRepository.save(administarteur);
        return administarteur;
    }

    ////////////////////Partie client
    //ajouter ou modifier un client
    @Override
    public Administarteur sign(Administarteur administarteur) {
        administarteur.setPassword(passwordEncoder.encode(administarteur.getPassword()));
        administrateurRepository.save(administarteur);
        return administarteur;
    }

////////////////////Partie coperative
    //ajouter et modifier une copeartive
    @Override
    public Cooperative saveOrUpdateCooperative(Cooperative cooperative) {
        cooperative.setPassword(passwordEncoder.encode(cooperative.getPassword()));
        repository.save(cooperative);
        return cooperative;

    }

    //afficher tous les copeartives
    @Override
    public List<Cooperative> getAllCooperatives() {
        List<Cooperative> cooperatives=repository.findAll();
        return (List<Cooperative>) repository.findAll() ;
    }

    //afficher les copeartive a partir de son id
    @Override
    public Cooperative getCooperativeById(int id) {
        return repository.findById(id).get() ;
    }


    //supprimer une coperative a partir de son id
    @Override
    public void deleteCooperative(int id) {
        repository.deleteById(id);

    }

    //afficher une copeartive a a partir de son nom
    @Override
    public List<Cooperative> getCooperativeByNom(String nom) {
        return repository.findByNom(nom) ;
    }

    //afficher une copeartive a partir de sa region
    @Override
    public List<Cooperative> getCooperativeByRegion(String region) {
        return repository.findByRegion(region);
    }

    //afficher les copeartive a partir de son secteur
    @Override
    public List<Cooperative> getCooperativeBysecteur(String secteur) {
        return repository.findBySecteur(secteur);
    }

    //afficher une copeartive a partir de son email
    @Override
    public Cooperative getAllCooperativesBymail(String email) {
        return repository.findByEmail(email);
    }


    @Override
    public Cooperative getCopearibeBYemail(String email) {
        return repository.findByEmail(email);
    }

}
