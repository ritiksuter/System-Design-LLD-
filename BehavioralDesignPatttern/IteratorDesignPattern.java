package BehavioralDesignPatttern;

import java.util.ArrayList;
import java.util.Collections;

interface PlaylistIterator {
    boolean hasNext();

    String next();
}

class SimplePlaylistIterator implements PlaylistIterator {
    private Playlist playlist;
    private int index;

    public SimplePlaylistIterator(Playlist playlist) {
        this.playlist = playlist;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < playlist.getSongs().size();
    }

    @Override
    public String next() {
        return playlist.getSongs().get(index++);
    }
}

class ShuffledPlaylistIterator implements PlaylistIterator {
    private Playlist playlist;
    private int index;
    private ArrayList<String> shuffledSongs;

    public ShuffledPlaylistIterator(Playlist playlist) {
        this.playlist = playlist;
        this.shuffledSongs = new ArrayList<>(playlist.getSongs());
        Collections.shuffle(shuffledSongs); // Shuffle the songs randomly
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < shuffledSongs.size();
    }

    @Override
    public String next() {
        return shuffledSongs.get(index++);
    }
}

class Playlist {
    private ArrayList<String> songs;

    public Playlist() {
        songs = new ArrayList<>();
    }

    public void addSong(String song) {
        songs.add(song);
    }

    public PlaylistIterator iterator(String type) {
        switch (type) {
            case "simple":
                return new SimplePlaylistIterator(this);
            case "shuffled":
                return new ShuffledPlaylistIterator(this);
            default:
                return null;
        }
    }

    public ArrayList<String> getSongs() {
        return songs;
    }
}

public class IteratorDesignPattern {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.addSong("Song 1");
        playlist.addSong("Song 2 Fav");
        playlist.addSong("Song 3");
        playlist.addSong("Song 4 Fav");
        playlist.addSong("Song 5");

        // Simple Playlist Iterator
        System.out.println("Simple Playlist:");
        PlaylistIterator simpleIterator = playlist.iterator("simple");
        while (simpleIterator.hasNext()) {
            System.out.println("Playing: " + simpleIterator.next());
        }
    }
}