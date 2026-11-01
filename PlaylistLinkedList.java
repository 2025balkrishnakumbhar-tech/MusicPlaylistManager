/**
 * Custom Doubly Linked List implementation for managing playlist nodes.
 * Explicitly manipulates head, tail, and current pointers.
 */
public class PlaylistLinkedList {
    private SongNode head;
    private SongNode tail;
    private SongNode current;

    // Supplementary feature: Simple array-based stack for Recently Played
    private SongNode[] recentlyPlayed;
    private int recentTop;
    private final int RECENT_CAPACITY = 5;

    public PlaylistLinkedList() {
        this.head = null;
        this.tail = null;
        this.current = null;
        this.recentlyPlayed = new SongNode[RECENT_CAPACITY];
        this.recentTop = -1;
    }

    // Check if ID already exists to prevent duplicates
    public boolean exists(int id) {
        SongNode temp = head;
        while (temp != null) {
            if (temp.id == id) return true;
            temp = temp.next;
        }
        return false;
    }

    // Add song to the tail of the list - O(1)
    public void addSong(int id, String title, String artist, String genre) {
        if (exists(id)) {
            System.out.println("❌ Error: A song with ID " + id + " already exists!");
            return;
        }

        SongNode newNode = new SongNode(id, title, artist, genre);
        if (head == null) {
            head = tail = current = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("✅ Song added successfully!");
    }

    // Delete song by ID - Handles head, tail, middle, and single node cases
    public void deleteSong(int id) {
        if (head == null) {
            System.out.println("❌ Playlist is empty!");
            return;
        }

        SongNode target = head;
        while (target != null && target.id != id) {
            target = target.next;
        }

        if (target == null) {
            System.out.println("❌ Error: Song with ID " + id + " not found.");
            return;
        }

        // Pointer adjustments
        if (target == head && target == tail) { // Single element case
            head = tail = current = null;
        } else if (target == head) { // Deleting head
            head = head.next;
            head.prev = null;
            if (current == target) current = head;
        } else if (target == tail) { // Deleting tail
            tail = tail.prev;
            tail.next = null;
            if (current == target) current = tail;
        } else { // Deleting middle node
            target.prev.next = target.next;
            target.next.prev = target.prev;
            if (current == target) current = target.next;
        }

        System.out.println("✅ Song '" + target.title + "' (ID: " + id + ") removed.");
    }

    // Search song by Title or Artist - O(N)
    public void searchSong(String query) {
        if (head == null) {
            System.out.println("❌ Playlist is empty!");
            return;
        }

        boolean found = false;
        SongNode temp = head;
        System.out.println("\n--- Search Results ---");
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(query) || temp.artist.equalsIgnoreCase(query)) {
                System.out.println(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("❌ No matching song found for: " + query);
        }
    }

    // Display all songs in forward traversal
    public void displayPlaylist() {
        if (head == null) {
            System.out.println("📁 Playlist is completely empty.");
            return;
        }

        System.out.println("\n=================== CURRENT PLAYLIST ===================");
        SongNode temp = head;
        while (temp != null) {
            String indicator = (temp == current) ? " 🎵 [PLAYING NOW] -> " : "                    ";
            System.out.println(indicator + temp);
            temp = temp.next;
        }
        System.out.println("========================================================");
    }

    // Play next song - O(1)
    public void playNext() {
        if (current == null) {
            System.out.println("❌ Playlist is empty!");
            return;
        }

        if (current.next != null) {
            current = current.next;
            pushRecent(current);
            System.out.println("▶ Playing Next: " + current.title + " by " + current.artist);
        } else {
            System.out.println("⚠️ Reached the end of the playlist. No next song!");
        }
    }

    // Play previous song - O(1)
    public void playPrev() {
        if (current == null) {
            System.out.println("❌ Playlist is empty!");
            return;
        }

        if (current.prev != null) {
            current = current.prev;
            pushRecent(current);
            System.out.println("◀ Playing Previous: " + current.title + " by " + current.artist);
        } else {
            System.out.println("⚠️ Reached the start of the playlist. No previous song!");
        }
    }

    // Toggle favorite flag
    public void toggleFavorite(int id) {
        SongNode temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.isFavorite = !temp.isFavorite;
                String status = temp.isFavorite ? "added to" : "removed from";
                System.out.println("⭐ '" + temp.title + "' " + status + " Favorites!");
                return;
            }
            temp = temp.next;
        }
        System.out.println("❌ Song with ID " + id + " not found.");
    }

    // Display favorite songs
    public void displayFavorites() {
        if (head == null) {
            System.out.println("❌ Playlist is empty!");
            return;
        }

        System.out.println("\n================ FAVORITE SONGS ================");
        boolean hasFav = false;
        SongNode temp = head;
        while (temp != null) {
            if (temp.isFavorite) {
                System.out.println(temp);
                hasFav = true;
            }
            temp = temp.next;
        }
        if (!hasFav) {
            System.out.println("No favorite songs added yet.");
        }
        System.out.println("=================================================");
    }

    // Internal stack operation for recently played songs
    private void pushRecent(SongNode song) {
        if (recentTop < RECENT_CAPACITY - 1) {
            recentTop++;
        } else {
            // Shift elements down when stack is full
            for (int i = 0; i < RECENT_CAPACITY - 1; i++) {
                recentlyPlayed[i] = recentlyPlayed[i + 1];
            }
        }
        recentlyPlayed[recentTop] = song;
    }

    // Display recently played stack
    public void displayRecentlyPlayed() {
        if (recentTop == -1) {
            System.out.println("🕒 No recently played history available.");
            return;
        }

        System.out.println("\n================ RECENTLY PLAYED ================");
        for (int i = recentTop; i >= 0; i--) {
            System.out.println((recentTop - i + 1) + ". " + recentlyPlayed[i].title + " - " + recentlyPlayed[i].artist);
        }
        System.out.println("=================================================");
    }
}