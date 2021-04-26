package modele;

import java.util.Random;

public class CreateRib {

    private String numero_compte;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CreateRib{");
        sb.append("numero_compte='").append(numero_compte).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getNumero_compte() {
        return numero_compte;
    }

    public CreateRib setNumero_compte(String numero_compte) {
        this.numero_compte = numero_compte;
        return this;
    }

    public String generate() {
        Random rand = new Random();
        String firstnum = "FR76";
        String num1 = Integer.toString(rand.nextInt(10000) + 1000);
        String num2 = Integer.toString(rand.nextInt(10000) + 1000);
        String num3 = Integer.toString(rand.nextInt(10000) + 1000);
        String num4 = Integer.toString(rand.nextInt(10000) + 1000);
        this.numero_compte = firstnum + " " + num1 + " " + num2 + " " + num3 + " " + num4;
        return this.numero_compte;
    }

}
