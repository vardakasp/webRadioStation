package model;

import enums.Genre;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static enums.Genre.BLUES;
import static enums.Genre.DISCO;
import static enums.Genre.HIPHOP;
import static enums.Genre.POP;
import static enums.Genre.ROCK;
import static enums.Genre.SOUL;


public class Song {
    private static final int SUM_OF_WEIGHTS = 100;

    private String title;
    private Artist artist;
    private Map<Genre, Double> genres;

    public Song(String name, String title, Map<Genre, Double> genres) {
        double sum = genres.values().stream().mapToDouble(Double::doubleValue).sum();

        if (sum == SUM_OF_WEIGHTS) {
            this.artist = new Artist(name);
            this.title = title;
            initializeGenres(genres);
        } else {
            throw new RuntimeException("Genres not populated for song: " + name + " " + title);
        }
    }

    protected void initializeGenres(Map<Genre, Double> genres) {
        HashMap<Genre, Double> initGenres = new HashMap<>() {{
            put(ROCK, 0d);
            put(POP, 0d);
            put(BLUES, 0d);
            put(SOUL, 0d);
            put(DISCO, 0d);
            put(HIPHOP, 0d);
        }};

        genres.entrySet()
                .stream()
                .forEach(entry -> initGenres
                        .computeIfPresent(entry.getKey(), (key, value) -> value = entry.getValue()));

        this.genres = initGenres;
    }

    public String getTitle() {
        return title;
    }

    public Map<Genre, Double> getGenres() {
        return genres;
    }

    @Override
    public String toString() {
        return artist.getName() + " - " + title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Song song = (Song) o;

        if (!Objects.equals(title, song.title)) return false;
        if (!Objects.equals(artist, song.artist)) return false;
        return Objects.equals(genres, song.genres);
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (artist != null ? artist.hashCode() : 0);
        result = 31 * result + (genres != null ? genres.hashCode() : 0);
        return result;
    }
}
