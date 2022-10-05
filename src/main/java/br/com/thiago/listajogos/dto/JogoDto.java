package br.com.thiago.listajogos.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@Builder(toBuilder = true)
public class JogoDto {

    private String nome;
    private String estudio;
    private String plataforma;
    private Integer anoLancamento;
    private Boolean necessitaAssinatura;
    private String urlFoto;
    private String tipo;
}
