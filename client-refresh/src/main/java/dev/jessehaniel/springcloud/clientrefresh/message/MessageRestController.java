package dev.jessehaniel.springcloud.clientrefresh.message;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/message")
public class MessageRestController {
    
    @Value("${message:Hello world}")
    private String message;
    
    @GetMapping
    String getMessage(){
        return this.message;
    }
}
