import init.InitData;
import model.RadioStation;
import model.Song;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        RadioStation radioStation = new RadioStation(InitData.getSongs());
        List<Song> playlist1 = radioStation.getPlaylistBySimilarity("lalal");
        radioStation.printPlaylist(playlist1);

        List<Song> playlist2 = radioStation.getPlaylistBySimilarity("Heroes");
        radioStation.printPlaylist(playlist2);
    }
}
