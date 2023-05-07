package barchart.barplugin;

import chart.plugin.ChartPluginInterface;
import controller.MainController;
import model.FixedBill;
import org.knowm.xchart.XChartPanel;

import javax.swing.*;
import java.util.List;

public class ChartPlugin implements ChartPluginInterface {
    @Override
    public JPanel loadPanel(MainController mainController) {
        List<FixedBill> temp = mainController.getFixedBillDataIO().getAll();
        return new XChartPanel<>(new PieChartPlugin(temp).getChart());
    }
}