package com.ipvc.projeto2Final.repositories;

import com.ipvc.projeto2Final.models.Reserva;
import com.ipvc.projeto2Final.models.Reservaquarto;
import com.ipvc.projeto2Final.models.ReservaquartoId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservaquartoRepositories extends JpaRepository<Reservaquarto, ReservaquartoId> {

    Optional<Reservaquarto> findByReserva(Reserva reserva);

    void deleteByReserva(Reserva reserva);
}
