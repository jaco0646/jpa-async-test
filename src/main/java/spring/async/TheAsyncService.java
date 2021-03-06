package spring.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import spring.jpa.TheRepo;

import java.util.Optional;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Service
public class TheAsyncService {
    private final TheRepo repo;

    public TheAsyncService(TheRepo repo) {
        this.repo = repo;
    }

    @Async
    public void logAuthToken() {
        System.out.println(">>> authToken before Repo call: " + getAuthToken());
        repo.findAll();
        System.out.println(">>> authToken after Repo call: " + getAuthToken());
    }

    private String getAuthToken() {
        return Optional.ofNullable(RequestContextHolder.getRequestAttributes())
                .map(ServletRequestAttributes.class::cast)
                .map(ServletRequestAttributes::getRequest)
                .map(request -> request.getHeader(AUTHORIZATION))
                .orElse("No Authorization Token in this Context!");
    }
}
