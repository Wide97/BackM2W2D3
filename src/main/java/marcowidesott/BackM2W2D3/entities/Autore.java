package marcowidesott.BackM2W2D3.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Autore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String dataDiNascita;
    private String avatar;

    public Autore(String nome, String cognome, String email, String dataDiNascita) {
        this.name = nome;
        this.surname = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.avatar = generateAvatarUrl(nome, cognome);
    }

    private String generateAvatarUrl(String nome, String cognome) {
        return "https://ui-avatars.com/api/?name=" + nome + "+" + cognome;
    }
}
