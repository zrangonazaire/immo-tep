package com.gestimo.agence_immobiliere;

import com.gestimo.abstract_entity.AbstractEntity;
import com.gestimo.appel_loyer.AppelLoyer;
import com.gestimo.bienimmobilier.Bienimmobilier;
import com.gestimo.caissiere.Caissiere;
import com.gestimo.categorie_chambre.CategorieChambre;
import com.gestimo.charge_additionnelle.ChargeAdditionnelle;
import com.gestimo.charges.Charges;
import com.gestimo.client.Client;
import com.gestimo.client_fidel.ClientFidel;
import com.gestimo.client_hotel.ClientHotel;
import com.gestimo.cloture_caisse.ClotureCaisse;
import com.gestimo.commune.Commune;
import com.gestimo.contrat_reservation.ContratReservation;
import com.gestimo.cron_mail.CronMail;
import com.gestimo.detail_contrat_reservation.DetailContratReservation;
import com.gestimo.droit_acces.DroitAcces;
import com.gestimo.encaissement.Encaissement;
import com.gestimo.encaissement_accessoire.EncaissementAccessoire;
import com.gestimo.encaissement_principal.EncaissementPrincipal;
import com.gestimo.encaissement_reservation.EncaissementReservation;
import com.gestimo.etablissement.Etablissement;
import com.gestimo.etablissement_utilisateur.EtablissementUtilisateur;
import com.gestimo.etage.Etage;
import com.gestimo.facture.Facture;
import com.gestimo.file_data.FileData;
import com.gestimo.groupe_droit.GroupeDroit;
import com.gestimo.image_data.ImageData;
import com.gestimo.image_table.ImageTable;
import com.gestimo.immeuble.Immeuble;
import com.gestimo.message_envoyer.MessageEnvoyer;
import com.gestimo.montant_loyer_bail.MontantLoyerBail;
import com.gestimo.operation.Operation;
import com.gestimo.paiement.Paiement;
import com.gestimo.pays.Pays;
import com.gestimo.prestation.Prestation;
import com.gestimo.prestation_additionnel_reservation.PrestationAdditionnelReservation;
import com.gestimo.prestation_hotel.PrestationHotel;
import com.gestimo.prix_par_categorie_chambre.PrixParCategorieChambre;
import com.gestimo.quartier.Quartier;
import com.gestimo.quittance.Quittance;
import com.gestimo.reduction_tarifaire.ReductionTarifaire;
import com.gestimo.role.Role;
import com.gestimo.services_hotel.ServicesHotel;
import com.gestimo.site.Site;
import com.gestimo.suivie_depense.SuivieDepense;
import com.gestimo.token.Token;
import com.gestimo.type_chambre.TypeChambre;
import com.gestimo.ville.Ville;
import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Entity
@Table(name = "agence_immobiliere")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AgenceImmobiliere extends AbstractEntity {

  private String adresse_agence;

  @OneToMany(mappedBy = "id_agence")
  private List<AppelLoyer> appel_loyer_list;

  @OneToMany(mappedBy = "id_agence")
  private List<Bienimmobilier> bienimmobilier_list;

  @OneToMany(mappedBy = "id_agence")
  private List<Caissiere> caissiere_list;

  @OneToMany(mappedBy = "id_agence")
  private List<CategorieChambre> categorie_chambre_list;

  @OneToMany(mappedBy = "id_agence")
  private List<ChargeAdditionnelle> charge_additionnelle_list;

  @OneToMany(mappedBy = "id_agence")
  private List<Charges> charges_list;

  @OneToMany(mappedBy = "id_agence")
  private List<Client> client_list;

  @OneToMany(mappedBy = "id_agence")
  private List<ClientFidel> client_fidel_list;

  @OneToMany(mappedBy = "id_agence")
  private List<ClientHotel> client_hotel_list;

  @OneToMany(mappedBy = "id_agence")
  private List<ClotureCaisse> cloture_caisse_list;

  @OneToMany(mappedBy = "id_agence")
  private List<Commune> commune_list;

  @OneToMany(mappedBy = "id_agence")
  private List<ContratReservation> contrat_reservation_list;

  @OneToMany(mappedBy = "id_agence")
  private List<CronMail> cron_mail_list;

  @OneToMany(mappedBy = "id_agence")
  private List<DetailContratReservation> detail_contrat_reservation_list;

  @OneToMany(mappedBy = "id_agence")
  private List<DroitAcces> droit_acces_list;

  @OneToMany(mappedBy = "id_agence")
  private List<Encaissement> encaissement_list;

  @OneToMany(mappedBy = "id_agence")
  private List<EncaissementAccessoire> encaissement_accessoire_list;

  @OneToMany(mappedBy = "id_agence")
  private List<EncaissementPrincipal> encaissement_principal_list;

  @OneToMany(mappedBy = "id_agence")
  private List<EncaissementReservation> encaissement_reservation_list;

  @OneToMany(mappedBy = "id_agence")
  private List<Etablissement> etablissement_list;

  @OneToMany(mappedBy = "id_agence")
  private List<EtablissementUtilisateur> etablissement_utilisateur_list;

  @OneToMany(mappedBy = "id_agence")
  private List<Etage> etage_list;

  @OneToMany(mappedBy = "id_agence")
  private List<Facture> facture_list;

  @OneToMany(mappedBy = "id_agence")
  private List<FileData> file_data_list;

  @OneToMany(mappedBy = "id_agence")
  private List<GroupeDroit> groupe_droit_list;

  @OneToMany(mappedBy = "id_agence")
  private List<ImageData> image_data_list;

  @OneToMany(mappedBy = "id_agence")
  private List<ImageTable> image_table_list;

  @OneToMany(mappedBy = "id_agence")
  private List<Immeuble> immeuble_list;

  @OneToMany(mappedBy = "id_agence")
  private List<MessageEnvoyer> message_envoyer_list;

  @OneToMany(mappedBy = "id_agence")
  private List<MontantLoyerBail> montant_loyer_bail_list;

  @OneToMany(mappedBy = "id_agence")
  private List<Operation> operation_list;

  @OneToMany(mappedBy = "id_agence")
  private List<Paiement> paiement_list;

  @OneToMany(mappedBy = "id_agence")
  private List<Pays> pays_list;

  @OneToMany(mappedBy = "id_agence")
  private List<Prestation> prestation_list;

  @OneToMany(mappedBy = "id_agence")
  private List<PrestationAdditionnelReservation> prestation_additionnel_reservation_list;

  @OneToMany(mappedBy = "id_agence")
  private List<PrestationHotel> prestation_hotel_list;

  @OneToMany(mappedBy = "id_agence")
  private List<PrixParCategorieChambre> prix_par_categorie_chambre_list;

  @OneToMany(mappedBy = "id_agence")
  private List<Quartier> quartier_list;

  @OneToMany(mappedBy = "id_agence")
  private List<Quittance> quittance_list;

  @OneToMany(mappedBy = "id_agence")
  private List<ReductionTarifaire> reduction_tarifaire_list;

  @OneToMany(mappedBy = "id_agence")
  private List<Role> role_list;

  @OneToMany(mappedBy = "id_agence")
  private List<ServicesHotel> services_hotel_list;

  @OneToMany(mappedBy = "id_agence")
  private List<Site> site_list;

  @OneToMany(mappedBy = "id_agence")
  private List<SuivieDepense> suivie_depense_list;

  @OneToMany(mappedBy = "id_agence")
  private List<Token> token_list;

  @OneToMany(mappedBy = "id_agence")
  private List<TypeChambre> type_chambre_list;

  @OneToMany(mappedBy = "id_agence")
  private List<Ville> ville_list;
}
