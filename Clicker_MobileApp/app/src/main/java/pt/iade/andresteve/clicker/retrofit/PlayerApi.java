package pt.iade.andresteve.clicker.retrofit;

import java.util.List;

import pt.iade.andresteve.clicker.models.Player;
import pt.iade.andresteve.clicker.models.Response;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PlayerApi {
    @GET("/api/players")
        Call<List<Player>> getPlayers();

    @GET("/api/players/{id}")
    Call<Player>getPlayerbyId(@Path("id") int playerId);

    @POST("/api/players")
    Call<Player>addPLayer(@Body Player addplayer);

    @DELETE("/api/players/{id}")
    Call<Response>deletePlayer(@Path("id") int playerId);
}
