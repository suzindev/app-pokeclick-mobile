package br.com.suzintech.pokeclick.api.endpoint;

import br.com.suzintech.pokeclick.api.response.ResponseData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokemonCardEndpoint {

    @GET("v1/cards")
    Call<ResponseData> getCards(@Query("count") int count);
}
