package pt.com.arquitetura.delivery.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;


@Getter
@Setter
@Entity
@Table(name = "tb_order", schema = "delivery")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Provider required")
    @Column(name = "id_provider")
    private Long idProvider;

    @NotEmpty(message = "Product required")
    private String product;

    @NotNull(message = "Price required")
    private BigDecimal price;

}