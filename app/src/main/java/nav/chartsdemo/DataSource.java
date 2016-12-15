package nav.chartsdemo;

import android.graphics.Color;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by naveensingh on 07/10/16.
 */

public class DataSource {


    public static PieData generatePieData() {

        int count = 5;
        char val = 'A';

        ArrayList<PieEntry> entries1 = new ArrayList<PieEntry>();
        entries1.add(new PieEntry(100, "Party A"));
        entries1.add(new PieEntry(120, "Party B"));
        entries1.add(new PieEntry(50, "Party C"));
        entries1.add(new PieEntry(200, "Party D"));
        entries1.add(new PieEntry(60, "Party E"));

        PieDataSet ds1 = new PieDataSet(entries1, "Election Results");
        ds1.setColors(ColorTemplate.JOYFUL_COLORS);
        ds1.setSliceSpace(2f);
        ds1.setValueTextColor(Color.WHITE);
        ds1.setValueTextSize(12f);

        com.github.mikephil.charting.data.PieData d = new com.github.mikephil.charting.data.PieData(ds1);

        return d;
    }

    public static LineData generateLineData() {
        ArrayList<Entry> values = new ArrayList<Entry>();
        values.add(new Entry(1, 108));
        values.add(new Entry(2, 60));
        values.add(new Entry(3, 60));
        values.add(new Entry(4, 208));
        values.add(new Entry(5, 412));
        values.add(new Entry(6, 170));
        values.add(new Entry(7, 322));
        values.add(new Entry(8, 107));
        values.add(new Entry(9, 165));
        values.add(new Entry(10, 260));
        values.add(new Entry(11, 178));
        values.add(new Entry(12, 550));

        LineDataSet set1 = new LineDataSet(values, "DataSet 1");
        set1.setAxisDependency(YAxis.AxisDependency.LEFT);
        set1.setLineWidth(1.5f);
        set1.setDrawValues(true);
        set1.setCircleRadius(5.0f);
        set1.setCircleColor(Color.rgb(36, 179, 125));
        set1.setColor(Color.rgb(36, 179, 125));
        set1.setDrawFilled(false);
        set1.enableDashedLine(10f, 5f, 0f);
        set1.setFillColor(Color.argb(0, 0, 0, 0));
//        set1.setHighLightColor(Color.rgb(244, 117, 117));
        set1.setDrawCircleHole(false);
        set1.setHighlightLineWidth(0);

        LineData data = new LineData(set1);
//        data.setValueTextColor(Color.rgb(226, 123, 123));
//        data.setValueTextSize(9f);
        data.setDrawValues(false);

        return data;
    }

}
