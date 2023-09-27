package br.com.thiago.listajogos.controller;

import br.com.thiago.listajogos.dto.JogoRequest;
import br.com.thiago.listajogos.dto.JogoResponse;
import br.com.thiago.listajogos.serive.ListaJogosService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/jogos")
@RequiredArgsConstructor
@Tag(name = "Lista Jogos", description = "Backend request for Lista de Jogos")
public class ListaJogosController {

    private final ListaJogosService listaJogosService;

    @GetMapping
    public Flux<JogoResponse> getListaJogos() {
        return listaJogosService.getListaJogos();
    }

    @PostMapping
    public Mono<JogoResponse> saveJogo(JogoRequest jogoRequest) {
        return listaJogosService.save(jogoRequest);
    }
}
