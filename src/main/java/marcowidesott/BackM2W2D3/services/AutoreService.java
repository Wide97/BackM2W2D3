package marcowidesott.BackM2W2D3.services;

import marcowidesott.BackM2W2D3.entities.Autore;
import marcowidesott.BackM2W2D3.exceptions.NotFoundException;
import marcowidesott.BackM2W2D3.payloads.AutorePayload;
import marcowidesott.BackM2W2D3.repositories.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class AutoreService {

    @Autowired
    private AutoreRepository autoreRepository;

    public Page<Autore> findAll(Pageable pageable) {
        return autoreRepository.findAll(pageable);
    }

    public Autore saveAuthor(AutorePayload body) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        LocalDate dataDiNascita = LocalDate.parse(body.getDataDiNascita(), formatter);

        Autore autore = new Autore(
                body.getName(),
                body.getSurname(),
                body.getEmail(),
                dataDiNascita.toString()
        );


        return autoreRepository.save(autore);
    }

    public Autore findById(Long userId) {
        return autoreRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Author not found"));
    }
}

