package com.example.app_sus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.app_sus.model.Chamado;
import com.example.app_sus.repository.ChamadoRepository;

@Service
public class ChamadoService {

    private final ChamadoRepository chamadoRepository;

    public ChamadoService(ChamadoRepository chamadoRepository) {
        this.chamadoRepository = chamadoRepository;
    }

    public List<Chamado> listarTodos() {
        return chamadoRepository.findAll();
    }

    public Optional<Chamado> buscarPorId(Long id) {
        return chamadoRepository.findById(id);
    }

    public Chamado salvar(Chamado chamado) {
        return chamadoRepository.save(chamado);
    }

    public void deletar(Long id) {
        chamadoRepository.deleteById(id);
    }
}
