package si.rsvo.izdelki.lib;

import java.util.List;

public class izdelkiMetadata {

    private Integer id;
    private String izdelek;
    private Integer izdelekId;

    public Integer getizdelek() {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
