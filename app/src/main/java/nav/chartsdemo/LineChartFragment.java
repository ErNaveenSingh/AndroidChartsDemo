package nav.chartsdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.AxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;


public class LineChartFragment extends Fragment implements OnChartValueSelectedListener {

    LineChart chart;

    public LineChartFragment() {
        // Required empty public constructor
    }

    public static LineChartFragment newInstance() {
        LineChartFragment fragment = new LineChartFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_line_chart, container, false);
        chart = (LineChart) v.findViewById(R.id.chart);
        chart.setOnChartValueSelectedListener(this);
        chart.setDrawGridBackground(false);

        chart.setTouchEnabled(true);

        // enable scaling and dragging
        chart.setDragEnabled(true);
        chart.setScaleEnabled(true);

        // if disabled, scaling can be done on x- and y-axis separately
        chart.setPinchZoom(false);

        AxisValueFormatter xAxisFormatter = new MonthAxisValueFormatter();

        MyMarkerView mv = new MyMarkerView(getContext(), R.layout.custom_marker_view, xAxisFormatter);
        chart.setMarkerView(mv); // Set the marker to the chart


        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setTextColor(Color.rgb(210, 210, 210));
        xAxis.setLabelCount(12, true);
        xAxis.setValueFormatter(xAxisFormatter);
        xAxis.setLabelRotationAngle(300f);

        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.removeAllLimitLines(); // reset all limit lines to avoid overlapping lines
        leftAxis.setDrawZeroLine(false);
        leftAxis.setTextColor(Color.rgb(210, 210, 210));
        chart.getAxisRight().setEnabled(false);


        // add data
        chart.setData(DataSource.generateLineData());


        chart.setDescription("");

        return v;
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }
}
