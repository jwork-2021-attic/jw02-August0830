package task2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Scene {

    private static int[] randomSequence(int count) {
        int[] sequence = new int[count];
        int[] nums = new int[count];
        for (int i = 0; i < count; ++i)
            nums[i] = i;
        int n = count;
        for (int i = 0; i < count; ++i) {
            int r = (int) (Math.random() * n);
            sequence[i] = nums[r];
            nums[r] = nums[n - 1];
            --n;
        }
        return sequence;
    }

    public static void main(String[] args) throws IOException {

        int count = 64;
        Line line = new Line(count);
        int[] sequence = Scene.randomSequence(count);
        Flocks flocks = new Flocks(count);
        for(int i=0;i<count;++i){
            line.put(Flocks.monsterList[i], sequence[i]);
        }

        Geezer theGeezer = Geezer.getTheGeezer();

        //Sorter sorter = new BubbleSorter();

        //Sorter sorter = new QuickSorter();

        Sorter sorter = new HeapSorter();

        theGeezer.setSorter(sorter);

        String log = theGeezer.lineUp(line);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }

}
