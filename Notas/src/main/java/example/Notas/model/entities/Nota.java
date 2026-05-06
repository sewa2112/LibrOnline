package example.Notas.model.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "notas")
public class Nota{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_notas;

    @Column(nullable = false)
    private Double calificacion;

    private Double prom_calificacion;

    @Column(nullable = false)
    private int id_evaluacion;

    @Column(nullable = false)
    private String rut_usuario;
}