package me.dio.diojavaapirestfull.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass //todo: Essa anotção deve ser posta para que posa ser extendida
@Getter
@Setter
public abstract class BaseItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 200, nullable = false)
    private String icon;
    @Column(length = 250, nullable = false)
    private String description;
}
