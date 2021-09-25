package task2;

import task2.Line;

public class Matrix {
    Line[] lines;
    private int lineLength;
    Matrix(int group,int length){
        lines = new Line[group];
        lineLength = length;
        for(int i=0;i<group;++i)
            lines[i]=new Line(length);
    }

    @Override
    public String toString() {
        String matrixString = "\t";
        for (Line l : lines) {
            matrixString += l.toString();
        }
        return matrixString;
    }

    public Linable[] toArray() {
        Linable[] linables = new Linable[this.lines.length*this.lineLength];

        for(int i=0;i<lines.length;++i){
            Linable[] eachlinable = lines[i].toArray();
            for(int j=0;j<lineLength;++j)
                linables[i*lineLength+j]=eachlinable[j];
        }

        return linables;

    }
}