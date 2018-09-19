package com.mustofin.expandablenavigationdrawer.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mustofin.expandablenavigationdrawer.MRecycelr.MyAdapter;
import com.mustofin.expandablenavigationdrawer.R;
import com.mustofin.expandablenavigationdrawer.SpaceCraft;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TemanDekatFragment extends Fragment {

    //this is the JSON Data URL
    //make sure you are using the correct ip else it will not work
    private static final String URL_PRODUCTS = "http://apps.cambodiaoutboundtours.com/partner.php";

    //a list to store all the products
    List<SpaceCraft> spaceList3;
    private RecyclerView recyclerView3;
   // private static String[] spacecrafts={"Kepler","Hubble","Rosetter","Discovery","Endeavor"};

    public static TemanDekatFragment newInstance()
    {
        return new TemanDekatFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.teman_dekat_fragment,null);


        //REFERENCE
        recyclerView3= (RecyclerView) rootView.findViewById(R.id.teman_deskat_rv);

        //LAYOUT MANAGER
        recyclerView3.setLayoutManager(new LinearLayoutManager(getActivity()));

        //ADAPTER
        recyclerView3.setAdapter(new MyAdapter(getActivity(),spaceList3));

        spaceList3 =  new ArrayList<SpaceCraft>();
        loadProducts();

        return rootView;
    }

    private void loadProducts() {
        /*
         * Creating a String Request
         * The request type is GET defined by first parameter
         * The URL is defined in the second parameter
         * Then we have a Response Listener and a Error Listener
         * In response listener we will get the JSON response as a String
         * */
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_PRODUCTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);

                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array
                                JSONObject product = array.getJSONObject(i);

                                //adding the product to product list
                                spaceList3.add(new SpaceCraft(
                                        product.getInt("id"),
                                        product.getString("name"),
                                        product.getString("address"),
                                        product.getString("tel"),
                                        product.getString("goldcard"),
                                        product.getString("standardcard"),
                                        product.getString("image")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            MyAdapter adapter = new MyAdapter(getActivity(), spaceList3);
                            recyclerView3.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our string request to queue
        Volley.newRequestQueue(getActivity()).add(stringRequest);
    }

}
