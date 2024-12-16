package com.sse.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.Serializable;
import java.time.Duration;

//@PreventDuplicateSubmit
//@PreAuthorize("@permission.checker('monitor:online-user:list')")
@RequestMapping("/sse")
public class streamUserActivitySSE {
    @GetMapping(value = "/user-activity-sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Integer> streamUserActivitySSE() {
        // 创建一个持续时间为指定秒数的 Flux 流
        return Flux.interval(Duration.ofSeconds(5))
                .flatMap(sequence -> Mono
                        .fromCallable("service层调用") // 返回在线用户人数
                        .onErrorReturn(0)
                );
    }
}
