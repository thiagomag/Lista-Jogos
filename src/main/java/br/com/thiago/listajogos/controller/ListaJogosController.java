package br.com.thiago.listajogos.controller;

import br.com.thiago.listajogos.dto.JogoRequest;
import br.com.thiago.listajogos.dto.JogoResponse;
import br.com.thiago.listajogos.service.ListaJogosService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

@RestController
@RequestMapping("/jogos")
@RequiredArgsConstructor
@Tag(name = "Lista Jogos", description = "Backend request for Lista de Jogos")
public class ListaJogosController {

    private final ListaJogosService listaJogosService;

    @GetMapping
    public Flux<JogoResponse> getListaJogos(@RequestParam JogoRequest searchRequest) {
        return listaJogosService.getListaJogos(searchRequest);
    }

    @GetMapping("/{idJogo}")
    public Mono<JogoResponse> findJogoById(@PathVariable Long idJogo) {
        return listaJogosService.findJogoById(idJogo);
    }

    @PostMapping
    public Mono<JogoResponse> saveJogo(@RequestBody JogoRequest jogoRequest) {
        return listaJogosService.save(jogoRequest);
    }

    @PutMapping("/{idJogo}")
    public Mono<JogoResponse> updateJogo(@PathVariable Long idJogo,
                                         @RequestBody JogoRequest jogoRequest) {
        return listaJogosService.updateJogo(jogoRequest, idJogo);
    }

    @DeleteMapping("/{idJogo}")
    public Mono<Void> updateJogo(@PathVariable Long idJogo) {
        return listaJogosService.deletarJogo(idJogo);
    }

    @PostMapping("/processarCSV")
    public Mono<String> processarCSV() throws IOException {
        return listaJogosService.processarCSV();
    }
}
