package com.example.helloworld.Slot9;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.helloworld.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ProductAdapter adapter;
    private List<Product> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);
        listView = findViewById(R.id.slot9_product_lv);
        list = new ArrayList<>();
        adapter = new ProductAdapter(this, list);
        listView.setAdapter(adapter);
        new FetchProduct().execute();
    }

    private class FetchProduct extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            StringBuilder response = new StringBuilder();
            try {
                URL url = new URL("https://hungnttg.github.io/shopgiay.json");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
            } catch (MalformedURLException e) {
                throw new RuntimeException();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return response.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            if (s != null && !s.isEmpty()) {
                try {
                    JSONObject json = new JSONObject(s);
                    JSONArray productsArray = json.getJSONArray("products");
                    for (int i = 0; i < productsArray.length(); i++) {
                        JSONObject pObject = productsArray.getJSONObject(i);
                        String styleId = pObject.getString("styleid");
                        String brand = pObject.getString("brands_filter_facet");
                        String price = pObject.getString("price");
                        String info = pObject.getString("product_additional_info");
                        String searchImage = pObject.getString("search_image");
                        Product product = new Product(styleId, brand, price, info, searchImage);
                        list.add(product);
                    }
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}