package com.manazello.pm.business.implbusiness;

import com.manazello.pm.business.ibusiness.InterfaceService;
import com.manazello.pm.entities.Historique;
import com.manazello.pm.repositories.HistoriqueRepository;

import java.util.List;

public class HistoriqueImpl implements InterfaceService<Historique> {

    final
    HistoriqueRepository historiqueRepository;

    public HistoriqueImpl(HistoriqueRepository historiqueRepository) {
        this.historiqueRepository = historiqueRepository;
    }

    @Override
    public Historique add(Historique entity) {
        return historiqueRepository.save(entity);
    }

    @Override
    public List<Historique> findAll() {
        return historiqueRepository.findAll();
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Historique update(Historique entity) {
        return null;
    }

    @Override
    public Historique findById(String id) {
        return null;
    }
}
