package com.example.android.navigationcomponentwithbottomnavigation;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.parceler.Parcels;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class InformasiFragment extends Fragment {

    private NavController navController;

    private ArrayList<InformasiKakao> listKakao = new ArrayList<>();

    public InformasiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_informasi, container, false);

        navController = NavHostFragment.findNavController(this);

        listKakao.add(
                new InformasiKakao(
                        getString(R.string.info_cocoa_healthy_title),
                        R.mipmap.kakao_normal,
                        getString(R.string.info_cocoa_healthy_content)
                )
        );
        listKakao.add(
                new InformasiKakao(
                        getString(R.string.info_cocoa_ill_title),
                        R.mipmap.kakao_normal,
                        getString(R.string.info_cocoa_ill_content)
                )
        );
        listKakao.add(
                new InformasiKakao(
                        getString(R.string.info_cocoa_pest_title),
                        R.mipmap.kakao_normal,
                        getString(R.string.info_cocoa_pest_content)
                )
        );

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);

        KakaoAdapter adapter = new KakaoAdapter(
                listKakao,
                new KakaoAdapter.itemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        if (navController!= null) {
                            navController.navigate(
                                    InformasiFragmentDirections.actionInformasiFragmentToDetailFragment(
                                            (InformasiKakao) Parcels.wrap(listKakao.get(position))
                                    )
                            );
                        }
                    }
                }
        );
        recyclerView.setAdapter(adapter);

        DividerItemDecoration divider = new DividerItemDecoration(
                recyclerView.getContext(), DividerItemDecoration.VERTICAL
        );
        recyclerView.addItemDecoration(divider);

        return view;
    }

}
