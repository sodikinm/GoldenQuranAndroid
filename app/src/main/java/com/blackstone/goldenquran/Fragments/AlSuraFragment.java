package com.blackstone.goldenquran.Fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blackstone.goldenquran.R;
import com.blackstone.goldenquran.adapters.AlsuraAdapter;
import com.blackstone.goldenquran.database.DataBaseManager;
import com.blackstone.goldenquran.models.AljuzaModel;
import com.blackstone.goldenquran.models.AlsuraModel;
import com.blackstone.goldenquran.ui.DrawerCloser;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AlSuraFragment extends Fragment {


    @BindView(R.id.alSuraRecyclerView)
    RecyclerView alSuraRecyclerView;

    public AlSuraFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().invalidateOptionsMenu();
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_al_sura, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((DrawerCloser) getActivity()).moveToolbarDown();

        alSuraRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        String[] ajzaNames = getResources().getStringArray(R.array.ajzaNames);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new AljuzaModel(ajzaNames[0]));
        arrayList.add(new AlsuraModel("9", "7", getString(R.string.suraName)));
        arrayList.add(new AlsuraModel("6", "7", getString(R.string.suraName)));
        arrayList.add(new AljuzaModel(ajzaNames[1]));
        arrayList.add(new AljuzaModel(ajzaNames[2]));
        arrayList.add(new AlsuraModel("8", "7", getString(R.string.suraName)));
        arrayList.add(new AljuzaModel(ajzaNames[3]));
        arrayList.add(new AlsuraModel("93", "7", getString(R.string.suraName)));
        arrayList.add(new AljuzaModel(ajzaNames[4]));
        arrayList.add(new AlsuraModel("87", "7", getString(R.string.suraName)));
        arrayList.add(new AlsuraModel("90", "7", getString(R.string.suraName)));
        arrayList.add(new AljuzaModel(ajzaNames[5]));
        arrayList.add(new AlsuraModel("11", "7", getString(R.string.suraName)));
        arrayList.add(new AlsuraModel("12", "7", getString(R.string.suraName)));
        arrayList.add(new AlsuraModel("1", "7", getString(R.string.suraName)));
        arrayList.add(new AljuzaModel(ajzaNames[6]));
        arrayList.add(new AlsuraModel("1", "7", getString(R.string.suraName)));
        arrayList.add(new AlsuraModel("1", "7", getString(R.string.suraName)));
        arrayList.add(new AlsuraModel("1", "7", getString(R.string.suraName)));
        arrayList.add(new AlsuraModel("1", "7", getString(R.string.suraName)));
        arrayList.add(new AlsuraModel("1", "7", getString(R.string.suraName)));
        arrayList.add(new AlsuraModel("1", "7", getString(R.string.suraName)));
        arrayList.add(new AlsuraModel("1", "7", getString(R.string.suraName)));
        arrayList.add(new AlsuraModel("1", "7", getString(R.string.suraName)));
        arrayList.add(new AlsuraModel("1", "7", getString(R.string.suraName)));
        arrayList.add(new AlsuraModel("1", "7", getString(R.string.suraName)));


        alSuraRecyclerView.setAdapter(new AlsuraAdapter(getActivity(), arrayList));
    }

    class getFahrasData extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            DataBaseManager dataBaseManager = new DataBaseManager(getActivity(), "fahras.db", true).createDatabase();
            dataBaseManager.getFahrasData();
            return null;
        }
    }
}
