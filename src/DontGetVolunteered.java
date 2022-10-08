import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class DontGetVolunteered {
    public static void main(String[] args) {
        System.out.println(new DontGetVolunteered().solution(0, 1));
        System.out.println(new DontGetVolunteered().solution(19, 36));
    }

    public static int solution(int src, int dest){
        if(src == dest) return 0;

        int srcX = posToCoords(src)[0];
        int srcY = posToCoords(src)[1];
        int destX = posToCoords(dest)[0];
        int destY = posToCoords(dest)[1];

        int hops = 0;

        LinkedHashMap<String, int[]> queue = getPossibleMoves(srcX, srcY);
        LinkedHashMap<String, int[]> depthQueue = new LinkedHashMap<>();

        while(true){
            hops++;

            for(Map.Entry<String, int[]> entry : queue.entrySet()){
                if(entry.getValue()[0] == destX && entry.getValue()[1] == destY){
                    return hops;
                }

                ((LinkedHashMap<String, int[]>) depthQueue).putAll(getPossibleMoves(entry.getValue()[0], entry.getValue()[1]));
            }

            queue = new LinkedHashMap<>(depthQueue);
            depthQueue.clear();
        }
    }

    static int[] posToCoords(int pos){
        int x = (int) Math.floor(pos/8);
        int y = pos % 8;
        return new int[]{x, y};
    }

    static int coordsToPos(int x, int y){
        return x + y * 8;
    }

    static LinkedHashMap<String, int[]> getPossibleMoves(int x, int y){
        List<int[]> allMoves = new ArrayList<>();

        allMoves.add(new int[]{x+2, y+1});
        allMoves.add(new int[]{x+2, y-1});
        allMoves.add(new int[]{x-2, y+1});
        allMoves.add(new int[]{x-2, y-1});
        allMoves.add(new int[]{x+1, y+2});
        allMoves.add(new int[]{x+1, y-2});
        allMoves.add(new int[]{x-1, y+2});
        allMoves.add(new int[]{x-1, y-2});

        LinkedHashMap<String, int[]> validMoves = new LinkedHashMap<>();

        for(int[] move : allMoves){
            if(move[0] >= 0 && move[0] < 8 && move[1] >= 0  && move[1] < 8){
                validMoves.put(move[0]+","+move[1], move);
            }
        }

        return validMoves;
    }
}
