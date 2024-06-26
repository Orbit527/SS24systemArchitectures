package at.fhv.lab1.eventbus;

import at.fhv.lab1.eventbus.events.*;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class EventPublisher {

    private final WebClient localApiClient = WebClient.create("http://localhost:8082");

    public EventPublisher() {
    }

    public Boolean publishEvent(Event event) {
        return localApiClient
                .post()
                .uri("/event")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(event),Event.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }

    public Boolean publishEvent(RoomBookedEvent event) {
        return localApiClient
                .post()
                .uri("/eventRoomBookedAdded")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(event),Event.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }

    public Boolean publishEvent(CancelBookingEvent event) {
        return localApiClient
                .post()
                .uri("/eventCancelBooking")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(event),Event.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }

    public Boolean publishEvent(CreateCustomerEvent event) {
        return localApiClient
                .post()
                .uri("/eventCustomerAdded")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(event),Event.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }

    public Boolean publishEvent(CreateRoomEvent event) {
        return localApiClient
                .post()
                .uri("/roomcreateevent")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(event),Event.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }
}
