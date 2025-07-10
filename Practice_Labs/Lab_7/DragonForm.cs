using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Windows.Forms;
using OxyPlot;
using OxyPlot.Series;
using OxyPlot.Axes;
using OxyPlot.WindowsForms;
using Timer = System.Windows.Forms.Timer;

namespace Lab_7;
public partial class DragonForm : Form
{
    private PlotView plotView;
    private NumericUpDown numMaxLevel;
    private Button btnAnimate;
    private PlotModel plotModel;


    private Timer animationTimer;
    private int currentLevel;
    private int targetLevel;

    public DragonForm()
    {
        Text = "Кривая дракона";
        Size = new Size(800, 600);

        numMaxLevel = new NumericUpDown
        {
            Minimum = 1,
            Maximum = 10,
            Value = 10,
            Location = new Point(10, 10),
            Width = 60
        };

        btnAnimate = new Button
        {
            Text = "Начертить",
            Location = new Point(80, 8),
            Width = 100
        };
        btnAnimate.Click += BtnAnimate_Click;

        plotView = new PlotView
        {
            Location = new Point(10, 40),
            Size = new Size(760, 500),
            Anchor = AnchorStyles.Top | AnchorStyles.Bottom
                    | AnchorStyles.Left | AnchorStyles.Right
        };

        Controls.Add(numMaxLevel);
        Controls.Add(btnAnimate);
        Controls.Add(plotView);
        InitializeComponent();
        InitializePlotModel();
        InitializeTimer();
    }


    private void InitializePlotModel()
    {
        plotModel = new PlotModel { Title = "Кривая дракона" };

        plotModel.Axes.Add(new LinearAxis
        {
            Position = AxisPosition.Bottom,
            MajorGridlineStyle = LineStyle.Solid,
            MinorGridlineStyle = LineStyle.Dot
        });
        plotModel.Axes.Add(new LinearAxis
        {
            Position = AxisPosition.Left,
            MajorGridlineStyle = LineStyle.Solid,
            MinorGridlineStyle = LineStyle.Dot
        });

        plotView.Model = plotModel;
    }

    private void InitializeTimer()
    {
        animationTimer = new Timer
        {
            Interval = 500
        };
        animationTimer.Tick += AnimationTimer_Tick;
    }

    private void BtnAnimate_Click(object sender, EventArgs e)
    {
        animationTimer.Stop();

        currentLevel = 0;
        targetLevel = (int)numMaxLevel.Value;


        plotModel.Series.Clear();
        plotModel.InvalidatePlot(true);


        animationTimer.Start();
    }

    private void AnimationTimer_Tick(object sender, EventArgs e)
    {

        currentLevel++;
        if (currentLevel > targetLevel)
        {
            animationTimer.Stop();
            return;
        }


        var pts = GenerateDragonCurve(currentLevel);


        var series = new LineSeries
        {
            Color = OxyColors.DarkBlue,
            StrokeThickness = 2
        };
        series.Points.AddRange(pts);


        plotModel.Series.Clear();
        plotModel.Series.Add(series);


        plotModel.ResetAllAxes();
        plotModel.InvalidatePlot(true);
    }


    private List<DataPoint> GenerateDragonCurve(int level)
    {
        var pts = new List<DataPoint>
        {
            new DataPoint(0, 0),
            new DataPoint(1, 0)
        };

        for (int i = 1; i < level; i++)
        {
            var pivot = pts.Last();
            int count = pts.Count;
            for (int j = count - 2; j >= 0; j--)
            {
                var p = pts[j];
                double dx = p.X - pivot.X;
                double dy = p.Y - pivot.Y;

                double rx = -dy;
                double ry = dx;
                pts.Add(new DataPoint(pivot.X + rx, pivot.Y + ry));
            }
        }

        return pts;
    }
}
public class Program
{
    [STAThread]
    static void Main()
    {
        Application.EnableVisualStyles();
        Application.SetCompatibleTextRenderingDefault(false);
        Application.Run(new DragonForm());
    }
}
