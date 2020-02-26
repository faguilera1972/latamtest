package cl.latam.test.latamtest.service;

import cl.latam.test.latamtest.model.PersonaInModel;
import cl.latam.test.latamtest.model.PersonaOutModel;

public interface IPersonasService {

    PersonaOutModel ingresarPersona(PersonaInModel personaInModel);
}
