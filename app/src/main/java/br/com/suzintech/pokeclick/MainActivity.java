package br.com.suzintech.pokeclick;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import br.com.suzintech.pokeclick.api.ApiCard;
import br.com.suzintech.pokeclick.api.response.Card;
import br.com.suzintech.pokeclick.api.response.ResponseData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    private List<Card> cardList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.main_lista);

        ApiCard.getCards(20, new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                if (response.isSuccessful() && response.body() != null) {
                    cardList = response.body().getCards();

                    List<String> pokemonNames = new ArrayList<>();

                    for (Card c : cardList) {
                        pokemonNames.add(c.getName());
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(
                            MainActivity.this,
                            android.R.layout.simple_list_item_1,
                            pokemonNames
                    );

                    listView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Card c = cardList.get(i);
                Intent intent = new Intent(MainActivity.this, PokemonDetailActivity.class);
                intent.putExtra("imageUrl", c.getImageUrl());
                intent.putExtra("name", c.getName());
                intent.putExtra("hp", c.getHp());
                intent.putExtra("nationalPokedexNumber", c.getNationalPokedexNumber());

                startActivity(intent);
            }
        });
    }
}