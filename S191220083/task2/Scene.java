package task2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Scene {

    public static void main(String[] args) throws IOException {

        int count =7;
        Line line = new Line(count);
        int[] sequence = {6,3,1,5,2,4,0};
        Flocks flocks = new Flocks(count);
        for(int i=0;i<count;++i){
            line.put(Flocks.monsterList[i], sequence[i]);
        }

        Geezer theGeezer = Geezer.getTheGeezer();

        Sorter sorter = new BubbleSorter();

        theGeezer.setSorter(sorter);

        String log = theGeezer.lineUp(line);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }

}
