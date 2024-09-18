package ar.edu.utn.frba.dds.ejercicio_01;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ejercicios")
public class Ejercicio {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nombre;
    @Column
    private String detalle;
}
