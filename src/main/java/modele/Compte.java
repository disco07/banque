package modele;

import javax.swing.JOptionPane;
import java.util.Objects;

public class Compte {

    private CreateRib num_compte;
    private double solde = 0;
    private int decouvertAutorise = 200;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Compte{");
        sb.append("num_compte=").append(num_compte);
        sb.append(", solde=").append(solde);
        sb.append(", decouvertAutorise=").append(decouvertAutorise);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Compte compte = (Compte) o;
        return Double.compare(compte.solde, solde) == 0 && decouvertAutorise == compte.decouvertAutorise
                && Objects.equals(num_compte, compte.num_compte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num_compte, solde, decouvertAutorise);
    }

    public CreateRib getNum_compte() {
        return num_compte;
    }

    public Compte setNum_compte(CreateRib num_compte) {
        this.num_compte = num_compte;
        return this;
    }

    public double getSolde() {
        return solde;
    }

    public Compte setSolde(double solde) {
        this.solde = solde;
        return this;
    }

    public int getDecouvertAutorise() {
        return decouvertAutorise;
    }

    public Compte setDecouvertAutorise(int decouvertAutorise) {
        this.decouvertAutorise = decouvertAutorise;
        return this;
    }

    public void afficherSolde() {
        JOptionPane.showMessageDialog(null, this.solde + " euros");
    }

    public double deposerArgent(double montant) {
        this.solde += montant;
        return this.solde;
    }

    public double retirerArgent(double montant) {
        if (montant <= this.solde + this.decouvertAutorise) {
            this.solde -= montant;
        } else {
            JOptionPane.showMessageDialog(null, "Vous ne pouvez plus faire de retrait");
        }
        return this.solde;
    }
}
