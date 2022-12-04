package si.rsvo.izdelki.models.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "izdelki_metadata")
@NamedQueries(value =
        {
                @NamedQuery(name = "izdelkiMetadataEntity.getAll",
                        query = "SELECT im FROM izdelkiMetadataEntity im")
        })

public class izdelkiMetadataEntity {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIzdelekId() {
        return izdelekId;
    }

    public void setIzdelekId(Integer izdelekId) {
        this.izdelekId = izdelekId;
    }

    public Integer getCena() {
        return cena;
    }

    public void setCena(Integer cena) {
        this.cena = cena;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "izdelekId")
    private Integer izdelekId;

    @Column(name = "cena")
    private Integer cena;

    @Column(name = "naziv")
    private String naziv;


}