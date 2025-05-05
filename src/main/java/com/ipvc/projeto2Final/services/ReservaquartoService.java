package com.ipvc.projeto2Final.services;

import com.ipvc.projeto2Final.models.Reservaquarto;
import com.ipvc.projeto2Final.models.ReservaquartoId;  // Importando o ReservaquartoId
import com.ipvc.projeto2Final.repositories.ReservaquartoRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
import com.ipvc.projeto2Final.models.Reserva;

@Service
public class ReservaquartoService {

    @Autowired
    private ReservaquartoRepositories reservaquartoRepository;

    public Optional<Reservaquarto> findByReserva(Reserva reserva) {
        return reservaquartoRepository.findByReserva(reserva);
    }

    public Reservaquarto saveReservaquarto(Reservaquarto reservaquarto) {
        return reservaquartoRepository.save(reservaquarto);
    }

    public Reservaquarto findReservaquartoById(ReservaquartoId id) {
        return reservaquartoRepository.findById(id).orElse(null);
    }

    public void deleteReservaquarto(ReservaquartoId id) {
        reservaquartoRepository.deleteById(id);
    }

    public List<Reservaquarto> getAllReservaquartos() { return reservaquartoRepository.findAll(); }

}
