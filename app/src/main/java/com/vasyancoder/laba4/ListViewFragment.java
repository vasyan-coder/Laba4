package com.vasyancoder.laba4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.vasyancoder.laba4.databinding.FragmentListViewBinding;

import java.util.ArrayList;
import java.util.List;

public class ListViewFragment extends Fragment {

    private FragmentListViewBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentListViewBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        HackathonListAdapter adapter = new HackathonListAdapter(requireContext(), R.layout.item_hackathon_list, initList());
        binding.hackathonList.setAdapter(adapter);
    }

    private List<HackathonListItem> initList() {
        List<HackathonListItem> list = new ArrayList<>();
        for (int i = 1; i <= 200; i++) {
            list.add(
                    new HackathonListItem(
                            R.drawable.ic_launcher_background,
                            getString(R.string.user_list_hackathon_title, String.valueOf(i)),
                            "Desc")
            );
        }
        return list;
    }
}
