package mx.mobilestudio.buscadornoticias;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import mx.mobilestudio.buscadornoticias.dto.GoogleNewsServiceResponse;
import mx.mobilestudio.buscadornoticias.fragment.NewsFragment;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private SearchView searchView;
    public static final String  API_NEWS_URL="https://ajax.googleapis.com/ajax/services/search/news";
    private GoogleNewsServiceResponse googleNewsServiceResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView = (SearchView) findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {


        if (query!=null && !query.equals("")){
            executeGoogleNewsApiRequest(query);
        }else{
            Toast.makeText(this,"Debes de introducir una busqueda",Toast.LENGTH_LONG).show();
        }



        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }


    public void executeGoogleNewsApiRequest(String query){

        String finalURL = Uri.parse(API_NEWS_URL).buildUpon()
                          .appendQueryParameter("v", "1.0")
                          .appendQueryParameter("rsz", "8")
                          .appendQueryParameter("q",query).build().toString();



        StringRequest stringRequest =new StringRequest(Request.Method.GET, finalURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(MainActivity.this,response ,Toast.LENGTH_LONG).show();

                Gson gson = new Gson();

                googleNewsServiceResponse = gson.fromJson(response,GoogleNewsServiceResponse.class);


                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                NewsFragment newsFragment = NewsFragment.newInstance("","");

                newsFragment.setGoogleNewsServiceResponse(googleNewsServiceResponse);



                fragmentTransaction.replace(R.id.framentContainer, newsFragment);

                fragmentTransaction.commit();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        Volley.newRequestQueue(this).add(stringRequest);

    }




}
