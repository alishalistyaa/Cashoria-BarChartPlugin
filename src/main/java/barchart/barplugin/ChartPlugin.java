package barchart.barplugin;

import chart.plugin.ChartPluginInterface;
import controller.MainController;
import model.FixedBill;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.internal.chartpart.Chart;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ChartPlugin implements ChartPluginInterface {
    @Override
    public JPanel loadPanel(MainController mainController) {
        List<FixedBill> temp = mainController.getFixedBillDataIO().getAll();
        JPanel sidePanel = new JPanel();
//        List<ExampleChart> charts = new ArrayList<ExampleChart>();
//        charts.add();
        sidePanel.add(new XChartPanel<>(new BarChartPlugin(temp).getChart()));
        sidePanel.add(new XChartPanel<>(new LineChartPlugin().getChart()));
        return sidePanel;
    }
}