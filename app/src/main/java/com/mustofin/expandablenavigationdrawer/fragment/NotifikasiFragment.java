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

public class NotifikasiFragment extends Fragment {

    //this is the JSON Data URL
    //make sure you are using the correct ip else it will not work
    private static final String URL_PRODUCTS = "http://ihtravel.com.kh/apps/partner.php?cat_id=1";

    //a list to store all the products
    List<SpaceCraft> spaceList2;

    //Recycler view
    private RecyclerView recyclerView2;

    public static NotifikasiFragment newInstance()
    {
        NotifikasiFragment notifikasiFragment = new NotifikasiFragment();

        return new NotifikasiFragment();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.notifikasi_fragment,null);


        //REFERENCE
        recyclerView2= (RecyclerView) rootView.findViewById(R.id.notifikasi_rv);

        //LAYOUT MANAGER
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));

        //ADAPTER
        recyclerView2.setAdapter(new MyAdapter(getActivity(),spaceList2));
        spaceList2 = new  ArrayList<SpaceCraft>();
        //this method will fetch and parse json
        //to display it in recyclerview
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
                                spaceList2.add(new SpaceCraft(
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
                            MyAdapter adapter = new MyAdapter(getActivity(), spaceList2);
                            recyclerView2.setAdapter(adapter);
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