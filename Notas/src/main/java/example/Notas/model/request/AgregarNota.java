package example.Notas.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AgregarNota {

    @NotBlank
    private String calificacion;

    @NotBlank
    private int id_evaluacion;
    
    @NotBlank
    private String rut_usuario;
    
}
