package com.astzz.statussaver;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class videoFragment extends Fragment {


    public videoFragment() {
        // Required empty public constructor
    }

    private RecyclerView VideoRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_video, container, false);

        VideoRecyclerView = view.findViewById(R.id.video_rcyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        VideoRecyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }
}