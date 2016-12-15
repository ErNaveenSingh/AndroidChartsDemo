package nav.chartsdemo;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.AxisValueFormatter;

public class MonthAxisValueFormatter implements AxisValueFormatter
{

    public static String[] mMonths = new String[]{
            "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };


    public MonthAxisValueFormatter() {

    }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        if (value>1)
            return mMonths[(int)(value-1)%12]+"' 16";
        else
            return "Jan' 16";
    }

    @Override
    public int getDecimalDigits() {
        return 1;
    }
}