namespace Lab_7;
public partial class ShipForm : Form
{
    private Color shipColor = Color.White;
    private readonly ColorDialog colorDialog;
    private readonly Button btnColor;

    public ShipForm()
    {
        Text = "Кораблик";
        ClientSize = new Size(380, 240);
        BackColor = Color.LightBlue;
        DoubleBuffered = true;

        colorDialog = new ColorDialog
        {
            AllowFullOpen = true,
            AnyColor = true,
            FullOpen = true,
            Color = shipColor
        };

        btnColor = new Button
        {
            Text = "Цвет кораблика…",
            Location = new Point(10, 10),
            AutoSize = true
        };
        btnColor.Click += BtnColor_Click;
        Controls.Add(btnColor);
    }

    private void BtnColor_Click(object sender, EventArgs e)
    {
        if (colorDialog.ShowDialog(this) == DialogResult.OK)
        {
            shipColor = colorDialog.Color;
            Invalidate();
        }
    }

    protected override void OnPaint(PaintEventArgs e)
    {
        base.OnPaint(e);
        DrawShip(e.Graphics, 20, 220);
    }

    private void DrawShip(Graphics g, int baseX, int baseY)
    {
        int cellWidth = 20;
        int cellHeight = 20;

        g.SmoothingMode =
            System.Drawing.Drawing2D.SmoothingMode.AntiAlias;
        Pen outline = Pens.Black;
        using (var brush = new SolidBrush(shipColor))
        {
            Point[] hull = {
        new Point(baseX, baseY),
        new Point(baseX, baseY - 2 * cellHeight),
        new Point(baseX + 10 * cellWidth, baseY - 2 * cellHeight),
        new Point(baseX + 11 * cellWidth, baseY - 3 * cellHeight),
        new Point(baseX + 17 * cellWidth, baseY - 3 * cellHeight),
        new Point(baseX + 14 * cellWidth, baseY),

    };
            g.FillPolygon(brush, hull);
            g.DrawPolygon(outline, hull);

            var port1 = new Rectangle(
                baseX + 11 * cellWidth,
                baseY - 2 * cellHeight,
                20,
                20
            );
            g.FillEllipse(brush, port1);
            g.DrawEllipse(outline, port1);

            var port2 = new Rectangle(
                baseX + 13 * cellWidth,
                baseY - 2 * cellHeight,
                20,
                20
            );
            g.FillEllipse(brush, port2);
            g.DrawEllipse(outline, port2);


            Point[] engine1 = {
        new Point(baseX + 3 * cellWidth, baseY - 2 * cellHeight),
        new Point(baseX + 4 * cellWidth, baseY - 3 * cellHeight),
        new Point(baseX + 4 * cellWidth, baseY - 4 * cellHeight),
        new Point(baseX + 14 * cellWidth, baseY - 4 * cellHeight),
        new Point(baseX + 14 * cellWidth, baseY - 3 * cellHeight),
        new Point(baseX + 11 * cellWidth, baseY - 3 * cellHeight),
        new Point(baseX + 10 * cellWidth, baseY - 2 * cellHeight),

    };
            g.FillPolygon(brush, engine1);
            g.DrawPolygon(outline, engine1);

            var rect1 = new Rectangle(
                baseX + 7 * cellWidth,
                baseY - 7 * cellHeight,
                20,
                60
            );
            g.FillRectangle(brush, rect1);
            g.DrawRectangle(outline, rect1);

            var rect2 = new Rectangle(
                baseX + 8 * cellWidth,
                baseY - 5 * cellHeight,
                60,
                20
            );
            g.FillRectangle(brush, rect2);
            g.DrawRectangle(outline, rect2);

            Point[] sail = {
        new Point(baseX, baseY - 2 * cellHeight),
        new Point(baseX + 10 * cellWidth, baseY - 10 * cellHeight),
        new Point(baseX + 17 * cellWidth, baseY - 3 * cellHeight),
        new Point(baseX + 11 * cellWidth, baseY - 3 * cellHeight),
        new Point(baseX + 10 * cellWidth, baseY - 2 * cellHeight),

    };
            g.DrawPolygon(outline, sail);


            g.DrawLine(
                outline,
                baseX + 5 * cellWidth, baseY - 3 * cellHeight,
                baseX + 9 * cellWidth, baseY - 3 * cellHeight
            );

            g.DrawLine(
                outline,
                baseX + 10 * cellWidth, baseY - 5 * cellHeight,
                baseX + 10 * cellWidth, baseY - 9 * cellHeight
            );

        }
    }

}

//static class Program
//{
//    [STAThread]
//    static void Main()
//    {
//        Application.EnableVisualStyles();
//        Application.SetCompatibleTextRenderingDefault(false);
//        Application.Run(new ShipForm());
//    }
//}
