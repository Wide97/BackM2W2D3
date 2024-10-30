package marcowidesott.BackM2W2D3.payloads;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorsPayload {
    private String message;
    private int statusCode;
    private String timestamp;
    private String details;

    public ErrorsPayload(String message, int statusCode, String details) {
        this.message = message;
        this.statusCode = statusCode;
        this.timestamp = java.time.LocalDateTime.now().toString();
        this.details = details;
    }
}
