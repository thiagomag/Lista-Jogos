package br.com.thiago.listajogos.repository;

import br.com.thiago.listajogos.dto.JogoResponse;
import br.com.thiago.listajogos.entity.Jogo;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ListaJogosRepository extends ReactiveCrudRepository<Jogo, Long> {

    @Query("SELECT * FROM lista_jogos")
    Flux<JogoResponse> findBySearchRequest(@Param("nome") String nome,
                                           @Param("tipo") String tipo,
                                           @Param("estudio") String estudio,
                                           @Param("plataforma") String plataforma,
                                           @Param("username") String username,
                                           @Param("anoLancamento") Integer anoLancamento,
                                           @Param("emailConta") String emailConta,
                                           @Param("necessitaAssinatura") Boolean necessitaAssinatura);
}
