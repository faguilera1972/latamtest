package cl.latam.test.latamtest.service;

import cl.latam.test.latamtest.constantes.Constantes;
import cl.latam.test.latamtest.model.PersonaInModel;
import cl.latam.test.latamtest.model.PersonaOutModel;
import cl.latam.test.latamtest.model.PoemaModel;
import cl.latam.test.latamtest.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class PersonasServiceImpl implements IPersonasService {

    @Autowired
    private IPoemaService poemaService;

    @Override
    public PersonaOutModel ingresarPersona(PersonaInModel personaInModel) {

        PersonaOutModel personaOutModel = new PersonaOutModel();
        personaOutModel.setNombre(personaInModel.getPrimerNombre());
        personaOutModel.setApellido(personaInModel.getApellidoPat());

        personaInModel.setCumpleAnio(DateUtils.obtenerCumpleanio(personaInModel.getFechaNac()));

        String fechaActual = DateUtils.dateToString(new Date(), Constantes.DD_MM_YYYY);
        int edad = DateUtils.getNumeroAnios(personaInModel.getFechaNac(),fechaActual);

        personaOutModel.setEdad(edad);

        int cantDiasCumple = DateUtils.cantidadDias(fechaActual,personaInModel.getCumpleAnio());
        personaOutModel.setDiasCumple(cantDiasCumple);
        personaOutModel.setFechaNac(personaInModel.getFechaNac());

        if(cantDiasCumple == 0){
            PoemaModel poemaModel = poemaService.obtenerPoema();

            personaOutModel.setPoemaModel(poemaModel);
        }



        return personaOutModel;
    }
}
