package com.example.pokedex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class Pokedex extends AppCompatActivity {

    TextView title,name,type,ability,genderratio,catchrate,hp,atk,deff,spatk,spdeff,spd,rate;
    ImageView image;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);
        title = findViewById(R.id.title);

        name = findViewById(R.id.name);
        type = findViewById(R.id.type);
        ability = findViewById(R.id.ability);
        genderratio = findViewById(R.id.genderratio);
        catchrate = findViewById(R.id.catchrate);
        image = findViewById(R.id.image);

        rate = findViewById(R.id.rate);
        hp = findViewById(R.id.hp);
        atk = findViewById(R.id.atk);
        deff = findViewById(R.id.deff);
        spdeff = findViewById(R.id.spdeff);
        spatk = findViewById(R.id.spatk);
        spd = findViewById(R.id.spd);

        Bundle bundle = getIntent().getExtras();
        final String pokemonx = bundle.getString("nama_pokemon");

        Toast.makeText(Pokedex.this, pokemonx,Toast.LENGTH_SHORT).show();

        reference = FirebaseDatabase.getInstance().getReference().child("Pokemon").child(pokemonx);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                hp.setText(dataSnapshot.child("hp").getValue().toString());
                atk.setText(dataSnapshot.child("atk").getValue().toString());
                deff.setText(dataSnapshot.child("def").getValue().toString());
                spdeff.setText(dataSnapshot.child("sp_def").getValue().toString());
                spatk.setText(dataSnapshot.child("sp_atk").getValue().toString());
                spd.setText(dataSnapshot.child("speed").getValue().toString());
                rate.setText(dataSnapshot.child("leveling_rate").getValue().toString());

                name.setText(dataSnapshot.child("name").getValue().toString());
                title.setText(dataSnapshot.child("title").getValue().toString());
                type.setText(dataSnapshot.child("type").getValue().toString());
                ability.setText(dataSnapshot.child("ability").getValue().toString());
                genderratio.setText(dataSnapshot.child("gender_ratio").getValue().toString());
                catchrate.setText(dataSnapshot.child("catch_rate").getValue().toString());
                Picasso.with(Pokedex.this)
                        .load(dataSnapshot.child("photo")
                                .getValue().toString()).centerCrop().fit()
                        .into(image);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
