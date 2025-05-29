package com.example.app_sus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.app_sus.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    // Aqui você pode adicionar métodos personalizados, se precisar
}
