package Album;

import Album.Track.Track;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

/**
 * Created by Trevor on 11/20/2014.
 */
public class DAO {

    public static ObservableList<Album> getAlbum() throws SQLException {

        ObservableList<Album> data = FXCollections.observableArrayList();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ResultSet totalTrackTime = null;

        String url = "jdbc:mysql://127.0.0.1:3306/cs3230";
        String user = "album_list";
        String password = "secure_pass";

        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();

            resultSet = statement.executeQuery("SELECT id, name, artist, genre, year, (select SEC_TO_TIME(SUM(TIME_TO_SEC(duration))) FROM tracks WHERE album_id = album.id) as duration FROM albums as album;");
            while (resultSet.next()) {
                Album album = new Album(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("artist"),
                        resultSet.getString("genre"),
                        resultSet.getInt("year"),
                        resultSet.getString("duration"));
                data.add(album);
            }

            return data;
        } finally {
            try {
                if(null != totalTrackTime) {
                    totalTrackTime.close();
                }
                if(null != resultSet) {
                    resultSet.close();
                }
                if(null != statement) {
                    statement.close();
                }
                if(null != connection) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addAlbum(Album album) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String url = "jdbc:mysql://127.0.0.1:3306/cs3230";
        String user = "album_list";
        String password = "secure_pass";

        String insertStatement = "INSERT " +
                "INTO albums (id, name, artist, genre, year) " +
                "VALUES (?,?,?,?,?,?);";

        try {
            connection = DriverManager.getConnection(url, user, password);
            preparedStatement = connection.prepareStatement(insertStatement);
            preparedStatement.setInt(1, album.getAlbumID());
            preparedStatement.setString(2, album.getAlbumName());
            preparedStatement.setString(3, album.getAlbumArtist());
            preparedStatement.setString(4, album.getAlbumGenere());
            preparedStatement.setInt(5, album.getAlbumYear());

            preparedStatement.execute();

        } finally {
            try {
                if(null != preparedStatement) {
                    preparedStatement.close();
                }
                if(null != connection) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteAlbum(Album album) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String url = "jdbc:mysql://127.0.0.1:3306/cs3230";
        String user = "album_list";
        String password = "secure_pass";

        String insertStatement = "DELETE " +
                "FROM albums WHERE id = ?;";

        try {
            connection = DriverManager.getConnection(url, user, password);
            preparedStatement = connection.prepareStatement(insertStatement);
            preparedStatement.setInt(1, album.getAlbumID());

            preparedStatement.execute();

        } finally {
            try {
                if (null != preparedStatement) {
                    preparedStatement.close();
                }
                if (null != connection) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static ObservableList<Track> getTrack(Album album) throws SQLException {

        ObservableList<Track> data = FXCollections.observableArrayList();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ResultSet totalTrackTime = null;
        PreparedStatement preparedStatement = null;

        String url = "jdbc:mysql://127.0.0.1:3306/cs3230";
        String user = "album_list";
        String password = "secure_pass";

        try {
            connection = DriverManager.getConnection(url, user, password);
            preparedStatement = connection.prepareStatement("SELECT * FROM tracks WHERE album_id = ?");
            preparedStatement.setInt(1, album.getAlbumID());

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Track track = new Track(
                        resultSet.getInt("id"),
                        resultSet.getInt("album_id"),
                        resultSet.getInt("track_number "),
                        resultSet.getString("name "),
                        resultSet.getTime("duration"));
                data.add(track);
            }

            return data;
        } finally {
            try {
                if(null != totalTrackTime) {
                    totalTrackTime.close();
                }
                if(null != resultSet) {
                    resultSet.close();
                }
                if(null != statement) {
                    statement.close();
                }
                if(null != connection) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addTrack(Track track) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String url = "jdbc:mysql://127.0.0.1:3306/cs3230";
        String user = "album_list";
        String password = "secure_pass";

        String insertStatement = "INSERT " +
                "INTO tracks (id, album_id , track_number , name , duration) " +
                "VALUES (?,?,?,?,?,?);";

        try {
            connection = DriverManager.getConnection(url, user, password);
            preparedStatement = connection.prepareStatement(insertStatement);
            preparedStatement.setInt(1, track.getTrackID());
            preparedStatement.setInt(2, track.getAlbumID());
            preparedStatement.setInt(3, track.getTrackNubmer());
            preparedStatement.setString(4, track.getTrackName());
            preparedStatement.setTime(5, track.getTrackTime());

            preparedStatement.execute();

        } finally {
            try {
                if(null != preparedStatement) {
                    preparedStatement.close();
                }
                if(null != connection) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteTrack(Track track) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String url = "jdbc:mysql://127.0.0.1:3306/cs3230";
        String user = "album_list";
        String password = "secure_pass";

        String insertStatement = "DELETE " +
                "FROM tracks WHERE id = ?;";

        try {
            connection = DriverManager.getConnection(url, user, password);
            preparedStatement = connection.prepareStatement(insertStatement);
            preparedStatement.setInt(1, track.getTrackID());

            preparedStatement.execute();

        } finally {
            try {
                if (null != preparedStatement) {
                    preparedStatement.close();
                }
                if (null != connection) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
