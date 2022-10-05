package br.com.thiago.listajogos.repository;

import br.com.thiago.listajogos.domain.Jogo;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ListaJogosRepository extends ReactiveCrudRepository<Jogo, Long> {
}
