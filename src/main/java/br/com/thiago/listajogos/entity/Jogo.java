package br.com.thiago.listajogos.entity;


import br.com.thiago.listajogos.enums.PlataformaEnum;
import br.com.thiago.listajogos.enums.TipoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@Builder(toBuilder = true)
@Table("lista_jogos")
public class Jogo {

    @Id
    @NotNull
    private Long id;
    @NotNull
    private String nome;
    @NotNull
    private String estudio;
    @NotNull
    private PlataformaEnum plataforma;
    @NotNull
    private Integer anoLancamento;
    @NotNull
    private Boolean necessitaAssinatura;
    @NotNull
    private TipoEnum tipo;
    private String urlFoto;
    private String emailConta;
    private String username;
}
