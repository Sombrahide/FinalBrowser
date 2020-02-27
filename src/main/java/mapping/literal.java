package mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "literal")

public class literal{
    @Id
    @Column(name = "idi_cod")
    private String idi_cod;
    @Column(name = "lit_key")
    private String lit_key;
    @Column(name = "lit_text")
    private String lit_text;

    public literal() {

    }

    public literal(String idi_cod, String lit_key, String lit_text) {
        this.idi_cod = idi_cod;
        this.lit_key = lit_key;
        this.lit_text = lit_text;
    }

    public String getIdi_cod() {
        return idi_cod;
    }

    public void setIdi_cod(String idi_cod) {
        this.idi_cod = idi_cod;
    }

    public String getLit_key() {
        return lit_key;
    }

    public void setLit_key(String lit_key) {
        this.lit_key = lit_key;
    }

    public String getLit_text() {
        return lit_text;
    }

    public void setLit_text(String lit_text) {
        this.lit_text = lit_text;
    }


}