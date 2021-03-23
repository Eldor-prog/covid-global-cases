package uz.eldor.trackcovid2.ui.country;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import uz.eldor.trackcovid2.R;

public class CountryFragment extends Fragment {

    RecyclerView rvCovidCountry;
    ProgressBar progressBar;

    ArrayList<CovidCountry> covidCountries;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_country, container, false);

        //call view
        rvCovidCountry = root.findViewById(R.id.rvCovidCountry);
        progressBar = root.findViewById(R.id.progress_circular_country);
        rvCovidCountry.setLayoutManager(new LinearLayoutManager(getActivity()));

        //cal volley method
        getDataFromServer();

        return root;
    }

    private void showRecyclerView() {
        CovidCountryAdapter covidCountryAdapter = new CovidCountryAdapter(covidCountries);
        rvCovidCountry.setAdapter(covidCountryAdapter);
    }

    private void getDataFromServer() {
        String url = "https://corona.lmao.ninja/v3/covid-19/countries";
        covidCountries = new ArrayList<>();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressBar.setVisibility(View.GONE);
                        if (response != null) {
                            try {
                                JSONArray jsonArray = new JSONArray(response);

                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject data = jsonArray.getJSONObject(i);
                                    covidCountries.add(new CovidCountry(data.getString("country"), data.getInt("cases")));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        showRecyclerView();
                    }
                },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error){
                progressBar.setVisibility(View.GONE);
                Log.d("TTT", error.toString());
            }
       });
        Volley.newRequestQueue(getActivity()).add(stringRequest);
    }

}