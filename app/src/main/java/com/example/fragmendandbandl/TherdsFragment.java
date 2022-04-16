package com.example.fragmendandbandl;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmendandbandl.databinding.FragmentTherdsBinding;

public class TherdsFragment extends Fragment {

    private FragmentTherdsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTherdsBinding.inflate(LayoutInflater.from(requireActivity()),container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getData();
        sendData();
    }

    private void getData() {
        Bundle bundle = getArguments();
        String string = bundle.getString("user");
        binding.text.setText(string);
    }


    private void sendData(){
        binding.click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                String string = binding.text.getText().toString();
                bundle.putString("user3",string);
                FourFragment fourFragment= new FourFragment();
                fourFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,fourFragment).commit();
            }
        });

    }
}