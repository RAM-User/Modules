package com.chapter9;

class Filter {
    public String name() {
        return getClass().getSimpleName();
    }
    public WaveForm process(WaveForm input) {
        return input;
    }
}
class WaveForm {
    private static long counter;
    private final long id = counter++;
    public String toString() {
        return "WaveForm" + id;
    }
}

class FilterAdapter implements ProcessorInterface {
    Filter filter;
    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }
    public String name() {
        return filter.name();
    }
    public WaveForm process(Object input) {
        return filter.process((WaveForm) input);
    }
}
public class FilterProcessor {
    public static void main(String[] args) {
        WaveForm waveForm = new WaveForm();
    }
}
