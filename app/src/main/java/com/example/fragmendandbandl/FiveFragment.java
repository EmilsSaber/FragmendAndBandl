package com.example.fragmendandbandl;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmendandbandl.databinding.FragmentFiveBinding;
import com.example.fragmendandbandl.databinding.FragmentFourBinding;


public class FiveFragment extends Fragment {

    private FragmentFiveBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentFiveBinding.inflate(LayoutInflater.from(requireActivity()),container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getData();

    }
    private void getData() {
        Bundle bundle = getArguments();
        String string = bundle.getString("user4");
        binding.text.setText(string);
    }
}