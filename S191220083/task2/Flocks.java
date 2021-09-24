package task2;

import java.util.Random;
import task2.Line.Position;

public class Flocks  {

    private int count;

    class Monster implements Linable{
        private final int r;
        private final int g;
        private final int b;

        private Position position;

        Monster(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }

        public int rank() {
            return ((this.r<<16) | (this.g<<8) | (this.b))%count;
        }

        @Override
        public String toString() {
            return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m    " + this.rank() + "  \033[0m";
        }

        @Override
        public void setPosition(Position position) {
            this.position = position;
        }

        @Override
        public Position getPosition() {
            return this.position;
        }

        public void swapPosition(Monster another) {
            Position p = another.position;
            this.position.setLinable(another);
            p.setLinable(this);
        }

        @Override
        public int getValue() {
            return this.rank();
        }
    
    }   

    static Monster[] monsterList;

    Flocks(int count) {
        this.count = count;
        Random r = new Random();
        monsterList = new Monster[this.count];
        for(int i=0;i<this.count;++i){
            monsterList[i]=new Monster(r.nextInt(256),r.nextInt(256),r.nextInt(256));
        }
    }

    public static Monster getMonsterByRank(int rank) {

        for (Monster monster : monsterList) {
            if (monster.rank() == rank) {
                return monster;
            }
        }
        return null;

    }
}