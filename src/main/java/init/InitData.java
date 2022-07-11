package init;

import model.Song;

import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static enums.Genre.BLUES;
import static enums.Genre.DISCO;
import static enums.Genre.POP;
import static enums.Genre.ROCK;
import static enums.Genre.SOUL;

public class InitData {
    public static Set<Song> getSongs() {
        return Stream
                .of(new Song("Oasis", "Wonderwall", new HashMap<>() {{
                            put(ROCK, 90d);
                            put(POP, 10d);
                        }}),
                        new Song("Oasis", "Don't look back in anger", new HashMap<>() {{
                            put(ROCK, 80d);
                            put(BLUES, 20d);
                        }}),
                        new Song("Pink Floyd", "Money", new HashMap<>() {{
                            put(ROCK, 50d);
                            put(POP, 20d);
                            put(BLUES, 10d);
                            put(DISCO, 20d);
                        }}),
                        new Song("Frank Zappa", "Catholic girls", new HashMap<>() {{
                            put(ROCK, 30d);
                            put(POP, 10d);
                            put(BLUES, 30d);
                            put(SOUL, 30d);
                        }}),
                        new Song("Led Zeppelin", "Stairway to heaven", new HashMap<>() {{
                            put(ROCK, 80d);
                            put(BLUES, 20d);
                        }}),
                        new Song("Deep Purple", "Perfect strangers", new HashMap<>() {{
                            put(ROCK, 100d);
                        }}),
                        new Song("Prince", "Purple rain", new HashMap<>() {{
                            put(ROCK, 10d);
                            put(POP, 80d);
                            put(BLUES, 10d);
                        }}),
                        new Song("AC DC", "Back in black", new HashMap<>() {{
                            put(ROCK, 100d);
                        }}),
                        new Song("BB King", "The thrill is gone", new HashMap<>() {{
                            put(BLUES, 100d);
                        }}),
                        new Song("Etta James", "I'd rather go blind", new HashMap<>() {{
                            put(BLUES, 60d);
                            put(SOUL, 40d);
                        }}),
                        new Song("U2", "With or without you", new HashMap<>() {{
                            put(ROCK, 40d);
                            put(POP, 20d);
                            put(BLUES, 40d);
                        }}),
                        new Song("David Bowie", "Heroes", new HashMap<>() {{
                            put(ROCK, 40d);
                            put(POP, 10d);
                            put(BLUES, 30d);
                            put(SOUL, 10d);
                            put(DISCO, 10d);
                        }}),
                        new Song("Lynyrd Skynyrd", "Free Bird", new HashMap<>() {{
                            put(ROCK, 90d);
                            put(BLUES, 10d);
                        }}),
                        new Song("Bon Jovi", "Always", new HashMap<>() {{
                            put(ROCK, 50d);
                            put(POP, 30d);
                            put(BLUES, 20d);
                        }}),
                        new Song("The Jesus and Mary Chain", "Happy when it rains", new HashMap<>() {{
                            put(ROCK, 40d);
                            put(POP, 60d);
                        }}))
                .collect(Collectors.toSet());
    }
}
