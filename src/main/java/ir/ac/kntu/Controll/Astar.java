package ir.ac.kntu.Controll;

import ir.ac.kntu.Model.Spot;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Astar {
    private boolean[][] UnWalkables;
    private Spot First;
    private Spot Last;
    private Spot CurrentSpot;
    private List<Spot> OpenList;
    private LinkedList<Spot> ClosedList;

    public Astar(boolean[][] unWalkables, Spot first, Spot last) {
        UnWalkables = unWalkables;
        First = first;
        Last = last;
    }

    public boolean[][] getUnWalkables() {
        return UnWalkables;
    }

    public void setUnWalkables(boolean[][] unWalkables) {
        UnWalkables = unWalkables;
    }

    public Spot getCurrentSpot() {
        return CurrentSpot;
    }

    public void setCurrentSpot(Spot currentSpot) {
        CurrentSpot = currentSpot;
    }

    public Spot getFirst() {
        return First;
    }

    public void setFirst(Spot first) {
        First = first;
    }

    public Spot getLast() {
        return Last;
    }

    public void setLast(Spot last) {
        Last = last;
    }

    public List<Spot> getOpenList() {
        return OpenList;
    }

    public void setOpenList(List<Spot> openList) {
        OpenList = openList;
    }

    public LinkedList<Spot> getClosedList() {
        return ClosedList;
    }

    public void setClosedList(LinkedList<Spot> closedList) {
        ClosedList = closedList;
    }

    public void addNeighbors(Spot spot){
        Spot n = new Spot(spot.getX(),spot.getY() - 1);
        Spot ne = new Spot(spot.getX() + 1,spot.getY());
        Spot nw = new Spot(spot.getX() - 1,spot.getY());
        Spot s = new Spot(spot.getX(),spot.getY() + 1);
        if(UnWalkables[n.getX()][n.getY()] && !ClosedList.contains(n)){
            getOpenList().add(n);
        }
        if(UnWalkables[ne.getX()][ne.getY()] && !ClosedList.contains(ne)){
            getOpenList().add(ne);
        }
        if(UnWalkables[nw.getX()][nw.getY()] && !ClosedList.contains(nw)){
            getOpenList().add(nw);
        }
        if(UnWalkables[s.getX()][s.getY()] && !ClosedList.contains(s)){
            getOpenList().add(s);
        }
    }

    public void fConstruct(Spot spot){
        int G = (spot.getX() - First.getX()) + (spot.getY() - First.getY());
        int H = (Last.getX() - spot.getX()) + (Last.getY() - spot.getY());
        spot.setF(G + H);
    }

    public List<Spot> FindPath(){
        OpenList.add(First);
        while (!OpenList.isEmpty()){
            if(ClosedList.contains(Last)){
                break;
            }
            for (Spot spot : OpenList) {
                fConstruct(spot);
            }
            Collections.sort(OpenList);
            CurrentSpot = OpenList.get(0);
            ClosedList.add(OpenList.get(0));
            OpenList.remove(0);
            addNeighbors(CurrentSpot);
        }
        return ClosedList;
    }
}
