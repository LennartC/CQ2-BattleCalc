package be.lacerta.cq2.battlecalc.util;

import java.awt.Color;
import java.awt.Component;

@SuppressWarnings("serial")
class StringGridBagLine extends Component
{

    public StringGridBagLine()
    {
        debug = false;
        lineColor = DEFAULT_LINE_COLOR;
        lineWidth = 3;
    }

    public int getLineWidth()
    {
        return lineWidth;
    }

    public void setLineWidth(int i)
    {
        if(i >= 1)
            lineWidth = i;
        else
            lineWidth = 1;
    }

    public Color getLineColor()
    {
        return lineColor;
    }

    public void setLineColor(Color color)
    {
        if(color == null)
            color = DEFAULT_LINE_COLOR;
        lineColor = color;
    }

    boolean debug;
    protected static final int DEFAULT_LINE_LENGTH = 10;
    protected static final int DEFAULT_LINE_WIDTH = 1;
    protected static final int MINIMUM_LINE_LENGTH = 3;
    protected static final int MINIMUM_LINE_WIDTH = 1;
    protected static final Color DEFAULT_LINE_COLOR;
    protected Color lineColor;
    protected int lineWidth;

    static
    {
        DEFAULT_LINE_COLOR = Color.black;
    }
}
