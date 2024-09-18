package br.com.suzintech.pokeclick;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class PokemonDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);

        ImageView imageView = findViewById(R.id.detail_image);
        Button buttonMoreInfo = findViewById(R.id.detail_button);

        String imageUrl = getIntent().getStringExtra("imageUrl");
        String name = getIntent().getStringExtra("name");
        String hp = getIntent().getStringExtra("hp");
        int nationalPokedexNumber = getIntent().getIntExtra("nationalPokedexNumber", 0);

        Picasso.get().load(imageUrl).into(imageView);

        buttonMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(PokemonDetailActivity.this);
                builder.setTitle(name);
                builder.setMessage("Esse pokémon possui " + hp + " de HP e seu número da pokédex é " + nationalPokedexNumber);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.create().show();
            }
        });
    }
}
