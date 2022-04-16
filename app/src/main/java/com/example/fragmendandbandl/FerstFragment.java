package com.example.fragmendandbandl;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmendandbandl.databinding.FragmentFerstBinding;


public class FerstFragment extends Fragment {

private FragmentFerstBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentFerstBinding.inflate(LayoutInflater.from(requireActivity()),container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
  sendData();
    }

    private void sendData() {

        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (!binding.textField.getText().toString().isEmpty()){
                   Bundle bundle = new Bundle();
                   String string = binding.textField.getText().toString();
                   bundle.putString("userName",string);
                   SecondFragment secondFragment = new SecondFragment();
                   secondFragment.setArguments(bundle);
                   getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,secondFragment).commit();
               }else {
                   binding.textField.setError("пополнте поле !");
               }
            }
        });
    }
}