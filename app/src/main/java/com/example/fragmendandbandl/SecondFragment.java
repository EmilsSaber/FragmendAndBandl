package com.example.fragmendandbandl;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmendandbandl.databinding.FragmentFerstBinding;
import com.example.fragmendandbandl.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(LayoutInflater.from(requireActivity()),container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getData();
        sendData();
    }

        private void getData () {
            Bundle bundle = getArguments();
            String string = bundle.getString("userName");
            binding.text.setText(string);
        }

    private void sendData(){
    binding.click.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           Bundle bundle = new Bundle();
           String string = binding.text.getText().toString();
           bundle.putString("user",string);
           TherdsFragment therdsFragment = new TherdsFragment();
           therdsFragment.setArguments(bundle);
           getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,therdsFragment).commit();
       }
   });

    }
}