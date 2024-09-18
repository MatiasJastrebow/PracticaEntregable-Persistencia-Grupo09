package ar.edu.utn.frba.dds.ejercicio_01;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "rutina")
public class Rutina {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @JoinColumn(name = "rutina_id", referencedColumnName = "id")
    private Deportista deportista;
    @ManyToMany
    @JoinTable(
            name = "rutina_por_dia",
            joinColumns = @JoinColumn(name = "rutina_id"),
            inverseJoinColumns = @JoinColumn(name = "dia_id")
    )
    private List<DiaDeEntrenamiento> diasDeEntrenamiento;

    @OneToOne
    @JoinColumn(name = "rutina_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Rutina rutinaAnterior;

    public Rutina() {
        this.diasDeEntrenamiento = new ArrayList<>();
    }

    public void agregarDiaDeEntrenamiento(DiaDeEntrenamiento diaDeEntrenamiento) {
        this.diasDeEntrenamiento.add(diaDeEntrenamiento);
    }
}
