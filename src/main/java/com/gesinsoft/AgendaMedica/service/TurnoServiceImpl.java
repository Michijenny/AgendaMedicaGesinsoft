package com.gesinsoft.AgendaMedica.service;


import com.gesinsoft.AgendaMedica.modelo.Turno;
import com.gesinsoft.AgendaMedica.repository.TurnoRepository;
import com.gesinsoft.AgendaMedica.servicios.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class TurnoServiceImpl extends GenericServiceImpl<Turno, Integer> implements TurnoService {

    @Autowired
    TurnoRepository turnoRepository;

    @Override
    public CrudRepository< Turno, Integer> getDao() {
        return turnoRepository;
    }

}
