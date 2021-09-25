package task2;

public class Geezer {

    private static Geezer theGeezer;

    public static Geezer getTheGeezer() {
        if (theGeezer == null) {
            theGeezer = new Geezer();
        }
        return theGeezer;
    }

    private Geezer() {

    }

    private Sorter sorter;

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }
    public String matrixLineUp(Matrix matrix){
        String log = new String();

        if(sorter == null)
            return null;

        Linable[] linables = matrix.toArray();
        int[] ranks = new int[linables.length];
        for(int i=0;i<linables.length;++i){
            ranks[i]=linables[i].getValue();
        }

        sorter.load(ranks);
        sorter.sort();

        String[] sortSteps = this.parsePlan(sorter.getPlan());

        for (String step : sortSteps) {
            this.execute(step);
            for(int i=0;i<matrix.lines.length;++i){
                System.out.println(matrix.lines[i].toString());
                log += matrix.lines[i].toString();
                log += "\n";
            }
            
            log += "\n[frame]\n";
        }

        return log;
    }

    public String lineUp(Line line) {

        String log = new String();

        if (sorter == null) {
            return null;
        }

        Linable[] linables = line.toArray();
        int[] ranks = new int[linables.length];

        for (int i = 0; i < linables.length; i++) {
            ranks[i] = linables[i].getValue();
        }

        sorter.load(ranks);
        sorter.sort();

        String[] sortSteps = this.parsePlan(sorter.getPlan());

        for (String step : sortSteps) {
            this.execute(step);
            System.out.println(line.toString());
            log += line.toString();
            log += "\n[frame]\n";
        }

        return log;

    }

    private String[] parsePlan(String plan) {
        return plan.split("\n");
    }

    private void execute(String step) {
        if(step == "")
            return;
        String[] couple = step.split("<->");
        Flocks.getMonsterByRank(Integer.parseInt(couple[0]))
                .swapPosition(Flocks.getMonsterByRank(Integer.parseInt(couple[1])));
    }

}
