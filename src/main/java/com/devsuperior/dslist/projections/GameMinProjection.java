//métodos gets que retornarão o que eu quero consultar no repositorios

package com.devsuperior.Dslist.projections;

public interface GameMinProjection {

    Long getId();
    String getTitle();
    Integer getGameYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();
}
