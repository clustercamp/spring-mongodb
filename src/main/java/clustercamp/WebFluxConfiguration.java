package clustercamp;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import clustercamp.api.ProductHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class WebFluxConfiguration {

  @Bean
  public RouterFunction<ServerResponse> routes(ProductHandler handler) {
    return RouterFunctions.route(GET("/product/{id}")
        .and(accept(MediaType.APPLICATION_JSON)), handler::query);
  }
}
