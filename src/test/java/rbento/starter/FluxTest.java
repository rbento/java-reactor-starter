
/* Copyright (c) 2022 Rodrigo Bento */

package rbento.starter;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

class FluxTest {

    @Test
    void testFluxJust() {
        StepVerifier.create(Flux.just("A", "B", "C"))
                .expectNext("A")
                .expectNext("B")
                .expectNext("C")
                .expectComplete()
                .verify();
    }
}
