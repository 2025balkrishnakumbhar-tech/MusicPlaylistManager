import java.util.Scanner;

/**
 * Main application class providing a interactive console menu loop.
 */
public class PlaylistManagerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlaylistLinkedList playlist = new PlaylistLinkedList();

        // Pre-populating sample data for demonstration
        playlist.addSong(101, "Blinding Lights", "The Weeknd", "Pop");
        playlist.addSong(102, "Believer", "Imagine Dragons", "Rock");
        playlist.addSong(103, "Starboy", "The Weeknd", "Pop");

        while (true) {
            System.out.println("\n========================================");
            System.out.println("       MUSIC PLAYLIST MANAGER");
            System.out.println("========================================");
            System.out.println("1. Add Song");
            System.out.println("2. Delete Song");
            System.out.println("3. Search Song");
            System.out.println("4. Display Playlist");
            System.out.println("5. Play Next Song");
            System.out.println("6. Play Previous Song");
            System.out.println("7. Toggle Favorite");
            System.out.println("8. Display Favorites");
            System.out.println("9. Recently Played");
            System.out.println("10. Exit");
            System.out.print("Enter your choice (1-10): ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input! Please enter a valid menu number.");
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter Song ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter Artist: ");
                        String artist = scanner.nextLine();
                        System.out.print("Enter Genre: ");
                        String genre = scanner.nextLine();
                        playlist.addSong(id, title, artist, genre);
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Invalid ID format! Numeric value required.");
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Enter Song ID to delete: ");
                        int delId = Integer.parseInt(scanner.nextLine());
                        playlist.deleteSong(delId);
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Invalid ID format!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Song Title or Artist to search: ");
                    String query = scanner.nextLine();
                    playlist.searchSong(query);
                    break;

                case 4:
                    playlist.displayPlaylist();
                    break;

                case 5:
                    playlist.playNext();
                    break;

                case 6:
                    playlist.playPrev();
                    break;

                case 7:
                    try {
                        System.out.print("Enter Song ID to toggle Favorite: ");
                        int favId = Integer.parseInt(scanner.nextLine());
                        playlist.toggleFavorite(favId);
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Invalid ID format!");
                    }
                    break;

                case 8:
                    playlist.displayFavorites();
                    break;

                case 9:
                    playlist.displayRecentlyPlayed();
                    break;

                case 10:
                    System.out.println("👋 Exiting Music Playlist Manager. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("❌ Invalid choice! Please select between 1 and 10.");
            }
        }
    }
}