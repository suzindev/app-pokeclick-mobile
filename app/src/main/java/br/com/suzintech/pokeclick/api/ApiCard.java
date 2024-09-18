package br.com.suzintech.pokeclick.api;

import br.com.suzintech.pokeclick.api.endpoint.PokemonCardEndpoint;
import br.com.suzintech.pokeclick.api.response.ResponseData;
import retrofit2.Callback;

public class ApiCard {

    public static void getCards(int countCards, Callback<ResponseData> callback) {
        ApiClient.getClient()
                .create(PokemonCardEndpoint.class)
                .getCards(countCards)
                .enqueue(callback);
    }
}
