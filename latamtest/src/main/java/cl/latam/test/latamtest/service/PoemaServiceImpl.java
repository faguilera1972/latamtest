package cl.latam.test.latamtest.service;

import cl.latam.test.latamtest.model.ListaPoemas;
import cl.latam.test.latamtest.model.PoemaModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class PoemaServiceImpl implements IPoemaService {

    @Value("${cl.latam.test.service.cumple}")
    private String urlCumple;

    @Override
    public PoemaModel obtenerPoema() {

        RestTemplate restTemplate = new RestTemplate();

        ListaPoemas lista = new ListaPoemas();


        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(urlCumple, Object[].class);

        Object[] poem = responseEntity.getBody();

        int numeroPoema = obtenerNumeroPoema();

        Object poemaObj = poem[numeroPoema];

        LinkedHashMap poemaModel = (LinkedHashMap) poemaObj;

        PoemaModel poemaModel1 =new PoemaModel();
        poemaModel1.setTitle((String) poemaModel.get("title"));
        poemaModel1.setContent((String) poemaModel.get("content"));
        return poemaModel1;
    }

    private int obtenerNumeroPoema() {
        int numeroPoema = 0 + (int)(Math.random()*4);
        return numeroPoema;
    }
}
