package com.example.Jack7_1P;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.Jack7_1P.database.Database;
import com.example.Jack7_1P.model.Items;

import java.util.ArrayList;

public class AdvertShow extends Fragment implements AdvertHelper.ItemClickListener {

    ArrayList<Items> advertsList = new ArrayList<>();

    public AdvertShow() {
    }

    public static AdvertShow newInstance() {
        AdvertShow fragment = new AdvertShow();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.show_all_advert, container, false);

        Database db = new Database(getContext());
        advertsList = db.fetchAllAdverts();

        RecyclerView RecyclerViewAdverts = view.findViewById(R.id.RecyclerViewAdverts);
        LinearLayoutManager VerticalManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        RecyclerViewAdverts.setLayoutManager(VerticalManager);
        AdvertHelper AdvertAdapter = new AdvertHelper(getContext(), advertsList, this);
        RecyclerViewAdverts.setAdapter(AdvertAdapter);

        return view;
    }

    @Override
    public void onItemClick(Items items) {
        Fragment fragment = AdvertFrag.newInstance(items);
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.hide(getActivity().getSupportFragmentManager().findFragmentByTag("AdvertShow"));
        transaction.add(R.id.FragmentContainer, fragment, "AdvertFrag");
        transaction.addToBackStack(null);
        transaction.commit();
    }
}