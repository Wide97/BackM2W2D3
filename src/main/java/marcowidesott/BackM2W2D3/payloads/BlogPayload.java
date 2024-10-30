package marcowidesott.BackM2W2D3.payloads;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
public class BlogPayload {
    private String categoria;
    private String titolo;
    private String contenuto;
    private Double tempoLettura;

    public BlogPayload(String categoria, String titolo, String contenuto, Double tempoLettura) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.contenuto = contenuto;
        this.tempoLettura = tempoLettura;
    }
}
