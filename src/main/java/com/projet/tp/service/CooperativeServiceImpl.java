package com.projet.tp.service;

import com.projet.tp.dao.AdministrateurRepository;
import com.projet.tp.dao.CooperativeRepository;
import com.projet.tp.dao.RoleRepo;
import com.projet.tp.entity.Administarteur;
import com.projet.tp.entity.Cooperative;
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
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Cooperative cooperative= repository.findByEmail(username);
        if(cooperative==null)
            {
                Administarteur administarteurr=administrateurRepository.findByEmail(username);
                if(administarteurr==null){
                    log.error("User not found in the database");
                    throw new UsernameNotFoundException("User Not found in the database");
                }
                else{
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

    @Override
    public List<Cooperative> getAllCooperatives() {
        System.out.println("aaa");
        return (List<Cooperative>) repository.findAll() ;
    }

    @Override
    public Cooperative getCooperativeById(int id) {
        return repository.findById(id).get() ;
    }

    @Override
    public Cooperative saveOrUpdateCooperative(Cooperative cooperative) {
        cooperative.setPassword(passwordEncoder.encode(cooperative.getPassword()));
        repository.save(cooperative);
        return cooperative;

    }

    @Override
    public Administarteur saveorUpdateAdmini(Administarteur administarteur) {
        administarteur.setPassword(passwordEncoder.encode(administarteur.getPassword()));
         administrateurRepository.save(administarteur);
        return administarteur;
    }
    @Override
    public void deleteCooperative(int id) {
        repository.deleteById(id);

    }


    @Override
    public List<Cooperative> getCooperativeByNom(String nom) {
        return repository.findByNom(nom) ;
    }

    @Override
    public List<Cooperative> getCooperativeByRegion(String region) {
        return repository.findByRegion(region);
    }

    @Override
    public List<Cooperative> getCooperativeBysecteur(String secteur) {
        return repository.findBySecteur(secteur);
    }

    @Override
    public Cooperative getAllCooperativesBymail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Cooperative getCopearibeBYemail(String email) {
        return repository.findByEmail(email);
    }


}
