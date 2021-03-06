package Album.Track;

import java.sql.Time;

/**
 * Created by Nathan on 11/20/2014.
 */
public class Track {
    private int trackID;
    private int albumID;
    private String trackName;
    private Time trackTime;
    private int trackNubmer;

    public Track(int ID, int AlbumID, int TrackNumber, String TrackName, Time TrackTime){
        this.trackID = ID;
        this.albumID = AlbumID;
        this.trackName = TrackName;
        this.trackTime = TrackTime;
        this.trackNubmer = TrackNumber;
    }

    public int getTrackNubmer() {
        return trackNubmer;
    }

    public void setTrackNubmer(int trackNubmer) {
        this.trackNubmer = trackNubmer;
    }

    public int getTrackID() {
        return trackID;
    }

    public void setTrackID(int intID) {
        this.trackID = intID;
    }

    public int getAlbumID() {
        return albumID;
    }

    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public Time getTrackTime() {
        return trackTime;
    }

    public void setTrackTime(Time trackTime) {
        this.trackTime = trackTime;
    }
}
