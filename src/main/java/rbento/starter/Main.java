
/* Copyright (c) 2022 Rodrigo Bento */

package rbento.starter;

import lombok.extern.slf4j.Slf4j;
import reactor.blockhound.BlockHound;

@Slf4j
public class Main {
    public static void main(String[] args) {
        BlockHound.install();
        log.info("Running with BlockHound...");
    }
}
