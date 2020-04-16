package com.company;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.DeviationRenderer;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.chart.ui.RectangleInsets;

import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.Week;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.YIntervalSeries;
import org.jfree.data.xy.YIntervalSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Affichage_Graphique {
    public Affichage_Graphique(List<Integer> listElement,List<Long> listSerie1,List<Long> listSerie2,String Titre,String xA,String yA,String serie1,String serie2) {
        DeviationRendererDemo2.main(listElement,listSerie1,listSerie2, Titre, xA, yA,serie1,serie2);
    }
}

class DeviationRendererDemo2 extends ApplicationFrame {
    /**
     * Creates a new demo.
     *
     * @param title the frame title.
     */
    public DeviationRendererDemo2(String title,List<Integer> listElement,List<Long> listSerie1,List<Long> listSerie2,String Titre,String xA,String yA,String serie1,String serie2) {
        super(title);
        JPanel chartPanel = createDemoPanel(listElement,listSerie1,listSerie2, Titre,xA, yA,serie1,serie2);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
    }

    /**
     * Creates a sample dataset.
     *
     * @return a sample dataset.
     */
    private static XYDataset createDataset(List<Integer> listElement,List<Long> listSerie1,List<Long> listSerie2,String serie1,String serie2) {
        //liste de meme taille

        if(listElement.size() != listSerie1.size() || listSerie2.size()  != listSerie1.size() ){
            System.out.println("LISTES DE TAILLE DIFFERENTES "+
                    listSerie1.size() +" "+listSerie2.size() +" "+listElement.size());
            return null;
        }
        YIntervalSeries series1 = new YIntervalSeries(serie1);//"Series 1"
        YIntervalSeries series2 = new YIntervalSeries(serie2);//"Series 2"

        for (int i = 0; i < listElement.size(); i++) {
            //
            // System.out.print(" "+listElement.get(i));
            series1.add(listElement.get(i), listSerie1.get(i), listSerie1.get(i), listSerie1.get(i));
            series2.add(listElement.get(i), listSerie2.get(i), listSerie2.get(i), listSerie2.get(i));
        }

        YIntervalSeriesCollection dataset = new YIntervalSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);

        return dataset;
    }

    /**
     * Creates a chart.
     *
     * @param dataset the data for the chart.
     * @return a chart.
     */
    private static JFreeChart createChart(XYDataset dataset,String Titre,String xA,String yA) {

        // create the chart...
        JFreeChart chart = ChartFactory.createScatterPlot(//)XYStepChart(
                Titre,          // chart title
                xA,                   // x axis label "Nombre d'axe"
                yA,       // y axis label "Temps (ms)"
                dataset
        );


        // get a reference to the plot for further customisation...
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setDomainPannable(true);
        plot.setRangePannable(false);
        plot.setInsets(new RectangleInsets(5, 5, 5, 20));

        DeviationRenderer renderer = new DeviationRenderer(false, true);
        /*renderer.setSeriesStroke(0, new BasicStroke(3.0f, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND));
        renderer.setSeriesStroke(0, new BasicStroke(3.0f,
                BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        renderer.setSeriesStroke(1, new BasicStroke(3.0f,
                BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));*/
        renderer.setSeriesFillPaint(0, new Color(255, 200, 200));
        renderer.setSeriesFillPaint(1, new Color(200, 200, 255));
        plot.setRenderer(renderer);

        // change the auto tick unit selection to integer units only...
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        yAxis.setAutoRangeIncludesZero(false);
        yAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        return chart;

    }

    /**
     * Creates a panel for the demo (used by SuperDemo.java).
     *
     * @return A panel.
     */
    public static JPanel createDemoPanel(List<Integer> listElement,List<Long> listSerie1,List<Long> listSerie2,String Titre,String xA,String yA,String serie1,String serie2) {
        JFreeChart chart = createChart(createDataset(listElement,listSerie1,listSerie2,serie1,serie2), Titre, xA, yA);
        return new ChartPanel(chart);
    }

    /**
     * Starting point for the demonstration application.
     *
    */
    public static void main(List<Integer> listElement,List<Long> listSerie1,List<Long> listSerie2,String Titre,String xA,String yA,String serie1,String serie2) {

        DeviationRendererDemo2 demo = new DeviationRendererDemo2(
                "JFreeChart: "+Titre,listElement,listSerie1, listSerie2, Titre, xA, yA,serie1,serie2);
        demo.pack();
        //RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}