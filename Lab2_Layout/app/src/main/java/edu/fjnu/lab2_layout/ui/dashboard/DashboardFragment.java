package edu.fjnu.lab2_layout.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import edu.fjnu.lab2_layout.R;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_constraintlayout, container, false);

        /*TODO:使用反射获取textView并赋值
        for(int i=1;i<=4;i++){
            for(int j=1;j<=4;j++){
                String name = "text"+i+"_"+j;
                int id = getResources().getIdentifier(name,"id",null);
                final TextView textView = root.findViewById(id);
                textView.setText(i+","+j);
            }
        }*/
        return root;
    }
}