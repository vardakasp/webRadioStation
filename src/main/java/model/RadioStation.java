package model;

import enums.Genre;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class RadioStation {
    private Set<Song> songs;

    public RadioStation(Set<Song> songs) {
        this.songs = songs;
    }

    public List<Song> getPlaylistBySimilarity(String songTitle) {
        Optional<Song> referenceSong = this.songs.stream()
                .filter(song -> song.getTitle().equalsIgnoreCase(songTitle))
                .findFirst();

        if (referenceSong.isEmpty()) {
            return null;
        }

        Map<Song, Double> songsWithDistance = new HashMap<>();
        this.songs.forEach(song -> songsWithDistance.put(song, calculateDistance(referenceSong.get(), song)));

        return songsWithDistance.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    protected Double calculateDistance(Song song1, Song song2) {
        Map<Genre, Double> weightsSong1 = new HashMap<>(song1.getGenres());
        Map<Genre, Double> weightsSong2 = song2.getGenres();

        weightsSong2.forEach((key, value) -> weightsSong1.merge(key, value, (v1, v2) -> pow((v1 - v2), 2)));
        return sqrt(weightsSong1.values().stream().mapToDouble(Double::doubleValue).sum());
    }

    public void printPlaylist(List<Song> songs) {
        if (songs == null) {
            System.out.println("Song is not available in the list\n");
        } else {
            songs.stream().map(Song::toString).forEach(System.out::println);
        }
    }
}
