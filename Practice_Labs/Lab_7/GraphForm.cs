using OxyPlot;
using OxyPlot.Series;
using OxyPlot.Axes;
using OxyPlot.WindowsForms;

namespace Lab_7;

public partial class GraphForm : Form
{
    private NumericUpDown numA, numB, numC, minX, maxX;
    private Button btnPlot;
    private PlotView plotView;

    public GraphForm()
    {
        this.Text = "Построитель параболы y = a·x² + b·x + c";
        this.Size = new Size(800, 600);

        var lblA = new Label { Text = "a:", Location = new Point(10, 15), AutoSize = true };
        numA = new NumericUpDown
        {
            Minimum = Int32.MinValue,
            Maximum = Int32.MaxValue,
            DecimalPlaces = 2,
            Increment = 0.1M,
            Value = 1,
            Location = new Point(30, 10),
            Width = 60
        };

        var lblB = new Label { Text = "b:", Location = new Point(110, 15), AutoSize = true };
        numB = new NumericUpDown
        {
            Minimum = Int32.MinValue,
            Maximum = Int32.MaxValue,
            DecimalPlaces = 2,
            Increment = 0.1M,
            Value = 0,
            Location = new Point(130, 10),
            Width = 60
        };

        var lblC = new Label { Text = "c:", Location = new Point(210, 15), AutoSize = true };
        numC = new NumericUpDown
        {
            Minimum = Int32.MinValue,
            Maximum = Int32.MaxValue,
            DecimalPlaces = 2,
            Increment = 0.1M,
            Value = 0,
            Location = new Point(230, 10),
            Width = 60
        };

        var lblMin = new Label { Text = "min x:", Location = new Point(310, 15), AutoSize = true };
        minX = new NumericUpDown
        {
            Minimum = Int32.MinValue,
            Maximum = Int32.MaxValue,
            DecimalPlaces = 2,
            Increment = 0.1M,
            Value = -10,
            Location = new Point(350, 10),
            Width = 60
        };

        var lblMax = new Label { Text = "max x:", Location = new Point(410, 15), AutoSize = true };
        maxX = new NumericUpDown
        {
            Minimum = Int32.MinValue,
            Maximum = Int32.MaxValue,
            DecimalPlaces = 2,
            Increment = 0.1M,
            Value = 10,
            Location = new Point(450, 10),
            Width = 60
        };

        btnPlot = new Button
        {
            Text = "Построить",
            Location = new Point(580, 8),
            Width = 100
        };
        btnPlot.Click += BtnPlot_Click;

        plotView = new PlotView
        {
            Location = new Point(10, 50),
            Size = new Size(760, 500),
            Anchor = AnchorStyles.Top | AnchorStyles.Bottom | AnchorStyles.Left | AnchorStyles.Right
        };

        this.Controls.Add(lblA);
        this.Controls.Add(numA);

        this.Controls.Add(lblB);
        this.Controls.Add(numB);

        this.Controls.Add(lblC);
        this.Controls.Add(numC);

        this.Controls.Add(lblMin);
        this.Controls.Add(minX);

        this.Controls.Add(lblMax);
        this.Controls.Add(maxX);

        this.Controls.Add(btnPlot);
        this.Controls.Add(plotView);
        InitializeComponent();
        InitializePlot();
    }

    private void InitializePlot()
    {
        var model = new PlotModel { Title = "y = a·x² + b·x + c" };

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
        decimal a = (decimal)numA.Value;
        decimal b = (decimal)numB.Value;
        decimal c = (decimal)numC.Value;
        decimal min = (decimal)minX.Value;
        decimal max = (decimal)maxX.Value;


        decimal x0 = -b / (2 * a);
        decimal y0 = a * x0 * x0 + b * x0 + c;


        var model = plotView.Model;



        model.Series.Clear();

        var line = new LineSeries
        {
            Color = OxyColors.Black,
            StrokeThickness = 2
        };

        decimal step = 0.01m;
        for (decimal x = min; x <= max; x += step)
        {
            decimal y = a * x * x + b * x + c;
            line.Points.Add(new DataPoint((double)x, (double)y));
        }

        model.Series.Add(line);

        var xAxis = model.Axes.First(ax => ax.Position == AxisPosition.Bottom);
        var yAxis = model.Axes.First(ax => ax.Position == AxisPosition.Left);

        decimal deltaX = (decimal)(xAxis.ActualMaximum - xAxis.ActualMinimum) / 2;
        decimal deltaY = (decimal)(yAxis.ActualMaximum - yAxis.ActualMinimum) / 2;

        xAxis.Zoom((double)(x0 - deltaX), (double)(x0 + deltaX));
        yAxis.Zoom((double)(y0 - deltaY), (double)(y0 + deltaY));

        model.InvalidatePlot(false);
    }
}

//static class Program
//{
//    [STAThread]
//    static void Main()
//    {
//        Application.EnableVisualStyles();
//        Application.SetCompatibleTextRenderingDefault(false);
//        Application.Run(new GraphForm());
//    }
//}

