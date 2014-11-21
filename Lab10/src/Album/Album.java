package Album;

import Album.Track.Track;
import javafx.collections.ObservableList;

import java.sql.Time;

/**
 * Created by Nathan on 11/20/2014.
 */
public class Album {

    private int albumID;
    private String albumName;
    private String albumArtist;
    private String albumGenere;
    private int albumYear;
    private String albumTime;
    private ObservableList<Track> tracks;

    public Album(int ID, String Name, String Artist, String Genre, int Year, String Time){
        this.albumID = ID;
        this.albumName = Name;
        this.albumArtist = Artist;
        this.albumGenere = Genre;
        this.albumYear = Year;
        this.albumTime = Time;
    }

    public int getAlbumID() {
        return albumID;
    }

    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumArtist() {
        return albumArtist;
    }

    public void setAlbumArtist(String albumArtist) {
        this.albumArtist = albumArtist;
    }

    public String getAlbumGenere() {
        return albumGenere;
    }

    public void setAlbumGenere(String albumGenere) {
        this.albumGenere = albumGenere;
    }

    public int getAlbumYear() {
        return albumYear;
    }

    public void setAlbumYear(int albumYear) {
        this.albumYear = albumYear;
    }

    public int getTrackCount(){
        return tracks.size();
    }

    public Track getTrack(int i){
        return tracks.get(i);
    }

    public void addTrack(Track item){
        tracks.add(item);
    }

    public void deleteTrack(int i){
        tracks.remove(i);
    }

    public void deleteTrack(Track item){
        tracks.remove(item);
    }

    public String getAlbumTime(){
        return albumTime;
    }
}
