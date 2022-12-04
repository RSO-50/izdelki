package si.rsvo.izdelki.models.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "izdelki_metadata")
@NamedQueries(value =
        {
                @NamedQuery(name = "izdelkiMetadataEntity.getAll",
                        query = "SELECT im FROM izdelkiMetadataEntity im"),
                @NamedQuery(name = "izdelkiMetadataEntity.getIzdelkibyCena",
                        query = "SELECT t FROM izdelkiMetadataEntity t WHERE t.izdelekId = :izdelekId"),
                @NamedQuery(name = "izdelkiMetadataEntity.getCenoIzdelka",
                        query = "SELECT t FROM izdelkiMetadataEntity t WHERE t.cenaId = :cenaId AND t.izdelekId = :izdelekId")
        })

public class izdelkiMetadataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cenaId")
    private Integer cena;

    @Column(name = "izdelekId")
    private Integer izdelekId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCenaId() {
        return cenaId;
    }

    public void setCenaId(Integer cenaId) {
        this.cenaId = cenaId;
    }

    public Integer getIzdelekId() {
        return izdelekId;
    }

    public void setIzdelekId(Integer izdelekId) {
        this.izdelekId = izdelekId;
    }

}