package br.com.thiago.listajogos.dto;

import br.com.thiago.listajogos.enums.PlataformaEnum;
import br.com.thiago.listajogos.enums.TipoEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
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
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class JogoResponse {

    private Long id;
    private String nome;
    private String estudio;
    private PlataformaEnum plataforma;
    private Integer anoLancamento;
    private Boolean necessitaAssinatura;
    private TipoEnum tipo;
    private String urlFoto;
    private String emailConta;
    private String username;
}
