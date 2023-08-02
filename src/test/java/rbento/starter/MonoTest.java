
/* Copyright (c) 2022 Rodrigo Bento */

package rbento.starter;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class MonoTest {

    @Test
    void testMonoJust() {
        StepVerifier.create(Mono.just("A")).expectNext("A").expectComplete().verify();
    }
}
