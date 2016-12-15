package nav.chartsdemo;

import android.content.Context;
import android.widget.TextView;

import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.AxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.Utils;

public class MyMarkerView extends MarkerView {

    private TextView tvContent;
    private AxisValueFormatter mAxisValueFormatter;
    public MyMarkerView(Context context, int layoutResource, AxisValueFormatter formatter) {
        super(context, layoutResource);

        tvContent = (TextView) findViewById(R.id.tvContent);
        mAxisValueFormatter = formatter;
    }

    // callbacks everytime the MarkerView is redrawn, can be used to update the
    // content (user-interface)
    @Override
    public void refreshContent(Entry e, Highlight highlight) {

        tvContent.setText(mAxisValueFormatter.getFormattedValue(e.getX(), null)+", "+e.getY());

    }

    @Override
    public int getXOffset(float xpos) {
        return -(getWidth() / 2);
    }

    @Override
    public int getYOffset(float ypos) {
        return -getHeight();
    }

}