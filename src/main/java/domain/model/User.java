package domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "tb_user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 200, nullable = false)
    private String name;

//    todo: como fazer a configuração do cascade
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;
//    todo: Além do cascade usado fetch.
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    /* FetchType.EAGER quer dizer que toda vez que um usuário for chamado
    * a lista de features também será retornada*/
    private List<Feature> features;

    @OneToOne(cascade = CascadeType.ALL)
    private Card card;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<News> news;

}
