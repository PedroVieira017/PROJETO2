package com.ipvc.projeto2Final.services;

import com.ipvc.projeto2Final.models.Quarto;
import com.ipvc.projeto2Final.repositories.QuartoRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepositories quartoRepositories;

    public List<Quarto> getAllQuartos() {
        return quartoRepositories.findAll();
    }

    public List<Quarto> getAllQuartosDisponiveis() {
        return quartoRepositories.findAll()
                .stream()
                .filter(q -> !"Reservado".equalsIgnoreCase(q.getStatus()))
                .collect(Collectors.toList());
    }

    public Quarto save(Quarto quarto) {
        return quartoRepositories.save(quarto);
    }
}

