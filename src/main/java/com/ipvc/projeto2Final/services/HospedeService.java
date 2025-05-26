package com.ipvc.projeto2Final.services;

import com.ipvc.projeto2Final.models.Hospede;
import com.ipvc.projeto2Final.repositories.HospedeRepositories;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HospedeService {
    private final HospedeRepositories hospedeRepository;

    public HospedeService(HospedeRepositories hospedeRepository) {
        this.hospedeRepository = hospedeRepository;
    }

    public List<Hospede> getAllHospedes() {
        return hospedeRepository.findAll();
    }

    public Optional<Hospede> findById(Integer id) {
        return hospedeRepository.findById(id);
    }

    public Hospede save(Hospede hospede) {
        return hospedeRepository.save(hospede);
    }

    public void delete(Integer id) {
        hospedeRepository.deleteById(id);
    }

    // HospedeService.java
    public Optional<Hospede> findByEmail(String email){ return hospedeRepository.findByEmail(email);}
}
