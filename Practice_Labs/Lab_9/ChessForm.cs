using System;
using System.Collections.Generic;
using System.Drawing;
using System.Windows.Forms;

namespace Lab_9
{
    public enum Pawn { None, White, Black }

    public partial class ChessForm : Form
    {
        private const int CellSize = 60;
        private const int LeftMargin = 30;
        private const int TopMargin = 10;
        private const int BottomMargin = 80;
        private const int RightMargin = 10;

        private Pawn[,] board = new Pawn[8, 8];
        private List<Point> highlightedMoves = new List<Point>();
        private Random rnd = new Random(DateTime.Now.Millisecond);

        private Button btnGenerateWhite;
        private Button btnGenerateBlack;

        public ChessForm()
        {
            Text = "Шахматы";
            DoubleBuffered = true;
            ClientSize = new Size(
                LeftMargin + 8 * CellSize + RightMargin,
                TopMargin + 8 * CellSize + BottomMargin
            );

            btnGenerateWhite = new Button
            {
                Text = "Сгенерировать белую пешку",
                Location = new Point(LeftMargin, TopMargin + 8 * CellSize + 20),
                Width = 200
            };
            btnGenerateWhite.Click += (s, e) => GeneratePawn(Pawn.White);

            btnGenerateBlack = new Button
            {
                Text = "Сгенерировать чёрную пешку",
                Location = new Point(LeftMargin + 220, TopMargin + 8 * CellSize + 20),
                Width = 200
            };
            btnGenerateBlack.Click += (s, e) => GeneratePawn(Pawn.Black);

            Controls.Add(btnGenerateWhite);
            Controls.Add(btnGenerateBlack);
        }

        private void GeneratePawn(Pawn color)
        {
            Array.Clear(board, 0, board.Length);
            highlightedMoves.Clear();

            int x, y;
            List<Point> possible;
            do
            {
                x = rnd.Next(0, 8);
                y = rnd.Next(0, 8);
                possible = CalculatePossibleMoves(x, y, color);
            }
            while (possible.Count == 0);

            board[x, y] = color;

            Point chosen = possible[rnd.Next(possible.Count)];
            highlightedMoves.Add(chosen);

            Invalidate();
        }

        private List<Point> CalculatePossibleMoves(int x, int y, Pawn color)
        {
            var moves = new List<Point>();
            int dir = color == Pawn.White ? +1 : -1;

            if (y + dir is int fy && fy >= 0 && fy < 8)
                moves.Add(new Point(x, fy));

            if (x - 1 >= 0 && y + dir is int dyl && dyl >= 0 && dyl < 8)
                moves.Add(new Point(x - 1, dyl));
            if (x + 1 < 8 && y + dir is int dyr && dyr >= 0 && dyr < 8)
                moves.Add(new Point(x + 1, dyr));

            return moves;
        }

        protected override void OnPaint(PaintEventArgs e)
        {
            base.OnPaint(e);
            var g = e.Graphics;

            for (int i = 0; i < 8; i++)
                for (int j = 0; j < 8; j++)
                {
                    bool light = (i + j) % 2 == 0;
                    var cellBrush = light ? Brushes.Beige : Brushes.SaddleBrown;
                    int px = LeftMargin + i * CellSize;
                    int py = TopMargin + (7 - j) * CellSize;
                    g.FillRectangle(cellBrush, px, py, CellSize, CellSize);
                    g.DrawRectangle(Pens.Black, px, py, CellSize, CellSize);
                }

            using var font = new Font("Segoe UI", 10);
            for (int i = 0; i < 8; i++)
            {
                // x
                string fx = (i + 1).ToString();
                var sx = g.MeasureString(fx, font);
                float tx = LeftMargin + i * CellSize + (CellSize - sx.Width) / 2;
                float ty = TopMargin + 8 * CellSize + 2;
                g.DrawString(fx, font, Brushes.Black, tx, ty);

                // y
                string fy = (i + 1).ToString();
                var sy = g.MeasureString(fy, font);
                float ux = LeftMargin - sy.Width - 2;
                float uy = TopMargin + (7 - i) * CellSize + (CellSize - sy.Height) / 2;
                g.DrawString(fy, font, Brushes.Black, ux, uy);
            }

            for (int i = 0; i < 8; i++)
                for (int j = 0; j < 8; j++)
                {
                    if (board[i, j] == Pawn.None) 
                        continue;

                    int px = LeftMargin + i * CellSize;
                    int py = TopMargin + (7 - j) * CellSize;
                    int d = CellSize / 2;
                    int off = (CellSize - d) / 2;
                    var rect = new Rectangle(px + off, py + off, d, d);
                    var br = board[i, j] == Pawn.White ? Brushes.White : Brushes.Black;
                    g.FillEllipse(br, rect);
                    g.DrawEllipse(Pens.Gray, rect);
                }

            foreach (var mv in highlightedMoves)
            {
                int px = LeftMargin + mv.X * CellSize;
                int py = TopMargin + (7 - mv.Y) * CellSize;
                int d = CellSize / 3;
                int off = (CellSize - d) / 2;
                var rect = new Rectangle(px + off, py + off, d, d);
                g.FillEllipse(Brushes.Blue, rect);
            }
        }

        [STAThread]
        public static void Main()
        {
            Application.EnableVisualStyles();
            Application.Run(new ChessForm());
        }
    }
}
