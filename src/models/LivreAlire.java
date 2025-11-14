package models;

import java.time.LocalDate;

public class LivreAlire extends Livre {

    private LocalDate dateSelection;

    public LivreAlire(Livre livre, LocalDate dateSelection){
        super(livre);
        this.dateSelection = dateSelection;
    }

    public LocalDate getDateSelection(){
        return dateSelection;
    }
}
