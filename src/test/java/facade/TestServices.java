package facade;

import facade.erreurs.TitreNotFoundException;
import modele.Playlist;
import modele.Titre;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Fred on 13/06/2017.
 */
public class TestServices {
    private PlaylistService service = new ServiceImpl();

    @Test
    public void testPlaylist() {
        Playlist liste = service.getPlaylist("fred", "bestOfU2");
        assertEquals(liste.getListe().size(),3);
    }
    @Test
    public void testCopie() {
        service.copierPlayList("mystere", "fred", "bestOfU2");
        Playlist liste = service.getPlaylist("mystere", "bestOfU2");
        assertEquals(liste.getListe().size(),3);
    }

    @Test
    public void testTitreDansPlaylist() throws TitreNotFoundException {
        Titre titre = service.getTitre(485); // ABBA mamma mia
        assertEquals(titre.getChanson(),"Mamma mia");
        Collection<Playlist> playlists = service.getAllPlaylistAvecCeTitre(titre);
        assertEquals(playlists.size(),1);
    }

    @Test
    public void testTitreDansPlaylist2() throws TitreNotFoundException {
        Titre titre = service.getTitre(434); // Staying alive
        assertEquals(titre.getChanson(),"Staying alive");
        Collection<Playlist> playlists = service.getAllPlaylistAvecCeTitre(titre);
        assertEquals(playlists.size(),2);
    }

    @Test
    public void testTitreDansPlaylist3() throws TitreNotFoundException {
        Titre titre = service.getTitre(22); // Beatles
        assertEquals(titre.getGroupe(),"Beatles");
        Collection<Playlist> playlists = service.getAllPlaylistAvecCeTitre(titre);
        assertEquals(playlists.size(),0);
    }



}
