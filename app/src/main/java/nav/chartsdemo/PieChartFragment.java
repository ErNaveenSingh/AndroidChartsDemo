package nav.chartsdemo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.List;


public class PieChartFragment extends Fragment {

    public PieChartFragment() {
        // Required empty public constructor
    }

    public static PieChartFragment newInstance() {
        PieChartFragment fragment = new PieChartFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pie_chart, container, false);
        PieChart chart = (PieChart) v.findViewById(R.id.chart);
        chart.setCenterText("");
        chart.setRotationEnabled(true);
        chart.setHighlightPerTapEnabled(true);
        chart.setDescription("");
        Legend l = chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);

        chart.setData(DataSource.generatePieData());
        return v;
    }
}
