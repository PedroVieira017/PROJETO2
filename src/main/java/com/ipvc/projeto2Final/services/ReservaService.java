package com.ipvc.projeto2Final.services;

import com.ipvc.projeto2Final.models.Reserva;
import com.ipvc.projeto2Final.repositories.ReservaRepositories;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {
    private final ReservaRepositories reservaRepository;

    public ReservaService(ReservaRepositories reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    public Optional<Reserva> findById(Integer id) {
        return reservaRepository.findById(id);
    }

    public Reserva save(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public void delete(Integer id) {
        reservaRepository.deleteById(id);
    }
}

