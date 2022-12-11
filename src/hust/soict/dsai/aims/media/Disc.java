package hust.soict.dsai.aims.media;

public class Disc extends Media {
    private static int nbDisc = 0;
    private int id;
    private int length;
    private String director;

    public Disc(String title, String category, float cost, int length, String director) {
        super(title, category, cost);
        this.length = length;
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - "
                + this.getLength() + " : " + this.getCost() + "$";
    }

    @Override
    public void play() {
        // TODO Auto-generated method stub
    }
}
