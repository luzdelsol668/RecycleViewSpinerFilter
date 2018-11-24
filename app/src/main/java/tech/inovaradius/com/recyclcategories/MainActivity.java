package tech.inovaradius.com.recyclcategories;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    AppCompatSpinner mySpinner;
    RecyclerView recyclerView;

    private static final String PREFS_SPINNER = "PREFS_SPINNER";
    CategoriesAdapter shopArrayAdapter;
SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySpinner = findViewById(R.id.myspinner);
        recyclerView = findViewById(R.id.recycleview);
        sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
        String[] planets = {"All", "T-Shirt", "Jeans", "Coumputer", "Phone"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, planets);
        mySpinner.setAdapter(spinnerAdapter);
        mySpinner.setOnItemSelectedListener(this);
        loadSpinnerPosition();


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        shopArrayAdapter = new CategoriesAdapter(getShop(), this);
      //  recyclerView.setAdapter(shopArrayAdapter);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String selectedText = adapterView.getItemAtPosition(i).toString();
        saveSpinnerPosition(i);
        getSelectedCategoryData(selectedText);

      //  Toast.makeText(this, selectedText, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private ArrayList<Shop> getShop() {
        ArrayList<Shop> shops = new ArrayList<>();
        shops.clear();

        shops.add(new Shop("Mercury", 1, "T-Shirt"));
        shops.add(new Shop("UY Scuti", 1, "T-Shirt"));
        shops.add(new Shop("Andromeda", 3, "Jeans"));
        shops.add(new Shop("VV Cephei A", 2, "Coumputer"));
        shops.add(new Shop("IC 1011", 3, "Jeans"));
        shops.add(new Shop("Sun", 2, "Coumputer"));
        shops.add(new Shop("Aldebaran", 2, "T-Shirt"));
        shops.add(new Shop("Venus", 1, "T-Shirt"));
        shops.add(new Shop("Malin 1", 3, "Jeans"));
        shops.add(new Shop("Rigel", 2, "Jeans"));
        shops.add(new Shop("Earth", 1, "T-Shirt"));
        shops.add(new Shop("Whirlpool", 3, "Jeans"));
        shops.add(new Shop("VY Canis Majoris", 2, "Jeans"));
        shops.add(new Shop("Saturn", 1, "Coumputer"));
        shops.add(new Shop("Sombrero", 3, "Jeans"));
        shops.add(new Shop("Betelgeuse", 2, "Coumputer"));
        shops.add(new Shop("Uranus", 1, "Coumputer"));
        shops.add(new Shop("Virgo Stellar Stream", 3, "Jeans"));
        shops.add(new Shop("Epsillon Canis Majoris", 2, "Jeans"));
        shops.add(new Shop("Jupiter", 1, "Jeans"));
        shops.add(new Shop("VY Canis Majos", 2, "T-Shirt"));
        shops.add(new Shop("Triangulum", 3, "Phone"));
        shops.add(new Shop("Cartwheel", 3, "Phone"));
        shops.add(new Shop("Antares", 2, "T-Shirt"));
        shops.add(new Shop("Mayall's Object", 3, "Phone"));
        shops.add(new Shop("Proxima Centauri", 2, "T-Shirt"));

        return shops;
    }

    private void getSelectedCategoryData(String newText) {

        String userInput = newText.toLowerCase();
        List<Shop> newList = new ArrayList<>();

        if (userInput.contains("all")) {
            shopArrayAdapter = new CategoriesAdapter(getShop(), MainActivity.this);

        } else {

            for (Shop mPredication : getShop())

            {
                String ded = mPredication.getCatego().toLowerCase();
                if (ded.contains(userInput)) {
                    newList.add(mPredication);
                }
            }

            shopArrayAdapter = new CategoriesAdapter(newList, MainActivity.this);
        }

        recyclerView.setAdapter(shopArrayAdapter);
        shopArrayAdapter.notifyDataSetChanged();
        recyclerView.setHasFixedSize(true);

        //shopArrayAdapter.updateList(newList);
    }

    public void saveSpinnerPosition(int position){

        sharedPreferences.edit()
                .putInt(PREFS_SPINNER,position)
                .apply();
    }

    public void loadSpinnerPosition(){

        if (sharedPreferences.contains(PREFS_SPINNER)){

            int position= sharedPreferences.getInt(PREFS_SPINNER,0);
            mySpinner.setSelection(position);
        }

    }
}

