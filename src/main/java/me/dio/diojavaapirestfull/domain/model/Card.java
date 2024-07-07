package me.dio.diojavaapirestfull.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name = "tb_card")
@Getter
@Setter
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 100, nullable = false)
    private String number;
    @Column(name = "card_limit",nullable = false, precision = 13, scale = 2)
    private BigDecimal limit;
}
