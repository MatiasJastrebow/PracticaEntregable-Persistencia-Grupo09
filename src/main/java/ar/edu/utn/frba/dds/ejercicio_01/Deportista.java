package ar.edu.utn.frba.dds.ejercicio_01;

import ar.edu.utn.frba.dds.ejercicio_01.converters.MotivacionesConverter;
import ar.edu.utn.frba.dds.ejercicio_01.motivaciones.Motivacion;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "deportista")
public class Deportista {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String nombre;
    @Column
    private String apellido;

    @ElementCollection
    @CollectionTable(name = "contacto",
            joinColumns = @JoinColumn(name = "deportista_id", referencedColumnName = "id"))

    @Column(name = "contacto")
    private List<String> contactos;

    @Convert(converter = MotivacionesConverter.class)
    @Column(name = "motivacion")
    private Motivacion motivacionPrincipal;

    @Column
    private Double pesoInicialEnKilos;

    public void agregarContacto(String contacto) {
        contactos.add(contacto);
    }

    public Deportista(){
        this.contactos = new ArrayList<>();
    }

}
