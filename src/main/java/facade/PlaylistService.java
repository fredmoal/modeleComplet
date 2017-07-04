package facade;

import facade.erreurs.PlaceDuTitreDejaOccupeeException;
import facade.erreurs.TitreNotFoundException;
import modele.Playlist;
import modele.Titre;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Service de gestion des playlists
 */
public interface PlaylistService {
    // gestion des titres
    void ajouterTitre(String groupe, String chanson, long place) throws PlaceDuTitreDejaOccupeeException;
    Collection<Titre> getAllTitres();
    Titre getTitre(String groupe, String titre) throws TitreNotFoundException;
    Titre getTitre(long place) throws TitreNotFoundException;

    // gestion des playlists
    void ajouterTitreDansPlaylist(String pseudo, String nomPlayList, String groupe, String chanson) throws TitreNotFoundException;
    void ajouterTitreParPlaceDansPlaylist(String pseudo, String nomPlayList, long place) throws TitreNotFoundException;
    void supprimerTitreDePlaylist(String pseudo, String nomPlaylist, long place);
    boolean creerPlayList(String pseudo, String nomPlayList);
    // copie dans les playlists de pseudo la playlist nomPlayListACopier de l'utilisateur pseudoUserACopier
    void copierPlayList(String pseudo, String pseudoUserACopier, String nomPlayListACopier);


    Collection<Playlist> getAllPlaylist();
    Collection<Playlist> getAllPlaylistUtilisateur(String pseudo);
    Set<String> getAllPlaylistNameUser(String pseudo);
    Collection<Playlist> getAllPlaylistDepuisDate(LocalDateTime dateTime);
    Playlist getPlaylist(String pseudo, String nomPlaylist);
    List<Titre> getPlaylistTitresOrdreAleatoire(String pseudo, String nomPlaylist);
    Collection<Playlist> getAllPlaylistAvecCeTitre(Titre titre);
}
