package clustercamp.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository repository;

  public Mono<Product> detail(String id) {
    return repository.findById(id);
  }

  public Mono<Product> create(Product product) {
    return repository.save(product);
  }

  @Transactional
  public void remove(String id) {
    repository.deleteById(id);
  }
}
