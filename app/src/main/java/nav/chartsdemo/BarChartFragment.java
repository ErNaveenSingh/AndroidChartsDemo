package nav.chartsdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.AxisValueFormatter;
import com.github.mikephil.charting.formatter.LargeValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;


public class BarChartFragment extends Fragment {

    BarChart chart;
    float groupSpace = 0.15f;
    float barSpace = 0.00f; // x3 dataset
    float barWidth = 0.38f; // x3 dataset

    public BarChartFragment() {
        // Required empty public constructor
    }

    public static BarChartFragment newInstance() {
        BarChartFragment fragment = new BarChartFragment();
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
        View v = inflater.inflate(R.layout.fragment_bar_chart, container, false);
        chart = (BarChart) v.findViewById(R.id.chart);


        chart.setDrawBarShadow(false);
        chart.setDrawValueAboveBar(true);

        chart.setDescription("");

        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
//        chart.setMaxVisibleValueCount(60);

        // scaling can now only be done on x- and y-axis separately
        chart.setPinchZoom(false);

        chart.setDrawGridBackground(false);
        // chart.setDrawYLabels(false);

        AxisValueFormatter xAxisFormatter = new MonthAxisValueFormatter();

        XAxis xAxis = chart.getXAxis();
        xAxis.setGranularity(1f);
        xAxis.setTextColor(Color.rgb(210, 210, 210));
        xAxis.setCenterAxisLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setLabelCount(12);
        xAxis.setDrawGridLines(false);
        xAxis.setLabelRotationAngle(300f);
//        xAxis.setValueFormatter(new AxisValueFormatter() {
//            @Override
//            public String getFormattedValue(float value, AxisBase axis) {
//                return String.valueOf((int) value);
//            }
//
//            @Override
//            public int getDecimalDigits() {
//                return 0;
//            }
//        });
        xAxis.setValueFormatter(xAxisFormatter);

        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setTextColor(Color.rgb(210, 210, 210));
        leftAxis.setYOffset(0);

        Legend l = chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(true);
        l.setYOffset(0f);
        l.setYEntrySpace(0f);
        l.setTextSize(8f);

        chart.getAxisRight().setEnabled(false);
        MyMarkerView mv = new MyMarkerView(getContext(), R.layout.custom_marker_view, xAxisFormatter);
        chart.setMarkerView(mv); // Set the marker to the chart

        setData();
        return v;
    }

    private void setData() {
        float groupSpace = 0.05f;
        float barSpace = 0.05f; // x2 dataset
        float barWidth = 0.40f; // x2 dataset
        // (barWidth + barSpace) * 2 + groupSpace = 1.00 -> interval per "group"
        int progress = 12;
        int startYear = 1;


        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();
        ArrayList<BarEntry> yVals2 = new ArrayList<BarEntry>();

        yVals1.add(new BarEntry(1, 108));
        yVals1.add(new BarEntry(2, 60));
        yVals1.add(new BarEntry(3, 60));
        yVals1.add(new BarEntry(4, 208));
        yVals1.add(new BarEntry(5, 412));
        yVals1.add(new BarEntry(6, 170));
        yVals1.add(new BarEntry(7, 322));
        yVals1.add(new BarEntry(8, 107));
        yVals1.add(new BarEntry(9, 165));
        yVals1.add(new BarEntry(10, 260));
        yVals1.add(new BarEntry(11, 178));
        yVals1.add(new BarEntry(12, 550));

//        ArrayList<BarEntry> values2 = new ArrayList<BarEntry>();
        yVals2.add(new BarEntry(1, 118));
        yVals2.add(new BarEntry(2, 120));
        yVals2.add(new BarEntry(3, 90));
        yVals2.add(new BarEntry(4, 108));
        yVals2.add(new BarEntry(5, 212));
        yVals2.add(new BarEntry(6, 370));
        yVals2.add(new BarEntry(7, 122));
        yVals2.add(new BarEntry(8, 177));
        yVals2.add(new BarEntry(9, 265));
        yVals2.add(new BarEntry(10, 200));
        yVals2.add(new BarEntry(11, 78));
        yVals2.add(new BarEntry(12, 280));


        BarDataSet set1, set2;

//        if (chart.getData() != null &&
//                chart.getData().getDataSetCount() > 0) {
//            set1 = (BarDataSet)chart.getData().getDataSetByIndex(0);
//            set2 = (BarDataSet)chart.getData().getDataSetByIndex(1);
//            set1.setValues(yVals1);
//            set2.setValues(yVals2);
//            chart.getData().notifyDataChanged();
//            chart.notifyDataSetChanged();
//        } else {
        // create 2 datasets with different types
        set1 = new BarDataSet(yVals1, "Income");
        set1.setColor(Color.rgb(36, 179, 125));
        set2 = new BarDataSet(yVals2, "Expense");
        set2.setColor(Color.rgb(220, 80, 80));

        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        dataSets.add(set1);
        dataSets.add(set2);

        BarData data = new BarData(dataSets);
        data.setValueFormatter(new LargeValueFormatter());
        data.setDrawValues(false);


        chart.setData(data);
//        }

        chart.getBarData().setBarWidth(barWidth);
        chart.getXAxis().setAxisMinValue(startYear);
        chart.getXAxis().setAxisMaxValue(chart.getBarData().getGroupWidth(groupSpace, barSpace) * progress + startYear);
        chart.groupBars(startYear, groupSpace, barSpace);
        chart.invalidate();
    }


}
