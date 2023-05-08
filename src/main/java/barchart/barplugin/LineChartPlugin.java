package barchart.barplugin;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;

import model.FixedBill;
import model.Member;
import model.VIP;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.markers.SeriesMarkers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LineChartPlugin implements ExampleChart<XYChart> {

    List<FixedBill> f;
    public LineChartPlugin(List<FixedBill> f) {
        this.f = f;
    }

    @Override
    public XYChart getChart() {
        List<Integer> ids = new ArrayList<>();
        List<Double> hargaTotal = new ArrayList<>();
        int i = 1;

        for (FixedBill fb: f) {
            hargaTotal.add(fb.calcTotalHargaJual());
            ids.add(i);
            i++;
        }

        // Create Chart
        XYChart chart = new XYChartBuilder().width(400).height(500).title("Line Chart").xAxisTitle("Jenis").yAxisTitle("Jumlah").build();

        // Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);
        chart.getStyler().setYAxisLabelAlignment(Styler.TextAlignment.Right);
        chart.getStyler().setYAxisDecimalPattern("$ #,###.##");
        chart.getStyler().setPlotMargin(0);
        chart.getStyler().setPlotContentSize(.95);

        Double[] hargaTotalArray = (Double[]) hargaTotal.toArray(new Double[hargaTotal.size()]);
        Integer[] idsArray = (Integer[]) ids.toArray(new Integer[ids.size()]);
        chart.addSeries("Transaksi", Arrays.asList(idsArray), Arrays.asList(hargaTotalArray));

        return chart;
    }

}
