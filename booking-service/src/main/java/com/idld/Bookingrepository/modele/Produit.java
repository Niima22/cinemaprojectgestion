package com.idld.Bookingrepository.modele;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Produit {
    private Long idProduit;
    private String intitule;
    private Double prix;

}