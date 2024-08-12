package com.modules.optional;

import java.util.Optional;

public class optional {
    public void empty() {
        Optional<Object> optionalBox = Optional.empty();

    }

    public void ofNullable() {
        Optional<Object> optionalBox = Optional.ofNullable("");

    }

    public void of() {
        Optional<Object> optionalBox = Optional.of("");

    }
}
