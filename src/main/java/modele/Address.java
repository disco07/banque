package modele;

import java.util.Objects;

public class Address {

    private int num_rue;
    private String rue;
    private String code_postale;
    private String ville;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return num_rue == address.num_rue && Objects.equals(rue, address.rue) && Objects.equals(code_postale, address.code_postale) && Objects.equals(ville, address.ville);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num_rue, rue, code_postale, ville);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Address{");
        sb.append("num_rue=").append(num_rue);
        sb.append(", rue='").append(rue).append('\'');
        sb.append(", code_postale='").append(code_postale).append('\'');
        sb.append(", ville='").append(ville).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public int getNum_rue() {
        return num_rue;
    }

    public Address setNum_rue(int num_rue) {
        this.num_rue = num_rue;
        return this;
    }

    public String getRue() {
        return rue;
    }

    public Address setRue(String rue) {
        this.rue = rue;
        return this;
    }

    public String getCode_postale() {
        return code_postale;
    }

    public Address setCode_postale(String code_postale) {
        this.code_postale = code_postale;
        return this;
    }

    public String getVille() {
        return ville;
    }

    public Address setVille(String ville) {
        this.ville = ville;
        return this;
    }
}
