/**
 * Represents a single node in the Doubly Linked List.
 * Stores song details and pointers to both previous and next nodes.
 */
public class SongNode {
    int id;
    String title;
    String artist;
    String genre;
    boolean isFavorite;

    SongNode prev;
    SongNode next;

    public SongNode(int id, String title, String artist, String genre) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.isFavorite = false;
        this.prev = null;
        this.next = null;
    }

    @Override
    public String toString() {
        String favTag = isFavorite ? " ★ [Fav]" : "";
        return String.format("ID: %-4d | Title: %-20s | Artist: %-15s | Genre: %-10s%s", 
                id, title, artist, genre, favTag);
    }
}