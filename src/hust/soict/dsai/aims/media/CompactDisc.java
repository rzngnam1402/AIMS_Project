package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private static int nbCompactDisc = 0;
    private int id;
    private String director;
    private int length;
    private String artist;
    private List<Track> tracks;

    public CompactDisc(String title, String category, String director, int length, float cost, String artist) {
        super(title, category, cost, length, director);
        nbCompactDisc++;
        this.id = nbCompactDisc;
        this.artist = artist;
        tracks = new ArrayList<Track>();
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track trackName) {
        if (this.tracks.contains(trackName)) {
            System.out.println("This track already existed");
        } else {
            System.out.println(trackName + " added");
            this.tracks.add(trackName);
        }
    }

    public void removeTrack(Track trackName) {
        if (this.tracks.contains(trackName)) {
            System.out.println(trackName + " removed");
            this.tracks.remove(trackName);
        } else {
            System.out.println("The author does not exist");
        }
    }

    public int getLength() {
        int length = 0;
        for (Track track : tracks) {
            length += track.getLength();
        }
        return length;
    }

    @Override
    public void play() {
        System.out.println("Artist: " + this.artist);
        for (Track track : tracks) {
            track.play();
        }
    }
}
