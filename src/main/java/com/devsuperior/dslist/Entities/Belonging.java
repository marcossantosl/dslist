//É um objeto auxiliar em uma relação de muitos pra muitos onde existem mais informações para explicitar, no caso aqui o position


package com.devsuperior.Dslist.Entities; //Modelo de objetos, é um caso onde precisa de um tipo de atributo apenas.

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_belonging")
public class Belonging {
   
    @EmbeddedId
    private BelongingPk id = new BelongingPk();
   
    private Integer position;

    public Belonging() {
    }

    public Belonging(Game game,GameList list, Integer position) {
        this.id.setGame(game);;
        this.id.setList(list);
        this.position = position;
    }

    public BelongingPk getId() {
        return id;
    }

    public void setId(BelongingPk id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Belonging other = (Belonging) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }



    
}
