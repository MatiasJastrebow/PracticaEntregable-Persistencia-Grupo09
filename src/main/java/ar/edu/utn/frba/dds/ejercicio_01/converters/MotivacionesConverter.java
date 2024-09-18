package ar.edu.utn.frba.dds.ejercicio_01.converters;

import ar.edu.utn.frba.dds.ejercicio_01.Deportista;
import ar.edu.utn.frba.dds.ejercicio_01.Rutina;
import ar.edu.utn.frba.dds.ejercicio_01.motivaciones.BajarDePeso;
import ar.edu.utn.frba.dds.ejercicio_01.motivaciones.Mantener;
import ar.edu.utn.frba.dds.ejercicio_01.motivaciones.Motivacion;
import ar.edu.utn.frba.dds.ejercicio_01.motivaciones.Tonificar;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class MotivacionesConverter implements AttributeConverter<Motivacion, String> {

    @Override
    public String convertToDatabaseColumn(Motivacion motivacion) {
        if (motivacion instanceof BajarDePeso) {
            return "bajarDePeso";
        } else if (motivacion instanceof Mantener) {
            return "mantener";
        } else if (motivacion instanceof Tonificar) {
            return "tonificar";
        }
        return null;
    }

    @Override
    public Motivacion convertToEntityAttribute(String s) {
        switch (s){
            case "bajarDePeso" -> {return new BajarDePeso();}
            case "tonificar" -> {return new Tonificar();}
            case "mantener" -> {return new Mantener();}
            default -> {return null;}
        }
    }
}
