package me.dio.diojavaapirestfull.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name = "tb_account")
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 100, nullable = false, unique = true)
    private String number;
    @Column(length = 50, nullable = false)
    private String agency;
    @Column(nullable = false,  precision = 13, scale = 2)
    private BigDecimal balance;
    @Column(name = "account_limit", nullable = false, precision = 13, scale = 2)
    private BigDecimal limit;

}
