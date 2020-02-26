package cl.latam.test.latamtest.controller;

import static org.mockito.Mockito.when;

import cl.latam.test.latamtest.model.PersonaInModel;
import cl.latam.test.latamtest.model.PersonaOutModel;
import cl.latam.test.latamtest.service.IPersonasService;
import cl.latam.test.latamtest.service.PersonasServiceImpl;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class PersonasControllerTest {

    @InjectMocks
    PersonasController personasController;

    @Mock
    PersonasServiceImpl personasService;

    @Test
    public void ingresaPersona(){

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        when(personasService.ingresarPersona(any(PersonaInModel.class))).thenReturn(any(PersonaOutModel.class));

        PersonaInModel personaInModel = obtenerPersonaIn();

        ResponseEntity<PersonaOutModel> responseEntity = personasController.ingresarPersona(personaInModel);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);


    }

    private PersonaInModel obtenerPersonaIn(){

        PersonaInModel personaInModel = new PersonaInModel();

        personaInModel.setPrimerNombre("Fernando");
        personaInModel.setSegundoNombre("Rodrigo");
        personaInModel.setApellidoPat("Aguilera");
        personaInModel.setApellidoMat("Soto");
        personaInModel.setFechaNac("17-04-1972");

        return personaInModel;

    }

}