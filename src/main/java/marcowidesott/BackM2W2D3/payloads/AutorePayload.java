package marcowidesott.BackM2W2D3.payloads;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AutorePayload {
    private String name;
    private String surname;
    private String email;
    private String dataDiNascita;

    public AutorePayload(String dataDiNascita, String email, String surname, String name) {
        this.dataDiNascita = dataDiNascita;
        this.email = email;
        this.surname = surname;
        this.name = name;
    }
}
