package spring.async;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
public class TheController {
    private final TheAsyncService asyncService;

    public TheController(TheAsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @GetMapping("/async")
    public String logAuthToken(WebRequest webRequest) {
        if (webRequest.getHeader(AUTHORIZATION) == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authorization header required");
        }
        asyncService.logAuthToken();
        return "OK";
    }
}
