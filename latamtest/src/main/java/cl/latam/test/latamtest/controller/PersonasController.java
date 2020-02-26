package cl.latam.test.latamtest.controller;

import cl.latam.test.latamtest.model.PersonaInModel;
import cl.latam.test.latamtest.model.PersonaOutModel;
import cl.latam.test.latamtest.service.IPersonasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PersonasController {

    @Autowired
    private IPersonasService personasService;

    @PostMapping(value = "/latamtest/persona/ingreso", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonaOutModel> ingresarPersona(@RequestBody PersonaInModel personaInModel){

        PersonaOutModel personaOutModel = personasService.ingresarPersona(personaInModel);
        return new ResponseEntity<PersonaOutModel>(personaOutModel, HttpStatus.OK);

    }
}
