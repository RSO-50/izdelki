package si.rsvo.izdelki.models.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "izdelki_metadata")
@NamedQueries(value =
        {
                @NamedQuery(name = "izdelkiMetadataEntity.getAll",
                        query = "SELECT im FROM izdelkiMetadataEntity im"),
                @NamedQuery(name = "izdelkiMetadataEntity.getIzdelkiByUporabnik",
                        query = "SELECT t FROM izdelkiMetadataEntity t WHERE t.uporabnikId = :uporabnikId"),
                @NamedQuery(name = "izdelkiMetadataEntity.getUporabnikovIzdelek",
                        query = "SELECT t FROM izdelkiMetadataEntity t WHERE t.uporabnikId = :uporabnikId AND t.izdelekId = :izdelekId")
        })

public class izdelkiMetadataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "izdelek")
    private String izdelek;

    @Column(name = "izdelekId")
    private Integer izdelekId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getizdelek() {
        return izdelek;
    }

    public void setIzdelek(String izdelek) {
        this.izdelek = izdelek;
    }

    public Integer getIzdelekId() {
        return izdelekId;
    }

    public void setIzdelekId(Integer izdelekId) {
        this.izdelekId = izdelekId;
    }

}