package com.example.mycalabash;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestDialog extends BaseDialogFragment {

    private static final int EMOTION_COLUMN_COUNT = 3;

    @Bind(R.id.recyclerView)
    protected RecyclerView recyclerView;

    public TestDialog() {
        // empty constructor is required
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);

        View view = inflater.inflate(R.layout.dialog_multi, container);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            view.setSystemUiVisibility(MainActivity.IMMERSIVE_MODE);
        }

        ButterKnife.bind(this, view);

        recyclerView.addItemDecoration(new SpacesItemDecoration(8));
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), EMOTION_COLUMN_COUNT));
        recyclerView.setAdapter(new TestAdapter());
        setCancelable(false);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        dismissDialog();
                    }
                })
        );

        return view;
    }

    @OnClick({R.id.dismiss})
    protected void dismissDialog() {
        dismiss();
    }
}
