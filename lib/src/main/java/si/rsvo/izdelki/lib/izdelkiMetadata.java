package si.rsvo.izdelki.lib;

import java.util.List;

public class izdelkiMetadata {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
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

    private Integer id;
    private String naziv;
    private Integer izdelekId;
    private Integer cena;
}
