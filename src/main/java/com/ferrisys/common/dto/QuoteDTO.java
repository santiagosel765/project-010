package com.ferrisys.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuoteDTO {
    private Integer id;
    private Integer clientId;
    private String description;
    private BigDecimal total;
    private Integer status;
}
