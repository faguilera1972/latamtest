package cl.latam.test.latamtest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "poemaModel"
})
public class ListaPoemas implements Serializable {

    @JsonProperty("poemaModel")
    private List<PoemaModel> poemaModel;

    public ListaPoemas() {
    }

    public ListaPoemas(List<PoemaModel> poemaModel) {
        this.poemaModel = poemaModel;
    }

    public List<PoemaModel> getPoemaModel() {
        return poemaModel;
    }

    public void setPoemaModel(List<PoemaModel> poemaModel) {
        this.poemaModel = poemaModel;
    }
}
