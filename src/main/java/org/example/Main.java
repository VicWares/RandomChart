package org.example;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.JFrame;
class ChartExample
{
    private static XYSeries series;
    private static JFreeChart chart;
    private static ChartPanel chartPanel;
    public static void main(String[] args)
    {
        series = new XYSeries("Data");
        XYSeriesCollection dataset = new XYSeriesCollection(series);
        chart = ChartFactory.createScatterPlot("Scatter Plot", "X-axis", "Y-axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        chartPanel = new ChartPanel(chart);
        JFrame frame = new JFrame("Chart Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(chartPanel);
        frame.pack();
        frame.setVisible(true);
        // Add a new point to the chart
        addPoint();
    }
    private static void addPoint()
    {
        for (int i = 0; i < 111; i++)
        {
            series.add(rndGen()[0], rndGen()[1]);
            chartPanel.repaint();
        }
    }
    private static int[] rndGen()
    {
        int[] rnd = new int[2];
        rnd[0] = (int) (Math.random() * 100);
        rnd[1] = (int) (Math.random() * 100);
        return rnd;
    }
}
