package nav.chartsdemo;

import android.content.Context;
import android.widget.TextView;

import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.AxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;

public class XYMarkerView extends MarkerView {

    private TextView tvContent;
    private AxisValueFormatter xAxisValueFormatter;



    public XYMarkerView(Context context, AxisValueFormatter xAxisValueFormatter) {
        super(context, R.layout.custom_marker_view);

        this.xAxisValueFormatter = xAxisValueFormatter;
        tvContent = (TextView) findViewById(R.id.tvContent);

    }

    @Override
    public void refreshContent(Entry e, Highlight highlight) {

    }

    @Override
    public int getXOffset(float xpos) {
        return 0;
    }

    @Override
    public int getYOffset(float ypos) {
        return 0;
    }

//    // callbacks everytime the MarkerView is redrawn, can be used to update the
//    // content (user-interface)
//    @Override
//    public void refreshContent(Entry e, Highlight highlight) {
//
//        tvContent.setText("x: " + xAxisValueFormatter.getFormattedValue(e.getX(), null) + ", y: " + format.format(e.getY()));
//
//        super.refreshContent(e, highlight);
//    }
//
//    @Override
//    public MPPointF getOffset() {
//        return new MPPointF(-(getWidth() / 2), -getHeight());
//    }
}
