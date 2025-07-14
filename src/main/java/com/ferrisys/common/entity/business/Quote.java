package com.ferrisys.common.entity.business;

import com.ferrisys.common.audit.Auditable;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import java.util.UUID;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "bus_quote")
public class Quote extends Auditable implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column
    private String description;

    @Column
    private BigDecimal total;

    @Column(nullable = false)
    private Integer status;
}
