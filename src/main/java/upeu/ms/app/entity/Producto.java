package upeu.ms.app.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name = "mae_producto")
@Builder
public class Producto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Double precio;
	@Column(name = "create_at")
	private LocalDateTime createAt;
	
	@Column(name = "estado")
	private Boolean estado;
	
	@Transient
	private Integer port;
}
