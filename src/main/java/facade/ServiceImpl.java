package facade;


import facade.erreurs.*;
import modele.LastLoginLog;
import modele.Playlist;
import modele.Titre;
import modele.User;

import java.time.LocalDateTime;
import java.util.*;


public class ServiceImpl implements LoginService, PlaylistService {

    private Map<String, User> utilisateurs = new HashMap<>();
    private Set<String> connectes = new HashSet<>();

    private Set<Titre> titres = new HashSet<>();
    private Map<Long,Titre> titresParPlace = new HashMap<>();

    public ServiceImpl() {
        // ajout de quelques utilisateurs
        try {
            enregistrerEtLogin("yohan","abc");
            enregistrerEtLogin("fred","abc");
            enregistrerEtLogin("mystere","abc");
            ajouterTitre("Beatles","Hey Jude",22);
            ajouterTitre("Beatles","Yesterday",39);
            ajouterTitre("Beatles","Let it be",58);
            ajouterTitre("Beatles","A day in the life",76);
            ajouterTitre("Beatles","Blackbird",142);
            ajouterTitre("Beatles","Here comes the sun",185);
            ajouterTitre("Beatles","Strawberry fields forever",187);
            ajouterTitre("Beatles","While my guitar gently weeps",191);
            ajouterTitre("Beatles","Fool on the hill",203);
            ajouterTitre("Beatles","The long and winding road",298);
            ajouterTitre("Beatles","Norwegian wood",303);
            ajouterTitre("Beatles","Michelle",321);
            ajouterTitre("Beatles","Eleanor Rigby",327);
            ajouterTitre("Beatles","Sgt. Pepper's Lonely Hearts c",335);
            ajouterTitre("Beatles","Get back",351);
            ajouterTitre("Beatles","Something",417);
            ajouterTitre("Beatles","Penny lane",438);
            ajouterTitre("Beatles","Help",467);
            ajouterTitre("Beatles","All you need is love",476);
            ajouterTitre("Beatles","She's leaving home",522);
            ajouterTitre("Beatles","In my life",584);
            ajouterTitre("Beatles","I am the walrus",641);
            ajouterTitre("Beatles","When I'm sixty four",695);
            ajouterTitre("Beatles","For no one",698);
            ajouterTitre("Beatles","Lucy in the sky with diamonds",748);
            ajouterTitre("Beatles","Here there and everywhere",807);
            ajouterTitre("Beatles","Lady Madonna",844);
            ajouterTitre("Beatles","A hard day's night",890);
            ajouterTitre("Beatles","And I love her",991);
            ajouterTitre("Beatles","Across the universe",1004);
            ajouterTitre("Beatles","Girl",1006);
            ajouterTitre("Beatles","Back in the U.S.S.R.",1068);
            ajouterTitre("Beatles","We can work it out",1069);
            ajouterTitre("Beatles","I saw her standing there",1076);
            ajouterTitre("Beatles","Eight days a week",1142);
            ajouterTitre("Beatles","Hello goodbye",1183);
            ajouterTitre("Beatles","Yellow submarine",1185);
            ajouterTitre("Beatles","Can't buy me love",1204);
            ajouterTitre("Beatles","All my loving",1208);
            ajouterTitre("Beatles","If I fell",1271);
            ajouterTitre("Beatles","Twist and shout",1358);
            ajouterTitre("Beatles","She loves you",1369);
            ajouterTitre("Beatles","Baby's in black",1428);
            ajouterTitre("Beatles","Day tripper",1479);
            ajouterTitre("Beatles","Paperback writer",1529);
            ajouterTitre("Beatles","No reply",1556);
            ajouterTitre("Beatles","Love me do",1606);
            ajouterTitre("Beatles","I feel fine",1622);
            ajouterTitre("Beatles","Ob la di ob la da",1649);
            ajouterTitre("Beatles","The ballad of John and Yoko",1678);
            ajouterTitre("Beatles","Ticket to ride",1719);
            ajouterTitre("Beatles","Magical mystery tour",1726);
            ajouterTitre("Beatles","Rock and roll music",1834);
            ajouterTitre("Beatles","I should have known better",1879);
            ajouterTitre("Beatles","I want to hold your hand",1973);
            ajouterTitre("Beatles","Please, please me",2197);
            ajouterTitre("Beatles","Getting Better",2408);
            ajouterTitre("Beatles","From Me To You",3265);
            ajouterTitre("Beatles","Things We Said Today",3268);
            ajouterTitre("Beatles","The Night Before",3277);
            ajouterTitre("Beatles","Please Mr. Postman",3285);
            ajouterTitre("Beatles","Do You Want To Know a Secret",3292);
            ajouterTitre("Beatles","If I Fell In Love With You",3356);
            ajouterTitre("Beatles","Roll Over Beethoven",3400);
            ajouterTitre("Beatles","A Taste of Honey",3435);
            ajouterTitre("Beatles","Mr. Moonlight",3459);
            ajouterTitre("Beatles","Long Tall Sally",3472);
            ajouterTitre("Beatles","You Really Got a Hold on Me",3483);
            ajouterTitre("Beatles","Anytime You Call",3484);
            ajouterTitre("Beatles","Nowhere Man",3485);
            ajouterTitre("Beatles","I am a Loser",3490);
            ajouterTitre("Rolling Stones","Angie",21);
            ajouterTitre("Rolling Stones","Sympathy for the devil",45);
            ajouterTitre("Rolling Stones","Paint it black",57);
            ajouterTitre("Rolling Stones","I can't get no Satisfaction",122);
            ajouterTitre("Rolling Stones","You can't always get what you",207);
            ajouterTitre("Rolling Stones","Gimme shelter",241);
            ajouterTitre("Rolling Stones","Wild horses",306);
            ajouterTitre("Rolling Stones","It's all over now",450);
            ajouterTitre("Rolling Stones","Brown sugar",465);
            ajouterTitre("Rolling Stones","Jumpin' Jack flash",495);
            ajouterTitre("Rolling Stones","Ruby Tuesday",525);
            ajouterTitre("Rolling Stones","Honky tonk women",558);
            ajouterTitre("Rolling Stones","As tears go by",568);
            ajouterTitre("Rolling Stones","Lady Jane",636);
            ajouterTitre("Rolling Stones","Waiting on a friend",688);
            ajouterTitre("Rolling Stones","Fool to cry",715);
            ajouterTitre("Rolling Stones","Little red rooster",729);
            ajouterTitre("Rolling Stones","She's a rainbow",776);
            ajouterTitre("Rolling Stones","The last time",812);
            ajouterTitre("Rolling Stones","Start me up",841);
            ajouterTitre("Rolling Stones","Midnight rambler",853);
            ajouterTitre("Rolling Stones","Let's spend the night togethe",921);
            ajouterTitre("Rolling Stones","Dead flowers",956);
            ajouterTitre("Rolling Stones","Miss you",968);
            ajouterTitre("Rolling Stones","Time is on my side",1154);
            ajouterTitre("Rolling Stones","Under my thumb",1246);
            ajouterTitre("Rolling Stones","That's how strong my love is",1250);
            ajouterTitre("Rolling Stones","Memory motel",1302);
            ajouterTitre("Rolling Stones","2000 Light years from home",1317);
            ajouterTitre("Rolling Stones","Tell me",1371);
            ajouterTitre("Rolling Stones","Get your kicks on Route 66",1381);
            ajouterTitre("Rolling Stones","Heart of stone",1382);
            ajouterTitre("Rolling Stones","Beast of burden",1666);
            ajouterTitre("Rolling Stones","Tumbling dice",1669);
            ajouterTitre("Rolling Stones","Get off of my cloud",1686);
            ajouterTitre("Rolling Stones","It's only rock 'n roll",1745);
            ajouterTitre("Rolling Stones","Mother's little helper",1792);
            ajouterTitre("Rolling Stones","Street fightin' man",1840);
            ajouterTitre("Rolling Stones","19th Nervous breakdown",1900);
            ajouterTitre("Rolling Stones","We love you",1903);
            ajouterTitre("Rolling Stones","Undercover The Night",2381);
            ajouterTitre("Rolling Stones","Emotional Rescue",2678);
            ajouterTitre("ABBA","Dancing queen",49);
            ajouterTitre("ABBA","The day before you came",104);
            ajouterTitre("ABBA","Eagle",135);
            ajouterTitre("ABBA","The winner takes it all",140);
            ajouterTitre("ABBA","Thank you for the music",243);
            ajouterTitre("ABBA","I have a dream",395);
            ajouterTitre("ABBA","Happy New Year",402);
            ajouterTitre("ABBA","Chiquitita",479);
            ajouterTitre("ABBA","Mamma mia",485);
            ajouterTitre("ABBA","Fernando",524);
            ajouterTitre("ABBA","Waterloo",546);
            ajouterTitre("ABBA","One of us",777);
            ajouterTitre("ABBA","Knowing me knowing you",917);
            ajouterTitre("ABBA","Gimme gimme gimme",1019);
            ajouterTitre("ABBA","Lay all your love on me",1059);
            ajouterTitre("ABBA","S.O.S.",1175);
            ajouterTitre("ABBA","Does your mother know",1193);
            ajouterTitre("ABBA","Take a chance on me",1294);
            ajouterTitre("ABBA","Super trouper",1407);
            ajouterTitre("ABBA","Money money money",1496);
            ajouterTitre("ABBA","The name of the game",1648);
            ajouterTitre("ABBA","Summer night city",1701);
            ajouterTitre("ABBA","Head over heals",1722);
            ajouterTitre("ABBA","Voulez vous",1963);
            ajouterTitre("ABBA","I do I do I do",2058);
            ajouterTitre("ABBA","Honey honey",2065);
            ajouterTitre("ABBA","Ring Ring",2431);
            ajouterTitre("ABBA","I've Been Waiting For You",3237);
            ajouterTitre("ABBA","The Way old Friends Do",3378);
            ajouterTitre("ABBA","Intermezzo No. 1",3385);
            ajouterTitre("ABBA","Tropical Loveland",3452);
            ajouterTitre("ABBA","I Believe In Angels",3458);
            ajouterTitre("ABBA","People Need Love",3471);
            ajouterTitre("ABBA","Our Last Summer",3480);
            ajouterTitre("Queen","Bohemian rhapsody",1);
            ajouterTitre("Queen","Love of my life",69);
            ajouterTitre("Queen","Who wants to live forever",74);
            ajouterTitre("Queen","I want to break free",121);
            ajouterTitre("Queen","Somebody to love",129);
            ajouterTitre("Queen","Don't stop me now",154);
            ajouterTitre("Queen","The show must go on",186);
            ajouterTitre("Queen","We will rock you",228);
            ajouterTitre("Queen","Killer queen",257);
            ajouterTitre("Queen","We are the champions",271);
            ajouterTitre("Queen","Radio ga ga",317);
            ajouterTitre("Queen","These are the days of our liv",336);
            ajouterTitre("Queen","Innuendo",393);
            ajouterTitre("Queen","Crazy little thing called",582);
            ajouterTitre("Queen","A kind of magic",601);
            ajouterTitre("Queen","Bicycle race",630);
            ajouterTitre("Queen","Another one bites the dust",638);
            ajouterTitre("Queen","You're my best friend",765);
            ajouterTitre("Queen","Tie your mother down",1186);
            ajouterTitre("Queen","Heaven For Every One",3274);
            ajouterTitre("Queen","Thank God It's Christmas",3289);
            ajouterTitre("Queen","Let Me Live",3327);
            ajouterTitre("Queen","Living On My Own",3357);
            ajouterTitre("Bee Gees","Massachusetts",287);
            ajouterTitre("Bee Gees","How deep is your love",350);
            ajouterTitre("Bee Gees","Words",356);
            ajouterTitre("Bee Gees","Staying alive",434);
            ajouterTitre("Bee Gees","Spicks and specks",552);
            ajouterTitre("Bee Gees","I started a joke",612);
            ajouterTitre("Bee Gees","Don't forget to remember",656);
            ajouterTitre("Bee Gees","Night fever",861);
            ajouterTitre("Bee Gees","Nights on broadway",920);
            ajouterTitre("Bee Gees","Tragedy",937);
            ajouterTitre("Bee Gees","Lonely days",1024);
            ajouterTitre("Bee Gees","You win again",1139);
            ajouterTitre("Bee Gees","How can you mend a broken",1173);
            ajouterTitre("Bee Gees","To love somebody",1236);
            ajouterTitre("Bee Gees","I've gotta get a message to y",1450);
            ajouterTitre("Bee Gees","New York mining disaster 1941",1477);
            ajouterTitre("Bee Gees","World",1727);
            ajouterTitre("Bee Gees","Too much heaven",1805);
            ajouterTitre("Bee Gees","You should be dancing",1848);
            ajouterTitre("Bee Gees","Jive talking",1941);
            ajouterTitre("Bee Gees","My world",2036);
            ajouterTitre("Bee Gees","Holiday",2224);
            ajouterTitre("Bee Gees","First Of May",3256);
            ajouterTitre("Bee Gees","When The Swallows Fly",3293);
            ajouterTitre("Beach Boys","God only knows",68);
            ajouterTitre("Beach Boys","Good vibrations",117);
            ajouterTitre("Beach Boys","Sloop John B",301);
            ajouterTitre("Beach Boys","Tears in the morning",789);
            ajouterTitre("Beach Boys","I can hear music",1269);
            ajouterTitre("Beach Boys","California girls",1516);
            ajouterTitre("Beach Boys","Heroes and villains",1587);
            ajouterTitre("Beach Boys","Then I kissed her",1638);
            ajouterTitre("Beach Boys","Wouldn't it be nice",1693);
            ajouterTitre("Beach Boys","Barbara Ann",1774);
            ajouterTitre("Beach Boys","Help me Rhonda",1857);
            ajouterTitre("Beach Boys","Kokomo",1905);
            ajouterTitre("Beach Boys","I get around",1986);
            ajouterTitre("Beach Boys","Sail On Sailor",2426);
            ajouterTitre("Beach Boys","Do It Again",2495);
            ajouterTitre("Beach Boys","Fun, Fun, Fun",3238);
            ajouterTitre("Beach Boys","Surfing USA",3275);
            ajouterTitre("Beach Boys","Little Honda",3371);
            ajouterTitre("Beach Boys","You're So Good To Me",3389);
            ajouterTitre("Beach Boys","Darlin'",3477);
            ajouterTitre("Elvis Presley","Suspicious minds",97);
            ajouterTitre("Elvis Presley","In the ghetto",157);
            ajouterTitre("Elvis Presley","Always on my mind",314);
            ajouterTitre("Elvis Presley","My boy",390);
            ajouterTitre("Elvis Presley","I just can't help believing",411);
            ajouterTitre("Elvis Presley","Jailhouse rock",528);
            ajouterTitre("Elvis Presley","Can't help falling in love",611);
            ajouterTitre("Elvis Presley","Love me tender",654);
            ajouterTitre("Elvis Presley","Are you lonesome tonight",664);
            ajouterTitre("Elvis Presley","Burning love",775);
            ajouterTitre("Elvis Presley","One night with you",778);
            ajouterTitre("Elvis Presley","Heartbreak hotel",960);
            ajouterTitre("Elvis Presley","It's now or never",999);
            ajouterTitre("Elvis Presley","You're the devil in disguis",1130);
            ajouterTitre("Elvis Presley","Wooden heart",1217);
            ajouterTitre("Elvis Presley","Don't be cruel",1315);
            ajouterTitre("Elvis Presley","Little sister",1611);
            ajouterTitre("Elvis Presley","Kiss me quick",1717);
            ajouterTitre("Elvis Presley","Good luck charm",2012);
            ajouterTitre("Dire Straits","Brothers in arms",20);
            ajouterTitre("Dire Straits","Sultans of swing",27);
            ajouterTitre("Dire Straits","Private investigations",31);
            ajouterTitre("Dire Straits","Walk of life",210);
            ajouterTitre("Dire Straits","Money for nothing",304);
            ajouterTitre("Dire Straits","Romeo and Juliet",316);
            ajouterTitre("Dire Straits","Telegraph road",329);
            ajouterTitre("Dire Straits","Tunnel of love",560);
            ajouterTitre("Dire Straits","Why worry",783);
            ajouterTitre("Dire Straits","On every street",951);
            ajouterTitre("Dire Straits","Water of love",1224);
            ajouterTitre("Dire Straits","Calling Elvis",1484);
            ajouterTitre("Dire Straits","Twisting by the pool",1748);
            ajouterTitre("Dire Straits","So Far Away",2923);
            ajouterTitre("Dire Straits","Your Latest Trick",3011);
            ajouterTitre("Dire Straits","Theme Of The Local Hero",3284);
            ajouterTitre("Dire Straits","The Way It Always Starts",3290);
            ajouterTitre("Dire Straits","The Man's Too Strong",3392);
            ajouterTitre("U2","One",6);
            ajouterTitre("U2","Sunday bloody sunday",41);
            ajouterTitre("U2","With or without you",48);
            ajouterTitre("U2","Beautiful day",59);
            ajouterTitre("U2","I still haven't found what I'",72);
            ajouterTitre("U2","Where the streets have no nam",98);
            ajouterTitre("U2","The unforgettable fire",114);
            ajouterTitre("U2","Pride (In the name of love)",137);
            ajouterTitre("U2","New Years day",172);
            ajouterTitre("U2","All I want is you",365);
            ajouterTitre("U2","I will follow",452);
            ajouterTitre("U2","Stuck in a moment you can't",631);
            ajouterTitre("U2","Walk on",781);
            ajouterTitre("U2","Desire",2524);
            ajouterTitre("U2","Sweetest Thing",2640);


            ajouterTitreDansPlaylist("fred","bestOfU2", "U2", "Sunday bloody sunday");
            ajouterTitreDansPlaylist("fred","bestOfU2", "U2", "I will follow");
            ajouterTitreDansPlaylist("fred","bestOfU2", "U2", "One");

            ajouterTitreDansPlaylist("fred","lafolie", "Bee Gees", "Staying alive");
            ajouterTitreDansPlaylist("fred","lafolie", "Queen", "We will rock you");
            ajouterTitreDansPlaylist("fred","lafolie", "Rolling Stones", "I can't get no Satisfaction");

            ajouterTitreDansPlaylist("yohan","nostalgie", "Bee Gees", "Staying alive");
            ajouterTitreDansPlaylist("yohan","nostalgie", "Elvis Presley", "Love me tender");
            ajouterTitreDansPlaylist("yohan","nostalgie", "Beach Boys", "Good vibrations");
            ajouterTitreDansPlaylist("yohan","nostalgie", "ABBA", "Mamma mia");
            logout("fred");
            logout("yohan");
            logout("mystere");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public LocalDateTime login(String pseudo, String mdp) throws CoupleUtilisateurMDPInconnuException, UtilisateurDejaConnecteException {
        if (connectes.contains(pseudo)) {
            throw new UtilisateurDejaConnecteException();
        }
        if (utilisateurs.containsKey(pseudo) && mdp.equals(utilisateurs.get(pseudo).getMotDePasse())) {
            User user = utilisateurs.get(pseudo);
            connectes.add(pseudo);
            LocalDateTime previous = LastLoginLog.lastLogin(pseudo);
            LastLoginLog.newLogin(user);
            return previous;
        }
        throw new CoupleUtilisateurMDPInconnuException();
    }

    @Override
    public void logout(String pseudo) throws UtilisateurNonConnecteException {
        if (!connectes.contains(pseudo)) {
            throw new UtilisateurNonConnecteException();
        }
        connectes.remove(pseudo);
    }

    @Override
    public void enregistrerEtLogin(String pseudo, String mdp) throws UtilisateurDejaExistantException {
        if (utilisateurs.containsKey(pseudo)) {
            throw new UtilisateurDejaExistantException();
        }
        User user = new User(pseudo,mdp);
        utilisateurs.put(pseudo,user);
        connectes.add(pseudo);
      /*  try {
            this.login(pseudo,mdp);
        } catch (CoupleUtilisateurMDPInconnuException e) {
            e.printStackTrace();
        } catch (UtilisateurDejaConnecteException e) {
            e.printStackTrace();
        }*/

    }

    @Override
    public void refresh(String pseudo, String mdp) throws CoupleUtilisateurMDPInconnuException, UtilisateurNonConnecteException {
        if (!connectes.contains(pseudo)) {
            throw new UtilisateurNonConnecteException();
        }
        if (utilisateurs.containsKey(pseudo) && mdp.equals(utilisateurs.get(pseudo).getMotDePasse())) {
            User user = utilisateurs.get(pseudo);
            LastLoginLog.newLogin(user);
        }
        throw new CoupleUtilisateurMDPInconnuException();
    }

    @Override
    public LocalDateTime lastLogin(String pseudo) {
        return LastLoginLog.lastLogin(pseudo);
    }

    @Override
    public void ajouterTitre(String groupe, String chanson, long place) throws PlaceDuTitreDejaOccupeeException {
        if (titresParPlace.containsKey(place)) {
            throw new PlaceDuTitreDejaOccupeeException();
        }
        Titre titre = new Titre(groupe, chanson, place);
        titres.add(titre);
        titresParPlace.put(place, titre);
    }

    @Override
    public Collection<Titre> getAllTitres() {
        return titres;
    }

    @Override
    public Titre getTitre(String groupe, String chanson) throws TitreNotFoundException {
        for(Titre titre : titres) {
            if (titre.getGroupe().equals(groupe)&&titre.getChanson().equals(chanson)) {
                return titre;
            }
        }
        throw new TitreNotFoundException();
    }

    @Override
    public Titre getTitre(long place) throws TitreNotFoundException {
        if (!titresParPlace.containsKey(place)) {
            throw new TitreNotFoundException();
        }
        return titresParPlace.get(place);
    }

    @Override
    public void ajouterTitreDansPlaylist(String pseudo, String nomPlaylist, String groupe, String chanson) throws TitreNotFoundException {
        User user = utilisateurs.get(pseudo);
        Playlist laPlaylist = user.getMesPlaylists().get(nomPlaylist);
        if (laPlaylist==null) {
            // une nouvelle playlist
            laPlaylist = new Playlist(user,nomPlaylist);
            user.putMesPlaylists(nomPlaylist, laPlaylist);

        }
        Titre titre = getTitre(groupe,chanson);
        laPlaylist.addListe(titre);
    }

    @Override
    public void ajouterTitreParPlaceDansPlaylist(String pseudo, String nomPlaylist, long place) throws TitreNotFoundException {
        User user = utilisateurs.get(pseudo);
        Playlist laPlaylist = user.getMesPlaylists().get(nomPlaylist);
        if (laPlaylist==null) {
            // une nouvelle playlist
            laPlaylist = new Playlist(user,nomPlaylist);
            user.putMesPlaylists(nomPlaylist, laPlaylist);

        }
        Titre titre = titresParPlace.get(place);
        if (titre==null) {
            throw new TitreNotFoundException();
        }
        laPlaylist.addListe(titre);
    }

    @Override
    public void supprimerTitreDePlaylist(String pseudo, String nomPlaylist, long place) {
        User user = utilisateurs.get(pseudo);
        if (user != null) {
            user.supprimerTitreDePlayList(nomPlaylist, place);
        }
    }

    @Override
    public boolean creerPlayList(String pseudo, String nomPlayList) {
        User user = utilisateurs.get(pseudo);
        Playlist playlist = user.getMesPlaylists().get(nomPlayList);
        if (playlist == null) {
            playlist = new Playlist(user, nomPlayList);
            user.putMesPlaylists(nomPlayList, playlist);
            return true;
        }
        else
            return false;

    }

    @Override
    public void copierPlayList(String pseudo, String pseudoUserACopier, String nomPlayListACopier) {
        User user = utilisateurs.get(pseudo);
        User userACopier = utilisateurs.get(pseudoUserACopier);
        Playlist playlist = userACopier.getMesPlaylists().get(nomPlayListACopier);
        Playlist copie = playlist.copie(user);
        user.putMesPlaylists(playlist.getNomListe(),playlist);
    }

    @Override
    public Playlist getPlaylist(String pseudo, String nomPlaylist) {
        User user = utilisateurs.get(pseudo);
        return user.getMesPlaylists().get(nomPlaylist);
    }

    @Override
    public Collection<Playlist> getAllPlaylist() {
        Collection<Playlist> all = new ArrayList<>();
        for(User user : utilisateurs.values()) {
            all.addAll(user.getMesPlaylists().values());
        }
        return all;
    }

    @Override
    public Collection<Playlist> getAllPlaylistUtilisateur(String pseudo) {
        return utilisateurs.get(pseudo).getMesPlaylists().values();
    }

    @Override
    public Set<String> getAllPlaylistNameUser(String pseudo) {
        return utilisateurs.get(pseudo).getMesPlaylists().keySet();
    }

    @Override
    public Collection<Playlist> getAllPlaylistDepuisDate(LocalDateTime dateTime) {
        Collection<Playlist> allDate = new ArrayList<>();
        for(User user : utilisateurs.values()) {
            for(Playlist playlist : user.getMesPlaylists().values()) {
                if (dateTime == null ||playlist.getCreation().isAfter(dateTime)) {
                    allDate.add(playlist);
                }
            }
        }
        return allDate;
    }

    @Override
    public List<Titre> getPlaylistTitresOrdreAleatoire(String pseudo, String nomPlaylist) {
        User user = utilisateurs.get(pseudo);
        Playlist playlist = user.getMesPlaylists().get(nomPlaylist);
        List<Titre> listeAlea = new ArrayList<>(playlist.getListe());
        Collections.shuffle(listeAlea);
        return listeAlea;
    }

    @Override
    public Collection<Playlist> getAllPlaylistAvecCeTitre(Titre titre) {
        Collection<Playlist> liste = new ArrayList<>();
        for(String pseudo : utilisateurs.keySet()) {
            for(Playlist playlist : getAllPlaylistUtilisateur(pseudo)) {
                if (playlist.getListe().contains(titre)) {
                    liste.add(playlist);
                }
            }
        }
        return liste;
    }
}
