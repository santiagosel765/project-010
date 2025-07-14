package com.ferrisys.common.entity.business;

import com.ferrisys.common.audit.Auditable;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "bus_purchase")
public class Purchase extends Auditable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private Provider provider;

    @Column
    private String description;

    @Column
    private BigDecimal total;

    @Column(nullable = false)
    private Integer status;
}
