
/* Copyright (c) 2022 Rodrigo Bento */

package rbento.starter;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public class MonoSamples {

    @Test
    public void justMono() {
        Mono.just("A");
    }

    @Test
    public void monoWithConsumer() {
        Mono.just("A")
                .log()
                .doOnSubscribe(s -> System.out.println("OnSubscribe: " + s))
                .doOnRequest(s -> System.out.println("OnRequest: " + s))
                .doOnSuccess(s -> System.out.println("OnSuccess: " + s))
                .subscribe(s -> System.out.println("subscribe: " + s));
    }

    @Test
    public void emptyMono() {
        Mono.empty().log().subscribe(System.out::println, null, () -> System.out.println("Done"));
    }

    @Test
    public void monoWithRuntimeException() {
        Mono.error(new RuntimeException()).log().subscribe();
    }

    @Test
    public void monoWithException() {
        Mono.error(new Exception()).log().subscribe();
    }

    @Test
    public void monoWithExceptionConsumer() {
        Mono.error(new Exception()).log().subscribe(System.out::println, e -> System.err.println("Exception: " + e));
    }

    @Test
    public void monoWithDoOnError() {
        Mono.error(new Exception())
                .doOnError(e -> System.err.println("Exception: " + e))
                .log()
                .subscribe();
    }

    @Test
    public void monoWithOnErrorResume() {
        Mono.error(new Exception())
                .onErrorResume(e -> {
                    System.err.println("Caught: " + e);
                    return Mono.just("B");
                })
                .log()
                .subscribe();
    }

    @Test
    public void monoWithOnErrorReturn() {
        Mono.error(new Exception()).onErrorReturn("B").log().subscribe();
    }
}
