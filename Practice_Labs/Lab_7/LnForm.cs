using OxyPlot.Axes;
using OxyPlot.Series;
using OxyPlot.WindowsForms;
using OxyPlot;

namespace Lab_7;
public partial class LnForm : Form
{
    private Button btnPlot;
    private PlotView plotView;

    public LnForm()
    {
        this.Text = "Построитель функции y = x * ln(x)";
        this.Size = new Size(800, 600);


        btnPlot = new Button
        {
            Text = "Построить",
            Location = new Point(10, 8),
            Width = 100
        };
        btnPlot.Click += BtnPlot_Click;

        plotView = new PlotView
        {
            Location = new Point(10, 50),
            Size = new Size(760, 500),
            Anchor = AnchorStyles.Top | AnchorStyles.Bottom | AnchorStyles.Left | AnchorStyles.Right
        };


        this.Controls.Add(btnPlot);
        this.Controls.Add(plotView);
        InitializeComponent();
        InitializePlot();
    }

    private void InitializePlot()
    {
        var model = new PlotModel { Title = "y = x * ln(x)" };

        model.Axes.Add(new LinearAxis
        {
            Position = AxisPosition.Bottom,
            Minimum = -100,
            Maximum = 100,
            MajorGridlineStyle = LineStyle.Solid,
            MinorGridlineStyle = LineStyle.Dot
        });
        model.Axes.Add(new LinearAxis
        {
            Position = AxisPosition.Left,
            Minimum = -100,
            Maximum = 100,
            MajorGridlineStyle = LineStyle.Solid,
            MinorGridlineStyle = LineStyle.Dot
        });

        plotView.Model = model;
    }

    private void BtnPlot_Click(object sender, EventArgs e)
    {

        var model = plotView.Model;
        model.Series.Clear();

        double xMin = 0.0000001;  
        double xMax = 10;
        double step = 0.001;

        var line = new LineSeries
        {
            Color = OxyColors.Black,
            StrokeThickness = 2
        };

        for (double x = xMin; x <= xMax; x += step)
        {
            double y = x * Math.Log(x);
            line.Points.Add(new DataPoint(x, y));
        }
        model.Series.Add(line);

        double x0 = Math.Exp(-1);
        double y0 = x0 * Math.Log(x0);     // = -1/e

        double xMaxEnd = xMax;
        double yMaxEnd = xMax * Math.Log(xMax);

        var marks = new ScatterSeries
        {
            MarkerType = MarkerType.Circle,
            MarkerSize = 5,
            MarkerFill = OxyColors.Red
        };
        marks.Points.Add(new ScatterPoint(x0, y0));
        marks.Points.Add(new ScatterPoint(xMaxEnd, yMaxEnd));
        model.Series.Add(marks);

        var xAxis = model.Axes[0];
        var yAxis = model.Axes[1];

        double halfX = (xAxis.ActualMaximum - xAxis.ActualMinimum) / 2;
        double halfY = (yAxis.ActualMaximum - yAxis.ActualMinimum) / 2;

        xAxis.Zoom(x0 - halfX, x0 + halfX);
        yAxis.Zoom(y0 - halfY, y0 + halfY);

        model.InvalidatePlot(false);

        MessageBox.Show(
            $"Локальный минимум:\n  x = {x0:F4}, y = {y0:F4}\n\n" +
            $"Максимум на границе:\n  x = {xMaxEnd:F4}, y = {yMaxEnd:F4}",
            "Экстремумы функции",
            MessageBoxButtons.OK,
            MessageBoxIcon.Information
        );
    }
}

//static class Program
//{
//    [STAThread]
//    static void Main()
//    {
//        Application.EnableVisualStyles();
//        Application.SetCompatibleTextRenderingDefault(false);
//        Application.Run(new LnForm());
//    }
//}

