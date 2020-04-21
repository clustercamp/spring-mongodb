package clustercamp.api;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromValue;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.server.ServerResponse.status;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ProductHandler {

  private final ProductService service;

  public Mono<ServerResponse> query(ServerRequest request) {
    return service.detail(request.pathVariable("id"))
        .flatMap(p -> ok().contentType(APPLICATION_JSON).body(fromValue(p)))
        .switchIfEmpty(status(HttpStatus.NOT_FOUND).build());
  }

//  public Mono<ServerResponse> create(ServerRequest request) {
//    service.create(request.bodyToMono(Product.class))
//        .flatMap(created(URI.create("/product/").))
//    repo.saveAll(req.bodyToMono(Todo::class.java))
//                    .flatMap { created(URI.create("/todos/${it.id}")).build() }
//                    .next()
//  }


}
