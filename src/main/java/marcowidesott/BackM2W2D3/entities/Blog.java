package marcowidesott.BackM2W2D3.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Blog {
    private Long id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private double tempoLettura;

    public Blog(String categoria, String titolo, String contenuto, int tempoDiLettura) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.contenuto = contenuto;
        this.tempoLettura = tempoDiLettura;
        this.cover = generateCoverUrl(200, 300);
    }

    private String generateCoverUrl(int larghezza, int altezza) {
        return "https://picsum.photos/" + larghezza + "/" + altezza;
    }
}
