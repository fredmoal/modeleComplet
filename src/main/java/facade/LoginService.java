package facade;

import facade.erreurs.*;
import modele.*;

import java.time.LocalDateTime;

public interface LoginService {

    /**
     *  Connection au service
     * @param pseudo    : pseudo de l'utilisateur
     * @param mdp       : mot de passe de l'utilisateur
     *
     * @return la date et l'heure du précédent dernier login de l'utilisateur
     *
     * @throws CoupleUtilisateurMDPInconnuException mauvais couple login/mote de passe.
     * @throws UtilisateurDejaConnecteException     l'utilisateur est déjà connecté.
     */
    LocalDateTime login(String pseudo, String mdp) throws CoupleUtilisateurMDPInconnuException, UtilisateurDejaConnecteException;

    /**
     *  Déconnection au service
     * @param pseudo    : pseudo de l'utilisateur
     *
     * @throws UtilisateurNonConnecteException     l'utilisateur n'est pas connecté.
     */
    void logout(String pseudo) throws UtilisateurNonConnecteException;

    /**
     *  Enregistrement d'un nouvel utilisateur et connection de celui-ci
     * @param pseudo    : pseudo de l'utilisateur
     * @param mdp       : mot de passe de l'utilisateur
     *
     * @throws UtilisateurDejaExistantException     Un utilisateur utilise déjà ce pseudo.
     */
    void enregistrerEtLogin(String pseudo, String mdp) throws UtilisateurDejaExistantException;

    /**
     *  Récupération de la date+heure du dernier login de l'utilisateur
     * @param pseudo    : pseudo de l'utilisateur
     */
    LocalDateTime lastLogin(String pseudo);

    /**
     *  reconnection au service : l'utilisateur se reconnecte au service avant le temps limite
     *  Attention : non utlisable si l'utilisateur s'est déconnecté
     *
     * @param pseudo    : pseudo de l'utilisateur
     * @param mdp       : mot de passe de l'utilisateur
     *
     * @throws CoupleUtilisateurMDPInconnuException mauvais couple login/mote de passe.
     * @throws UtilisateurDejaConnecteException     l'utilisateur est déjà connecté.
     */
    void refresh(String pseudo, String mdp) throws CoupleUtilisateurMDPInconnuException, UtilisateurNonConnecteException;
}
