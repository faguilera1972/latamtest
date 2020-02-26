package cl.latam.test.latamtest.controller;

import cl.latam.test.latamtest.model.PoemaModel;
import cl.latam.test.latamtest.service.IPoemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PoemaController {

    @Autowired
    private IPoemaService poemaService;

    @GetMapping(value = "/latamtest/cumple")
    public ResponseEntity<PoemaModel> obtenerPoema() {

        PoemaModel poemaModel = poemaService.obtenerPoema();
        return new ResponseEntity<PoemaModel>(poemaModel, HttpStatus.OK);
    }
}
