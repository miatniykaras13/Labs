using System;
using System.Drawing;
using System.Windows.Forms;
using OxyPlot;
using OxyPlot.Series;
using OxyPlot.Axes;
using OxyPlot.WindowsForms;
using System.Reflection;
using Lab_7;

namespace Lab_7;

public partial class DragonForm : Form
{
    private PlotView plotView;
    private NumericUpDown numLevel;
    private Button btnDraw;
    private PlotModel plotModel;

    public DragonForm()
    {
        this.Text = "Фрактал: Кривая дракона";
        this.Size = new Size(800, 600);

        numLevel = new NumericUpDown
        {
            Minimum = 1,
            Maximum = Int32.MaxValue,
            Value = 10,
            Location = new Point(10, 10),
            Width = 60
        };


        btnDraw = new Button
        {
            Text = "Построить",
            Location = new Point(80, 8),
            Width = 100
        };
        btnDraw.Click += BtnDraw_Click;

        plotView = new PlotView
        {
            Location = new Point(10, 40),
            Size = new Size(760, 500),
            Anchor = AnchorStyles.Top | AnchorStyles.Bottom
                    | AnchorStyles.Left | AnchorStyles.Right
        };

        this.Controls.Add(numLevel);
        this.Controls.Add(btnDraw);
        this.Controls.Add(plotView);
        InitializeComponent();
        InitializePlotModel();
    }


    private void InitializePlotModel()
    {
        plotModel = new PlotModel
        {
            Title = "Кривая дракона"
        };

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

    private void BtnDraw_Click(object sender, EventArgs e)
    {
        int level = (int)numLevel.Value;

        // Генерация точек фрактала
        var points = GenerateDragonCurve(level);

        // Создаём серию для отрисовки линий
        var series = new LineSeries
        {
            Color = OxyColors.DarkBlue,
            StrokeThickness = 2
        };
        series.Points.AddRange(points);

        // Очищаем предыдущий фрактал и добавляем новый
        plotModel.Series.Clear();
        plotModel.Series.Add(series);

        // Автоматический подбор осей под данные
        plotModel.ResetAllAxes();
        plotModel.InvalidatePlot(true);
    }

    // Возвращает список точек DataPoint для кривой дракона
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
            // Добавляем зеркально-повернутые точки
            for (int j = count - 2; j >= 0; j--)
            {
                var p = pts[j];
                double dx = p.X - pivot.X;
                double dy = p.Y - pivot.Y;
                // Поворот +90°: (x,y) → (−y, x)
                double rx = -dy;
                double ry = dx;
                pts.Add(new DataPoint(pivot.X + rx, pivot.Y + ry));
            }
        }

        return pts;
    }
}


static class Program
{
    [STAThread]
    static void Main()
    {
        Application.EnableVisualStyles();
        Application.SetCompatibleTextRenderingDefault(false);
        Application.Run(new DragonForm());
    }
}