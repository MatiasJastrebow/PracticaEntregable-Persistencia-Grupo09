package ar.edu.utn.frba.dds.ejercicio_01;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "dia_entrenamiento")
public class DiaDeEntrenamiento {

  @Id
  @GeneratedValue
  private Long id;

  @ManyToMany
  @JoinTable(
          name = "ejercicios_por_dia",
          joinColumns = @JoinColumn(name = "dia_id", referencedColumnName = "id"),
          inverseJoinColumns = @JoinColumn(name = "ejercicio_id", referencedColumnName = "id")
  )
  private List<Ejercicio> ejercicios;

  @Column
  private Integer numero; // representa el orden en la duracion de la rutina.

  @OneToOne
  @JoinColumn(name = "rutina_id", referencedColumnName = "id")
  private DiaDeEntrenamiento siguienteDia;

  public DiaDeEntrenamiento() {
    this.ejercicios = new ArrayList<>();
  }
  public void agregarEjercicio(Ejercicio ejercicio) {
    this.ejercicios.add(ejercicio);
  }
}
